package packages;

class Defaults {
    static int staticNum;
    int instanceNum;
}

public class DefaultValues {
    public static void main(String[] args) {
        System.out.println("Static: " + Defaults.staticNum); // 0 (default)

        Defaults d = new Defaults();
        System.out.println("Instance: " + d.instanceNum); // 0 (default)
    }
}
