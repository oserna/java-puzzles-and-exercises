package oo.cards;

public enum Suit {
	
	SPADES(1) {
		@Override
		public String toString() {
			return "Spades";
		}
	},
	CLUBS(2) {
		@Override
		public String toString() {
			return "Clubs";
		}
	},
	HEARTS(3) {
		@Override
		public String toString() {
			return "Hearts";
		}
	},
	DIAMONDS(4) {
		@Override
		public String toString() {
			return "Diamons";
		}
	};
		
	private Suit(int type) {
		this.type = type;
	}
	
	private int type;
	public abstract String toString();
}
