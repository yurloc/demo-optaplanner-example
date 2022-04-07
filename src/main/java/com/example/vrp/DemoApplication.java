package com.example.vrp;

import java.util.Arrays;

import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import org.optaplanner.core.api.solver.SolverFactory;
import com.example.vrp.domain.Customer;
import com.example.vrp.domain.Depot;
import com.example.vrp.domain.Vehicle;
import com.example.vrp.domain.VehicleRoutingSolution;
import com.example.vrp.domain.location.AirLocation;
import com.example.vrp.domain.location.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private final Location location1 = new AirLocation(1L, 0.0, 0.0);
    private final Location location2 = new AirLocation(2L, 0.0, 4.0);
    private final Location location3 = new AirLocation(3L, 3.0, 0.0);

    private final SolverFactory<VehicleRoutingSolution> solverFactory;

    public DemoApplication(SolverFactory<VehicleRoutingSolution> solverFactory) {
        this.solverFactory = solverFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Depot depot = new Depot(1L, location1);
            Vehicle vehicleA = new Vehicle(1L, 100, depot);
            Customer customer1 = new Customer(2L, location2, 80);
            // customer1.setPreviousStandstill(vehicleA);
            // customer1.setVehicle(vehicleA);
            // vehicleA.setNextCustomer(customer1);
            Customer customer2 = new Customer(3L, location3, 40);
            // customer2.setPreviousStandstill(customer1);
            // customer2.setVehicle(vehicleA);
            // customer1.setNextCustomer(customer2);

            VehicleRoutingSolution probblem = new VehicleRoutingSolution();
            probblem.setCustomerList(Arrays.asList(customer1, customer2));
            probblem.setDepotList(Arrays.asList(depot));
            probblem.setVehicleList(Arrays.asList(vehicleA));
            probblem.setLocationList(Arrays.asList(location1, location2, location3));

            HardSoftLongScore score1 = ScoreManager.<VehicleRoutingSolution, HardSoftLongScore>create(solverFactory).updateScore(probblem);
            logger.info("Problem score (before solving): {}", score1);

            VehicleRoutingSolution solution = solverFactory.buildSolver().solve(probblem);

            HardSoftLongScore score2 = ScoreManager.<VehicleRoutingSolution, HardSoftLongScore>create(solverFactory).updateScore(solution);
            logger.info("Solution score (after solving): {}", score2);
        };
    }

}
