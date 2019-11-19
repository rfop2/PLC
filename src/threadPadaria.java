import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Produtor extends Thread{
	BlockingQueue<Pao> fila;
	int capacidade;
	
	public Produtor(BlockingQueue<Pao> f, int capacidade) {
		this.fila = f;
		this.capacidade = capacidade;
	}
	
	public void run() {
		for(int i =0; i < capacidade; i++) {
			try {
				fila.put(new Pao()); 
				synchronized(this.fila) {
					this.fila.notify();
				}
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println(capacidade +" paes produzidos");
	}
}

class Consumidor extends Thread{
	BlockingQueue<Pao> fila;
	int capacidade;
	
	public Consumidor(BlockingQueue<Pao> f, int capacidade) {
		this.fila = f;
		this.capacidade = capacidade;
	}
	
	public void run() {
		for(int i = 0; i<capacidade; i++) {
			try {
				this.fila.take();
				synchronized(this.fila) {
					this.fila.notify();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(capacidade + " paes consumidos");
	}

}
class Pao{
	
}


public class threadPadaria{
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BlockingQueue<Pao> fila = new ArrayBlockingQueue<Pao>(50);
		Produtor p = new Produtor(fila, 50);
		Consumidor c = new Consumidor(fila, 50);
		
		p.start();
		c.start();
		p.join();
		c.join();
	}

}