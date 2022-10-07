package appPackage.services.implementations;

import appPackage.data.Computer;
import appPackage.repositories.ComputerRepository;
import appPackage.services.interfaces.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    private ComputerRepository computerRepository;

    public ComputerServiceImpl() {
    }

    @Autowired
    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void createComputer(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public Computer getComputerBySerialNumber(String serialNumber) {
        return computerRepository.getOne(serialNumber);
    }


    @Override
    public List<Computer> getAllBrokenComputers() {
        return computerRepository.findByNeedsReparationTrue();
    }


    @Override
    public List<Computer> getAllWorkingComputers() {
        return computerRepository.findByNeedsReparationTrue();
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }
}
