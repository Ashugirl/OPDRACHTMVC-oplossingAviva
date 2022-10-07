package appPackage.data;


import java.util.List;


public class Student {


    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private boolean isOnBlackList;

    private List<LoanReceipt> computersTheyLoaned;

    private Course course;

    public Student() {

    }

    public Student(String userName, String passWord, String firstName, String lastName, boolean isOnBlackList, Course course) {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOnBlackList = isOnBlackList;
        this.course = course;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isOnBlackList() {
        return isOnBlackList;
    }

    public void setOnBlackList(boolean onBlackList) {
        isOnBlackList = onBlackList;
    }

    public List<LoanReceipt> getComputersTheyLoaned() {
        return computersTheyLoaned;
    }

    public void setComputersTheyLoaned(List<LoanReceipt> computersTheyLoaned) {
        this.computersTheyLoaned = computersTheyLoaned;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isOnBlackList=" + isOnBlackList +
                ", computersTheyLoaned=" + computersTheyLoaned +
                '}';
    }
}
