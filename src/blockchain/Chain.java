package blockchain;
import java.util.*;
import java.security.Security;

public class Chain extends chainFunctions {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;


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
        chainValidity(blockchain);
    }

}