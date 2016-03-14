package com.iamvtn.esper;

import java.util.Random;

import com.iamvtn.esper.engine.STOEngine;
import com.iamvtn.esper.model.Stock;

public class StockSender implements Runnable {
	private static StockSender instance = null;

	public static StockSender getInstance() {
		if (instance == null) {
			instance = new StockSender();
		}
		return instance;
	}

	private static Random generator = new Random();

	public static String symbol;
	public static Long from;
	public static Long to;

	public static Stock GenerateRandomRate(String symbol, Long from, Long to) {
		// Insert Dummy Data
		Long price = genRandomLong(from, to, generator);
		Stock rate = new Stock();
		rate.setPriceRF(price);
		rate.setSymbol(symbol);

		return rate;
	}

	public static Long genRandomLong(Long aStart, Long aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		long randomNumber = (long) (fraction + aStart);
		return randomNumber;
	}

	public void run() {
		while (true) {
			Stock stock = GenerateRandomRate(symbol, from, to);

			// TODO send stock to Esper.
			STOEngine.getInstance().getCepRT().sendEvent(stock);
		}
	}
}
