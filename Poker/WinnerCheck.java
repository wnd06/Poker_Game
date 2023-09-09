package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCheck {

    private final static List<Card> list = new ArrayList<>();

    public static void topCheck(Table table) {

        for (User player : table.getUserList()) { // list의 제일 첫번째의 위치한 카드가 제일 좋은 카드이므로 유저들중 이 키드를 들고있는 사람이 우승
            for (Card card : player) {
                if (card.getNum() == list.get(0).getNum() && card.getSuit() == list.get(0).getSuit()) {
                    System.out.println("Winner : " + player.getName());
                    System.out.println(list.get(0).toString());
                }
            }
        }
    }
    public static void check(Card card) {
        list.add(card);

        Collections.sort(list, (e1, e2) -> { /**만약에 카드의 번호가 같을 때 카드 문양을 보고 우선순위 바꿈.*/
            if(e1.getNum().numberRank() == e2.getNum().numberRank())
                return e2.getSuit().getNum() - e1.getSuit().getNum();
            else
                return e2.getNum().numberRank() - e1.getNum().numberRank();
        });
    }
}
