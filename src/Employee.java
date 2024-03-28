import java.util.Objects;

public class Employee {
    private static int counter = 1;
    private final int id;
    private final String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = counter;
        counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, salary);
    }

    @Override
    public String toString() {
        return " id: " + id +
                " ФИО: " + fullName +
                " Отдел № " + department +
                " Зарплата: " + salary;


    }
}
