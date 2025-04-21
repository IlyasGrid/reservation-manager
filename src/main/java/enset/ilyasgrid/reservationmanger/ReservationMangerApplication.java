package enset.ilyasgrid.reservationmanger;

import enset.ilyasgrid.reservationmanger.entities.Entreprise;
import enset.ilyasgrid.reservationmanger.repository.EntrepriseRepository;
import enset.ilyasgrid.reservationmanger.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationMangerApplication implements CommandLineRunner {

    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReservationMangerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Entreprises
        Entreprise entreprise1 = new Entreprise();
        entreprise1.setName("Tech Innov");
        entreprise1.setEmail("contact@techinnov.com");
        entreprise1.setActivity("Informatique");
        entreprise1.setUsername("tech123");

        Entreprise entreprise2 = new Entreprise();
        entreprise2.setName("Eco Solutions");
        entreprise2.setEmail("info@ecosolutions.org");
        entreprise2.setActivity("Écologie");
        entreprise2.setUsername("ecoUser");

        // Save Entreprises to DB
        entrepriseRepository.save(entreprise1);
        entrepriseRepository.save(entreprise2);

        System.out.println("Entreprises saved:");

    }


}
