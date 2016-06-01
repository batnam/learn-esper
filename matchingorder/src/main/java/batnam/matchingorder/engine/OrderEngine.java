package batnam.matchingorder.engine;

import batnam.matchingorder.model.OrderBuy;
import batnam.matchingorder.model.OrderSell;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 * Created by namvu on 31/05/2016.
 */
public class OrderEngine {
	private static OrderEngine instance = null;

	public static OrderEngine getInstance() {
		if (instance == null) {
			instance = new OrderEngine();
		}
		return instance;
	}

	EPServiceProvider cep;
	EPRuntime cepRT;
	EPAdministrator cepAdm;

	public OrderEngine() {
		Configuration cepConfig = new Configuration();
		// We register Stock as objects the engine will have
		cepConfig.addEventType("OrderS", OrderSell.class.getName());
		cepConfig.addEventType("OrderB", OrderBuy.class.getName());

		// We setup the engine
		cep = EPServiceProviderManager.getProvider("orderEngine", cepConfig);
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
