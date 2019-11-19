import java.util.Scanner;

public class testePrimo extends Thread {
	int valorN;
	int numeros[] = new int[100];
	public testePrimo(int valorN) {
		this.valorN=valorN;
	}
	public void run() {
		for(int i=0; i<=this.valorN; i++) {
			if(ehPrimo(i)) {
				System.out.println(""+i);
			}
		}
	}
	static boolean ehPrimo(int n) {
		if(n <= 1)
			return false;
		for(int i=2; i<n; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int valorN;
		valorN = in.nextInt();
		new testePrimo(valorN).start();
	}
}
