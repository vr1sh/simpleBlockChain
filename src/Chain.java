import java.util.ArrayList;
import java.util.Arrays;

public class Chain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("This is the first block", "0"));
        blockchain.add(new Block("This is the second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("This is the third block", blockchain.get(blockchain.size()-1).hash));

        for(Block block : blockchain) {
            System.out.println(block.hash);
        }

    }

}