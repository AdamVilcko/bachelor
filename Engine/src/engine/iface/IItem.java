package engine.iface;

import java.util.List;

/**
 *
 * @author Adam VILČKO
 */
public interface IItem {

    /**
     * Getter for Item ID.
     *
     * @return
     *      ID of selected item.
     */
    int getId();

    /**
     * Getter for vector of related items.
     *
     * @return
     *      Array of integers that represent linkage.
     */
    Integer[] getVector();

    /**
     * Add one of an vector integer at given index.
     *
     * @param index
     *      Index of vector value that is going to be added by one.
     */
    void addVectorValueAt(int index);

    /**
     * Setter for the related items of selected item.
     *
     * @param l
     *      List of related items.
     */
    void setRelatedItems(List<IItem> l);

    /**
     * Getter for a correlation index related to a selected item.
     *
     * @return
     *      Value of a correlation index.
     */
    Double getCorrelation();

    /**
     * Setter for a correlation index related to a selected item.
     *
     * @param d
     *      Value of a correlation index.
     */
    void setCorrelation(Double d);

    /**
     * Getter for related items of selected item.
     *
     * @return
     *      List of related items.
     */
    List<IItem> getRelatedItems();

}
