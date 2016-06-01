package batnam.matchingorder.strategy;

import batnam.matchingorder.engine.OrderEngine;
import batnam.matchingorder.listener.MatchingOrderListener;

import com.espertech.esper.client.EPStatement;

/**
 * Created by namvu on 31/05/2016.
 */
public class MatchingOrderStrategy {
	private static MatchingOrderStrategy instance = null;

	public static synchronized MatchingOrderStrategy getInstance() {
		if (instance == null) {
			instance = new MatchingOrderStrategy();
		}
		return instance;
	}

	static EPStatement matchingStatement;

	public void run() {

		String stmt = "SELECT * FROM OrderB.win:time(8 hour) AS b, OrderS.win:time(8 hour) AS s "
				+ " WHERE b.symbol = s.symbol  "
				+ " AND b.price = s.price "
				+ " AND b.quantity = s.quantity "
				+ " AND b.side != s.side ";
//		String stmt = "SELECT * FROM OrderB.win:time(8 hour) AS b "
//				+ " WHERE b.symbol = 'ACB'  ";

		matchingStatement = OrderEngine.getInstance().getCepAdm().createEPL(stmt);

		MatchingOrderListener matchingOrderListener = new MatchingOrderListener();

		matchingStatement.addListener(matchingOrderListener);

		System.out.println("Start Matching Order strategy " + matchingStatement.getText());
	}
}
