package Poker;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card>{

    private Suit suit;
    private CardNumber num;

    public Card(Suit suit, CardNumber num) {
        this.suit = suit;
        this.num = num;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardNumber getNum() {
        return num;
    }

    public String toString() {
        return this.suit + " " + this.num;
    }

    @Override
    public int compareTo(Card o) {
        return o.getNum().numberRank() - this.num.numberRank();
    }
}
