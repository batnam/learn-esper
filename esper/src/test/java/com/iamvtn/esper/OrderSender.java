package com.iamvtn.esper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.iamvtn.esper.event.STOStrategy;
import com.iamvtn.esper.model.Order;

public class OrderSender {
	static Thread t1;

	public static Order initCust() {
		Order orderStrategy = new Order();
		orderStrategy.setUserId("0001");
		orderStrategy.setAcctNo("0001000089");
		orderStrategy.setQtty(100L);
		return orderStrategy;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Order orderS = initCust();
		consoleLog(orderS);

	}

	public static void consoleLog(Order orderS) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;

		print();
		while ((s = in.readLine()) != null) {
			if (s.equalsIgnoreCase("sto")) {
				printCustInfoSTO(orderS, in);
				orderS.setStrategyType("STO");
				STOStrategy.getInstance().run(orderS);
			} else if (s.equalsIgnoreCase("so")) {
				printCustInfoSO(orderS, in);
				orderS.setStrategyType("SO");
				STOStrategy.getInstance().run(orderS);
			} else if (s.equalsIgnoreCase("to")) {
				printCustInfoTO(orderS, in);
				orderS.setStrategyType("TO");
				STOStrategy.getInstance().run(orderS);
			} else if (s.equalsIgnoreCase("stock")) {
				printStockInfo(in);
				if (t1 != null && t1.isAlive()) {
					t1.interrupt();
				}
				t1 = new Thread(StockSender.getInstance());
				t1.start();
			}

			print();
		}
	}

	public static void printStockInfo(BufferedReader in) throws IOException {
		System.out.println("Symbol: ");
		StockSender.symbol = in.readLine();
		System.out.println("Random price from: ");
		StockSender.from = Long.parseLong(in.readLine());
		System.out.println("Random price to: ");
		StockSender.to = Long.parseLong(in.readLine());
	}

	public static void printCustInfoSTO(Order ord, BufferedReader in) throws IOException {
		System.out.println("Symbol: ");
		String symbol = in.readLine();
		ord.setSymbol(symbol);
		System.out.println("Buy Price: ");
		String price = in.readLine();
		ord.setPrice(Long.parseLong(price));
		System.out.println("Stop Loss Price: ");
		String stopPrice = in.readLine();
		ord.setStopPrice(Long.parseLong(stopPrice));
		System.out.println("Take Profit Price: ");
		String takePrice = in.readLine();
		ord.setTakePrice(Long.parseLong(takePrice));
	}

	public static void printCustInfoSO(Order ord, BufferedReader in) throws IOException {
		System.out.println("Symbol: ");
		String symbol = in.readLine();
		ord.setSymbol(symbol);
		System.out.println("Buy Price: ");
		String price = in.readLine();
		ord.setPrice(Long.parseLong(price));
		System.out.println("Stop Loss Price: ");
		String stopPrice = in.readLine();
		ord.setStopPrice(Long.parseLong(stopPrice));
	}

	public static void printCustInfoTO(Order ord, BufferedReader in) throws IOException {
		System.out.println("Symbol: ");
		String symbol = in.readLine();
		ord.setSymbol(symbol);
		System.out.println("Buy Price: ");
		String price = in.readLine();
		ord.setPrice(Long.parseLong(price));
		System.out.println("Take Profit Price: ");
		String takePrice = in.readLine();
		ord.setTakePrice(Long.parseLong(takePrice));
	}

	public static void print() {
		System.out.println("===========");
		System.out.println("type 'sto' to send order to Stop Loss and Take Profit Strategy ");
		System.out.println("type 'so' to send order to Stop Loss Strategy ");
		System.out.println("type 'to' to send order to Take Profit Strategy ");
		System.out.println("type 'stock' to send random stock to Esper engine ");
		System.out.println("type 'exit' to shut down");
		System.out.println("===========");
	}
}
