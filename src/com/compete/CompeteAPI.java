package com.compete;

import com.compete.exception.CompeteAPIException;
import com.compete.invoker.CompeteAPIInvoker;
import com.compete.invoker.Config;
import com.compete.vo.CompeteResponse;

public class CompeteAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public CompeteResponse getGenderMetrics(String domain, Config config)
			throws CompeteAPIException {
		CompeteAPIInvoker invoker = new CompeteAPIInvoker();
		invoker.setConfig(config);
		return invoker.getTrends("gen", domain);
	}

	public CompeteResponse getGenderMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		CompeteAPIInvoker invoker = new CompeteAPIInvoker();
		invoker.setConfig(config);
		return invoker.getTrends("gen", domain, latest);
	}

	public CompeteResponse getGenderMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		CompeteAPIInvoker invoker = new CompeteAPIInvoker();
		invoker.setConfig(config);
		return invoker.getTrends("gen", domain, startDate, endDate);
	}
}
