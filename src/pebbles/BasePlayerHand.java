/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pebbles;

import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class BasePlayerHand implements PebbleBag {
    final private ArrayList<Pebble> PebbleBag;
    
    
    public BasePlayerHand() {
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
    
    public boolean totals100() {
        int total = 0;
        for (int i=0; i < PebbleBag.size(); i++) { 
            total += (int)(PebbleBag.get(i).getWeight());                     
                         //need comparable to be an int to sum
                         //if not 100 return false
                         
        }      
        return total == 100;
    }

}
