/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pebbles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author laura
 */
public class Pebbles {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws Exception{

        if (args.length == 0){
            System.out.println("Command line input was empty.");
            System.exit(1);
        }
        /*
        try {
            File file = new File(args[1]);
            input = new Scanner(file);
        } catch (FileNotFoundException ioException) {
            System.err.println("Cannot open file.");
            System.exit(1);
        }
        **/
        ArrayList arr = new ArrayList();
        
        BufferedReader br = new BufferedReader(new FileReader(args[1]));
        String line = null;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String str : values) {
                arr.add(Integer.parseInt(str));
      }
    }
    br.close();
        System.out.println(arr);
        int amount;
        amount = Integer.parseInt(args[0]);
        
        
        // TODO code application logic here
    }
}
    
