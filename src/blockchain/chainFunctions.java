package blockchain;
import blockchain.Chain;
import java.util.ArrayList;
import java.util.ArrayList;

public class chainFunctions {
    public static void displayChain(ArrayList<Block> blockchain) {
        int i = 0;
        for (Block block : blockchain) {
            System.out.println("Hash of block number" + " " + i + " is: " + block.hash);
            System.out.println();
            i++;
        }
    }

    public static void addToChain(ArrayList<Block> blockchain, int i) {
        if(i == 0) {
            blockchain.add(new Block("genesis block", "0"));
        } else {
            blockchain.add(new Block(i + "th block", blockchain.get(blockchain.size() - 1).hash));
        };
    }

    public static void chainValidity(ArrayList<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calcHash()) ){
                System.out.println("Current Hashes not equal");
                System.out.println("BlockChain is not valid");
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                System.out.println("Chain is not valid");
            }
        }
        System.out.println("Chain passed the validity test");
    }

}

