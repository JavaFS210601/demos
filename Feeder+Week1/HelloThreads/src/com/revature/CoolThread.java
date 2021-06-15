package com.revature;

//This Thread will extend Thread in order to override the run() method
//As seen in NeglectedThread, we could have implemented Runnable to do the same thing
public class CoolThread extends Thread {
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 100; i++) {
			
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			sb.append(" is working...");
			
			System.out.println(sb);
			
			//This is only so we can see the Thread running... .sleep() will make the Thread wait in millisecond intervals
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			
		}
		
		System.out.println("Thread Complete!!");
		
	}
	
}
