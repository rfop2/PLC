import java.util.concurrent.atomic.AtomicInteger;

class cont{
	AtomicInteger c = new AtomicInteger(0);
	
	public void increment() {
		c.incrementAndGet();
	}
	
	public void decrement() {
		c.decrementAndGet();
	}
	
	public int getValor() {
		return c.get();
	}
}
public class ContadorAtomico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
