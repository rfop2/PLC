import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class threadVetor {
	public static Lock l[];
	
	synchronized static public void lerArray(int[] numeros, int indice) {
		System.out.println(numeros[indice]);
	}
	
	static public void trocaDois(int[] numeros, int indicePrimeiro, int indiceSegundo) {
		
		
		int aux;
		aux = numeros[indicePrimeiro];
		numeros[indicePrimeiro] = numeros[indiceSegundo];
		numeros[indiceSegundo] = aux;
	}
	
	synchronized static public void imprimeArray(int[] numeros) {
		for(int i=0; i<=numeros.length-1; i++) {
			System.out.print(numeros[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = new int[10];
		l = new Lock[10];
		for(int i=0; i<=numeros.length-1; i++) {
			numeros[i] = i;
			
		}
		imprimeArray(numeros);
		trocaDois(numeros, 0, 9);
		imprimeArray(numeros);		

	}

}
