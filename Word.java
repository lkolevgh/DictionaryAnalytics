import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Word Class. Responsible for making Word objects and having properties to evualuate/modify a Word object
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class Word implements TreeComparable
{
    // instance variables 
    private PrintWriter pw;
    
    private ObjectList list;
    private int count;
    private String word;

    /**
     * Constructor for objects of class Word
     */
    public Word(PrintWriter pw)
    {
        // initialise instance variables
        this.list = new ObjectList(); 
        this.count = 0; 
        this.word = "";
    }
    
    /**
     * Constructor for objects of class Word (for query search)
     */
    public Word(String s)
    {
        this.word = s;
    }
    
    /**
     * Constructor for objects of class Word (for creating a Word Object)
     */
    public Word(PrintWriter pw, String word, int count, ObjectList list)
    {
        // initialise instance variables
        this.pw = pw;
        
        this.list = list; 
        this.count = count; 
        this.word = word;
    }
    
    /**
     * - Responsible for visiting a word in the ObjectList list. Invoked from inTrav(), will output the word, along with the number of times the word was found as well as the 
     *   line numbers and positions of each word found 
     *
     */
    public void visit() {
        System.out.print(String.format("%-12s %-8s", word, count));
        pw.print(String.format("%-12s %-8s", word, count));
        
        ObjectListNode p = list.getFirstNode();
        
        while(p != null) {
            LinePosition lineTemp = (LinePosition) p.getInfo();
            System.out.print(lineTemp.getLine() + "-" + lineTemp.getPos() + "  ");
            pw.print(lineTemp.getLine() + "-" + lineTemp.getPos() + "  ");
            
            p = p.getNext();
        } 
        System.out.println("");
	pw.println("");
    }
    
    /**
     * - Responsible for operating tasks on a word. Invoked from insertBSTDup(), will increment the word count and add line number and position to a node of a linked list
     *
     */
    public void operate(Object o) {
        Word wordTemp = (Word) o;
        
        ObjectListNode p = wordTemp.getList().getFirstNode();
        
        count += 1;
        
        list.addLast(p);
    }
    
    /**
     * -Responsible for comparing Word objects to other Word objects based on String word 
     *
     * @return    return word.compareTo(wordTemp.getWord())  (String word is grabbed) (recursive statement*)
     */
    public int compareTo(Object o) {
        Word wordTemp = (Word) o;
        return word.compareTo(wordTemp.getWord());
    }
    
    /**
     * A getter method for the count of an Word object
     *
     * @return    return count (int)
     */
    public int getCount()
    {
        return count;
    }
    
    /**
     * * A getter method for the list of an Word object
     *
     * @return    return list (ObjectList)
     */
    public ObjectList getList()
    {
        return list;
    }
    
    /**
     * A getter method for the word (a string) of an Word object
     *
     * @return    return word (String)
     */
    public String getWord()
    {
        return word;
    }
}
