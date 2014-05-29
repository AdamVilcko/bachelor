package engine;

import engine.iface.IItem;
import java.util.List;
import util.index.CosineCounter;
import util.index.EuclideanCounter;
import util.index.ICounter;
import util.index.Index;
import util.index.JaccardCounter;

/**
 *
 * @author Adam VILČKO
 */
public class CounterFactory {

    /**
     * Initialize wanted counter that is selected and set-up by the user.
     *
     * @param selectedIndex
     *          Flag indicating selected counter.
     * @param item
     *          Item selected by the user.
     * @param items
     *          List of related items.
     * @return
     *          Initialized counter.
     */
    public static ICounter getSelectedCounter(Index selectedIndex) {
        ICounter counter;

        switch (selectedIndex) {
            case JACCARD:
                counter = JaccardCounter.getInstance();
                break;
            case COSINE:
                counter = CosineCounter.getInstance();
                break;
            case EUCLIDEAN:
                counter = EuclideanCounter.getInstance();
                break;
            default:
                counter = CosineCounter.getInstance();
        }

        return counter;
    }

}
