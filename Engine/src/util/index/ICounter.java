/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.index;

import engine.iface.IItem;
import java.util.List;

/**
 *
 * @author Adam
 */
public interface ICounter {

    /**
     * Count correlation index for all of given items
     * related to the selected one.
     */
    void countCorrelation(IItem item, List<IItem> items);

}
