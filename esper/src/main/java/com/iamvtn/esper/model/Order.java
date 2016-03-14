package com.iamvtn.esper.model;

public class Order {
	private String userId;
	private String acctNo;
	private String symbol;
	private Long qtty;
	private Long price;
	private String strategyType;
	private Long stopPrice;
	private Long takePrice;
	private String orderId;

	@Override
	public String toString() {
		return "acctNo: " + acctNo.toString() + " - userId: " + userId.toString()
				+ " - buy price: " + price.toString()
				+ " - symbol: " + symbol.toString() + " - stopPrice: " + stopPrice.toString()
				+ " - takePrice: " + takePrice.toString() + " - qtty: " + qtty.toString();
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the acctNo
	 */
	public String getAcctNo() {
		return acctNo;
	}

	/**
	 * @param acctNo the acctNo to set
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
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
	 * @return the qtty
	 */
	public Long getQtty() {
		return qtty;
	}

	/**
	 * @param qtty the qtty to set
	 */
	public void setQtty(Long qtty) {
		this.qtty = qtty;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return the strategyType
	 */
	public String getStrategyType() {
		return strategyType;
	}

	/**
	 * @param strategyType the strategyType to set
	 */
	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}

	/**
	 * @return the stopPrice
	 */
	public Long getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(Long stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the takePrice
	 */
	public Long getTakePrice() {
		return takePrice;
	}

	/**
	 * @param takePrice the takePrice to set
	 */
	public void setTakePrice(Long takePrice) {
		this.takePrice = takePrice;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
