package Controller;

import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import Entity.Absorber;
import Entity.Ball;
import Entity.CircleBarrier;
import Entity.SquareBarrier;
import Entity.StaticFlipper;
import Entity.TriangleBarrier;
import Entity.Walls;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class EntityListener extends Observable implements ActionListener {

	private Model el;
	
	public EntityListener (Model el) {
		this.el = el;
	}
	
	@Override
	public final void actionPerformed(final ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Triangle":
			//System.out.println("Triangle Button Selected");
			el.setTBT(); 
			break;
		case "Square":
			//System.out.println("Square Button Selected");
			el.setSBT(); 
			break;
		case "RFlipper":
			//System.out.println("RFlipper Button Selected");
			el.setRFBT(); 
			break;
		case "LFlipper":
			//System.out.println("LFlipper Button Selected");
			el.setLFBT(); 
			break;
		case "Circle":
			//System.out.println("Circle Button Selected");
			el.setCBT(); 
			break;
		case "Ball":
			//System.out.println("Ball Button Selected");
			el.setBT(); 
			break;
		case "Absorber":
			//System.out.println("Absorber Button Selected");
			el.setAT();
			break;
		case "Delete":
			//System.out.println("Delete Button Selected");
		    el.setDBT(); 
			break;
		case "Rotate":
			//System.out.println("Rotate Button Selected");
			el.setRBT();
			break;
		}
	}
	
	
}
