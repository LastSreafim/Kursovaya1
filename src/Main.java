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
        changeAllSalary(employees, 4);
        printAllEmployeesData(employees);//проверяем индексацию зп (У ВСЕХ)
        System.out.println("Total Monthly Salary Expenses in Department: " + calculateTotalSalaryExpensesInDepartment(employees, 3));
        System.out.println("Average Salary in Department: " + calculateAverageSalaryInDepartment(employees, 2));
        System.out.println("Employee with Maximum Salary in Department: " + findEmployeeWithMaxSalaryInDepartment(employees, 1));
        System.out.println("Employee with Minimum Salary in Department: " + findMinSalaryEmployeeInDepartment(employees, 4));
        changeAllSalaryInDepartment(employees, 4, 5);
        printEmployeesInDepartment(employees, 5);
        printEmployeesWithSalaryAbove(employees, 100_000);
        printEmployeesWithSalaryBelow(employees, 100_000);
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

    public static void changeAllSalary(Employee[] employees, double percent) {
        for (Employee emp : employees) {
            double currentSalary = emp.getSalary();
            double changedSalary = currentSalary * percent / 100 + currentSalary;
            emp.setSalary(changedSalary);
        }

    }

    public static double calculateTotalSalaryExpensesInDepartment(Employee[] employees, int department) {
        double totalSalary = 0;
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                totalSalary += emp.getSalary();
            }

        }
        return totalSalary;
    }

    public static Employee findMinSalaryEmployeeInDepartment(Employee[] employees, int department) {
        int minSalaryEmployee = employees[0].getId();
        double minSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getDepartment() == department && emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp.getId();
            }
        }
        return employees[minSalaryEmployee - 1];
    }

    public static Employee findEmployeeWithMaxSalaryInDepartment(Employee[] employees, int department) {
        int maxSalaryEmployee = employees[0].getId();
        double maxSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getDepartment() == department && emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp.getId();
            }
        }
        return employees[maxSalaryEmployee - 1];
    }

    public static double calculateAverageSalaryInDepartment(Employee[] employees, int department) {
        double totalSalary = 0;
        int count = 0;

        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                totalSalary += emp.getSalary();
                count++;
            }
        }
        return totalSalary / count;
    }

    public static void changeAllSalaryInDepartment(Employee[] employees, double percent, int department) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                double changedSalary = emp.getSalary() * (1 + percent / 100);
                emp.setSalary(changedSalary);
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees, int department) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " +
                        emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryBelow(Employee[] employees, double threshold) {
        for (Employee emp : employees) {
            if (emp.getSalary() < threshold) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " + emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryAbove(Employee[] employees, double threshold) {
        for (Employee emp : employees) {
            if (emp.getSalary() >= threshold) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " + emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }


}
