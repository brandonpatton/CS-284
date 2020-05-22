//I pledge my honor that I have abided by the Stevens Honor System.
//Brandon Patton

package Maze;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    
    /*
     * public boolean findMazePath(int x, int y):
     * 		Returns true if a path is found through the maze
     * 
     * 		If the current cell being analyzed falls outside the grid, then false is returned since
     * 		there is no possible path through that cell
     * 
     * 		If the current cell being analyzed does not have NON_BACKGROUND, then false is returned since there is
     * 		no possible path through that cell.
     * 
     * 		If the current cell being analyzed is the exit cell, then the cell is painted color PATH and true is returned.
     * 
     * 		Otherwise, the current cell is assumed to be part of the path
     * 				- it is then painted color path and each neighboring cell is explored to see if they too are part of the path.
     * 				- if a dead end is found it is colored TEMPORARY
     */
    public boolean findMazePath(int x, int y) {
        if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0 || maze.getColor(x, y) != GridColors.NON_BACKGROUND) {
        	return false;
        }
        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
        	maze.recolor(x, y, GridColors.PATH);     
        	return true;
        } else {
        	maze.recolor(x, y, GridColors.PATH);
        	if((findMazePath(x + 1, y) || findMazePath(x - 1, y) || findMazePath(x, y + 1) || findMazePath(x, y - 1)) == false) {
        		maze.recolor(x, y, GridColors.TEMPORARY);
        		return false;
        	}
        	return true; 	
        }
        	
    }
    
    /*
     * public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y):
     * 		A list of all solutoins to the maze is returned.  Each solution is represented as a list of coordinates.
     * 
     * 		If there are no solutions then the resulting list is empty. 
     */
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y){
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
    	Stack<PairInt> trace = new Stack<>();
    	findMazePathStackBased(0,0,result,trace);
    	return result;
    }
    
    /*
     * public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace):
     * 		(x,y) are the coordinates being visited
     * 		result is the list of the successful paths recorded up to now.
     * 		trace is the trace of the current path being explored.
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
    	if(y<0 || x<0 || x > maze.getNCols()-1 || y>maze.getNRows()-1 || maze.getColor(x,y) != NON_BACKGROUND) {
    		return;
    	}
    	else if (x==maze.getNCols()-1 && y== maze.getNRows()-1) {
    		maze.recolor(x, y,PATH);
    		trace.push(new PairInt(x,y));
    		result.add(new ArrayList<PairInt>(trace));
    		trace.pop();
    		maze.recolor(x, y, NON_BACKGROUND);
    	}
    	else {
    		maze.recolor(x, y, PATH);
    		trace.push(new PairInt(x,y));
    		findMazePathStackBased(x+1, y, result, trace);
    		findMazePathStackBased(x-1, y, result, trace);
    		findMazePathStackBased(x, y-1, result, trace);
    		findMazePathStackBased(x, y+1, result, trace);
    		trace.pop();
    		maze.recolor(x,y,NON_BACKGROUND);
    	}
    }
    
    /*
     * public ArrayList<PairInt> findMazePathMin(int x, int y):
     * 		Returns the shortest path in the list of paths.
     * 
     */
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	maze.recolor(PATH, NON_BACKGROUND);
    	ArrayList<ArrayList<PairInt>> answer = findAllMazePaths(x,y);
    	if(answer.size() != 0){
	    	ArrayList<PairInt> min = answer.get(0);
	    	int minLength = min.size();
	    	for(int i=1; i<answer.size(); i++){
	    		if(minLength >= answer.get(i).size()){
	    			min = answer.get(i);
	    			minLength = min.size();
	    		}
	    	}
	    	return min;
    	}
    	else{
    		return new ArrayList<PairInt>();
    	}
    }

    

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
