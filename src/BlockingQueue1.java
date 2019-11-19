import java.util.LinkedList;
import java.util.List;

class bq{
	List<Integer> fila;
	int limite;
	bq(int limite, List fila){
		this.limite = limite;
		this.fila = fila;
	}
	
	public synchronized void addFila(int valor) throws InterruptedException {
		while(this.fila.size() == this.limite) {
			wait();
		}
		
		if(this.fila.size() == 0) {
			notifyAll();
		}
		
		this.fila.add(valor);
	}
	
	public synchronized void removerFila() throws InterruptedException{
		while(this.fila.size() == 0) {
			wait();
		}
		
		if(this.fila.size() == limite) {
			notifyAll();
		}
		
		this.fila.remove(0);
	}
	
	public synchronized String imprimeFila() throws InterruptedException{
		return fila.toString();
	}
}

public class BlockingQueue1 extends Thread{
	bq bq;
	BlockingQueue1(bq bq){
		this.bq = bq;
	}
	
	public void run() {
		//testes
		try {
			bq.addFila(5);
			bq.addFila(3);
			bq.removerFila();
			System.out.println(bq.imprimeFila());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int limite = 10;
		List fila = new LinkedList<Integer>();
		
		bq bq = new bq(limite, fila);
		BlockingQueue1 thread1 = new BlockingQueue1(bq);
		thread1.start();
		BlockingQueue1 thread2 = new BlockingQueue1(bq);
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

}
