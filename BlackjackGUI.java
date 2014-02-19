import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.lang.StringBuilder;

public class BlackjackGUI extends JFrame{

	private JButton startButton;
	private JButton hitButton;
	private JButton standButton;
	
	private JPanel playerPanel;
	private JPanel dealerPanel;
	private JPanel buttonPanel;
	
	private JTextField playerCards;
	private JTextField dealerCards;
	
	private ButtonHandler buttonHandler;
	
	private StringBuilder playerBuilder;
	private StringBuilder dealerBuilder;
	
	private BlackjackModel model;
	
	public BlackjackGUI(BlackjackModel model){
	
		super("Blackjack");
		
		this.model = model;
		
		GridLayout mainLayout = new GridLayout(1,3,5,5);
		GridLayout playerLayout = new GridLayout(1,1,5,5);
		GridLayout dealerLayout = new GridLayout(1,1,5,5);
		GridLayout buttonLayout = new GridLayout(3,1,5,5);
		
		this.playerPanel = new JPanel();
		this.dealerPanel = new JPanel();
		this.buttonPanel = new JPanel();
		
		this.playerCards = new CardsList(model, 1);
		this.playerCards.setEditable(false);
		
		this.model.addObserver((CardsList) this.playerCards);
		
		this.playerBuilder = new StringBuilder("");
		this.playerCards.setText(playerBuilder.toString());
		
		this.playerPanel.setSize(new Dimension(300,50));
		this.playerPanel.add(playerCards);
		
		this.dealerCards = new CardsList(model, 2);
		this.dealerCards.setEditable(false);
		
		this.model.addObserver((CardsList) this.dealerCards);
		
		this.dealerBuilder = new StringBuilder("");
		this.dealerCards.setText(dealerBuilder.toString());
		
		this.dealerPanel.setSize(new Dimension(300,50));
		this.dealerPanel.add(dealerCards);
		
		this.buttonHandler = new ButtonHandler();
		
		setLayout(mainLayout);
		
		this.playerPanel.setLayout(playerLayout);
		this.buttonPanel.setLayout(buttonLayout);
		
		this.startButton = new JButton("Start!");
		this.startButton.setActionCommand("start");
		this.startButton.addActionListener(buttonHandler);
		this.buttonPanel.add(startButton);
		
		this.hitButton = new JButton("Hit me!");
		this.hitButton.setActionCommand("hit");
		this.hitButton.addActionListener(buttonHandler);
		this.buttonPanel.add(hitButton);
		
		this.standButton = new JButton("Stand.");
		this.standButton.setActionCommand("stand");
		this.standButton.addActionListener(buttonHandler);
		this.buttonPanel.add(standButton);
		
		add(playerPanel);
		add(buttonPanel);
		add(dealerPanel);
	}
	
	private class ButtonHandler implements ActionListener{
	
		public void actionPerformed(ActionEvent event){
			
			if(event.getActionCommand() == "start"){
				model.start();
			}
			else if(event.getActionCommand() == "hit"){
				model.hit();
			}
			else if(event.getActionCommand() == "stand"){
				model.stand();
			}
			else
            {
                System.out.println("Error");
            }        
		}
	}
}