import packages.Shape;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double pay() {
        return hourlyRate * hoursWorked;
    }

    packages.Shape shape = new packages.Shape() {
        @Override
        public double area() {
            return 0;
        }

        @Override
        public double perimeter() {
            return 0;
        }
    };
    Shape shape2 = new Shape() {
        @Override
        public double area() {
            return 0;
        }

        @Override
        public double perimeter() {
            return 0;
        }
    };

}
