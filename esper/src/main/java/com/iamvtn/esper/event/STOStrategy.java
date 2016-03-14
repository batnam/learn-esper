package com.iamvtn.esper.event;

import com.espertech.esper.client.EPStatement;
import com.iamvtn.esper.constants.CommonConstant;
import com.iamvtn.esper.engine.STOEngine;
import com.iamvtn.esper.listener.STOListener;
import com.iamvtn.esper.model.Order;

public class STOStrategy {
	private static STOStrategy instance = null;

	public static synchronized STOStrategy getInstance() {
		if (instance == null) {
			instance = new STOStrategy();
		}
		return instance;
	}

	static EPStatement stoStatement;

	public void run(Order order) {
		System.out.println("Received  :" + order.toString());

		if (order.getStrategyType().equals(CommonConstant.STOPLOSS_TAKEPROFIT_ORDER)) {
			stoStatement = STOEngine.getInstance().getCepAdm().createEPL(
					" SELECT * FROM Stock(symbol='" + order.getSymbol() + "') WHERE priceRF <= " + order.getStopPrice() + " OR priceRF >= " + order.getTakePrice());
		} else if (order.getStrategyType().equals(CommonConstant.TAKEPROFIT_ORDER)) {
			stoStatement = STOEngine.getInstance().getCepAdm().createEPL(
					" SELECT * FROM Stock(symbol='" + order.getSymbol() + "') WHERE priceRF >= " + order.getTakePrice());
		} else if (order.getStrategyType().equals(CommonConstant.STOPLOSS_ORDER)) {
			stoStatement = STOEngine.getInstance().getCepAdm().createEPL(
					" SELECT * FROM Stock(symbol='" + order.getSymbol() + "') WHERE priceRF <= " + order.getStopPrice());
		}

		STOListener stoListener = new STOListener(order);
		stoStatement.addListener(stoListener);

		System.out.println("Start STO strategy" + stoStatement.getText());
	}
}
