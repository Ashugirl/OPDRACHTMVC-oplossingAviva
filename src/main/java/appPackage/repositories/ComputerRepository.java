package appPackage.repositories;

import appPackage.data.Computer;

import java.util.List;


public interface ComputerRepository {

    List<Computer> findByNeedsReparationTrue();
    List<Computer> findByNeedsReparationFalse();
    Computer getOne(String serialNumber);
    List<Computer> findAll();
    Computer save(Computer computer);

}
