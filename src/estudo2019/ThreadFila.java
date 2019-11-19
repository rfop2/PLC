package estudo2019;

import java.util.LinkedList;
import java.util.List;

class fila {
	List<Integer> f;
	int tamanho;
	
	public fila(int tamanho, List<Integer> f) {
		this.tamanho = tamanho;
		this.f = f;
		
	}
	
	synchronized public void adiciona(int n) {
		f.add(n);
		
	}
	
	synchronized public void remove() {
		if(f.isEmpty()) {
			System.out.println("ta vazia!");
		} else {
			f.remove(0);
		}
	}
}


public class ThreadFila extends Thread{
	fila fila;
	
	public ThreadFila (fila fila) {
		this.fila = fila;
	}
	
	public void run() {
		fila.adiciona(5);
		System.out.println("" + getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Integer> f = new LinkedList<Integer>();
		fila fila = new fila(5, f);
		Thread t1 = new ThreadFila(fila);
		Thread t2 = new ThreadFila(fila);
		Thread t3 = new ThreadFila(fila);
		Thread t4 = new ThreadFila(fila);
		Thread t5 = new ThreadFila(fila);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
		

	}

}
