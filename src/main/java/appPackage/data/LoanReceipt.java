package appPackage.data;




import java.time.LocalDate;


public class LoanReceipt {


    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Student loanedTo;
    private Computer loanedComputer;

    public LoanReceipt() {
    }

    public LoanReceipt(LocalDate startDate, Student loanedTo, Computer loanedComputer) {
        this.startDate = startDate;
        this.loanedTo = loanedTo;
        this.loanedComputer = loanedComputer;
    }

    public LoanReceipt(LocalDate startDate, LocalDate endDate, Student loanedTo, Computer loanedComputer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanedTo = loanedTo;
        this.loanedComputer = loanedComputer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Student getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(Student loanedTo) {
        this.loanedTo = loanedTo;
    }

    public Computer getLoanedComputer() {
        return loanedComputer;
    }

    public void setLoanedComputer(Computer loanedComputer) {
        this.loanedComputer = loanedComputer;
    }
}
