import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Xref Class. Responsible for handling tasks that involve the getty.txt file or the omit.txt file. Also involves the usage of the Object binary tree, hashing, and contains
 * tasks that are used to cross reference information from the getty address
 * 
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class Xref
{
    // instance variables 
    private Scanner gettyScanner;
    private Scanner omitScanner;

    private PrintWriter pw;

    private ObjectBinaryTree tree;
    private Hash hash;

    /**
     * Constructor for objects of class Xref
     */
    public Xref(PrintWriter pw, Scanner omitScanner, Scanner gettyScanner, Hash hash)
    {
        // initialise instance variables
        this.pw = pw; 

        this.omitScanner = omitScanner;
        this.gettyScanner = gettyScanner;

        this.tree = new ObjectBinaryTree();
        this.hash = hash;
    }

    /**
     * -Responsible for displaying the contents of the getty.txt file. Scans getty.txt file, and outputs each line of text prefixed by a line number
     *
     */
    public void displayGetty() throws FileNotFoundException {
        Scanner gettyScanner2 = new Scanner(new File("getty.txt"));
        int lineNum = 1;

        System.out.println("\nThe content of the Getty: \n");
        pw.println("\nThe content of the Getty: \n");

        while (gettyScanner2.hasNext()) { 
            String word = gettyScanner2.nextLine();
            System.out.printf("%-3d %-2s\n", lineNum, word);
            pw.printf("%-3d %-2s\n", lineNum, word);
            lineNum++;
        }
        gettyScanner2.close();
    }

    /**
     * - Responsible for evaluating the omit.txt file and invoking the map() method to map the ommited words in the hash table
     *
     */
    public void initOmit() throws FileNotFoundException {
        while(omitScanner.hasNextLine()){
            String line = omitScanner.nextLine();
            String[] tokens = line.split("\\s+");

            hash.map(tokens[0]);
        }
     }

    /**
     * - Responsible for instating new Word objects from the getty.txt file and storing them into the binary search tree (along with their line position information)
     *
     */
    public void initGetty() throws FileNotFoundException {
        int lineNum = 1;

        while(gettyScanner.hasNextLine()) {
            String temp = gettyScanner.nextLine();
            String[] tokens = temp.replaceAll("[;.,-]", "").toLowerCase().split("\\s+");

            for (int j = 0; j < tokens.length; j++) {
                ObjectList tempList = new ObjectList();

                if(hash.search(tokens[j]) == false) { 
                    LinePosition tempLine = new LinePosition(lineNum, j+1);
                    tempList.addLast(tempLine);

                    Word tempWord = new Word(pw, tokens[j], 1, tempList);
                    tree.insertBSTDup(tempWord);
                }
            }
            lineNum++;
        }
    }

    /**
     * - Responsible for displaying/outputting the contents of the binary search tree
     *
     */
    public void displayTree(){
        System.out.printf("\n\nA well-formatted cross-referenced list in alphabetical order: \n\n");
        System.out.println(String.format("%-10s %-8s %-8s", "Word", "Count", "Line-Postion\n"));
        pw.printf("\n\nA well-formatted cross-referenced list in alphabetical order: \n\n");
        pw.println(String.format("%-10s %-8s %-8s", "Word", "Count", "Line-Postion\n"));

        ObjectTreeNode p = tree.getRoot();
        tree.inTrav(p);

        System.out.println("\nTotal number of words omited: " + hash.getOmitCount() +"\n");
        pw.println("\nTotal number of words omited: " + hash.getOmitCount() + "\n");
    }

    /**
     *  A getter method that returns the Object binary tree
     *
     * @return    return tree (returns the binary tree)
     */
    public ObjectBinaryTree getTree(){
        return tree;
    }
}
