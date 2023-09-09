package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class User implements Iterable<Card> {

    private List<Card> UserCard = new ArrayList<>();
    private String name;
    private Rank rank;
    public User(String name) {
        this.name = name;
    }

    public void add(Card card) {
        UserCard.add(card);
    }

    @Override
    public String toString() {
        return this.name +
                "님의 카드= " + UserCard;
    }

    @Override
    public Iterator<Card> iterator() {
        return this.UserCard.iterator();
    }

    public String getName() {
        return name;
    }

    public List<Card> getUserCard() {
        return this.UserCard;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }
}
