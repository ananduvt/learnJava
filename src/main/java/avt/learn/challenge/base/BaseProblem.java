package avt.learn.challenge.base;

import org.springframework.beans.factory.annotation.Autowired;

import avt.learn.challenge.service.SolutionExecutionService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Problem
@Getter
@Setter
@Component
public abstract class BaseProblem {

	@Autowired
	private SolutionExecutionService solutionExecutionService;
	
	private String problemStatement;
	private Object[][] inputOutputs;
	
	protected BaseProblem() {
		problemStatement = setProblemStatement();
		inputOutputs = setProblemInputOutputs();
	}
	
	public abstract String setProblemStatement();
	
	public abstract Object[][] setProblemInputOutputs();
}
