package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate an ApplicationContext so we can do stuff with our beans
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Instantiate an AvengerDAO object by getting the bean for it
		//Notice we specify AvengerDAO.class, so we don't have to do the cast (like in HelloSpring)
		AvengerDAO dao = ac.getBean(AvengerDAO.class);

		//Make a new Avenger object using the AvengerDAO method
		Avenger a1 = dao.getById(5);
		
		//Make a new Avenger bean so we can make a brand new Avenger
		Avenger a2 = ac.getBean(Avenger.class);
		
		//Give values to this new Avenger
		a2.setAveId(6);
		a2.setAveName("Squirrel Girl");
		a2.setPower("Power of Squirrel (very stronk)");
		a2.setFirstName("Doreen");
		a2.setLastName("Green");
		a2.setPowerLevel(9001);
		
		System.out.println(a2);
		
		//making squirrel girl fight
		System.out.println(dao.fight(a2, "Plot Sword"));
		
	}

}
