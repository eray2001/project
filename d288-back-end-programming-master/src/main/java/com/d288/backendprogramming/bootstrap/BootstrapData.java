package com.d288.backendprogramming.bootstrap;

import com.d288.backendprogramming.dao.CustomerRepo;
import com.d288.backendprogramming.dao.DivisionRepo;
import com.d288.backendprogramming.entities.Customer;
import com.d288.backendprogramming.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepo customerRepo;
    private final DivisionRepo divisionRepo;

    public BootstrapData(CustomerRepo customerRepo, DivisionRepo divisionRepo) {
        this.customerRepo = customerRepo;
        this.divisionRepo = divisionRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer bill = new Customer();
        bill.setAddress("435 street");
        bill.setFirstName("Bill");
        bill.setLastName("Bob");
        bill.setPhone("(453)435-5674");
        bill.setPostal_code("15645");

        Division newHampshire = divisionRepo.findById(28L).orElse(null);
        bill.setDivision(newHampshire);
        customerRepo.save(bill);
        divisionRepo.save(newHampshire);


        Customer sal = new Customer();
        sal.setAddress("465 street");
        sal.setFirstName("Sal");
        sal.setLastName("Fisher");
        sal.setPhone("(453)935-5672");
        sal.setPostal_code("49378");

        Division california = divisionRepo.findById(04L).orElse(null);
        sal.setDivision(california);
        customerRepo.save(sal);
        divisionRepo.save(california);

        Customer tim = new Customer();
        tim.setAddress("735 street");
        tim.setFirstName("Tim");
        tim.setLastName("Means");
        tim.setPhone("(453)438-5674");
        tim.setPostal_code("72346");

        Division quebec = divisionRepo.findById(68L).orElse(null);
        tim.setDivision(quebec);
        customerRepo.save(tim);
        divisionRepo.save(quebec);

        Customer cris = new Customer();
        cris.setAddress("2645 street");
        cris.setFirstName("Cris");
        cris.setLastName("Cross");
        cris.setPhone("(328)435-4639");
        cris.setPostal_code("13894");

        Division nunavut = divisionRepo.findById(70L).orElse(null);
        cris.setDivision(nunavut);
        customerRepo.save(cris);
        divisionRepo.save(nunavut);

        Customer evan = new Customer();
        evan.setAddress("94 street");
        evan.setFirstName("Evan");
        evan.setLastName("Crow");
        evan.setPhone("(137)435-3156");
        evan.setPostal_code("23148");

        Division montana = divisionRepo.findById(25L).orElse(null);
        evan.setDivision(montana);
        customerRepo.save(evan);
        divisionRepo.save(montana);

    }
}
