package com.iamvtn.esper.engine;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.iamvtn.esper.model.Stock;

public class STOEngine {
	private static STOEngine instance = null;

	public static STOEngine getInstance() {
		if (instance == null) {
			instance = new STOEngine();
		}
		return instance;
	}

	EPServiceProvider cep;
	EPRuntime cepRT;
	EPAdministrator cepAdm;

	public STOEngine() {
		Configuration cepConfig = new Configuration();
		// We register Stock as objects the engine will have to handle
		cepConfig.addEventType("Stock", Stock.class.getName());

		// We setup the engine
		cep = EPServiceProviderManager.getProvider("stoEngine", cepConfig);
		cepRT = cep.getEPRuntime();
		cepAdm = cep.getEPAdministrator();
	}

	/**
	 * @return the cep
	 */
	public EPServiceProvider getCep() {
		return cep;
	}

	/**
	 * @return the cepRT
	 */
	public EPRuntime getCepRT() {
		return cepRT;
	}

	/**
	 * @return the cepAdm
	 */
	public EPAdministrator getCepAdm() {
		return cepAdm;
	}
}
