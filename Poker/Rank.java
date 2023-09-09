package Poker;

import java.util.List;

public enum Rank {

    OnePair(2),
    TwoPair(3),
    Top(1);


    public static int calculator(List<Card> list, int num) {
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getNum() == list.get(i + 1).getNum()) {
                switch (num) {
                    case 1 : count++;
                    case 2 : {
                        WinnerCheck.check(list.get(i));
                        WinnerCheck.check(list.get(i + 1));
                    }
                }
                i++;
            }
        }
        return count;
    }
    public static Rank pedigree(List<Card> list) { /**처음 유저들의 패의 족보를 나타내주는 메서드*/
        int count = calculator(list, 1);

        if(count == 2)
            return Rank.TwoPair;
        else if(count == 1)
            return Rank.OnePair;
        else
            return Rank.Top;
    }
    public static void pair(List<Card> list)  { /**이제 투페어가 2개이상 이거나 원페어가 2개이상 일 때 구별하는 메서드*/
        calculator(list, 2);
    }
    public static void top(List<Card> list)  { /**모두 top만 나왔을 때 1등 구별하는 메서드*/
        WinnerCheck.check(list.get(0));
    }
    private final int pedigreeRank;
    Rank(int pedigreeRank) {
        this.pedigreeRank = pedigreeRank;
    }

    int pedigreeRank() {
        return pedigreeRank;
    }
}
