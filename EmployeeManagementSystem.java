import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    private String id;
    private String name;
    private int age;
    private double salary;

    Employee(String id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display(){
        System.out.println("ID: "+id+ " Name: "+name+ " Age: "+age+" Salary: "+salary);
    }
}

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("========================================");
            System.out.println("------ Employee Management System ------");
            System.out.println("========================================");
            System.out.println("1. Add Employee.");
            System.out.println("2. View Employee.");
            System.out.println("3. Update Employee.");
            System.out.println("4. Delete Employee.");
            System.out.println("5. Exit.");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Employee's Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee's Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Employee's Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        employeeList.add(new Employee(id, name, age, salary));
        System.out.println("Employee added Successfully!");
    }

    static void viewEmployee() {
        if (employeeList.isEmpty()) {
            System.out.println("No Employees found!");
        } else {
            System.out.println("---- Employee List ----");
            for (Employee emp : employeeList) {
                emp.display();
            }
        }
    }

    static void updateEmployee() {
        System.out.print("Enter an ID to update: ");
        String id = sc.nextLine();
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                System.out.print("Enter new Employee ID: ");
                emp.setId(sc.nextLine());
                System.out.print("Enter new Employee's Name: ");
                emp.setName(sc.nextLine());
                System.out.print("Enter new Employee's Age: ");
                emp.setAge(sc.nextInt());
                System.out.print("Enter new Employee's Salary: ");
                emp.setSalary(sc.nextDouble());
                sc.nextLine();

                System.out.println("Employee Updated Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee Not Found!");
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to Delete: ");
        String id = sc.nextLine();
        boolean removed = employeeList.removeIf(emp -> emp.getId().equals(id));
        if (removed) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
