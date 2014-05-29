package item;

import engine.iface.IItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Adam
 */
@ManagedBean(name="item")
@SessionScoped
public class Item implements IItem, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     *
     * @param id
     *      Item ID.
     * @param vector
     *      Initialized vector for correlation counting purposes.
     */
    public Item(int id, Integer[] vector) {
        this.id = id;
        this.vector = vector;
        initVectorValues();
    }

    private void initVectorValues() {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }
    }

    private final int id;

    private final Integer[] vector;

    private Double correlation = new Double(0);

    private List<IItem> relatedItems = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Integer[] getVector() {
        return vector;
    }

    @Override
    public void addVectorValueAt(int index) {
        if (index == -1) {
            return;
        }

        this.vector[index] += 1;
    }

    @Override
    public Double getCorrelation() {
        return correlation;
    }

    @Override
    public void setCorrelation(Double d) {
        this.correlation = d;
    }

    @Override
    public boolean equals(Object o) {
        return id == ((Item) o).getId();
    }

    @Override
    public List<IItem> getRelatedItems() {
        return relatedItems;
    }

    @Override
    public void setRelatedItems(List<IItem> l) {
        this.relatedItems = l;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Arrays.hashCode(this.vector);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item[");
        sb.append("id=");
        sb.append(id);
        sb.append(", vector=");
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
