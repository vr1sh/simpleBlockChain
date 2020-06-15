package blockchain;
import blockchain.Chain;

import java.security.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Base64;

public class chainFunctions {

    public static int difficulty = 3;

    public static String applySHA(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addToChain(ArrayList<Block> blockchain, int i) {
        if(i == 0) {
            blockchain.add(new Block("genesis block","0"));
            blockchain.get(0).mineBlock(difficulty);
        } else {
            blockchain.add(new Block(i + "th block", blockchain.get(blockchain.size() - 1).hash));
            blockchain.get(i).mineBlock(difficulty);
        };
    }

    public static void displayChain(ArrayList<Block> blockchain) {
        int i = 0;
        System.out.println("The BlockChain: ");
        for (Block block : blockchain) {
            System.out.println("Hash of block number" + " " + i + " is: " + block.hash);
            System.out.println("Hash of previous block: " + block.previousHash);
            System.out.println();
            i++;
        }
    }

    public static void chainValidity(ArrayList<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        for(int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calcHash()) ){
                System.out.println("Current Hashes not equal");
                System.out.println("BlockChain is not valid");
            }
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                System.out.println("Chain is not valid");
            }
        }
        System.out.println("Chain passed the validity test");
    }

}

