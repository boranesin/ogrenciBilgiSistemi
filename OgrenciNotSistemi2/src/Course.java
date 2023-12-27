public class Course {
    String name;
    String code;
    String prefix;
    double note;
    double oralExamNote;
    double oralExamWeight; // Sözlü notun ağırlığı
    Teacher teacher;

    public Course(String name, String code, String prefix, double oralExamWeight, Teacher teacher) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.oralExamWeight = oralExamWeight; // Sözlü not ağırlığını ayarlayın
        this.teacher = teacher;
        this.note = 0;
        this.oralExamNote = 0;
    }
}
