/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import engine.iface.IItem;
import java.util.Comparator;

/**
 *
 * @author Adam
 */
public class ItemComparator implements Comparator<IItem> {

    @Override
    public int compare(IItem o1, IItem o2) {
        return o1.getCorrelation().compareTo(o2.getCorrelation());
    }

}
