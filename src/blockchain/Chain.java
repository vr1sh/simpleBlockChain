package blockchain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chain extends chainFunctions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of blocks you want the chain to have:");
        int m = scan.nextInt();
        int i = 0;
        ArrayList<Block> blockchain = new ArrayList<Block>();
        while(i < m) {
            addToChain(blockchain, i++);
            displayChain(blockchain, i);
        }
    }

}