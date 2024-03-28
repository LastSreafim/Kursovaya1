public class Main {
    static EmployeeBook employeeBook = new EmployeeBook();
    public static void main(String[] args) {

        employeeBook.addEmployee("Иван Иванов", 1, 60_000);
        employeeBook.addEmployee("Сергей Сергеев", 2, 55_000);
        employeeBook.addEmployee("Семён Семёнов", 1, 78_0);
        employeeBook.addEmployee("Василий Васильев", 3, 110_000);
        employeeBook.addEmployee("Михаил Михаилов", 5, 260_000);
        employeeBook.addEmployee("Денис Денисов", 4, 62_000);
        employeeBook.addEmployee("Назар Назаров", 3, 66_500);
        employeeBook.addEmployee("Игорь Игорев", 2, 111_111);
        employeeBook.addEmployee("Владимир Владимиров", 5, 125_512);
        employeeBook.addEmployee("Мария Мариева", 4, 320_000);


        employeeBook.removeEmployee(4);
        employeeBook.printAllEmployeesData();
        employeeBook.addEmployee("Сулейман Хан", 3, 400_000);
        employeeBook.printAllEmployeesData();
        System.out.println("Общая затрата на зарпалту: " + employeeBook.calculateTotalSalaryExpenses());
        System.out.println("Средняя зарплата среди работников: " + employeeBook.calculateAverageSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.findEmployeeWithMaxSalary());
        employeeBook.printFullNamesOfEmployees();
        employeeBook.changeAllSalary(4);
        employeeBook.printAllEmployeesData();
        System.out.println("Общая зарплата среди работников отдела: " + employeeBook.calculateTotalSalaryExpensesInDepartment(1));
        System.out.println("Средняя зарплата среди работников отдела: " + employeeBook.calculateAverageSalaryInDepartment(5));
        System.out.println("Сотрудник с минимальной зарплатой по отделу: " + employeeBook.findMinSalaryEmployeeInDepartment(2));
        System.out.println("Сотрудник с минимальной зарплатой по отделу: " + employeeBook.findEmployeeWithMaxSalaryInDepartment(3));
        employeeBook.changeAllSalaryInDepartment(4,4);
        employeeBook.printEmployeesInDepartment(2);
        System.out.println("Все сотрудники с зарплатой выше 100_000: ");
        employeeBook.printEmployeesWithSalaryAbove(100_000);
        System.out.println("Все сотрудники с зарплатой ниже 100_000: ");
        employeeBook.printEmployeesWithSalaryBelow(100_000);
        employeeBook.findEmployeeById(11);

    }

}

