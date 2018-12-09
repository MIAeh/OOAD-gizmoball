package Controller;

import java.util.Observable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;

import Entity.Absorber;
import Entity.Ball;
import Entity.CircleBarrier;
import Entity.SquareBarrier;
import Entity.StaticFlipper;
import Entity.TriangleBarrier;



public class OperationListener extends Observable implements ActionListener{

	private Model el;
	

	public OperationListener(Model el) {
	
		this.el=el;
	}
	
	
	@Override
	public final void actionPerformed(final ActionEvent e) {

		switch (e.getActionCommand()) {
		case "CLear":
			this.clearMode(el);
			break;
		case "Load":
			try {
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					this.clearMode(el);
					File selectedFile = jfc.getSelectedFile();
					this.loadGame(selectedFile.getPath(),el);
					System.out.println(selectedFile.getAbsolutePath());
				}
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Save":	
			try {

				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					this.saveGame(selectedFile.getPath(),el);
					System.out.println(selectedFile.getAbsolutePath());
				}


			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Quit":
			this.quitGame();
		}
	
	}
	
	
	//��ս���������Ԫ��
	public void clearMode(Model model) {
		model.getAbsorbers().clear();
		model.getBalls().clear();
		model.getCircleBarriers().clear();
		//model.getRotatedFlipers().clear();
		model.getSquareBarriers().clear();
		model.getStaticFlippers().clear();
		model.getTriangleBarriers().clear();
	}
	
	
	//�˳�

	public void quitGame(){
		System.exit(0);
	}
	

	//����
	public void saveGame(String path, Model model) throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = new FileWriter(path);

		try {

			bw = new BufferedWriter(fw);
			
			for(Absorber a: model.getAbsorbers()){
				bw.write("Absorber" + " " + a.getID() + " " + ((int)a.getX()/25) + " " + ((int)a.getY()/25) + " " + 20 + " " +  ((int)a.getWidth()/25));
				bw.newLine();
			}
			for(TriangleBarrier t: model.getTriangleBarriers()){
				bw.write("Triangle" + " " + t.getID() + " " + ((int)(t.getExactX()-12.5)/25) + " " + ((int)(t.getExactY()-12.5)/25));
				bw.newLine();
				if(t.getDegree()==90){
					bw.write("Rotate " + t.getID());
					bw.newLine();
				}
				else if(t.getDegree()==180){
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
				}
				else if(t.getDegree()==270){
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
					bw.newLine();
					bw.write("Rotate " + t.getID());
					bw.newLine();
				}
			}
			for(SquareBarrier s: model.getSquareBarriers()){
				bw.write("Square" + " " + s.getID() + " " + ((int)s.getX()/25) + " " + ((int)(s.getY()-25)/25));
				bw.newLine();
			}
			
			for(CircleBarrier c: model.getCircleBarriers()){
				bw.write("Circle" + " " + c.getID() + " " + ((int)(c.getX()-12.5)/25) + " " + ((int)(c.getY()-12.5)/25));
				bw.newLine();
			}
			for(Ball b: model.getBalls()){
				bw.write("Ball" + " " + b.getID() + " " + ((int)b.getX()/25) + " " + ((int)b.getY()/25) + " " + 0 + " " +  0);
				bw.newLine();
			}
			for(StaticFlipper rf: model.getStaticFlippers()){
				bw.write("RightFlipper" + " " + rf.getID() + " " + ((int)(rf.getXpos()-40)/25) + " " + ((int)rf.getYpos()/25));
				bw.newLine();
			}
//			for(LeftFlipper lf: lFlipper){
//				bw.write("LeftFlipper" + " " + lf.getID() + " " + ((int)lf.getXpos()/25) + " " + ((int)lf.getYpos()/25));
//				bw.newLine();
//			}
			

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	//����

	public void loadGame(String path, Model model) throws FileNotFoundException {

		File file = new File(path);
		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			model.createGizmo(input.nextLine());
		}
		this.setChanged();
		this.notifyObservers();

	}
	
	
	
	
}