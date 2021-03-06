package batnam.matchingorder.model;

/**
 * Created by namvu on 31/05/2016.
 */
public class OrderSell {
	private String symbol;
	private String price;
	private String acctno;
	private String side;
	private String orderId;
	private String quantity;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderSell [symbol=" + symbol + ", price=" + price + ", acctno=" + acctno + ", side=" + side + ", orderId=" + orderId + ", quantity=" + quantity + "]";
	}
}