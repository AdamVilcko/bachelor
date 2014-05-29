package util.index;

import engine.iface.IItem;
import java.util.List;

/**
 * Counter for counting Cosine distance measure. It counts
 * cosine distance between selected item and the list of
 * related items given in constructor in this object.
 *
 * @author Adam VILČKO
 */
public class CosineCounter implements ICounter {

    private static final CosineCounter INSTANCE = new CosineCounter();

    /**
     * Constructor.
     */
    private CosineCounter() {    }

    public static CosineCounter getInstance() {
        return INSTANCE;
    }

    /**
     * Count correlation index for all of given items
     * related to the selected one.
     */
    @Override
    public void countCorrelation(IItem item, List<IItem> items) {
        final Integer[] selectedVector = item.getVector();

        for (IItem it : items) {
            final Integer[] givenVector = it.getVector();
            double numerator = countNumerator(selectedVector, givenVector);
            double denominator = countDenominator(selectedVector, givenVector);

            if (denominator == 0) {
                it.setCorrelation(new Double(0));
                continue;
            }

            it.setCorrelation(numerator/denominator);
        }
    }

    private double countNumerator(Integer[] arrA, Integer[] arrB) {
        double result = 0;

        for (int i = 0; i < arrA.length && i < arrB.length; i++) {
            result += (arrA[i] * arrB[i]);
        }

        return result;
    }

    private double countDenominator(Integer[] arrA, Integer[] arrB) {
        double resA = 0;
        double resB = 0;

        for (int i = 0; i < arrA.length; i++) {
            resA += Math.pow(arrA[i].doubleValue(), 2);
        }

        for (int i = 0; i < arrB.length; i++) {
            resB += Math.pow(arrB[i].doubleValue(), 2);
        }

        return Math.sqrt(resA) * Math.sqrt(resB);
    }

}
