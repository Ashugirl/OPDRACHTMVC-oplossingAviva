package appPackage.services.implementations;

import appPackage.data.Computer;
import appPackage.data.LoanReceipt;
import appPackage.data.Student;
import appPackage.repositories.ComputerRepository;
import appPackage.repositories.ComputerRepositoryImpl;
import appPackage.repositories.LoanReceiptRepository;
import appPackage.repositories.StudentRepository;
import appPackage.services.interfaces.LoanReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanReceiptImpl implements LoanReceiptService {

    private LoanReceiptRepository loanReceiptRepository;
    private ComputerRepository computerRepository;
    private StudentRepository studentRepository;

    public LoanReceiptImpl() {
    }

    @Autowired
    public LoanReceiptImpl(LoanReceiptRepository loanReceiptRepository, ComputerRepository computerRepository, StudentRepository studentRepository) {
        this.loanReceiptRepository = loanReceiptRepository;
        this.computerRepository = computerRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<LoanReceipt> getAllReceipts() {
        return loanReceiptRepository.findAll();
    }

    @Override
    public List<LoanReceipt> getAllOpenReceipts() {

        return loanReceiptRepository.findByEndDateIsNull();
    }

    //Make this method return every receipt that has no end Date, that has been open for more than 9 months
    //Example1: A computer has been lend out the 28/10/2020 and not yet returned. It's been over 9 months. This needs to be on the list
    //Example2: A computer has been loaned on 11/07/2022 and not yet returned. It's only been 2 months, this should not be on the list
    @Override
    public List<LoanReceipt> getAllOpenReceiptsLongerThan9Months() {
        LocalDate today = LocalDate.now();
        List<LoanReceipt> allReceipts = getAllOpenReceipts();
        List<LoanReceipt> overdueReceipts = new ArrayList<>();
        for (LoanReceipt receipt : allReceipts) {
            if (receipt.getStartDate().plus(9, ChronoUnit.MONTHS).isBefore(today)) {
                overdueReceipts.add(receipt);
            }

        }
            return overdueReceipts;
        }

    //make a Method that lends a computer to a student. Make sure that the student is not blacklisted
    //, that the student doesn't already own a computer and that the PC is not already in use.
    // If it was succesful, the method returns true. When lending, startDate is today
    @Override
    public boolean loanComputerToStudent(Computer computer, Student student) {
        computer = computerRepository.getOne(computer.getSerialNumber()) ;
        student = studentRepository.getOne(student.getUserName());
        System.out.println(student.isOnBlackList() + " " + isPcInUse(computer) + " " +checkIfStudentCurrentlyOwnsPC(student));
        if((!student.isOnBlackList()) && isPcInUse(computer) == false && checkIfStudentCurrentlyOwnsPC(student) == null){
            LoanReceipt loanReceipt = new LoanReceipt(LocalDate.now(), student, computer);
            loanReceiptRepository.save(loanReceipt);
            System.out.println(loanReceipt.getStartDate() + " " + loanReceipt.getLoanedTo() + " " + loanReceipt.getLoanedComputer());
            return true;
        }else{
            System.out.println("no computer loaned");
        return false;}
     }


    @Override
    public boolean isPcInUse(Computer computer) {
        LoanReceipt foundReceipt = loanReceiptRepository.findByComputerAndEndDateIsNull(computer);
        if (foundReceipt!=null){
            return true;
        }
        return false;
    }

    @Override
    public Computer checkIfStudentCurrentlyOwnsPC(Student student) {
        LoanReceipt foundReceipt = loanReceiptRepository.findByStudentAndEndDateIsNull(student);
        if (foundReceipt != null){
            return foundReceipt.getLoanedComputer();
        }
        return null;
    }
}
