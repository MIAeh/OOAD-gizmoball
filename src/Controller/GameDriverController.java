package Controller;


public class GameDriverController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model el = new Model();
		BuildModeGUI buildMode = new BuildModeGUI(el);
		
		//µã»÷¿ªÊ¼
		RunModeGUI runMode = new RunModeGUI(buildMode);
	}

}
