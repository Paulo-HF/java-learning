package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        Department department = new Department(departmentName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        WorkerLevel workerLvl = WorkerLevel.valueOf(sc.next().toUpperCase());

        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        sc.nextLine();

        Worker worker = new Worker(name, baseSalary, workerLvl, department);

        System.out.print("How many contracts to this worker?: ");
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++) {

            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.next(), dtf);

            System.out.print("Value per hour: ");
            double value = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract hourContract = new HourContract(date, value, hours);
            worker.addContract(hourContract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3, 7));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}