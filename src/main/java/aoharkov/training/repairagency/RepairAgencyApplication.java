package aoharkov.training.repairagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepairAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairAgencyApplication.class, args);
/*        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("alex@gmail.com"));
        System.out.println(passwordEncoder.encode("anatolii@gmail.com"));
        System.out.println(passwordEncoder.encode("artem@gmail.com"));
        System.out.println(passwordEncoder.encode("bohdan@gmail.com"));
        System.out.println(passwordEncoder.encode("dmytro.p@gmail.com"));
        System.out.println(passwordEncoder.encode("dmytro@gmail.com"));*/
    }

}
