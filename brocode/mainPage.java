public class mainPage {
    public static void main(String[] args) {
        Car car = new Car();
        Vehicle secondVehicle = new Car();

        Vehicle[] cars = { car, secondVehicle };

        System.out.println(car);
        System.out.println(secondVehicle);

    }

}
