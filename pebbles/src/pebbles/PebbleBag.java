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


    /**
     * Method checks if the bag totals 100.
     * <p>
     * This method returns whether the bag totals a weight of 100
     * 
     * @param pebble to be checked against
     * @return whether the bag totals 100
     */
    public boolean totals100(Pebble pebble);

    /**
     * Method checks if there are any pebbles in the bag.
     * 
     * @return whether there are any pebbles in the bag
     */
    public boolean isEmpty();
    
    /**
     * Method checks if a bag is valid for the specifications provided
     * 
     * @return whether a bag is valid 
     */
    public boolean isValid();
    
    
   
}
