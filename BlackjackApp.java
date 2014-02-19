import javax.swing.JFrame;

public class BlackjackApp{

	public static void main( String[] args ){
		BlackjackModel model = new BlackjackModel();
		BlackjackGUI gui = new BlackjackGUI(model);
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(600, 400);
		gui.setVisible(true);
	}
}