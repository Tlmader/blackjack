import java.util.Random;

public class Deck{

	private Card[] deck;
	private int currentCard;
	private String suit;
	
	public Deck(){
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};		
		deck = new Card[52];
		currentCard = 0;
		for(int i = 0; i < deck.length; i++){
			deck[i] = new Card(faces[i % 13], suits[i / 13]);
		}
	}
	
	public void shuffle(){
		currentCard = 0;
		for(int i = 0; i < deck.length; i++){
			Random randomGenerator = new Random();
			int randomI = randomGenerator.nextInt(deck.length);
			Card temp = deck[i];
			deck[i] = deck[randomI];
			deck[randomI] = temp;
		}
	}
	
	public Card dealCard(){
		if(currentCard == 0){
			shuffle();
		}
		return deck[currentCard];
	}
}