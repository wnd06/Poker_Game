package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Table {

    private final List<User> userList = new ArrayList<>();
    private final List<String> nameList = new ArrayList<>();
    private final List<Rank> rankList = new ArrayList<>();

    public Table(int usercount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("방명록을 작성하시오: ");
        for (int i = 0; i < usercount; i++) {
            nameList.add(scanner.next());
            userList.add(new User(nameList.get(i)));
        }
        System.out.println("Poker Game Start!!");

    }

    public void putCard(Dealer dealer) {

        dealer.add();
        for (int i = 0; i < userList.size(); i++) {
            for (int j = 0; j < 5; j++) {
                userList.get(i).add(dealer.give());
                dealer.delete(dealer.give());
                Collections.sort(userList.get(i).getUserCard());
            }
        }
    }
    /**유저들의 패 공개*/
    public void openCard() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
            Rank getpedigee = Rank.pedigree(userList.get(i).getUserCard());
            rankList.add(getpedigee);
            System.out.println(getpedigee);
        }

        /**최종 승자 가리는 구간*/

        for (int i = 0; i < userList.size(); i++) { //TwoPair가 있으면 그것만 체크
            if(rankList.get(i) == Rank.TwoPair) {
                Rank.pair(userList.get(i).getUserCard());
            }
            else if(rankList.get(i) == Rank.OnePair) { //TwoPair는 없고 OnePair 또는 top만 있을 경우
                if(rankList.contains(Rank.TwoPair)) {
                    continue;
                }
                Rank.pair(userList.get(i).getUserCard());
            }
            else if(rankList.get(i) == Rank.Top){ //top만 있을 경우
                if(rankList.contains(Rank.TwoPair) || rankList.contains(Rank.OnePair)) {
                    continue;
                }
                Rank.top(userList.get(i).getUserCard());
            }
        }
    }
    public List<User> getUserList() {
        return userList;
    }
}
