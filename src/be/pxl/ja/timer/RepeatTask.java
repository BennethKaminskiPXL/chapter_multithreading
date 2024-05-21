package be.pxl.ja.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
//Niet kennen, @Scheduled gebruiken in Spring!
public class RepeatTask {

	public static void main(String[] args) {
		//timertask is een abstracte klasse, je moet de run methode implementeren
		TimerTask repeatedTask = new TimerTask() {
			public void run() {
				System.out.println("Task started on " + LocalDateTime.now());
				try {
					Thread.sleep(12000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task completed on " + LocalDateTime.now());
			}
		};
		Timer timer = new Timer("Timer");
		long period = 10000L;
		timer.scheduleAtFixedRate(repeatedTask, 0, period);
	}
}
