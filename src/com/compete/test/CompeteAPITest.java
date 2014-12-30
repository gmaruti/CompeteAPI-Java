package com.compete.test;

import java.util.List;

import com.compete.CompeteAPI;
import com.compete.exception.CompeteAPIException;
import com.compete.invoker.Config;
import com.compete.vo.CompeteResponse;
import com.compete.vo.Datum;

public class CompeteAPITest {

	public void test(){
		Config config = new Config();
		config.setApiKey(""); //set the API key

//		config.setSetProxy(true);
//		config.setProxyHost("");
//		config.setProxyPort("");

		testGetGenderMetrics(config);


	}

	private void testGetGenderMetrics(Config config){

		CompeteAPI api = new CompeteAPI();

		try {
			CompeteResponse response = api.getGenderMetrics("facebook.com", config);
			List<Datum> male = response.getData().getTrends().getMale();
			for (Datum data : male) {
				System.out.println("Date " + data.getDate());
				System.out.println("Value " + data.getValue());
			}
		} catch (CompeteAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
