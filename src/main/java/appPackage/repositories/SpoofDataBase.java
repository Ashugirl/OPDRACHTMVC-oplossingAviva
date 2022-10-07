package appPackage.repositories;

import appPackage.data.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpoofDataBase {


    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List <LoanReceipt> loanReceipts = new ArrayList<>();
    private static List <Computer> computers = new ArrayList<>();



    public SpoofDataBase() {
        Course java = new Course("Java");
        Course cSharp = new Course("C#");
        Student java1 = new Student("PearlDS","password123","Pearl","De Smet",false,java);
        Student cSharp1= new Student("QuintenDC","password123","Quinten","De Clerc",false,cSharp);
        Student java2 = new Student("ManuelC","password123","Manuel","Cogneau",true,java);
        Student cSharp2 = new Student("KenanK","password123","Kenan","Kurda",true,cSharp);
        students.add(java1);students.add(cSharp1);students.add(java2);students.add(cSharp2);
        List<Student> onlyJavaStudents = new ArrayList<>();
        onlyJavaStudents.add(java1);onlyJavaStudents.add(java2);
        List<Student> onlyCSharpStudents = new ArrayList<>();
        onlyCSharpStudents.add(cSharp1);onlyCSharpStudents.add(cSharp2);
        java.setStudentList(onlyJavaStudents);
        cSharp.setStudentList(onlyCSharpStudents);
        courses.add(java);courses.add(cSharp);
        Computer computer = new Computer("198765", Brand.APPLE, "no comment", false);
        Computer computer2 = new Computer("185765", Brand.DELL, "no comment", false);
        Computer computer3 = new Computer("1985675", Brand.SAMSUNG, "ManuelC returned it broken, spilled water over it", true);
        Computer computer4 = new Computer("102134", Brand.TOSHIBA, "no comment", false);
        Computer computer5 = new Computer("365425", Brand.APPLE, "It's too old, needs replacement", true);
        Computer computer6 = new Computer("43871982", Brand.TOSHIBA, "Is still loaned out by Kenan after 9 months, Kenan hasn't brought it back yet.", false);
        computers.add(computer);computers.add(computer2);computers.add(computer3);computers.add(computer4);computers.add(computer5);computers.add(computer6);
        LoanReceipt loanReceipt = new LoanReceipt(LocalDate.of(2022,5,30),cSharp1,computer2); loanReceipt.setId(1L);
        LoanReceipt loanReceipt1 = new LoanReceipt(LocalDate.of(2021,3,18),LocalDate.of(2021,9,2),cSharp2,computer2); loanReceipt1.setId(2L);
        LoanReceipt loanReceipt2 = new LoanReceipt(LocalDate.of(2022,7,22),java1,computer); loanReceipt2.setId(3L);
        LoanReceipt loanReceipt3 = new LoanReceipt(LocalDate.of(2019,8,18),LocalDate.of(2020,3,2),java2,computer3); loanReceipt3.setId(4L);
        LoanReceipt loanReceipt4 = new LoanReceipt(LocalDate.of(2021,11,5),cSharp2,computer6); loanReceipt4.setId(5L);
        loanReceipts.add(loanReceipt);loanReceipts.add(loanReceipt1);loanReceipts.add(loanReceipt2);loanReceipts.add(loanReceipt3);loanReceipts.add(loanReceipt4);
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static void setCourses(List<Course> courses) {
        SpoofDataBase.courses = courses;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        SpoofDataBase.students = students;
    }

    public static List<LoanReceipt> getLoanReceipts() {
        return loanReceipts;
    }

    public static void setLoanReceipts(List<LoanReceipt> loanReceipts) {
        SpoofDataBase.loanReceipts = loanReceipts;
    }

    public static List<Computer> getComputers() {
        return computers;
    }

    public static void setComputers(List<Computer> computers) {
        SpoofDataBase.computers = computers;
    }
}
