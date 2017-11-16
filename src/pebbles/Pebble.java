package pebbles;

/**
 * A class implementing this interface should
 * store the identity of the pebble and be able
 * to return a numerical representation.
 * 
 * @author Tim
 * @author Laura
 * @param <T> The type of value stored within a pebble
 */

public interface Pebble<T  extends Comparable<T>> {

    /**
     * Method returns a numerical representation of the pebble.
     * <p>
     * This method is deterministic and should not change after
     * the identity of the pebble has been set.
     * 
     * @return the numerical representation of the pebble
     */
    public T getWeight();
}
