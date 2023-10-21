package dat250.votingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ProperVotingApplication {

    public static void main(String[] args){
            SpringApplication.run(ProperVotingApplication.class, args);
    }
}
