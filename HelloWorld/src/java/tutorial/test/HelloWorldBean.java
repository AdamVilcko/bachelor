/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adam
 */
@ManagedBean(name="helloWorldBean")
@SessionScoped
public class HelloWorldBean implements Serializable {

    /**
     * Creates a new instance of HelloWorldBean
     */
    public HelloWorldBean() {
        Random r = new Random();
        random = new Integer(r.nextInt(10));
        System.out.println(random);
        
        for (int i = 0; i < 99; i++) {
            items.add(new Item(i));
        }
    }
    
    private Integer random;
    private Integer userNumber;
    String response;
    private List<Item> items = new ArrayList<Item>();
    private Item item;
    private int selectedId;

    public Integer getRandom() {
        return random;
    }
    
    public void setRandom(Integer r) {
        this.random = r;
    }
    
    public Integer getUserNumber() {
        return userNumber;
    }
    
    public void setUserNumber(Integer i) {
        this.userNumber = i;
    }
    
    public String getResponse() {
        if ((userNumber != null) && (userNumber.compareTo(random) == 0)) {

            //invalidate user session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();

            return "Yay! You got it!";
        } else {

            return "<p>Sorry, " + userNumber + " isn't it.</p>"
                    + "<p>Guess again...</p>";
        }
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> l) {
        this.items = l;
    }
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item i) {
        this.item = i;
    }
    
    public int getSelectedId() {
        return selectedId;
    }
    
    public void setSelectedId(int i) {
        this.selectedId = i;
    }
    
    public void initItemView() {
//        if (selectedId == null) {
//            String message = "Bad request. Please use a link from within the system.";
//            FacesContext.getCurrentInstance().addMessage(null, 
//                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
//            return;
//        }
        
        item = items.get(selectedId);
        if (item == null) {
            String message = "Bad request. Unknown item.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
    
}
