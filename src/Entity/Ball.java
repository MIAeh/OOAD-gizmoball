package Entity;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

public class Ball {
	private String ID;
	private double vx;
	private double vy;
	private Vect velocity;
	
	private double radius;
	private double x;
	private double y;
	private Color colour;
	private boolean stopped;
	


	public Ball(String ID, double x, double y, double xv, double yv) {
		velocity = new Vect(xv, yv);
		this.ID=ID;
		this.x=x;
		this.y=y;
		this.radius=radius;
		stopped=true;
		colour = Color.YELLOW;
		radius = 6.25;
	}
	
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
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
	
	public Circle getCircle(){
		return new Circle(x, y, radius);
	}


	public void setBallSpeed(int x, int y) {
		this.vx=x;
		this.vy=y;
	}	

	public Vect getVelo(){
			return velocity;
	}

	public void setVelo(Vect v){
		velocity = v;
	}
	
	public void stop(){
		stopped = true;
	}


	public boolean stopped(){
		return stopped;
	}

	public Color getColour(){
		return colour;
	}

	
	//重力
	public void applyGravity(double time,double GRAVITY,double t) {
		this.vx=vx;
		this.vy=this.vy + (GRAVITY*t);
		
	}
	
	//摩擦
	public void applyFriction(double time,double MU,double MU2) {
		this.vx = vx*(1-(MU*time)-((MU2/25*vx)*time)); 
		this.vy = vy*(1-(MU*time)-((MU2/25*vy)*time));
		
	}

	//小球随时间移动
	public void movelBallForTime(double time) {
		if(this.stopped) {
			double newVx = this.vx;
			double newVy = this.vy;
			this.x = this.x + (newVx * time);
			this.y = this.y + (newVy * time);
		}
		//return ball;
	}
	
	//移动到指定位置
	public void move(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	//被吸收停止运动
	public void setStopped() {
		this.stopped=true;
		this.vx=0;
		this.vy=0;
	}
	
	//开始运动
	public void start(){
		stopped = false;
	}
	
	//球球相撞
	public void reflectBall(Ball b) {
		
	}
}
