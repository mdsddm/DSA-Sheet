package ProfJahir;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*  Define Person(name, weight(in kg), height(in cm)) class in java with required methods. Thereafter write java program by defining Demo class having read (Person a[]), print(Person a[]), sort(Person a[], String onAttribute) and main() static function to read, print and sort the list of person. In sort() function  the one attribute out of name, height, weight and BMI is passsed and it sort the list based on passed attribute. The print static function print the list of person within square brackets seprated by comma and information of each person should be placed within paranthesis as name(name:xyz, height : hh cm, weight : ww kg, BMI : r.x kg.m^2, BMI-category : abc), where BMI-category is computed as if BMI < 18.5 then BMI-category = "Underweight", if 18.5 <= BMI < 25 then BMI-category="Normal", if 25 <= BMI < 30 then BMI-category="Overweight", else BMI-category="Obesity"   */
public class MinorTwoFirst {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("How many Person : ");
        int num = in.nextInt();
        Person[] a = new Person[num];
        read(a);
        System.out.print("Enter sorting Attribute  : ");
        String onAttribute = in.nextLine();
        sort(a, onAttribute);
        print(a);
    }

    private static void read(Person[] a) {
        in.nextLine();// clearing buffer
        for (int i = 0; i < a.length; i++) {
            System.out.println("Entry of " + (i + 1) + " person : ");

            System.out.print("  name : ");
            String name = in.nextLine();

            System.out.print("  weight : ");
            double weight = Double.parseDouble(in.nextLine());

            System.out.print("  height : ");
            double height = Double.parseDouble(in.nextLine());

            a[i] = new Person(name, weight, height);
        }
        System.out.println("Entry of " + a.length + " Person Complete Successfully !");
    }

    private static void print(Person[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Entry of " + (i + 1) + " person : ");
            System.out.println("  name : " + a[i].name);
            System.out.println("  weight : " + a[i].weight + " kg");
            System.out.println("  height : " + a[i].height + " cm");
            System.out.println("  BMI : " + a[i].BMI + " kg/m^2");
            System.out.println("  BMI-category : " + a[i].getBmiCategory());

        }
    }

    private static void sort(Person[] a, String onAttribute) {
        if (onAttribute.equals("name")) {
            Arrays.sort(a, Comparator.comparing(o -> o.name));
        } else if (onAttribute.equals("weight")) {
            Arrays.sort(a, Comparator.comparing(o -> o.weight));
        } else if (onAttribute.equals("height")) {
            Arrays.sort(a, Comparator.comparing(o -> o.height));
        } else if (onAttribute.equals("BMI")) {
            Arrays.sort(a, Comparator.comparing(o -> o.BMI));
        } else {
            System.out.println("you Entered Wrong sorting onAttribute !!!");
            return;
        }
        System.out.println("Sorting Completed with respect to " + onAttribute);
    }

}

class Person {
    String name;
    double weight;
    double height;
    double BMI;

    // Constructure
    Person(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        BMI = (weight * 10000) / (height * height); // height is in cm so multiplying by 10000
    }

    String getBmiCategory() {
        if (BMI < 18.5) {
            return "Underweight";
        } else if (18.5 <= BMI && BMI < 25) {
            return "Normal";
        } else if (25 <= BMI && BMI > 30) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

}
