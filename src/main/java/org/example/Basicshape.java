package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Basicshape {
    public static void main(String[] args) {

        Logger l=Logger.getLogger("com.api.jar");
        Scanner sc = new Scanner(System.in);
        double radius;
        double length;
        double base;
        double width;
        double height;
        double a;
        double b;
        String s="circle";
        String s2="rectangle";
        String s3="triangle";

        Shape s1 = null;

        l.info("Enter the type of shape\n1.circle\n2.rectangle\n3.triangle");
        String type = sc.next();

        try {
            if (type.equals(s)) {
                l.info("Enter the radius\n");
                radius = sc.nextDouble();
                s1 = new Shape(type, radius);
            } else if (type.equals(s2)) {
                l.info("Enter the length\n");
                length = sc.nextInt();
                l.info("Enter the width\n");
                width = sc.nextDouble();
                s1 = new Shape(type, length, width);
            } else if (type.equals(s3)) {
                l.info("Enter the length of a\n");
                a = sc.nextDouble();
                l.info("Enter the length of b\n");
                b = sc.nextDouble();
                l.info("Enter the base\n");
                base = sc.nextDouble();
                l.info("Enter the height\n");
                height = sc.nextDouble();
                s1 = new Shape(type, a, b, base, height);
            } else {
                l.info("Enter the correct shape");
            }
        }catch(InputMismatchException e){
            l.log(Level.INFO,()->" "+e);
        }
        l.info("Area is " + s1.getArea());
        l.info("Perimeter is" + s1.getPerimeter());
    }

}


class Shape extends Basicshape {
    private String type;
    private double length;
    private double base;
    private double width;
    private double height;
    private double a;
    private double b;
    private double radius;
    String s="circle";
    String s2="rectangle";
    String s3="triangle";

    Shape(String type, double radius) {
        this.type = type;
        this.radius = radius;
    }

    Shape(String type, double length, double width) {
        this.type = type;
        this.length = length;
        this.width = width;
    }

    Shape(String type, double base, double height, double a, double b) {
        this.type = type;
        this.height = height;
        this.base = base;
        this.a = a;
        this.b = b;
    }

    public double getPerimeter() {
        double perimeter = 0;
        if (type.equals(s3)) {
            perimeter = a + b + base;
        } else if (type.equals(s2)) {
            perimeter = 2 * (length + width);
        } else if (type.equals(s)) {
            perimeter = 2 * Math.PI * radius;
        }
        return perimeter;
    }

    public double getArea() {
        double area = 0;
        if (type.equals(s3)) {
            area = base * height * 0.5;
        } else if (type.equals(s2)) {
            area = length * width;
        } else if (type.equals(s)) {
            area = Math.PI * radius * radius;
        }
        return area;
    }
}