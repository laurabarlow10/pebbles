package pebbles;

/**
 * The no-argument constructor of a class implementing this 
 * interface should initialize the PebbleBag with no cards.
 * 
 * @author Tim
 * @author Laura
 */

public interface PebbleBag {
    
    /**
     * Method returns the quantity of pebbles held within.
     * <p>
     * PebbleBag contains Pebble objects, and this 
     * reflects the quantity held.
     * 
     * @return the quantity of Pebble instances held within
     */
    public int size();

    /**
     * Method adds a Pebble to the PebbleBag.
     * <p>
     * This method places the pebble randomly in the PabbleBag
     * 
     * @param pebble Pebble to be put into the PebbleBag
     */
    public void put(Pebble pebble);

    /**
     * Method returns a random Pebble.
     * <p>
     * This method randomly places the pebble in the PebbleBag
     * 
     * @return the pebble removed from the PebbleBag
     */
    public Pebble remove();
}
