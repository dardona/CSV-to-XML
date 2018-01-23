package com.danny.csv.to.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Danny
 */
public class Converter {
    public static void main(String[] args) throws JAXBException{
        
        //Relative path to excel file
        String file = "src/batchfile.csv";
        BufferedReader reader = null;
        
        String line = "";
        int transactionID = 1;
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        JAXBContext context;
        context = JAXBContext.newInstance(Transaction.class);
        
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                
                String[] lineParts = line.split(", ");
                
                //Creating new Transaction object and setting the values of the last read row in the constructor
                transactions.add(new Transaction(transactionID++,
                                                 lineParts[0],
                                                 lineParts[1],
                                                 Double.parseDouble(lineParts[2]),
                                                 lineParts[3],
                                                 lineParts[4]));
                
                //Creating unique xml files based on transaction ID
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(transactions.get(transactions.size() - 1), new File(transactions.get(transactions.size() - 1).getTransactionID() + ".xml"));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
