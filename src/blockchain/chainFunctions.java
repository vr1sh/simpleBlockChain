package blockchain;
import blockchain.Chain;
import java.util.ArrayList;
import java.util.ArrayList;

public class chainFunctions {
    public static void displayChain(ArrayList<Block> blockchain, int i) {
        for (Block block : blockchain) {
            System.out.println("Hash of block number" + " " + i++ + " is: " + block.hash);
            System.out.println();
        }
    }

    public static void addToChain(ArrayList<Block> blockchain, int i) {
        if(i == 0) {
            blockchain.add(new Block("genesis block", "0"));
        } else {
            blockchain.add(new Block(i + "th block", blockchain.get(blockchain.size() - 1).hash));
        };
    }

}

