package com.iamvtn.esper.model;

public class Stock {
	private String symbol;
	private String exchange;
	private Long priceCE;
	private Long priceFL;
	private Long priceRF;

	@Override
	public String toString() {
		return "Symbol: " + symbol + " - priceRF: " + priceRF;

	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * @param exchange the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	/**
	 * @return the priceCE
	 */
	public Long getPriceCE() {
		return priceCE;
	}

	/**
	 * @param priceCE the priceCE to set
	 */
	public void setPriceCE(Long priceCE) {
		this.priceCE = priceCE;
	}

	/**
	 * @return the priceFL
	 */
	public Long getPriceFL() {
		return priceFL;
	}

	/**
	 * @param priceFL the priceFL to set
	 */
	public void setPriceFL(Long priceFL) {
		this.priceFL = priceFL;
	}

	/**
	 * @return the priceRF
	 */
	public Long getPriceRF() {
		return priceRF;
	}

	/**
	 * @param priceRF the priceRF to set
	 */
	public void setPriceRF(Long priceRF) {
		this.priceRF = priceRF;
	}

}
