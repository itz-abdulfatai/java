public class MonthlyEmployee extends Employee {
    private double salary;

    public MonthlyEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double pay() {
        return salary;
    }
}
