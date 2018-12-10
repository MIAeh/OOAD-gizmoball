package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Entity.Model;




public class MsListener implements MouseListener {
	private BuildModeGUI buildGUI;
	private Model el;

	public MsListener(BuildModeGUI g, Model m) {
		buildGUI = g;
		el = m;
		buildGUI.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int l =20;
		int x=el.rounder((e.getX()-7));
		int y=el.rounder((e.getY()-102));
		
		System.out.println("listener");

		


		if(el.getDBT()==true) {

			String id = (x + "" + y );

			System.out.println(id);

			if (el.checkTaken(x, y)) { 

				el.removeLFlipper("LF"+id);
				el.removeRFlipper("RF"+id);
				el.removeSBarrier("S"+id);
				el.removeCBarrier("C"+id);
				el.removeTBarrier(x, y);
				el.removeSqOccupied(x, y);
				el.removeAbsorber();
			

			}

		}



		if(el.getRBT()==true) {			
			
			if ((el.checkTaken(x, y))) { 
				
				el.rotateTBarrier(x, y);					
			}			
		}
		
		
		if(el.getTBT()==true) {
			

			if (!(el.checkTaken(x, y))) { 
				el.addTriangleBumper(x, y); 
				
			}


		}

		if(el.getSBT()==true) {
			


			if (!(el.checkTaken(x, y))) { 

				el.addSquareBumper(x, y+25);
				

			}

		}

		if(el.getLFBT()==true) {

			if (!(el.checkTaken(x, y)) && !(el.checkTaken(x, y+25)))  { 
		
				el.addLFlipper(x, y); 
				
			}

		}

		if(el.getRFBT()==true) {

			if (!(el.checkTaken(x, y)) && !(el.checkTaken(x, y+25))) { 

				el.addRFlipper(x, y); 
				
			}

		}

		if(el.getCBT()==true) {
			System.out.println("hey2");

			if (!(el.checkTaken(x, y))) { 
				
				el.addCircleBumper(x+12.5, y+12.5); 			
				
			}

		}

		if(el.getBT()==true) {
			
			System.out.println("*******");
			System.out.println(e.getX());
			System.out.println(e.getY());			

			el.addBall(e.getX()-7, e.getY()-102); 
		}

		if(el.getA()==true) {
			
			el.addAbsorber(); 
			
		}

	
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
