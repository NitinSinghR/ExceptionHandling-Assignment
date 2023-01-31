package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Credit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Logger l= Logger.getLogger("com.api.jar");

         l.info("Enter the credit card name:");
         String name = sc.next();
         l.info("Enter the credit card number:");
         String number = sc.next();
         l.info("enter the expiration date");
         String date=sc.next();

         l.info("Enter the credit card name:");
         String name1 = sc.next();
         l.info("Enter the credit card number:");
         String number1 = sc.next();
         l.info("enter the expiration date");
         String date1=sc.next();

        Card c=new Card(name,number,date);
        Card c1 = null;
        try {
            c1 = (Card) c.clone();
        }catch(CloneNotSupportedException e){
            l.log(Level.INFO,()->" "+e);
        }
        Card c2=new Card(name1,number1,date1);

        String e=""+c1.compare(c2);
        l.info(e);
    }
}
class Card extends Credit implements Cloneable{
    private String name;
    private String number;
    private String date;

    Card(String name,String number,String date){
        this.name=name;
        this.number=number;
        this.date=date;
    }
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    public boolean compare(Card verify){
        return this.number.equals(verify.number);
    }
}