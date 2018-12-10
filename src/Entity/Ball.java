package Entity;

import java.awt.Color;

import physics.Circle;
import physics.Geometry;
import physics.Vect;

public class Ball {

	private String ID;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private Vect velocity;
	private double radius;
	private Color colour;
	private boolean stopped;

	public Ball(String ID, double x, double y, double xv, double yv) {
		this.x = x;
		this.y = y;
		colour = Color.YELLOW;
		velocity = new Vect(xv, yv);
		radius = 6.25;
		stopped = false;
		this.ID = ID;
		this.vx = xv;
		this.vy = yv;
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		velocity = v;
		this.vx=v.getX();
		this.vy=v.getY();
	}

	public double getRadius() {
		return radius;
	}

	public Circle getCircle() {
		return new Circle(x, y, radius);
	}

	public double getExactX() {
		return x;
	}

	public double getExactY() {
		return y;
	}

	public void setExactX(double x) {
		this.x = x;
	}

	public void setExactY(double y) {
		this.y = y;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		stopped = false;
	}

	public boolean stopped() {
		return stopped;
	}

	public Color getColour() {
		return colour;
	}

	public String getID() {
		return ID;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setBallSpeed(int x, int y) {
		this.vx = x;
		this.vy = y;
	}

	// ï¿½ï¿½ï¿½ï¿½
	public void applyGravity(double time, double GRAVITY, double t) {
		// this.vx=vx;
		this.vy = this.vy + (GRAVITY * t);

	}

	// Ä¦ï¿½ï¿½
	public void applyFriction(double time, double MU, double MU2) {
		this.vx = vx * (1 - (MU * time) - ((MU2 / 25 * vx) * time));
		this.vy = vy * (1 - (MU * time) - ((MU2 / 25 * vy) * time));

	}

	// ÇòËæÊ±¼äÒÆ¶¯
	public void moveForTime(double time) {

		double newX = 0.0;
		double newY = 0.0;
		newX = this.x + (this.velocity.x() * time);
		newY = this.y + (this.velocity.y() * time);
		this.x = newX;
		this.y = newY;

	}

	// ÇòÒÆ¶¯µ½Ö¸¶¨Î»ÖÃ
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Í£Ö¹ï¿½Ë¶ï¿½
	 public void setStopped() {
		 this.stopped=true;
		 Vect v1=new Vect(0.0,0.0);
		 this.setVelo(v1);
	 }
	 public double timeUntilCircleCollision(Ball b) {
		 Circle ballCircle = b.getCircle();
		 Vect ballVelocity = new Vect(b.getVx(),b.getVy());
		 return Geometry.timeUntilCircleCollision(this.getCircle(), ballCircle, ballVelocity);
	 }
	

}
