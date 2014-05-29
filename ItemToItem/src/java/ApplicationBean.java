
import engine.iface.IItem;
import java.io.Serializable;
import item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import util.index.Index;

/**
 *
 * @author Adam
 */
@ManagedBean(name="appBean")
@SessionScoped
public class ApplicationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int ITEMS_NUMBER = 16;

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
        for (int i = 0; i < ITEMS_NUMBER; i++) {
            items.add(new Item(i, new Integer[ITEMS_NUMBER]));
        }
    }

    private List<IItem> items = new ArrayList<>();

    private Index counterIndex = Index.COSINE;

    private IItem selectedItem;

    private int selectedItemId;

    public List<IItem> getItems() {
        return items;
    }

    public void setItems(List<IItem> l) {
        this.items = l;
    }

    public IItem getItem() {
        return selectedItem;
    }

    public void setItem(IItem item) {
        this.selectedItem = item;
    }

    public int getSelectedId() {
        return selectedItemId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedItemId = selectedId;
    }

    public Index getCounterIndex() {
        return counterIndex;
    }

    public void setCounterIndex(Index i) {
        this.counterIndex = i;
    }

    public SelectItem[] getCounterIndexes() {
        SelectItem[] selItems = new SelectItem[Index.values().length];
        int i = 0;

        for (Index index : Index.values()) {
            SelectItem si = new SelectItem(index, index.getLabel());
            selItems[i++] = si;
        }

        return selItems;
    }

    public void initItemView() {
        int previsousItemIndex = -1;

        if (selectedItem != null) {
            selectedItem.addVectorValueAt(selectedItemId);
            previsousItemIndex = selectedItem.getId() - 1;
            System.out.println(selectedItem);
        }
        selectedItem = items.get(selectedItemId);
        selectedItem.addVectorValueAt(previsousItemIndex);
        System.out.println(selectedItem);
        engine.Engine e = new engine.Engine(selectedItem, items);
        e.setIndex(counterIndex);
        e.assigneRelatedItemsToSelectedOne();

        if (selectedItem == null) {
            String message = "Bad request. Unknown item.";
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }


}
