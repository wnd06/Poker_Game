package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Dealer implements Iterable<Card>{
    private List<Card> cards = new ArrayList<>();

    //52장의 카드 덱 완성.
    public void add() {

        Suit [] suits = Suit.values(); // 배열에 들어있음.
        CardNumber[] cardNumbers = CardNumber.values();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < cardNumbers.length; j++) {
                cards.add(new Card(suits[i], cardNumbers[j]));
            }
        }
        Collections.shuffle(cards); //카드 52장 셔플
    }

    //카드 5장씩 주기
    public Card give() {
        return cards.get(0);
    }
    public void delete(Card card) {
        cards.remove(card);
    }

    @Override
    public Iterator<Card> iterator() {

        return cards.iterator();
    }

}
