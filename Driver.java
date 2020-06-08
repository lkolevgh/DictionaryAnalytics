import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Driver Class. Responsible for the whole program execution
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class Driver
{
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner omitScanner = new Scanner(new File("omit.txt"));
        Scanner gettyScanner = new Scanner(new File("getty.txt"));

        Hash hash = new Hash(pw);
        Xref xref = new Xref(pw, omitScanner, gettyScanner, hash);
        Query query = new Query(pw, xref);
        
        xref.initOmit();
        hash.displayHashTab();
        xref.displayGetty();
        xref.initGetty();
        xref.displayTree();
        query.searchWord();
        
        pw.close();
    }
}