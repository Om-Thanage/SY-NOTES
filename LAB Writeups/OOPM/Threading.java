import java.util.*;

class Square extends Thread {
    private int n;

    public Square(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println(n);
        System.out.println("Square: " + (n * n));
    }
}

class Cube extends Thread {
    private int n;

    public Cube(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println(n);
        System.out.println("Cube: " + (n * n * n));
    }
}

class RNG extends Thread{
    public void run(){
        for(int i = 0; i<20; i++){
            Random r = new Random();
            int n = (r.nextInt())%10 + 10;
            Square s = new Square(n);
            Cube c = new Cube(n);

            if (n % 2 == 0){
                s.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
            else {
                c.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
    

public class Threading {
    public static void main(String[] args) {
        RNG r = new RNG();
        r.start();
    }
}



