
class Conta {
	double saldo;
	String nome;
	
	public Conta(String name , double amnt) {
		saldo = amnt;
		nome = name;
	}
	
	synchronized void depositar(double money) {
		saldo+=money;
	}
	
	synchronized void sacar(double money) {
		saldo-=money;
	}
}
	class GerContas extends Thread{
		Conta[] contas = null;
		public GerContas(Conta[] accs) {
			contas = accs;
		}
		public void run() {
			contas[0].depositar(100);
			contas[3].sacar(50);
			contas[2].depositar(100);
			contas[1].sacar(50);
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c1 = new Conta("Vinicius" , 100.00);
		Conta c2 = new Conta("Stephen Black" , 100.00);
		Conta c3 = new Conta("Arabella" , 100.00);
		Conta c4 = new Conta("John Childermass" , 100.00);
		
		GerContas g1 = new GerContas(new Conta[]{c1,c2,c3,c4});
		GerContas g2 = new GerContas(new Conta[]{c4,c3,c2,c1});
		g1.start(); 
		g2.start();
		
		try {
			g1.join();
			g2.join();
		} catch (InterruptedException e) {}
		for(int i=0; i<=3; i++) {	
			System.out.println(g1.contas[i].saldo);
		}
		for(int i=0; i<=3; i++) {
			System.out.println(g2.contas[i].saldo);
		}
		
	}

}
