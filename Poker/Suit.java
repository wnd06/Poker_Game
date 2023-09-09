package Poker;

import java.util.Random;

public enum Suit {
        SPADE("\u2660", 4),
        HEART("\u2665", 3),
        CLOVER("\u2663", 2),
        Diamond("\u25C6", 1);

        public final int num;
        public final String name;
        Suit(String name, int num) {
            this.name = name;
            this.num = num;
        }
        public int getNum() { return this.num; }
        public String toString() {
            return  this.name;
        }
}
