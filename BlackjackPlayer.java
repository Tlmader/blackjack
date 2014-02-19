import java.util.Arrays;

public class BlackjackPlayer{

	private Card[] hand;
	private AI myStrategy;
	private int handValue;
	private int decision;
	private int cardCount;
	
	public BlackjackPlayer(){
		hand = new Card[21];
		cardCount = -1;
	}
	
	public BlackjackPlayer(AI strategy){
		myStrategy = strategy;
		hand = new Card[21];
	}
	
	public void giveCard(Card newCard, int round){
		hand[round] = newCard;
		getHandValue(round);
	}
	
	public int getHandValue(int round){
		boolean hasAce = false;
		int newHandValue = 0;
		for(int i = 0; i <= round; i++){
			newHandValue = newHandValue + hand[i].getValue();
			if(hand[i].getValue() == 1){
				hasAce = true;
			}
		}
		handValue = newHandValue;
		if(hasAce == true && handValue <= 11){
			handValue = handValue + 10;
		}
		return handValue;
	}
	
	public int takeTurn(){
		decision = myStrategy.hitOrStand(handValue);
		if(decision == 1){
			cardCount++;
		}
		return decision;
	}
	
	public String getHand(){
		return Arrays.toString(hand);
	}
}