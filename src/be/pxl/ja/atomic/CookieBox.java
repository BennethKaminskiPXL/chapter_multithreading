package be.pxl.ja.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CookieBox {

	private AtomicInteger numberOfCookies; // wordt als 1 actie uitgevoerd, zonder dat een andere thread ertussen kan komen

	public CookieBox(int numberOfCookies) {
		this.numberOfCookies = new AtomicInteger(numberOfCookies);
	}

	public boolean takeCookie() {
		int result = numberOfCookies.getAndDecrement();
		return result > 0;
	}
}
