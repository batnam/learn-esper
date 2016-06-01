package batnam.matchingorder.listener;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;
import com.espertech.esper.event.bean.BeanEventBean;

/**
 * Created by namvu on 31/05/2016.
 */
public class MatchingOrderListener implements StatementAwareUpdateListener {

	public void update(EventBean[] newData, EventBean[] oldData, EPStatement epStatement, EPServiceProvider epServiceProvider) {
		System.out.println("Helloooooooooooo");
		if (newData != null) {

			Object newDataObj = newData[newData.length - 1].getUnderlying();
			Map<String, Object> def = (HashMap<String, Object>) newDataObj;

			BeanEventBean orderSell = (BeanEventBean) def.get("s");
			System.out.println(orderSell.toString() + " * " + orderSell.get("orderId"));
			BeanEventBean orderBuy = (BeanEventBean) def.get("b");
			System.out.println(orderBuy.toString() + " * " + orderBuy.get("orderId"));

			System.out.println("Matching \n");
		}
	}
}
