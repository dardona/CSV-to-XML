package com.danny.csv.to.xml;


import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danny
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Transaction")
public class Transaction {
    
    //Variables needed for XML elements in the new file
    private int transactionID;
    private String dateProcessed;
    private String name;
    private double originalAmount;
    private double convertedAmount;
    private double exchangeRate; 
    private String currency;
    private String bank;
    
    public Transaction() {
        
    }
    
    public Transaction(int transactionID, String dateProcessed, String name, double originalAmount, String currency, String bank){
        this.transactionID = transactionID;
        this.dateProcessed = dateProcessed;
        this.name = name;
        this.originalAmount = originalAmount;
        this.currency = currency;
        this.bank = bank;
        
        this.convertAmount();
    } 

    public double convertAmount(){
         //Conversion rates
        final double USDtoCAD = 1.24;
        final double EURtoCAD = 1.53;
        
        switch (currency) {
            case "CAD": exchangeRate = 1; break;
            case "USD": exchangeRate = USDtoCAD; break;
            case "EUR": exchangeRate = EURtoCAD; break;
        }
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        convertedAmount = Double.parseDouble(df.format(originalAmount * exchangeRate)); 
        return convertedAmount;
    }
    
    //Getters and Setters
    
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    
    public String getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(String dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public double getExchangeRate(){
        return exchangeRate;
    }
    
    public void setExchangeRate(double exchangeRate){
        this.exchangeRate = exchangeRate;
    }
    
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    
}
