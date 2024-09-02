package avt.learn.challenge;

import avt.learn.challenge.base.Solution;
import avt.learn.challenge.service.SolutionExecutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication

public class ChallengesRunner implements CommandLineRunner {

    private final SolutionExecutionService solutionExecutionService;

    public ChallengesRunner(SolutionExecutionService solutionExecutionService) {
        this.solutionExecutionService = solutionExecutionService;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ChallengesRunner.class).web(WebApplicationType.NONE).build().run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Executing all available Java Challenge Problems");
        solutionExecutionService.invokeJavaProblems("avt.learn.challenge.problems");
    }

}
