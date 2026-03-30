public class TestEmployee {
    public static void printPay(Employee emp) {
        System.out.println(emp.getName() + "'s salary: " + emp.pay());
    }

    public static void main(String[] args) {
        MonthlyEmployee me = new MonthlyEmployee("John Monthly", 5000);
        HourlyEmployee he = new HourlyEmployee("Jane Hourly", 20, 160);
        Manager manager = new Manager("Boss Manager", 8000);
        manager.setBonus(2000);

        printPay(me);
        printPay(he);
        printPay(manager);
    }
}



