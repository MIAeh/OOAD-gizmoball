package Entity;

import java.util.Observable;

public class RotatedFlipper extends Observable{
	private static final double ANGULAR_MOMENTUM = 2.0 * Math.PI;

	private int x;
	private int y;
	private int v;
	private double angle, angularMomentum;
	protected boolean triggered;
	

	public RotatedFlipper(int x, int y)
	{
		this.x=x;
		this.y=y;
		angularMomentum = ANGULAR_MOMENTUM;
	}
	
	public double getAngularMomentum(){
		return angularMomentum;
	}
	
	public void setAngle(double angle)
	{
		this.angle = angle;// % (2 * Math.PI);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	//runµÄÊ±ºòÐý×ª
	public void doAction()
	{
		if (triggered)
		{
			angularMomentum = 0;
		}
		else
		{
			angularMomentum = ANGULAR_MOMENTUM;
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean canRotate() {
		return false;
	}
}
