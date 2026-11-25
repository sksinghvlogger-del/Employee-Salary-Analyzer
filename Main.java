import java.util.Scanner;

class EmployeeSalaryAnalyzer {

    int[] employeeIds = new int[100];
    String[] employeeNames = new String[100];
    double[] salaries = new double[100];

    int count = 0;

    // Add Employee
    void addEmployee(int id, String name, double salary) {

        if (count >= 100) {
            System.out.println("Employee limit reached!");
            return;
        }

        if (id <= 0 || salary < 0 || name.trim().isEmpty()) {
            System.out.println("Invalid employee details!");
            return;
        }

        if (searchIndexById(id) != -1) {
            System.out.println("Employee ID already exists!");
            return;
        }

        employeeIds[count] = id;
        employeeNames[count] = name;
        salaries[count] = salary;

        count++;

        System.out.println("Employee added successfully!");
    }

    // Display Employees
    void displayEmployees() {

        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.println("\nID\tName\t\tSalary");

        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t%-15s %.2f%n",
                    employeeIds[i],
                    employeeNames[i],
                    salaries[i]);
        }
    }

    // Search Employee by ID
    int searchIndexById(int id) {

        for (int i = 0; i < count; i++) {

            if (employeeIds[i] == id) {
                return i;
            }
        }

        return -1;
    }

    void searchById(int id) {

        int index = searchIndexById(id);

        if (index == -1) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Employee Found:");
            System.out.println("ID: " + employeeIds[index]);
            System.out.println("Name: " + employeeNames[index]);
            System.out.println("Salary: " + salaries[index]);
        }
    }

    // Search Employee by Name
    void searchByName(String name) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employeeNames[i].equalsIgnoreCase(name)) {

                System.out.println("Employee Found:");
                System.out.println("ID: " + employeeIds[i]);
                System.out.println("Name: " + employeeNames[i]);
                System.out.println("Salary: " + salaries[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Employee not found!");
        }
    }

    // Bubble Sort
    void sortBySalary(boolean ascending) {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                boolean swap = ascending
                        ? salaries[j] > salaries[j + 1]
                        : salaries[j] < salaries[j + 1];

                if (swap) {

                    double tempSalary = salaries[j];
                    salaries[j] = salaries[j + 1];
                    salaries[j + 1] = tempSalary;

                    int tempId = employeeIds[j];
                    employeeIds[j] = employeeIds[j + 1];
                    employeeIds[j + 1] = tempId;

                    String tempName = employeeNames[j];
                    employeeNames[j] = employeeNames[j + 1];
                    employeeNames[j + 1] = tempName;
                }
            }
        }

        System.out.println("Employees sorted successfully!");
        displayEmployees();
    }

    // Calculate Total and Average Salary
    void calculateAverageSalary() {

        if (count == 0) {
            System.out.println("No records available!");
            return;
        }

        double total = 0;

        for (int i = 0; i < count; i++) {
            total += salaries[i];
        }

        System.out.println("Total Salary: " + total);
        System.out.println("Average Salary: " + total / count);
    }

    // Highest Salary
    void findHighestSalary() {

        if (count == 0) {
            System.out.println("No records available!");
            return;
        }

        int max = 0;

        for (int i = 1; i < count; i++) {

            if (salaries[i] > salaries[max]) {
                max = i;
            }
        }

        System.out.println("Highest Salary: " + salaries[max]);
        System.out.println("Employee: " + employeeNames[max]);
    }

    // Lowest Salary
    void findLowestSalary() {

        if (count == 0) {
            System.out.println("No records available!");
            return;
        }

        int min = 0;

        for (int i = 1; i < count; i++) {

            if (salaries[i] < salaries[min]) {
                min = i;
            }
        }

        System.out.println("Lowest Salary: " + salaries[min]);
        System.out.println("Employee: " + employeeNames[min]);
    }
}


// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeSalaryAnalyzer analyzer =
                new EmployeeSalaryAnalyzer();

        while (true) {

            System.out.println("\n===== EMPLOYEE SALARY ANALYZER =====");

            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Search Employee by Name");
            System.out.println("5. Sort Salary Ascending");
            System.out.println("6. Sort Salary Descending");
            System.out.println("7. Calculate Salary Statistics");
            System.out.println("8. Find Highest Salary");
            System.out.println("9. Find Lowest Salary");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    analyzer.addEmployee(id, name, salary);
                    break;

                case 2:

                    analyzer.displayEmployees();
                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    analyzer.searchById(searchId);
                    break;

                case 4:

                    System.out.print("Enter Employee Name: ");
                    String searchName = sc.nextLine();

                    analyzer.searchByName(searchName);
                    break;

                case 5:

                    analyzer.sortBySalary(true);
                    break;

                case 6:

                    analyzer.sortBySalary(false);
                    break;

                case 7:

                    analyzer.calculateAverageSalary();
                    break;

                case 8:

                    analyzer.findHighestSalary();
                    break;

                case 9:

                    analyzer.findLowestSalary();
                    break;

                case 10:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}