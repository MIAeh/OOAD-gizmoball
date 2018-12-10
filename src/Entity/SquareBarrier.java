package Entity;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class SquareBarrier {

	private double x;
	private double y;
	private Color colour;
	private LineSegment ls;
	private double w;
	private ArrayList<Circle> circles;
	private ArrayList<LineSegment> lines;
	private double radius;
	private Circle circle;
	private String ID;

 	
	public SquareBarrier(String ID, double x, double y){
		this.x = x;
		this.y = y;
		w = 25;
		radius = 0;
		circles = new ArrayList<>();
		lines = new ArrayList<>();
		this.ID = ID;
		colour = Color.decode("#6beae6");
		circles.add(new Circle(new Vect(((x)), ((y))), radius));
		circles.add(new Circle(new Vect(((x+w)), ((y))), radius));
		circles.add(new Circle(new Vect(((x+w)), ((y-w))), radius));
		circles.add(new Circle(new Vect(((x)), ((y-w))), radius));
		lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
		lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(3).getCenter().getX(), circles.get(3).getCenter().getY()));
		lines.add(new LineSegment(circles.get(3).getCenter().getX(), circles.get(3).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
		lines.add(new LineSegment(circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));

	}	
	
	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
	
	public Circle getCircle(){
		return circle;
	}
	
	public ArrayList<Circle> getCircles(){
		return circles;
	}

	public boolean canRotate() {
		return false;
	}

	public void bounceBall(Ball ball) {

	}

	public Color getColour() {
		return colour;
	}

	public double getRadius() {
		return radius;
	}

	public double getW() {
		return w;
	}

	public LineSegment getLine(){
		return ls;
	}
	

	public ArrayList<LineSegment> getLines(){
		return lines;
	}
	
	public String getID() {
		return ID;
	}
	
	//��ײʱ��
//	public double timeUntilCircleCollision(Ball b) {
//		
//	}
//	
//	
//	//����С��
//	public Vect reflectBall(Ball b) {
//		
//		
//	}
}
