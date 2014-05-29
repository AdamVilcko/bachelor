/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Adam
 */
@ManagedBean(name="item")
@SessionScoped
public class Item {

    /**
     * Creates a new instance of Item
     */
    public Item(int id) {
        this.id = id;
    }
    
    private final int id;
    
    public int getId() {
        return id;
    }

}
