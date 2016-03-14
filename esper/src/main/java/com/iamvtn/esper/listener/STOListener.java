package com.iamvtn.esper.listener;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;
import com.iamvtn.esper.model.Order;
import com.iamvtn.esper.model.Stock;

public class STOListener implements StatementAwareUpdateListener {
	Order orderEvent = new Order();

	public STOListener(Order orderEvent) {
		this.orderEvent = orderEvent;
	}

	public void update(EventBean[] newData, EventBean[] oldData, EPStatement epStatement, EPServiceProvider epServiceProvider) {
		if (newData != null) {
			Stock rateEvent = (Stock) newData[newData.length - 1].getUnderlying();

			if (orderEvent.getTakePrice() != null && orderEvent.getTakePrice() > 0
					&& rateEvent.getPriceRF() >= orderEvent.getTakePrice()) {
				System.out.println(" ********************** ");
				System.out.println(" - TakeProfitOrderListener received: ");
			} else if (orderEvent.getStopPrice() != null && orderEvent.getStopPrice() > 0
					&& rateEvent.getPriceRF() <= orderEvent.getStopPrice()) {
				System.out.println(" ********************** ");
				System.out.println(" - StopLossOrderListener received: ");
			}

			System.out.println(" - Rate: " + rateEvent.toString());
			System.out.println(" - Order: " + orderEvent.toString());
			System.out.println(" ********************** ");

			epStatement.removeListener(this);
		}
	}

}
