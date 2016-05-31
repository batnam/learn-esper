package batnam.matchingorder.listener;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;

import java.util.Map;

/**
 * Created by namvu on 31/05/2016.
 */
public class MatchingOrderListener implements StatementAwareUpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData, EPStatement epStatement, EPServiceProvider epServiceProvider) {
        System.out.println("Helloooooooooooo");
        if (newData != null) {
            System.out.println("Matching \n");
            Map bean1 = (Map) newData[0].getUnderlying();
            Map bean2 = (Map) newData[1].getUnderlying();

        }
    }

    private void printMapBean(Map bean) {


    }
}
