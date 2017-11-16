/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pebbles;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author laura
 */
public class Pebbles {
    static int numBags = 6;

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        BasePebbleBag[] table;
        String p = new String("12, 13, 14, 67, 78, 89, 90, 45, 23, 56, 45, 23, 45, 4, 6, 8, 3, 5, 1, 34, 2, 56, 34, 6, 54, 32, 43, 2");
        table = new BasePebbleBag[numBags];
        ArrayList<ArrayList<Integer>> pebbleWeightsArray;
        pebbleWeightsArray = new ArrayList<ArrayList<Integer>>(numBags);
        for (int x = 0; x < numBags; x++){
             try{
                //if x < 3
                pebbleWeightsArray.add(x, parseInput(p)); // pebble lists 0,1,2
                //if x > 2 
                //give empty array list 
            } catch (NumberFormatException e) {
                System.out.println("File presented was in an invalid formet. Please provide file in a valid format (integers separated by commas)");
                System.exit(1);
            }
            table[x] = new BasePebbleBag(pebbleWeightsArray.get(x));
        }
        
        int numPlayers = 3;
        BasePlayer[] players;
        CyclicBarrier barrier = new CyclicBarrier(numPlayers);
        players = new BasePlayer[numPlayers];
        for (int x = 0; x < numPlayers; x++){
            players[x] = new BasePlayer(x, table, barrier);
        }
        
        //create a player instance for each player
        //set game running
        return;
    }
    
    public static ArrayList<Integer> parseInput(String input) throws NumberFormatException{
        String[] split = input.split(",");
        ArrayList<Integer> bag = new ArrayList<Integer>();
        for (int x = 0; x < split.length; x++){
            bag.add(Integer.parseInt(split[x]));
           
        }
        return bag;
    }
    
}
