package Poker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();

        System.out.println("인원 수를 적으시오: ");
        int num = scanner.nextInt();

        Table table = new Table(num);
        
        table.putCard(dealer);
        table.openCard();
        WinnerCheck.topCheck(table);
    }
}
