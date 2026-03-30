package others;

public class TestPersons {

    // ===== Person Class =====
    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person: " + name;
        }
    }

    // ===== Employee Class =====
    static class Employee extends Person {
        private String ID;
        private double payRate;

        public Employee(String name, String ID, double payRate) {
            super(name);
            this.ID = ID;
            this.payRate = payRate;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public double getPayRate() {
            return payRate;
        }

        public void setPayRate(double payRate) {
            this.payRate = payRate;
        }

        public double pay() {
            return payRate;
        }

        public String toString() {
            return "Employee: " + getName() + ", ID: " + ID + ", Pay Rate: " + payRate;
        }
    }

    // ===== Course Class =====
    static class Course {
        private String courseCode;
        private String courseTitle;

        public Course(String courseCode, String courseTitle) {
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public String toString() {
            return courseCode + " - " + courseTitle;
        }
    }

    // ===== Faculty Class =====
    static class Faculty extends Employee {
        private String officeHours;
        private Course[] teachingCourses;

        public Faculty(String name, String ID, double payRate, String officeHours, Course[] teachingCourses) {
            super(name, ID, payRate);
            this.officeHours = officeHours;
            this.teachingCourses = teachingCourses;
        }

        public String getOfficeHours() {
            return officeHours;
        }

        public void setOfficeHours(String officeHours) {
            this.officeHours = officeHours;
        }

        public Course[] getTeachingCourses() {
            return teachingCourses;
        }

        public void setTeachingCourses(Course[] teachingCourses) {
            this.teachingCourses = teachingCourses;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Faculty: ").append(getName())
                    .append(", ID: ").append(getID())
                    .append(", Pay Rate: ").append(getPayRate())
                    .append(", Office Hours: ").append(officeHours)
                    .append(", Courses:");

            for (Course c : teachingCourses) {
                sb.append("\n    ").append(c);
            }

            return sb.toString();
        }
    }

    // ===== printPerson method =====
    public static void printPerson(Person p) {
        System.out.println(p);
    }

    // ===== main method =====
    public static void main(String[] args) {
        Person person = new Person("Abdul Aliyu");
        Employee employee = new Employee("John Doe", "EMP001", 5000.0);

        Course[] courses = {
                new Course("CSC101", "Intro to CS"),
                new Course("CSC201", "Data Structures")
        };

        Faculty faculty = new Faculty("Dr. Sarah", "FAC123", 12000.0, "9am - 3pm", courses);

        printPerson(person);
        printPerson(employee);
        printPerson(faculty);
    }
}
