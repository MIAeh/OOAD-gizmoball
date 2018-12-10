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
	
	//Ð¡ÇòÅö×²shi'a
//	public double timeUntilWallCollision_andReflect(Ball b,double shortestTime,Vect newVelo)
//	{
//		Circle ballCircle = b.getCircle();
//		Vect ballVelocity = new Vect(b.getVx(),b.getVy());
//		
//		//getLineSegments
//		ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
//		LineSegment l1 = new LineSegment(leftTopX,leftTopY,rightBottomX,rightBottomY);
//		LineSegment l2 = new LineSegment(leftTopX,leftTopY,rightBottomX,rightBottomY);
//		LineSegment l3 = new LineSegment(leftTopX,leftTopY,rightBottomX,rightBottomY);
//		LineSegment l4 = new LineSegment(leftTopX,leftTopY,rightBottomX,rightBottomY);
//		lss.add(l1);
//		lss.add(l2);
//		lss.add(l3);
//		lss.add(l4);
//		
//		double time=0;
//		for (LineSegment line : lss) {
//			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(line, ballVelocity, 1.0);
//			}
//		}
//							
//		return shortestTime;
//			
//	}
}
