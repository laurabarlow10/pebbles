package pebbles;

/**
 * A class implementing this interface should
 * accept pebbles and understand what constitutes a
 * done condition, in reference to the game being played.
 * 
 * @author Tim
 * @author Laura
 */

public interface Player extends Runnable {

    /**
     * Method adds pebbles to an internal hand.
     * <p>
     * The pebble must be stored within the instance, with
     * the ability to use the pebble at a later date to try
     * and reach a defined winning condition.
     * 
     * @param pebble Pebble to be added to the players hand
     */
    public void addPebble(Pebble pebble);

    /**
     * Method checks held pebbles to see if met defined condition
     * <p>
     * The result must be deterministic, and fit with the 
     * definition of a winning condition.
     * 
     * @return whether the pebbles held equal a winning condition
     */
    public boolean checkDoneCondition();
    
}
