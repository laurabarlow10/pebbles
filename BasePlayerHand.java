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
    final private ArrayList<Integer> PebbleBag;
    
    
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
    public synchronized void put(Integer i) {
        PebbleBag.add(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Integer remove() {
        if(PebbleBag.isEmpty()){  
            //need to add from white bag to refil not throw exception??
            //return zero to indicate that bag is empty so we can do above
            throw new IllegalStateException("Can't dequeue an empty deck");         
        }       
        int rando = (int)((Math.random()*PebbleBag.size()));
        Integer i = PebbleBag.remove(rando);         
        
        return i;
    }

    public boolean totals100() {
        int total = 0;
        for (int i=0; i < PebbleBag.size(); i++) { 
            total += (int)(PebbleBag.get(i)); 
        }      
        return total == 100;
    }

}
