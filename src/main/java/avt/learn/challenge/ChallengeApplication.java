package avt.learn.challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import avt.learn.challenge.service.SolutionExecutionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	private final  SolutionExecutionService solutionExecutionService;;
	
	public ChallengeApplication(SolutionExecutionService solutionExecutionService) {
		this.solutionExecutionService = solutionExecutionService;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Let's Learn Java");
		solutionExecutionService.invokeJavaProblems("avt.learn.challenge.problems");
	}

}
