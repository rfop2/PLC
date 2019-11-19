import java.util.Collections;
import java.util.Vector;

class meuVector{
	Vector<Integer> mV;
	
	meuVector(Vector<Integer> mV){
		this.mV = mV;
	}
	
	synchronized public void setV(int valor, int index) {
		mV.set(index, valor);
	}
	
	synchronized public int getV(int index) {
		return mV.get(index);
	}
	
	synchronized public void swap(int index1, int index2) {
		Collections.swap(mV, index1, index2);
	}
	
	synchronized public void add(int valor) {
		mV.add(valor);
	}
}



public class Vectorr extends Thread{
	meuVector v;
	Vectorr(meuVector v){
		this.v = v;
	}
	public void run(){
		v.add(5);
		System.out.println(""+ v.getV(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vector = new Vector<Integer>();
		meuVector mV = new meuVector(vector);
		Vectorr v = new Vectorr(mV);
		v.start();
	}

}
