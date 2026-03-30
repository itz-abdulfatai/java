package others;

public class Student {
    public static void main(String[] a) {
        // System.out.println("Hello, World!");
        String name = "albert";

        Students student1 = new Students(name, 20);
        System.out.println(student1);
    }

}

class Students {

    String name;
    int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student Name: " + name + ", Age: " + age;
    }

    int[] b = new int[1];

}