/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import engine.iface.IItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import util.ItemComparator;
import util.index.ICounter;
import util.index.Index;

/**
 *
 * @author Adam
 */
public class Engine {

    public Engine(IItem item, List<IItem> items) {
        this.item = item;
        this.items = items;
    }

    private final IItem item;

    private final List<IItem> items;

    private Index index = Index.JACCARD;

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public void assigneRelatedItemsToSelectedOne() {
        ICounter counter = CounterFactory.getSelectedCounter(index);
        counter.countCorrelation(item, items);
        List<IItem> l = new ArrayList<>(items);
        Iterator<IItem> it = l.listIterator();

        while (it.hasNext()) {
            final IItem i = it.next();
            System.out.println(i.getCorrelation());
            if (i.getCorrelation() < 0.1 || i.equals(item)) {
                it.remove();
            }
        }

        Collections.sort(l, new ItemComparator());
        item.setRelatedItems(l);
    }

}
