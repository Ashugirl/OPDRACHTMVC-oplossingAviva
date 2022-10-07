package appPackage.services.interfaces;

import appPackage.data.Computer;
import appPackage.data.LoanReceipt;
import appPackage.data.Student;

import java.util.List;

public interface LoanReceiptService {

    List<LoanReceipt> getAllReceipts();
    List<LoanReceipt> getAllOpenReceipts();
    List<LoanReceipt> getAllOpenReceiptsLongerThan9Months();
    boolean loanComputerToStudent(Computer computer, Student student);
    boolean isPcInUse(Computer computer);
    Computer checkIfStudentCurrentlyOwnsPC(Student student);

}
