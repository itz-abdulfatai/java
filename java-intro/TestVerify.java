public class TestVerify {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.greet(); // This should throw error at runtime!
    }
}
