public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иван Иванов", 1, 60_000);
        employees[1] = new Employee("Сергей Сергеев", 2, 55_000);
        employees[2] = new Employee("Семён Семёнов", 1, 78_000);
        employees[3] = new Employee("Василий Васильев", 3, 112_000);
        employees[4] = new Employee("Михаил Михаилов", 5, 261_900);
        employees[5] = new Employee("Денис Денисов", 4, 62_000);
        employees[6] = new Employee("Назар Назаров", 3, 66_518);
        employees[7] = new Employee("Игорь Игорев", 2, 111_111);
        employees[8] = new Employee("Владимир Владимиров", 5, 40_000);
        employees[9] = new Employee("Мария Мариева", 4, 320_000);
        printAllEmployeesData(employees);
        System.out.println("Total Monthly Salary Expenses: " + calculateTotalSalaryExpenses(employees));
        System.out.println("Employee with Minimum Salary: " + findEmployeeWithMinSalary(employees).getFullName());
        System.out.println("Employee with Maximum Salary: " + findEmployeeWithMaxSalary(employees).getFullName());
        System.out.println("Average Salary: " + calculateAverageSalary(employees, calculateTotalSalaryExpenses(employees)));
        printFullNamesOfEmployees(employees);
    }

    public static void printAllEmployeesData(Employee[] employees) {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static double calculateTotalSalaryExpenses(Employee[] employees) {
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }

    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        int minSalaryEmployee = employees[0].getId();
        double minSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp.getId();
            }
        }
        return employees[minSalaryEmployee - 1];
    }

    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalaryEmployee = employees[0].getId();
        double maxSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp.getId();
            }
        }
        return employees[maxSalaryEmployee - 1];
    }

    public static double calculateAverageSalary(Employee[] employees, double totalSalary) {
        int count = employees.length;
        return totalSalary / count;
    }

    public static void printFullNamesOfEmployees(Employee[] employees) {
        for (Employee emp : employees) {
            System.out.println(emp.getFullName());
        }
    }
}
