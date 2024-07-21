package avt.learn.learnJava.base;

import org.springframework.beans.factory.annotation.Autowired;

import avt.learn.learnJava.service.SolutionExecutionService;

@Problem
public abstract class BaseProblem {

	@Autowired
	public SolutionExecutionService solutionExecutionService;

	public abstract void execute();

}
