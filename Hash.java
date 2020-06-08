import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Hash Class. Responsible for any task that involves hashing and provides the tools/methods according so.
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class Hash
{
    // instance variables 
    private PrintWriter pw;

    private String[] hashTab;

    private int coll;
    private int resColl;
    private int totalColl; 
    
    private int numOfElem;
    
    private int omitCount;
    
    private int keyCode;

    /**
     * Constructor for objects of class Hash
     */
    public Hash(PrintWriter pw)
    {
        // initialise instance variables
        this.pw = pw;
        this.hashTab = new String[37];

        this.omitCount = 0;
        
        this.coll = 0;
        this.resColl = 0;
        this.totalColl = 0;
        
        this.numOfElem = 0;
    }

    /**
     * - Responsible for generating an address when given a key
     *
     * @param     String s (a string representing a word)
     * @return    return key (the unique key/value that was generated)
     */
    private int getHash(String s) {
        int sum = 0;
        int key = 0;
        final int TABLESIZE = 37;

        for (int i = 0; i < s.length(); i++) {
            sum += (int) s.charAt(i);
        }

        key = (sum^2 * 153*2) % TABLESIZE;
        return key; 
    }

    /**
     * - Responsible for outputting the description of the hash function
     *
     */
    public void displayInfo() {
        System.out.printf("\nHASH FUNCTION DESCRIPTION:\n");
        System.out.printf("A hash function is a function which when given a key, generates an address in the table.\n");
        System.out.printf("The hash function below is preformed by taking a words accumulated unicode value based on the characters it posseses\n");
        System.out.printf("And then taking that unicode sum of the word and running it through the hash function :\n");
        System.out.printf("( sum^2 * 153*2 )\n");
        System.out.printf("In which it provides a unique key for a word to be inserted in the hash table with an address\n\n\n");

        pw.printf("\nHASH FUNCTION DESCRIPTION:\n");
        pw.printf("A hash function is a function which when given a key, generates an address in the table.\n");
        pw.printf("The hash function below is preformed by taking a words accumulated unicode value based on the characters it posseses\n");
        pw.printf("And then taking that unicode sum of the word and running it through the hash function :\n");
        pw.printf("( sum^2 * 153*2 )\n");
        pw.printf("In which it provides a unique key for a word to be inserted in the hash table with an address\n\n\n");
    }

    /**
     * - Responsible for mapping a ommited word. First it generates the unique address/value for the word and then it inserts it into the hash table
     *
     * @param     String s (the word represented as a String) 
     */
    public void map(String s) {
        keyCode = getHash(s);
        insert(keyCode, s);
    }

    /**
     * - Responsible for inserting the omited word. Uses Linear probing as a solution to collisions when inserting.
     *
     * @param     int code , String s (the word represented as a String)
     */
    public void insert(int code, String s) {
        int count = 0;
        int pro = code;
        
        if(hashTab[code] != null) {
            coll++;
            //Linear Probing as the solution for collisions
            while(hashTab[pro] != null) {
                pro++;
                
                if (count > 0) {
                    resColl++;
                }
                count++;
                if(pro > hashTab.length-1) {
                    pro = 0;
                }
            }
            if(hashTab[pro] == null) {
                hashTab[pro] = s;
                numOfElem++;
            }  
        } else {
            hashTab[code] = s; 
            numOfElem++;
        }
    }

    /**
     * - Responsible for displaying/outputting the contents of the hash table (including indices of each item in the hash table). Displays load factor and collisison details as well
     *
     */
    public void displayHashTab() {
        displayInfo();

        System.out.printf("Count   |     Key\n");
        System.out.printf("-----------------------\n");
        pw.printf("Count   |     Key\n");
        pw.printf("-----------------------\n");

        for (int ind = 0; ind < hashTab.length; ind++) {
            if(hashTab[ind] != null) {
                System.out.println(String.format("  %-5d |     %-5s", ind, hashTab[ind]));
                System.out.printf("        ---------------\n");
                pw.println(String.format("  %-5d |     %-5s", ind, hashTab[ind]));
                pw.printf("        ---------------\n");
            } else if (hashTab[ind] == null) {
                System.out.println(String.format("  %-5d |     %-5s", ind, "-"));
                System.out.printf("        ---------------\n");
                pw.println(String.format("  %-5d |     %-5s", ind, "-"));
                pw.printf("        ---------------\n");
            }
        }

        float loadFactor = (float)  numOfElem / hashTab.length;
        loadFactor *= 100;
        
        System.out.printf("\nLoad Factor of the Hash Table: " + (int) loadFactor + "%%\n");
        pw.printf("\nLoad Factor of the Hash Table: " + (int) loadFactor + "%%\n");
        
        
        totalColl = coll + resColl;
        
        System.out.printf("\nNumber of hash function collisions: " + coll + "\n");
        pw.printf("\nNumber of hash function collisions: " + coll + "\n");
        
        System.out.printf("\nNumber of resolution collisions: " + resColl + "\n");
        pw.printf("\nNumber of resolution collisions: " + resColl + "\n");
        
        System.out.printf("\nTotal number of Collisions: " + totalColl + "\n\n");
        pw.printf("\nTotal number of Collisions: " + totalColl + "\n\n");
    }

    /**
     * - Responsible for searching a word in the hash table. 
     *   
     *   *If the index of the array is empty, it's a missed searched. 
     *   *If the index of the array matches with the string/word, then it found a omited word (successful search).
     *   *If the index of an array does not match the string/word, then the array list is Linear probed until it hits a succesful search. 
     *   *If the string/word is not found until the end of laping around the hash table, then it's a failed search
     *
     * @param     String s (the word represented as a String) 
     * @return    returns a true or false statement
     */
    public boolean search(String s) {
        keyCode = getHash(s);

        boolean lapAround = false;
        int pro = keyCode;
        
        if(hashTab[keyCode] == null){
            return false;
        } 
        if (hashTab[keyCode].equals(s)) {
            omitCount++;
            return true;
        } 
        while (hashTab[pro] != null && !(hashTab[pro].equals(s))) {
            pro++;
            
            if (lapAround == true && pro == keyCode) {
                return false;
            }
            if (pro > hashTab.length - 1) {
                pro = 0;
                lapAround = true;
            }
            if (hashTab[pro] != null && hashTab[pro].equals(s)){
                omitCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * A getter method for the omit count 
     *
     * @return    return omitCount;
     */
    public int getOmitCount() {
        return omitCount;
    }
}
