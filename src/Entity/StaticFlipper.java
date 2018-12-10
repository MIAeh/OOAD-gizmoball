package Entity;

import java.awt.Color;
import java.util.ArrayList;

import physics.Angle;
import physics.Circle;
import physics.GeometryImpl;
import physics.LineSegment;
import physics.Vect;

public class StaticFlipper {
	private double x;
	private double y;
	private int width;
	private Color colour;
	private int degree;
	private String ID;
	private ArrayList<Circle> circles;
	private ArrayList<LineSegment> lines;
	private GeometryImpl gi;
	
	public StaticFlipper(String ID, double x, double y) {
		this.x = x;
		this.y = y;
		colour = Color.decode("#ffc71e");
		width = 50;
		degree = -90;
		this.ID = ID;
		gi = new GeometryImpl();
		lines = new ArrayList<>();
		circles = new ArrayList<>();
		circles.add(new Circle(new Vect((x+5), (y+5)), 5));
	 	circles.add(new Circle(new Vect((x+5), (y+width)-5), 5));


		lines.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()));
		lines.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()));
	}

	public double getXpos() {
		return x;
	}
	public ArrayList<LineSegment> getLines(){
		return lines;
	}
	
	public ArrayList<Circle> getCircles(){
		return circles;
	}


	public double getYpos() {
		return y;
	}

	public void setXpos(double newX) {
		x = newX;
	}

	public void setYpos(double y) {
		y = y;
	}

	public int getWidth() {
		return width;
	}

	public void flip(){
		if(degree >-180) {
		degree = degree-30;
		new Angle(degree);
		ArrayList<Circle> temp3 = new ArrayList<>();
		Circle temp = gi.rotateAround(circles.get(1), circles.get(0).getCenter(), new Angle(Math.toRadians(30)));
		temp3.add(circles.get(0));
		temp3.add(temp);
		circles = temp3;
		
		ArrayList<LineSegment> temp2 = new ArrayList<>();
		
		temp2.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY()-5, circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()-5));
		temp2.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY()+5, circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()+5));
		lines = temp2;
		}
		
		
	}
	


	public void unFlip(){
		if(degree <-90) {
			degree = degree+10;
			new Angle(degree);
			ArrayList<Circle> temp3 = new ArrayList<>();
			Circle temp = gi.rotateAround(circles.get(1), circles.get(0).getCenter(), new Angle(Math.toRadians(-10)));
			temp3.add(circles.get(0));
			temp3.add(temp);
			circles = temp3;
			ArrayList<LineSegment> temp2 = new ArrayList<>();
			
		
			temp2.add(new LineSegment(circles.get(0).getCenter().getX()-5, circles.get(0).getCenter().getY()-5, circles.get(1).getCenter().getX()-5, circles.get(1).getCenter().getY()-5));
			temp2.add(new LineSegment(circles.get(0).getCenter().getX()+5, circles.get(0).getCenter().getY()+5, circles.get(1).getCenter().getX()+5, circles.get(1).getCenter().getY()+5));
			lines = temp2;
		}
		
	}



	public int getDegree(){
		return degree;

	}
	
	public Color getColour(){
		return colour;
	}
	
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
