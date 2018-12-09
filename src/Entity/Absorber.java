package Entity;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Absorber {

	private double x;
	private double y;
	private double width;
	private int height;
	private Color colour;
	private int ballnum; //吸收了有多少个球
	private ArrayList<Ball> balls;  //吸收的球列表
	private LineSegment ls;
	private String ID;

	public Absorber(String ID, double x, double y, double dunno, double w) {
		this.x = x;
		this.y = y;
		width = w;
		colour = Color.GREEN;
		ls = new LineSegment(x, y, x + w, y);
		this.ID = ID;
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Color getColour(){
		return colour;
	}
	
	public String getID() {
		return ID;
	}
	
	public double getWidth() {
		return width;
	}
	
	//计算碰撞时间
	public double timeUntilAbsorb(Ball b)
	{
		Circle ballCircle = b.getCircle();
		Vect ballVelocity = new Vect(b.getVx(),b.getVy());		
		double time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);	
			
		return time;
	}

	//吸收球
	public void absorbBall(Ball ball) {

		//球停在原处还是？
		ball.move(this.x + this.width - 0.25, this.y + this.height- 0.25);

		if (!balls.contains(ball)) {
			balls.add(ball);
			//	ball.addObserver(this);
			ball.setStopped();
		}
		this.ballnum++;
	}
	
	
	
	
}
