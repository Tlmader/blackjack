public class Card{

	private int value;
	private String face;
	private String suit;
	private boolean isAce;
	
	public Card(String _face, String _suit){
		face = _face;
		suit = _suit;
		if(face == "Ace"){
			value = 1;
		}
		if(face == "Deuce"){
			value = 2;
		}
		if(face == "Three"){
			value = 3;
		}
		if(face == "Four"){
			value = 4;
		}
		if(face == "Five"){
			value = 5;
		}
		if(face == "Six"){
			value = 6;
		}
		if(face == "Seven"){
			value = 7;
		}
		if(face == "Eight"){
			value = 8;
		}
		if(face == "Nine"){
			value = 9;
		}
		if(face == "Ten"){
			value = 10;
		}
		if(face == "Jack"){
			value = 10;
		}
		if(face == "Queen"){
			value = 10;
		}
		if(face == "King"){
			value = 10;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public String toString(){
		return face + " of " + suit;
	}
}