package edisontkp.com.justpark.model;

/**
 * Created by edisontkp on 16/10/2016.
 */

public class PayParkResponseModel {
    String TransactionId, Payer, Amount, Payee, Status,CarPlate, Duration,RefCode;

    public PayParkResponseModel(String transactionId, String payer, String amount, String payee, String status, String carPlate, String duration, String refCode) {
        TransactionId = transactionId;
        Payer = payer;
        Amount = amount;
        Payee = payee;
        Status = status;
        CarPlate = carPlate;
        Duration = duration;
        RefCode= refCode;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getPayee() {
        return Payee;
    }

    public void setPayee(String payee) {
        Payee = payee;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
        CarPlate = carPlate;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getRefCode() {
        return RefCode;
    }

    public void setRefCode(String refCode) {
        RefCode = refCode;
    }
}
