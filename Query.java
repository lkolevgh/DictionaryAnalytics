import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Query Class. Responsible for any tasks or operations regarding query searches.
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class Query
{
    // instance variables 
    private PrintWriter pw;

    private String qWord;
    private Xref invoke;

    /**
     * Constructor for objects of class Query
     */
    public Query(PrintWriter pw, Xref xref)
    {
        // initialise instance variables
        this.pw = pw;

        this.invoke = xref;
        this.qWord = null;
    }

    /**
     * - Responsible for preforming run time queries/preform searches on Word Objects 
     *   * Invokes/accesses/gets the binary tree to get the Word objects (nodes)
     *   * If the word inputted from the user is found, display/output the word, the number of times the word appears in the text and the position the word appears on each line
     *   * If the word inputted from the user is not found, display a error message accordingly so and reprompt the user to input a different word
     *
     */
    public void searchWord() {
        char xrefChar = 'x'; 

        ObjectBinaryTree tree = invoke.getTree();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n**Input 0 or 'exit' to exit the program**");
        pw.println("\n**Input 0 or 'exit' to exit the program**");

        while(xrefChar == 'x') {
            System.out.println("\nEnter a word that you would like to query: ");
            pw.println("\nEnter a word that you would like to query: ");

            qWord = scanner.nextLine();
            System.out.println("\n");
            pw.print(qWord + "\n\n");

            if(qWord.contains("0") || qWord.contains("exit")) {
                System.out.println("Program has stopped");
                pw.println("Program has stopped");
                break;
            }

            Word word = new Word(qWord.toLowerCase());
            ObjectTreeNode cur = tree.searchBST(word);

            if (cur != null) {
                Word wordTemp = (Word) cur.getInfo();
                ObjectListNode p = wordTemp.getList().getFirstNode();

                System.out.println(String.format("%-10s %-8s %-8s", "Word", "Count", "Line-Postion\n"));
                pw.println(String.format("%-10s %-8s %-8s", "Word", "Count", "Line-Postion\n"));
                
                System.out.print(String.format("%-11s %-5s   ", wordTemp.getWord(), wordTemp.getCount()));
                pw.print(String.format("%-11s %-5s   ", wordTemp.getWord(), wordTemp.getCount()));

                while (p != null) {
                    LinePosition lineTemp = (LinePosition) p.getInfo();
                    System.out.print(lineTemp.getLine() + "-" + lineTemp.getPos() + "  ");
                    pw.print(lineTemp.getLine() + "-" + lineTemp.getPos() + "  ");

                    p = p.getNext();
                }

                System.out.println("\n");
                pw.println("\n");
            } else {
                System.out.println("**ERROR** word " + qWord + " could not be found, try a different word");
                pw.println("**ERROR** word " + qWord + " could not be found, try a different word");
            }
        }
        scanner.close(); 
    }
}
