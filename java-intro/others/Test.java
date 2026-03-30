package others;

public class Test {
    public static void main(String[] args) {

        // if (1 < 5) {

        // System.out.println("is highr");
        // }

        // id - int , name - string , gp - double
        // define constructor of d student class
        // define a method getGpa
        // define method that prints full student details
        // create student object based on the class and print details

        Student abdul = new Student(45, "abdul", 5);
        System.out.println(abdul.getGpa());
        abdul.print();

    }

}

class Student {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void print() {
        System.out.println("name is: " + name + ", " + "gpa is: " + gpa + ", id is: " + id);
    }

}

// ()
// {}
