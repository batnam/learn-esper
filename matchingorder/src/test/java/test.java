import batnam.matchingorder.engine.OrderEngine;
import batnam.matchingorder.strategy.MatchingOrderStrategy;
import batnam.matchingorder.model.OrderSell;
import batnam.matchingorder.model.OrderBuy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by namvu on 31/05/2016.
 */
public class test {
    public static void main(String[] args) throws Exception {
        MatchingOrderStrategy.getInstance().run();

        OrderSell orderSell = new OrderSell();
        orderSell.setAcctno("ACC1234561");
        orderSell.setOrderId("ID1234561");
        orderSell.setPrice("2000");
        orderSell.setQuantity("100");
        orderSell.setSymbol("ACB");
        OrderEngine.getInstance().getCepRT().sendEvent(orderSell);

        OrderBuy orderBuy = new OrderBuy();
        orderBuy.setAcctno("ACC1234562");
        orderBuy.setOrderId("ID1234562");
        orderBuy.setPrice("2000");
        orderBuy.setQuantity("100");
        orderSell.setSymbol("ACB");
        OrderEngine.getInstance().getCepRT().sendEvent(orderBuy);


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while ((s = in.readLine()) != null) {
            if (s.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
        }
    }
}
