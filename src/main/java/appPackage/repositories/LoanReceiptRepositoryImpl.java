package appPackage.repositories;

import appPackage.data.Computer;
import appPackage.data.LoanReceipt;
import appPackage.data.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanReceiptRepositoryImpl implements LoanReceiptRepository{


    @Override
    public LoanReceipt findByComputerAndEndDateIsNull(Computer computer) {

        for (LoanReceipt loanReceipt: SpoofDataBase.getLoanReceipts()){
            if (loanReceipt.getLoanedComputer().getSerialNumber().equals(computer.getSerialNumber())&&loanReceipt.getEndDate()==null){
                return loanReceipt;
            }
        }

        return null;
    }

    @Override
    public LoanReceipt findByStudentAndEndDateIsNull(Student student) {
        for (LoanReceipt loanReceipt: SpoofDataBase.getLoanReceipts()){
            if (loanReceipt.getLoanedTo().getUserName().equals(student.getUserName())&&loanReceipt.getEndDate()==null){
                return loanReceipt;
            }
        }
        return null;
    }

    @Override
    public List<LoanReceipt> findByEndDateIsNull() {
        List<LoanReceipt> computersThatNeedToBeReturned= new ArrayList<>();
        for (LoanReceipt loanReceipt: SpoofDataBase.getLoanReceipts()){
            if (loanReceipt.getEndDate()==null){
                computersThatNeedToBeReturned.add(loanReceipt);
            }
        }
        return computersThatNeedToBeReturned;
    }

    @Override
    public List<LoanReceipt> findAll() {
        return SpoofDataBase.getLoanReceipts();
    }

    @Override
    public LoanReceipt getOne(Long id) {
        for (LoanReceipt loanReceipt: SpoofDataBase.getLoanReceipts()){
            if (loanReceipt.getId().equals(id)){
                return loanReceipt;
            }
        }
        return null;
    }

    @Override
    public LoanReceipt save(LoanReceipt loanReceipt) {
        Long newId= SpoofDataBase.getLoanReceipts().get(SpoofDataBase.getLoanReceipts().size()-1).getId();
        loanReceipt.setId(++newId);
        SpoofDataBase.getLoanReceipts().add(loanReceipt);

        return loanReceipt;
    }
}
