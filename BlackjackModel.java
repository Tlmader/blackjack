import java.util.Observable;

public class BlackjackModel extends Observable{

	private BlackjackPlayer player;
	private BlackjackPlayer dealer;
	
	private Deck myDeck;

	private int playerRound;
	private int dealerRound;
	
	private boolean playing;
	
	private String handToPrint;
	
	private AI dealerAI = new AI();
	
	private Card newCard = new Card("", "");
	
	public void start(){
		player = new BlackjackPlayer();
		dealer = new BlackjackPlayer(dealerAI);
		
		playing = true;
		Deck myDeck = new Deck();
		playerRound = -1;
		dealerRound = -1;
		
		setChanged();
		notifyObservers();
	}
	
	public void hit(){
		playerRound = playerRound++;
		newCard = myDeck.dealCard();
		player.giveCard(newCard, playerRound);
		if(player.getHandValue(playerRound) > 21){
			playing = false;
		}
		if(dealer.takeTurn() == 1){
			newCard = myDeck.dealCard();
			dealer.giveCard(newCard, dealerRound);
		}
		setChanged();
		notifyObservers();
	}
	
	public void stand(){
		playing = false;
		if(dealer.takeTurn() == 1){
			dealerRound = dealerRound++;
			newCard = myDeck.dealCard();
			dealer.giveCard(newCard, dealerRound);
		}
		setChanged();
		notifyObservers();
		setChanged();
		notifyObservers();	
	}
	
	public String getHand(int whichPlayer){
		if(whichPlayer == 1){
			handToPrint = player.getHand();
		}
		else if(whichPlayer == 2){
			handToPrint = dealer.getHand();		
		}
		return handToPrint;
	}
}