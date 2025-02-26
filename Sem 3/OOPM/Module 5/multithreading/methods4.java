
/*
class ThreadB extends Thread{
    int total;
    
    public void run(){
        synchronized(this)
{
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
       }
    }
}
public class methods4 {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
 
        synchronized(b)
{
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
       }
    }
}
 */


public class methods4 {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
 
		System.out.println("Total is: " + b.total);
 
	}
}
 
class ThreadB extends Thread {
	int total;
 
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			total += i;
		}
	}
}


