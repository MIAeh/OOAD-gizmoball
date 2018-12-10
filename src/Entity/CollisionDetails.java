package Entity;

import physics.Vect;

public class CollisionDetails {

	private double tuc;
	private Vect velo;
	
	public CollisionDetails(double t, Vect v){
		tuc = t;
		velo = v;
	}
	
	public double getTuc(){
		return tuc;
	}
	
	public Vect getVelo(){
		return velo;
	}
}
