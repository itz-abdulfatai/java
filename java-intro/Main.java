// static inner
// class Outer {
// static int outerStatic = 10;
// int outerInstance = 20;

// static class StaticNested {
// void display() {
// System.out.println("Outer static: " + outerStatic);
// // System.out.println(outerInstance); // ❌ Not allowed
// }
// }
// }

// public class New {
// public static void main(String[] args) {
// Outer.StaticNested nested = new Outer.StaticNested();
// nested.display();
// }
// }

// member

// class Outer {
// int outerInstance = 30;

// class Inner {
// void display() {
// System.out.println("Outer instance: " + outerInstance);
// }
// }
// }

// public class Main {
// public static void main(String[] args) {
// Outer outer = new Outer();
// Outer.Inner inner = outer.new Inner(); // 👈 needs outer object
// inner.display();
// }
// }

// Local Inner Class

// class Outer {
// void showMessage() {
// final String msg = "Hello from Local Inner Class!";

// class LocalInner {
// void display() {
// System.out.println(msg);
// }
// }

// LocalInner inner = new LocalInner();
// inner.display();
// }
// }

// public class Main {
// public static void main(String[] args) {
// new Outer().showMessage();
// }
// }

// anonymous inner class

// interface Greeting {
// void sayHello();
// }

// public class Main {
// public static void main(String[] args) {
// Greeting g = new Greeting() { // 👈 Anonymous inner class
// public void sayHello() {
// System.out.println("Hello from Anonymous Inner Class!");
// }
// };

// g.sayHello();
// }
// }
