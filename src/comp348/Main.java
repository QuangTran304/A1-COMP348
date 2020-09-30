package comp348;


import com.sun.jdi.DoubleValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;

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




        Scanner fileReader = null;                                     // Do this because we need to handle exception inside 'try' block

        try {
            fileReader = new Scanner(new FileInputStream("src/comp348/inputStrings.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(1);
        }


        List<Employee> employeeList = new ArrayList<>();       // Dynamic array is more efficient than raw array

        while (fileReader.hasNext()) {
            Employee e = Employee.parse(fileReader.nextLine());        // Parse employee information from each line in the file
            employeeList.add(e);
        }
        fileReader.close();                                            // Done reading file. Close the file stream


        // Sort and Display employees by last-name & first-name
        List<Employee> employeeByName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))       // Use method-reference == Lambda
                .collect(Collectors.toList());
        System.out.println("\n------ Sorted Employees by first & last name ------");
        employeeByName.forEach(System.out::println);                   // Use method-reference == Lambda


        // Sort & Display employees by ID
        List<Employee> employeeByID = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getID))
                .collect(Collectors.toList());

        System.out.println("\n------ Sorted Employees by ID ------");
        employeeByID.forEach(System.out::println);

        //making a sublist of salaries from the list of employees
        List<BigDecimal> ids = employeeList.stream()
                .map(Employee::getSalary).collect(Collectors.toList());

        //transforming that sublist into a douuble list for easier manipulation
        List<Double> salarydoubles =  ids.stream().map(BigDecimal::doubleValue).collect(Collectors.toList());

        //grouping in less than 25000, finding average and count
        List<Double> lesstwentyfive = salarydoubles.stream().filter( e ->e<25000).collect(Collectors.toList());
        DoubleSummaryStatistics a = lesstwentyfive.stream()
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("The average salary of people making less than 25000 is " + a.getAverage() + " and there are " + a.getCount() +
                " employees in that range.");

        //grouping between 25000 and 40000
        List<Double> moretwentyfive = salarydoubles.stream().filter( e ->e>=25000&&e<=40000).collect(Collectors.toList());
        DoubleSummaryStatistics b = moretwentyfive.stream()
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("The average salary of people making more than 25000 but less than 40000 is " + b.getAverage() + " and there are " + b.getCount() +
                " employees in that range.");

        //grouping betweeen 40000 and 70000
        List<Double> moreforty = salarydoubles.stream().filter( e ->e>=40000&&e<=70000).collect(Collectors.toList());
        DoubleSummaryStatistics c = moreforty.stream()
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("The average salary of people making more than 40000 but less than 70000 is " + c.getAverage() + " and there are " + c.getCount() +
                " employees in that range.");

        //grouping between more than 70000
        List<Double> moreseventy = salarydoubles.stream().filter( e ->e>70000).collect(Collectors.toList());
        DoubleSummaryStatistics d = moreseventy.stream()
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("The average salary of people making more than 70000 is " + d.getAverage() + " and there are " + d.getCount() +
                " employees in that range.");

        //finding the total average and total count
        double totalaverage = ids.stream().mapToDouble(BigDecimal::doubleValue).sum()/ids.size();

        System.out.println("The total average salary is " + Math.floor(totalaverage*100)/100 + " and the total number of employees is " + ids.size());






    }
    }

