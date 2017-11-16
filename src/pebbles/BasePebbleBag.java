package pebbles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of CardDeck which uses recursion similar to 
 * a LinkedList. This implementation doesn't use any generics.
 * 
 * @author wwcy201
 * @author lb552
 */
public class BasePebbleBag implements PebbleBag {
    
    final private ArrayList<Integer> PebbleBag;
    
    /**
     * Method initializes an empty BaseCardDeck
     */
    public BasePebbleBag(ArrayList<Integer> weights) {
        PebbleBag = weights;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized int size() {
        return PebbleBag.size();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void put(Pebble pebble) {
        PebbleBag.add(pebble);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Pebble remove() {
        if(PebbleBag.isEmpty()){  
            //need to add from white bag to refil not throw exception??
            //return zero to indicate that bag is empty so we can do above
            throw new IllegalStateException("Can't dequeue an empty deck");         
        }       
        int rando = (int)((Math.random()*PebbleBag.size()));
        Pebble pebble = PebbleBag.remove(rando);         
        
        return pebble;
    }

    public boolean isEmpty() {
        return PebbleBag.isEmpty();
    }

    public boolean isValid(int numPlayers) {
        int size = PebbleBag.size();
        if (size != numPlayers * 11) { //Bag size must be 11 times number of players on startup.
            return false;
        }
        //positive integers, comma separated, contains minimum 11*no of players
        //comma separated regex check done when read in 
        for (int i=0; i < size; i++) {   
            if(0 > i) {
                //contains minimum 11*no of players need to access command line input for no of players??
                return false;
            }        
        }

         return true;
    }
    
}
