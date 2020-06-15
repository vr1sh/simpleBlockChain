package blockchain;
import java.security.*;
import java.util.ArrayList;


public class Transactions {

    public String transactionId; // this is also the hash of the transaction.
    public PublicKey sender; // senders address/public key.
    public PublicKey recipient; // Recipients address/public key.
    public float value;
    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.

    public Transactions(PublicKey from, PublicKey to, float value,  ArrayList<transactionInput> inputs) {
        this.sender = from;
        this.recipient = to;
        this.value = value;
        this.inputs = inputs;
    }

    public ArrayList<transactionInput> inputs = new ArrayList<transactionInput>();
    public ArrayList<transactionOutput> outputs = new ArrayList<transactionOutput>();

    private static int sequence = 0; // a rough count of how many transactions have been generated.


    // This Calculates the transaction hash (which will be used as its Id)
    private String calcHash() {
        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
        return chainFunctions.applySHA(
                chainFunctions.getStringFromKey(sender) +
                        chainFunctions.getStringFromKey(recipient) +
                        Float.toString(value) + sequence
        );
    }

    //Signs all the data we dont wish to be tampered with.
    public void generateSignature(PrivateKey privateKey) {
        String data = chainFunctions.getStringFromKey(sender) + chainFunctions.getStringFromKey(recipient) + Float.toString(value);
        signature = chainFunctions.applyECDSASig(privateKey,data);
    }
    //Verifies the data we signed hasnt been tampered with
    public boolean verifySignature() {
        String data = chainFunctions.getStringFromKey(sender) + chainFunctions.getStringFromKey(recipient) + Float.toString(value)	;
        return chainFunctions.verifyECDSASig(sender, data, signature);
    }

}
