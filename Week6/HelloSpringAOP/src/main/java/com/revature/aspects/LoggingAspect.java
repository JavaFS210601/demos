package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Avenger;

//This class is an ASPECT. We will handle all of our Logging functionality here.
//So much cleaner to put this all in one place, instead of all over our application.
@Component
@Aspect
public class LoggingAspect {
	
	private static Logger log = LogManager.getLogger(LoggingAspect.class);

	@Before("within(com.revature.models.*)") //This method will run before any method in the models package (due to within)
	public void logModelMethods(JoinPoint jp) { //A JoinPoint is where an advice COULD be injected. In this case models.
		//getTarget() returns the object getting called, getSignature() gets the method signature
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	//A pointcut is where advice WILL be injected. In this case, the method called() that returns a String, taking any params.
	//the returning attribute? It's simply giving us access to the the object that the method returns (the String)
	@AfterReturning(pointcut="execution(String fight(..))", returning="returnedObject")
	public void logFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
 	
	
	//@Around is the more complicated annotation to use, but it's definitely the most powerful
	//It has the ability to start and stop method execution
	@Around("execution(String fight(..))")
	//ProceedingJoinPoint is the JoinPoint used for @Around
	public String logAttackSuccess(ProceedingJoinPoint pjp) throws Throwable { 
		Avenger a = (Avenger) pjp.getArgs()[0]; //getArgs() will retrieve parameter values from the given method (fight)
		String s = (String) pjp.getArgs()[1]; //then we use getArgs() again to get the String parameter of fight()
		
		log.warn(a.getAveName() + " is trying to fight!!!");
		
		if(a.getAveName().equals("Groot")) {
			log.info(a.getAveName() + " doesn't fight anymore, he's an accountant");
			log.warn("THE FIGHT METHOD WAS NOT CALLED!!!");
			return "Looks like no fight happened :(";
		} else {
			String fightString = (String) pjp.proceed(); //this will actually allow the fight() method to run
			log.info("THE FIGHT METHOD RAN!!!");
			return fightString;
		}
		
	}

}
