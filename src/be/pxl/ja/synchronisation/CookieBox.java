package be.pxl.ja.synchronisation;

public class CookieBox {

	private int numberOfCookies;

	public CookieBox(int numberOfCookies) {
		this.numberOfCookies = numberOfCookies;
	}

	public synchronized boolean takeCookie() { // synchronized method zodat het stukje code alleen toegekend wordt aan 1 thread
			if (numberOfCookies > 0) {
				numberOfCookies--;
				return true;
			}
			return false;
	}
}
