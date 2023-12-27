public class Student {
    String name;
    String stuNo;
    String classes;
    Course course1;
    Course course2;
    Course course3;
    double average;
    boolean isPass;

    public Student(String name, String stuNo, String classes, Course c1, Course c2, Course c3) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.course1 = c1;
        this.course2 = c2;
        this.course3 = c3;
        this.average = 0.0;
        this.isPass = false;
    }

    public void isPass() {
        this.calcAverage();
        if (this.average > 55) {
            System.out.println(this.name + " geçti. Ortalama: " + this.average);
            this.isPass = true;
        } else {
            System.out.println(this.name + " kaldı. Ortalama: " + this.average);
            this.isPass = false;
        }
    }

    private void calcAverage() {
        double total = 0;
        total += (this.course1.note * (1 - this.course1.oralExamWeight)) + (this.course1.oralExamNote * this.course1.oralExamWeight);
        total += (this.course2.note * (1 - this.course2.oralExamWeight)) + (this.course2.oralExamNote * this.course2.oralExamWeight);
        total += (this.course3.note * (1 - this.course3.oralExamWeight)) + (this.course3.oralExamNote * this.course3.oralExamWeight);
        this.average = total / 3;
    }
}
