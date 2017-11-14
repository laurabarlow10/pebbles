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
    
    final private ArrayList<Pebble> PebbleBag;
    
    /**
     * Method initializes an empty BaseCardDeck
     */
    public BasePebbleBag() {
        PebbleBag = new ArrayList();
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
            throw new IllegalStateException("Can't dequeue an empty deck");         
        }       
        int rando = (int)((Math.random()*PebbleBag.size()));
        Pebble pebble = PebbleBag.remove(rando);         
        
        return pebble;
    }
    
    /**
     * {@inheritDoc}
    
    @Override
    public synchronized Card getHead() {
        if(deck.isEmpty()){             
            throw new IllegalStateException("Can't get head of an empty deck");         
        }         
                
        return deck.getFirst();
    }
     */
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean totals100(PebbleBag pebbleBag) {
        if(isEmpty()) {
            return false;
        }
        int total = new int 0;
        for (int i=0; i < PebbleBag.size(); i++) { 
            
            total += (int)(Pebble.getWeight());                     
                         //need comparable to be an int to sum
                         //if not 100 return false
                         
            }             
        }

        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean isEmpty() {
        return pabbleBag.isEmpty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid() {
    //positive integers, comma separated, contains minimum 11*no of players
    //comma separated regex check done when read in 
        Map<Pebble, Integer> m = new HashMap();
        
        for (int i=0; i < PebbleBag.size(); i++) {   
            
            if(0 < i < 92) {
            //contains minimum 11*no of players need to access command line input for no of players??
                return true;
            }        
            m.put(card, (freq == null) ? 1 : freq + 1);
        }
        
        return false;
    }
    
}
