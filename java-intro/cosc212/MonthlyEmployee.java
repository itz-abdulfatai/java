package cosc212;

public class MonthlyEmployee extends Employee {
    private double payRate;

    public MonthlyEmployee(int id, String name, double payRate) {
        super(id, name);
        this.payRate = payRate;
    }

    @Override
    public double getPay() {
        return 0;
    }

}
