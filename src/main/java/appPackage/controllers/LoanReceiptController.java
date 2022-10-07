package appPackage.controllers;

import appPackage.data.Computer;
import appPackage.data.LoanReceipt;
import appPackage.data.Student;
import appPackage.services.interfaces.ComputerService;
import appPackage.services.interfaces.LoanReceiptService;
import appPackage.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoanReceiptController {

    private LoanReceiptService loanReceiptService;
    private StudentService studentService;
    private ComputerService computerService;
    private List<LoanReceipt> loansYouWantToSee;

    @Autowired
    public LoanReceiptController(LoanReceiptService loanReceiptService, StudentService studentService, ComputerService computerService) {
        this.loanReceiptService = loanReceiptService;
        this.studentService = studentService;
        this.computerService = computerService;
    }


    @GetMapping("allLoans")
    public String getAll(Model model){
        loansYouWantToSee = loanReceiptService.getAllReceipts();
        return "redirect:MakeALoan";
    }

    @GetMapping("allOpen")
    public String getAllThatAreOpen(Model model){
        loansYouWantToSee =  loanReceiptService.getAllOpenReceipts();
        return "redirect:MakeALoan";
    }

    @GetMapping("TooLateReturned")
    public String getAllThatAreOpenfor9Months(Model model){
        loansYouWantToSee =  loanReceiptService.getAllOpenReceiptsLongerThan9Months();
        return "redirect:MakeALoan";
    }

    @GetMapping("MakeALoan")
    public String MakeALoan(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("computers", computerService.getAllWorkingComputers());
        if(loansYouWantToSee==null){
            loansYouWantToSee = loanReceiptService.getAllReceipts();
        }
        model.addAttribute("currentOpenLoans", loansYouWantToSee);
        model.addAttribute("loanReceipt",new LoanReceipt());
        return "loans";
    }

    @PostMapping("MakeALoan")
    public String MakeALoan(LoanReceipt loanReceipt){
        Computer computer = computerService.getComputerBySerialNumber(loanReceipt.getLoanedComputer().getSerialNumber());
        Student student = studentService.getStudentByUsername(loanReceipt.getLoanedTo().getUserName());

        loanReceiptService.loanComputerToStudent(computer, student);

        return "redirect:MakeALoan";
    }
}
