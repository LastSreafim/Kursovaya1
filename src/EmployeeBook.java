public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    private int size;

    public boolean addEmployee(String fullName, int department, double salary) {
        if (size >= employees.length) {
            return false;
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[size++] = newEmployee;
        return true;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i].getId() == id) {
                System.out.println(employees[i].getId() + " " + employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }

        }
    }

    public void findEmployeeById(int id) {
    boolean flag = false;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getId() == id) {
                System.out.println("Сотрудник найден: " + employee.getId() + " " + employee.getFullName());
            flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Сотрудник не найден");
        }
    }

    public void printAllEmployeesData() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public double calculateTotalSalaryExpenses() {
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }

    public Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        double minSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        double maxSalary = employees[0].getSalary();
        for (Employee emp : employees) {
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }


    public double calculateAverageSalary() {
        double totalSalary = calculateTotalSalaryExpenses();
        int count = employees.length;
        if (count == 0) {
            return 0;
        }
        return totalSalary / count;
    }

    public void printFullNamesOfEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp.getFullName());
        }
    }

    public void changeAllSalary(double percent) {
        for (Employee emp : employees) {
            double currentSalary = emp.getSalary();
            double changedSalary = currentSalary * percent / 100 + currentSalary;
            emp.setSalary(changedSalary);
        }

    }

    public double calculateTotalSalaryExpensesInDepartment(int department) {
        double totalSalary = 0;
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                totalSalary += emp.getSalary();
            }

        }
        return totalSalary;
    }

    public Employee findMinSalaryEmployeeInDepartment(int department) {
        Employee minSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee emp : employees) {
            if (emp.getDepartment() == department && emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee maxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee emp : employees) {
            if (emp.getDepartment() == department && emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        double totalSalary = 0;
        int count = 0;

        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                totalSalary += emp.getSalary();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return totalSalary / count;
    }

    public void changeAllSalaryInDepartment(double percent, int department) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                double changedSalary = emp.getSalary() * (1 + percent / 100);
                emp.setSalary(changedSalary);
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        for (Employee emp : employees) {
            if (emp.getDepartment() == department) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " +
                        emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryBelow(double threshold) {
        for (Employee emp : employees) {
            if (emp.getSalary() < threshold) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " + emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryAbove(double threshold) {
        for (Employee emp : employees) {
            if (emp.getSalary() >= threshold) {
                System.out.println("ID: " + emp.getId() + ", Full Name: " + emp.getFullName() + ", Salary: " + emp.getSalary());
            }
        }
    }
}
