package Entity;

import java.awt.Color;

import physics.Circle;
import physics.Geometry;
import physics.Vect;

public class CircleBarrier{

	private double x;
	private double y;
	private double width=1;
	private int height=1;
	private double radius;
	private Color colour;
	private String ID;
	
	private Circle circle;
	
	public CircleBarrier(String id, double x, double y){
		this.x = x;
		this.y = y;
		colour = Color.decode("#1579ab");
		radius = 12.5;
		circle = new Circle(new Vect(x, y), radius);
		this.ID = id;
	}
	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
	
	public boolean canRotate() {
		return false;
	}
	
	public Circle getCircle(){
		return circle;
	}
	
	public String getID() {
		return ID;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColour() {
		return colour;
	}

	//��ײʱ��
	public double timeUntilCircleCollision(Ball b) {
		Circle ballCircle = b.getCircle();
		Vect ballVelocity = new Vect(b.getVx(),b.getVy());
		
		return Geometry.timeUntilCircleCollision(circle, ballCircle, ballVelocity);
		
	}
	
	
//	//����С��
	public Vect reflectBall(Ball b) {
		Circle circle = new Circle(new Vect(x, y), radius);
		Vect ballVelocity = new Vect(b.getVx(),b.getVy());
		return Geometry.reflectCircle(circle.getCenter(), b.getCircle().getCenter(),
				ballVelocity, 1.0);
		
	}
	

}
