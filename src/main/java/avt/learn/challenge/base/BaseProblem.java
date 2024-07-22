package avt.learn.challenge.base;

import org.springframework.beans.factory.annotation.Autowired;

import avt.learn.challenge.service.SolutionExecutionService;

@Problem
public abstract class BaseProblem {

	@Autowired
	public SolutionExecutionService solutionExecutionService;

	public abstract void execute();

}
