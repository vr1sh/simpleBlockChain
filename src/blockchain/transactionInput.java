package blockchain;
import blockchain.transactionOutput;

public class transactionInput {
    public String transactionOutputId; //Reference to TransactionOutputs -> transactionId
    public transactionOutput UTXO; //Contains the Unspent transaction output

    public transactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}