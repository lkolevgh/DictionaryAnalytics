import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * LinePosition Class. Responsible for storing and providing tools that involve line positions.
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public class LinePosition
{
    // instance variables 
    private int position;
    private int line;

    /**
     * Constructor for objects of class LinePosition
     */
    public LinePosition()
    {
        // initialise instance variables
        this.position = 0;
        this.line = 0;
    }
    
    /**
     * Constructor for objects of class LinePosition (for making LinePosition objects)
     */
    public LinePosition(int line, int position)
    {
        // initialise instance variables
        this.position = position;
        this.line = line;
    }
    
    /**
     * A getter method for the position 
     *
     * @return    return position
     */
    public int getPos()
    {
        return this.position;
    }
    
    /**
     * A getter method for the line number
     *
     * @return    return line
     */
    public int getLine()
    {
        return this.line;
    }
}
