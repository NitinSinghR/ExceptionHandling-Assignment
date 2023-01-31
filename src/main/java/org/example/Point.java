package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Point {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger l= Logger.getLogger("com.api.jar");
        int x=0;
        int y = 0;
        int x1=0;
        int y1=0;
        try {
            l.info("Enter the x value:");
            x = sc.nextInt();
            l.info("Enter the y value:");
            y = sc.nextInt();

            l.info("Enter the x value:");
            x1 = sc.nextInt();
            l.info("Enter the y value:");
            y1 = sc.nextInt();
        }catch(InputMismatchException e){
            l.log(Level.INFO,()->" "+e);
        }
        Points p = new Points(x, y);
        Points p1=null;
        try {
            p1 = (Points) p.clone();
        }catch(CloneNotSupportedException e){
        l.log(Level.INFO,()->" "+e);
    }
        String e=p1.equals(x1,y1);
        l.info(e);
    }
}
class Points extends Point implements Cloneable{
    private int x1;
    private int y1;
    Points(int x,int y) {
        this.x1 = x;
        this.y1 = y;
    }

    public String equals(int x,int y) {
        if (x1 == x && y == y1) {
            return "true";
        } else {
            return "false";
        }
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}