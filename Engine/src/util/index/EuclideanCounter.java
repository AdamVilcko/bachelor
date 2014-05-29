/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.index;

import engine.iface.IItem;
import java.util.List;

/**
 * Counter for counting Euclidean space distance between
 * item and the items given in a list. It counts distance
 * measure between two items ind assigne it to the one from
 * the given list.
 *
 * @author Adam VILČKO
 */
public class EuclideanCounter implements ICounter {

    private static final EuclideanCounter INSTANCE = new EuclideanCounter();

    /**
     * Constructor.
     */
    private EuclideanCounter() {    }

    public static EuclideanCounter getInstance() {
        return INSTANCE;
    }

    @Override
    public void countCorrelation(final IItem item, List<IItem> items) {
        final Integer[] arrA = item.getVector();
        for (IItem it : items) {
            double basic = countBasic(arrA, it.getVector());
            it.setCorrelation(Math.sqrt(basic));
        }
    }

    private double countBasic(final Integer[] arrA, final Integer[] arrB) {
        double result = 0;

        for (int i = 0; i < arrA.length || i < arrB.length; i++) {
            result += Math.pow(arrA[i].doubleValue() - arrB[i].doubleValue(), 2);
        }

        return result;
    }

}
