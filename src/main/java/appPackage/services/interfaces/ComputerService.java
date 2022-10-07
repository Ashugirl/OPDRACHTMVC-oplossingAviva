package appPackage.services.interfaces;

import appPackage.data.Computer;

import java.util.List;

public interface ComputerService {

    void createComputer(Computer computer);
    Computer getComputerBySerialNumber(String serialNumber);
    List<Computer> getAllBrokenComputers();
    List<Computer> getAllWorkingComputers();
    List<Computer> getAllComputers();

}
