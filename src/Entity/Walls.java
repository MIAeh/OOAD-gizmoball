package Entity;

import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;



public class Walls {

	
	private int leftTopX;
	private int leftTopY;
	private int rightBottomX;
	private int rightBottomY;

	public Walls(int x1, int y1, int x2, int y2) {
		leftTopX = x1;
		leftTopY = y1;
		rightBottomX = x2;
		rightBottomY = y2;
	}
	
	public ArrayList<LineSegment> getLineSegments() {
		ArrayList<LineSegment> ls = new ArrayList<LineSegment>();
		LineSegment l1 = new LineSegment(leftTopX,leftTopY,rightBottomX,leftTopY);
		LineSegment l2 = new LineSegment(leftTopX,leftTopY,leftTopX,rightBottomY);
		LineSegment l3 = new LineSegment(rightBottomX,leftTopY,rightBottomX,rightBottomY);
		LineSegment l4 = new LineSegment(leftTopX,rightBottomY,rightBottomX,rightBottomY);
		ls.add(l1);
		ls.add(l2);
		ls.add(l3);
		ls.add(l4);
		return ls;
	}

}
