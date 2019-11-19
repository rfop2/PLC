package estudo2019;

import java.util.Scanner;

public class threadPrimos extends Thread {
	
	int n;
	
	threadPrimos (int n){
		this.n = n;
	}
	
	synchronized public boolean ehPrimo(int numero) {
		int div = 0;
		for(int i = 1; i<this.n; i++) {
			if(numero % i == 0) {
				div++;
			}
		}
		
		if(div > 2 ) {
			return false;
		} else {
			return true;
		}
		
	}
	public void run() {
		for(int i=0; i <n; i++) {
			if(ehPrimo(i)) {
				System.out.print(" "+i);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int qntdThreads,numeroMaximo;
		Thread temp = null;
		
		qntdThreads = in.nextInt();
		numeroMaximo = in.nextInt();
		
		
		for(int i = 0; i<qntdThreads; i++) {
			temp = new threadPrimos(numeroMaximo);
			temp.start();
			temp.join();
		}
		
		
	}

}
