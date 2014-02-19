import javax.swing.JTextField;
import java.util.Observer;
import java.util.Observable;

public class CardsList extends JTextField implements Observer{

	private BlackjackModel model;
	private BlackjackPlayer player;
	private int whichPlayer;
	
	public CardsList(BlackjackModel model, int whichPlayer){
		super();
		this.model = model;
		this.whichPlayer = whichPlayer;
	}
	
	public void update(Observable obs, Object obj){
		String display = (String) obj;
		if(display == "card"){
			setText(this.model.getHand(this.whichPlayer));
		}
	}
}