package blockchain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chain extends chainFunctions {

    public static void main(String[] args) {
        int i = 0;
        boolean condition = true;
        ArrayList<Block> blockchain = new ArrayList<Block>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter: \n1 to add a block \n2 to display the BlockChain\n3 to exit");
        int n = scan.nextInt();
        while(condition) {
            switch(n) {
                case 1:
                    addToChain(blockchain, i);
                    break;
                case 2:
                    displayChain(blockchain, i);
                    break;
                case 3: condition = false;
                    break;
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }

}