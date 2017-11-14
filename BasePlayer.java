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
    final private PebbleBag hand;
    final private PebbleBag give;
    final private PebbleBag take;
    final private PebbleBag lastBag;
    final private PebbleBag discardWeight;
    
    
    final private AtomicBoolean isDone;
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
    public BasePlayer(int id,PebbleBag take,PebbleBag give, PebbleBag discardWeight, PebbleBag lastBag, AtomicBoolean isDone, CyclicBarrier startingGate) {
        this.id = id;
        hand = new BasePebbleBag();
        this.give = give;
        this.take = take;
        this.lastBag = lastBag;
        this.isDone = isDone;
        this.discardWeight = discardWeight;
        this.startingGate = startingGate;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addPebble(Pebble pebble) {
        hand.put(pebble);
        checkDoneCondition();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkDoneCondition() {
        //change so that player bag is different to bags on the table as have different methods, can both extend pebblebag
        if(hand.totals100()) {
            if (isDone.compareAndSet(false, true)) {
                System.out.println("Player "+id+" wins");
                return true;
            }
        }
        return false;
    }
    
    private void discardPebble() {
        
        output.remove(hand.remove());
    } 
    
    private void takeCard() {
        hand.enqueue(input.dequeue());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            startingGate.await();
        }  catch (InterruptedException | BrokenBarrierException e) {
            return;
        }
        
        while(!isDone.get()) {
            if(input.isEmpty()) {
                continue;
            }
            
            try {
                takeCard();
            } catch (IllegalStateException e) {
                throw new RuntimeException("input was empty: "+e);
            }
            
            while(hand.getHead().getNumber().equals(id)) {
                hand.enqueue(hand.dequeue());
            }
            discardCard();
            
            checkDoneCondition();
        }
    }
    
}