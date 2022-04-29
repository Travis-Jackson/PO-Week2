package week2codingchallenge;

import java.awt.Point;
import java.util.ArrayList;

// Robot path from top left to bottom right
// of a grid with directional constraints

// [(n-1, n-1)............(n-1, 0),
// .........................(0, 0)]


public class RobotGrid {
	
	public ArrayList<Point> getPath(boolean[][] board){
		if(board.length == 0 || board == null || board[0][0] == false) {
			return null;
		}
		ArrayList<Point> p = new ArrayList<Point>();
		
		if(getPath(board, board.length-1, board[0].length-1, p)) {
			return p;
		}
		return null;
	}
	
	public boolean getPath(boolean[][] board, int row, int col, ArrayList<Point> p) {
		if(board[row][col] == false || row < 0 || col < 0) {
			return false;
		}
		else {
			boolean there_yet = (row == 0) && (col == 0);
			if(there_yet || getPath(board, row-1, col, p) || getPath(board, row, col-1, p)) {
				
				Point points = new Point(row,col);
				p.add(points);
				
				return true;
			}
		}
		return false;
	}
}

// I utilized Shivangi Singh YouTube channel for the answer
