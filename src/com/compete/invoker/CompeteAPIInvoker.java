package com.compete.invoker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.compete.exception.CompeteAPIException;
import com.compete.vo.CompeteResponse;
import com.compete.vo.CompeteResponseData;
import com.compete.vo.Datum;
import com.compete.vo.Trends;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CompeteAPIInvoker {

	private String trends_url = "https://apps.compete.com/sites/%s/trended/%s/?apikey=%s";
	private String keyword_url = "https://apps.compete.com/sites/%s/kw/kw_all/?apikey=%s";
	private String incoming_traffic_url = "https://apps.compete.com/sites/%s/iref/iref_all/?apikey=%s";

	private String multiple = "https://apps.compete.com/sites/compete.com/trended/search/?apikey=%s&metrics=";

	private Config config;

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	private Map<String, String> errorMessages = new HashMap<String, String>() {
		{
			put("400",
					"The request contains invalid parameters or parameters which do not make sense when grouped together ");
			put("403", "ACCESS_DENIED");
			put("404", "Resource Not Found");
			put("500", "UNKNOWN ERROR");
			put("503", "Service Unavailable");
			put("504", "Service Unavailable");
		}
	};

	private Map<String, String> metricAbbr = new HashMap<String, String>() {
		{
			put("400", "");
			put("403", "ACCESS_DENIED");
			put("404", "Resource Not Found");
			put("500", "UNKNOWN ERROR");
			put("503", "Service Unavailable");
			put("504", "Service Unavailable");
		}
	};

	public CompeteResponse getTrends(String metric, String domain)
			throws CompeteAPIException {
		String url = getBaseURL(metric, domain);
		return fetchData(url, metric);
	}

	public CompeteResponse getTrends(String metric, String domain, String latest)
			throws CompeteAPIException {
		String url = getBaseURL(metric, domain);
		url += "&latest=" + latest;
		return fetchData(url, metric);
	}

	public CompeteResponse getTrends(String metric, String domain,
			String startDate, String endDate) throws CompeteAPIException {
		String url = getBaseURL(metric, domain);
		url += "&start_date=" + startDate + "&end_date=" + endDate;
		return fetchData(url, metric);
	}

	public CompeteResponse getTrends(String metric, String domain, String latest,
			String startDate, String endDate) throws CompeteAPIException {
		String url = getBaseURL(metric, domain);
		if (latest != null)
			url += "&latest=" + latest;
		if (startDate != null)
			url += "&start_date=" + startDate;
		if (endDate != null)
			url += "&end_date=" + endDate;
		return fetchData(url, metric);
	}
	
	private String getBaseURL(String metric, String domain) {
		String url = null;
		if ("keyword".equalsIgnoreCase(metric))
			url = new Formatter().format(keyword_url, domain,
					config.getApiKey()).toString();
		else if ("incoming_traffic".equalsIgnoreCase(metric))
			url = new Formatter().format(incoming_traffic_url, domain,
					config.getApiKey()).toString();
		else
			url = new Formatter().format(trends_url, metric, domain,
					config.getApiKey()).toString();

		return url;
	}

	public CompeteResponse fetchData(String urlStr, String metric) throws CompeteAPIException {
		if (config.isSetProxy()) {
			System.setProperty("http.proxyHost", config.getProxyHost());
			System.setProperty("http.proxyPort", config.getProxyPort());
		}

		// -------below code is modified to accept proxy username and password.
		if (config.isSetPassword()) {
			Authenticator.setDefault(new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(config.getProxyUser(),
							config.getProxyPassword().toCharArray());
				}
			});
			System.setProperty("http.proxyUser", config.getProxyUser());
			System.setProperty("http.proxyPassword", config.getProxyPassword());
		}
		// -------End of Modification

		URL url = null;

		// urlStr += urlStr.contains("?") ? "&" : "?";
		// System.out.println(urlStr + config.getApiKeyStr());
		try {
			url = new URL(urlStr);
		} catch (java.net.MalformedURLException e) {
			e.printStackTrace();
			throw new CompeteAPIException(e.getMessage(), e);
		}

		HttpURLConnection conn = null;
		String json = "";
		try {
			conn = (HttpURLConnection) url.openConnection();

			if (conn.getResponseCode() != 200) {
				// System.out.println("Failed to get profile detail for \""
				// + urlStr + config.getApiKeyStr() + "\", HTTP status: " +
				// conn.getResponseCode() + " "
				// + conn.getResponseMessage());
				String message = errorMessages.get(conn.getResponseCode());
				if (message == null) {
					message = "Unknown error occured";
				}
				String rateLimitLimit = conn
						.getHeaderField("X-APIKey-Quota-Allotted");
				String rateLimitLimitRemaining = conn
						.getHeaderField("X-APIKey-Quota-Current");
				String rateLimitLimitReset = conn
						.getHeaderField("X-RateLimit-Reset");
				String errorMessage = conn
						.getHeaderField("X-Mashery-Error-Code");
				message += "X-RateLimit-Limit=" + rateLimitLimit
						+ " X-RateLimit-Remaining=" + rateLimitLimitRemaining
						+ " X-RateLimit-Reset=" + rateLimitLimitReset;
				CompeteAPIException e = new CompeteAPIException(message);

				throw e;
			}

			InputStream obj = (InputStream) conn.getContent();

			BufferedReader br = new BufferedReader(new InputStreamReader(obj));
			String str = "";

			while ((str = br.readLine()) != null) {
				json += str;
			}
		} catch (java.io.IOException e) {
			// e.printStackTrace();
			throw new CompeteAPIException(e.getMessage(), e);
		}
		// System.out.println(json);
		Gson gson = new Gson();
		if (metric.equals("inc") || metric.equals("age"))
			return getNestedResponse(json, metric);
		
		return gson.fromJson(json.trim(), CompeteResponse.class);
	}

	private CompeteResponse getNestedResponse(String json, String metric)
			throws CompeteAPIException {
		CompeteResponse response = new CompeteResponse();
		Map<String, List<Datum>> valueMap = new HashMap<String, List<Datum>>();
		Gson gson = new Gson();
		List<Datum> datum = null;
		String jsonStr = null;
		try {
			JSONObject jsonObj = new JSONObject(json);
			
			JSONObject trends = ((JSONObject)((JSONObject)jsonObj.get("data")).get("trends"));

			for (String name : JSONObject.getNames(trends)) {
				jsonStr = trends.get(name).toString();
				datum = gson.fromJson(jsonStr.trim(), new TypeToken<List<Datum>>() {
				}.getType());
				valueMap.put(name, datum);
			}
		} catch (Exception e) {
			throw new CompeteAPIException(e.getMessage(), e);
		}
		Trends trends = new Trends();

		CompeteResponseData data = new CompeteResponseData();
		if (metric.equalsIgnoreCase("inc"))
			trends.setIncome(valueMap);
		else
			trends.setAge(valueMap);
		response.setData(data);
		return response;
	}
}
