/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Main {

    // Iterative function to generate all permutations of a String in Java
    // using Collections
    public static void permutations(String character)
    {
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
 
        // initialize the list with the first character of the string
        partial.add(String.valueOf(character.charAt(0)));
 
        // do for every character of the specified string
        for (int forwardcharacter = 1; forwardcharacter< character.length(); forwardcharacter++)
        {
            // consider previously constructed partial permutation one by one
 
            // (iterate backwards to avoid ConcurrentModificationException)
            for (int backwardcharacter = partial.size() - 1; backwardcharacter >= 0 ; backwardcharacter--)
            {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(backwardcharacter);
 
                // Insert next character of the specified string in all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed string in the list
 
                for (int nextcharacter = 0; nextcharacter <= str.length(); nextcharacter++)
                {
                    // Advice: use StringBuilder for concatenation
                    partial.add(str.substring(0, nextcharacter) + character.charAt(forwardcharacter) +
                                str.substring(nextcharacter));
                }
            }
        }
        // print the permutations
        System.out.println(partial);
    }
 
    // Iterative program to generate all permutations of a String in Java
    public static void main(String[] args) {
        String character = "ABC";
        permutations(character);
    }
    
}