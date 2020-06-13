import java.util.ArrayList;
import java.util.Arrays;

public class Chain {

    static int i = 1;
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("genesis block", "0"));
        blockchain.add(new Block("second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("third block", blockchain.get(blockchain.size()-1).hash));

        for(Block block : blockchain) {
            System.out.println("Hash of block number" + " " + i + " " + block.hash);
            System.out.println();
            i++;
        }

    }

}