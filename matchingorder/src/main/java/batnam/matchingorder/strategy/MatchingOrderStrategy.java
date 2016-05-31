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

        String stmt = "SELECT * FROM OrderBuy.win:time(8 hour) AS orderBuy, OrderSell.win:time(8 hour) AS orderSell "
                + " WHERE orderBuy.symbol = orderSell.symbol  "
                + " AND orderBuy.price = orderSell.price "
                + " AND orderBuy.quantity = orderSell.quantity "
                ;

        matchingStatement = OrderEngine.getInstance().getCepAdm().createEPL(stmt);

        MatchingOrderListener matchingOrderListener = new MatchingOrderListener();

        matchingStatement.addListener(matchingOrderListener);

        System.out.println("Start Matching Order strategy " + matchingStatement.getText());
    }
}
