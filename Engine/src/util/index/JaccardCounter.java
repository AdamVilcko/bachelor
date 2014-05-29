package util.index;

import engine.iface.IItem;
import java.util.List;

/**
 * It counts Jaccard index between two items. Into a constructor
 * is given selected item and the list of related items between
 * which it will count the Jaccard index and assigne it to the
 * all related items.
 *
 * @author Adam VILČKO
 */
public class JaccardCounter implements ICounter {

    private static final JaccardCounter INSTANCE = new JaccardCounter();

    /**
     * Constructor.
     */
    private JaccardCounter() {    }

    public static JaccardCounter getInstance() {
        return INSTANCE;
    }

    /**
     * Count correlation index for all of given items
     * related to the selected one.
     */
    @Override
    public void countCorrelation(IItem item, List<IItem> items) {
        final Integer[] arrA = item.getVector();
        for (IItem it : items) {
            double intersec = intersection(arrA, it.getVector());
            double union = union(arrA, it.getVector());

            if (union == 0) {
                it.setCorrelation(new Double(0));
                continue;
            }

            it.setCorrelation(intersec/union);
        }
    }

    private double intersection(final Integer[] arrA, final Integer[] arrB) {
        double result = 0;

        for (int i = 0; i < arrA.length || i < arrB.length; i++) {
            if (arrA[i] > 1 && arrB[i] > 1) {
                result++;
            }
        }

        return result;
    }

    private double union(final Integer[] arrA, final Integer[] arrB) {
        double result = 0;

        for (int i = 0; i < arrA.length || i < arrB.length; i++) {
            if (arrA[i] > 1 || arrB[i] > 1) {
                result++;
            }
        }

        return result;
    }

}
