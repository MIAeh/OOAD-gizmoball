package Entity;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class TriangleBarrier {

	
	private String ID;
	private double x;
	private double y;
	private Color colour;
	private LineSegment ls;
	private double w;
	private ArrayList<Circle> circles;
	private ArrayList<LineSegment> lines;
	private double radius;
	private double degree;


	public TriangleBarrier(String ID, double x, double y){
		this.x = x;
		this.y = y;
		w = 12.5;
		this.ID = ID; 
		radius = 0;
		degree = 0;
		circles = new ArrayList<>();
		lines = new ArrayList<>();
		colour = Color.gray;
		circles.add(new Circle(new Vect((x-w), (y+w)), radius));
		circles.add(new Circle(new Vect((x+w), (y-w)), radius));
		circles.add(new Circle(new Vect((x-w), (y-w)), radius));

		lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
		lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
		lines.add(new LineSegment(circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));


	}	
	
	public String getID(){
		return ID;
	}

	public void setDegree(double newDegree)
	{
		degree = newDegree;
	}

	public void setDegree90(){
		if (degree==0) {
			degree = 90;

			circles.get(0).setCenter();

			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
			lines.add(new LineSegment(circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));

		}
		
		else if (degree==90){	

			degree = 180;

			circles.get(2).setYCenter();

			lines.removeAll(lines);

			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
			lines.add(new LineSegment(circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));

		}

		else if (degree==180){	

			degree = 270;

	

			circles.get(1).unsetCenter();

			lines.removeAll(lines);

			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
			lines.add(new LineSegment(circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));

		}

		else if (degree==270){	

			degree = 0;

			circles.get(1).setCenter();
			circles.get(2).unsetYCenter();
			circles.get(0).unsetCenter();

			lines.removeAll(lines);

			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY()));
			lines.add(new LineSegment(circles.get(0).getCenter().getX(), circles.get(0).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));
			lines.add(new LineSegment(circles.get(1).getCenter().getX(), circles.get(1).getCenter().getY(), circles.get(2).getCenter().getX(), circles.get(2).getCenter().getY()));

		}
	} 


	public double getDegree(){
		return degree;
	}

	public double getRadius(){
		return radius;
	}

	public Color getColour() {
		return colour;
	}

	public ArrayList<Circle> getCircles(){
		return circles;
	}

	public ArrayList<LineSegment> getLines(){
		return lines;
	}

	public LineSegment getLine(){
		return ls;
	}

	public double getExactX(){
		return x;
	}

	public double getExactY(){
		return y;
	}
}
