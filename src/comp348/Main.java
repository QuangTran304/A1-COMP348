package comp348;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //input test (by parsa)
//        Employee e1 = e1.parse("0132435,John,Doe,30000.00");
//        System.out.println(e1.toString());
//        System.out.println(e1.getSalary());
//        System.out.println(e1.getID());
//        System.out.println(e1.getName());


        // Test by Quang
        Employee worker1 = new Employee("1234567", "John", "Doe", new BigDecimal("3000.02"));
        System.out.println("Worker1: " + worker1.toString());
        System.out.println("\nID: " + worker1.getID());
        System.out.println("Name: " + worker1.getName());
        System.out.println("Salary: " + worker1.getSalary());

        System.out.println("\n---------");

        Employee worker2 = Employee.parse("1528950,Jane,Doe,3500.24");
        System.out.println("Worker2: " + worker2.toString());

        System.out.println("\n---------");

        Employee worker3 = Employee.parse("2593950,Bruno,Mars,2900.89");
        System.out.println("Worker3: " + worker3.toString());

        System.out.println("\n---------");




        Scanner fileReader = null; // Need to handle exception inside 'try' block

        try {
            fileReader = new Scanner(new FileInputStream("src/comp348/inputStrings.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(1);
        }

        // Just for testing, using 'while' & 'for' is not allowed in our assignment
        while (fileReader.hasNext()) {
            String s = fileReader.nextLine();
            System.out.println(s);
        }

        fileReader.close();
    }
}
