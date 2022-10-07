package appPackage.repositories;

import appPackage.data.Computer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ComputerRepositoryImpl implements ComputerRepository{
    @Override
    public List<Computer> findByNeedsReparationTrue() {
        List<Computer> brokenComputers = new ArrayList<>();
        for(Computer computer: SpoofDataBase.getComputers()){
            if (computer.isNeedsReparation()){
                brokenComputers.add(computer);
            }
        }

        return brokenComputers;
    }

    @Override
    public List<Computer> findByNeedsReparationFalse() {
        List<Computer> goodComputers = new ArrayList<>();
        for(Computer computer: SpoofDataBase.getComputers()){
            if (!computer.isNeedsReparation()){
                goodComputers.add(computer);
            }
        }

        return goodComputers;
    }

    @Override
    public Computer getOne(String serialNumber) {
        for (Computer computer: SpoofDataBase.getComputers()){
            if (computer.getSerialNumber().equals(serialNumber)){
                return computer;
            }
        }

        return null;
    }

    @Override
    public List<Computer> findAll() {
        return SpoofDataBase.getComputers();
    }

    @Override
    public Computer save(Computer computer) {
        SpoofDataBase.getComputers().add(computer);
        return computer;
    }
}
