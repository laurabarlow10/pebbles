package pebbles;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An implementation of Player that can play the game described in the 
 * specification. 
 * 
 * @author wwcy201
 * @author lb552
 */
public class BasePlayer implements Player {
    final private int id;
    final private BasePlayerHand hand;
    final private BasePebbleBag[] table;
    
    
    final private CyclicBarrier startingGate;
            
    /**
     * Method initializes a BasePlayer.
     * <p>
     * A BasePlayer needs two card decks, a flag for when to end, and a starting
     * condition to allow a fair start.
     * 
     * @param id the unique identifier of a player
     * @param input a reference to the deck to take cards from
     * @param output a reference to the deck to discard cards into
     * @param isDone a flag to alert all players when a win has been reached
     * @param startingGate a gate to allow all players to start at once
     */
    public BasePlayer(int id, BasePebbleBag[] table, CyclicBarrier startingGate) {
        this.id = id;
        hand = new BasePlayerHand();
        this.table = table;
        this.startingGate = startingGate;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addPebble(Integer i) {
        hand.put(i);
        checkDoneCondition();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkDoneCondition() {
        if(hand.totals100()) {
                //launch inturupt. google it
                System.out.println("Player "+id+" wins");
                return true;
        }
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            startingGate.await();
            //Where each players loop runs
            //Got 9 pebbles
            //Draw pebble
            //check if 100
            //discard pebble
            //if 100 -> win and inturupt other threads.
        }  catch (InterruptedException | BrokenBarrierException e) {
            return;
        }
        
        //gets done if interrupted, eg gracefully shut down game
         checkDoneCondition();
    }
    
}