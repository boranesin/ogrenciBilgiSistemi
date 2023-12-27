import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Öğretmenler ve derslerin oluşturulması
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Tarih", "101", "TRH", 0.2, new Teacher("Mahmut Hoca", "TRH", "555")));
        courses.add(new Course("Fizik", "102", "FZK", 0.2, new Teacher("Graham", "FZK", "542")));
        courses.add(new Course("Biyoloji", "103", "BIO", 0.2, new Teacher("Külyutmaz", "BIO", "532")));

        // Öğrencilerin oluşturulması
        Student s1 = new Student("İnek Şaban", "123", "4", courses.get(0), courses.get(1), courses.get(2));
        Student s2 = new Student("Güdük Necmi", "444", "4", courses.get(0), courses.get(1), courses.get(2));

        // Not giriş işlemleri
        System.out.println("Notlar 0 ile 100 arasında olmalıdır.");
        enterGradesForStudent(scanner, s1);
        s1.isPass();

        enterGradesForStudent(scanner, s2);
        s2.isPass();

        scanner.close(); // Scanner'ı kapat
    }

    private static void enterGradesForStudent(Scanner scanner, Student student) {
        Course[] courses = {student.course1, student.course2, student.course3};

        for (Course course : courses) {
            System.out.println(student.name + " için " + course.name + " dersi yazılı notunu giriniz:");
            int yazili = getValidGrade(scanner);

            System.out.println(student.name + " için " + course.name + " dersi sözlü notunu giriniz:");
            int sozlu = getValidGrade(scanner);

            course.note = yazili;
            course.oralExamNote = sozlu;
        }
    }

    private static int getValidGrade(Scanner scanner) {
        while (true) {
            try {
                int grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    return grade;
                } else {
                    System.out.println("Geçersiz not! Lütfen 0 ile 100 arasında bir değer giriniz:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı giriniz:");
                scanner.next(); // Geçersiz girişi atla
            }
        }
    }
}
