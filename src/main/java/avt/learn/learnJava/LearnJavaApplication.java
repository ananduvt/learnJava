package avt.learn.learnJava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import avt.learn.learnJava.service.SolutionExecutionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LearnJavaApplication implements CommandLineRunner {

	private final  SolutionExecutionService solutionExecutionService;;
	
	public LearnJavaApplication(SolutionExecutionService solutionExecutionService) {
		this.solutionExecutionService = solutionExecutionService;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(LearnJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Let's Learn Java");
		solutionExecutionService.invokeJavaProblems("avt.learn.learnJava");
	}

}
