package be.pxl.ja.demo1;

public class WorkerThread4 {

	public static void main(String[] args) {
		Thread virtualThread = Thread.startVirtualThread(() -> {
			System.out.println("Line A (" + Thread.currentThread().getName() + ")");
			System.out.println("Line B (" + Thread.currentThread().getName() + ")");
			System.out.println("Line C (" + Thread.currentThread().getName() + ")");
			System.out.println("Line D (" + Thread.currentThread().getName() + ")");
			System.out.println("Line E (" + Thread.currentThread().getName() + ")");
		});
		System.out.println("Line 1 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 2 (" + Thread.currentThread().getName() + ")");
		System.out.println("Line 3 (" + Thread.currentThread().getName() + ")");
		//deze moet er dan bij : anders stopt de main thread en stopt de virtual thread
        try {
            virtualThread.join(); // wait for the virtual thread to end, anders wordt de main thread afgesloten en stopt de virtual thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
