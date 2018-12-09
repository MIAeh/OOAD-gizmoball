package Controller;

import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entity.*;


public class EntityListener extends Observable implements ActionListener {

	private Model el;
	
	
	
	public EntityListener (Model el) {
		this.el = el;
	}
	
	@Override
	public final void actionPerformed(final ActionEvent e) {
		el.setDBF();
		el.setAF();
		el.setBF();
		el.setCBF();
		el.setLFBF();
		el.setRFBF();
		el.setSBF();
		el.setDBF();  
		el.setRBF();
		el.setDBF();
		el.setTBF();
		el.setBT();
		
		switch (e.getActionCommand()) {
		
		case "Triangle":
			System.out.println("Triangle Button Selected");
			el.setTBT(); 
			break;
		case "Square":
			System.out.println("Square Button Selected");
			el.setSBT(); 
			break;
		case "RFlipper":
			System.out.println("RFlipper Button Selected");
			el.setRFBT(); 
			break;
		case "LFlipper":
			System.out.println("LFlipper Button Selected");
			el.setRFBT();
			break;
		case "Circle":
			System.out.println("Circle Button Selected");
			el.setCBT(); 
			break;
		case "Ball":
			System.out.println("Ball Button Selected");
			el.setBT(); 
			break;
		case "Absorber":
			System.out.println("Absorber Button Selected");
			el.setAT();
			break;
		
		case "Rotate":
			System.out.println("Rotate Button Selected");
			el.setRBT();
			break;
			
		default:
			System.out.println("Nothing done!");
		}
	}
	
	
}
