package util.index;


/**
 * Enumeration of possible indexes that the user can select.
 *
 * @author Adam
 */
public enum Index {

    JACCARD("Jaccard Index"),
    COSINE("Cosine Distance"),
    EUCLIDEAN("Euclidean Distance");

    private final String index;

    private Index(String s) {
        this.index = s;
    }

    public String getLabel() {
        return index;
    }

}
