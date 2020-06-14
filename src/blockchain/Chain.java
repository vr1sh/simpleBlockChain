package blockchain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chain extends chainFunctions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of blocks to generate:");
        int n = scan.nextInt();
        int i;
        ArrayList<Block> blockchain = new ArrayList<Block>();
        for(i = 0; i < n; i++) {
            addToChain(blockchain, i);
        }
        displayChain(blockchain);
    }

}