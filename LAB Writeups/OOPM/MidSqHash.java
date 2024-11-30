import java.util.*;
class MidSqHash{
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int x = s1.nextInt();
        int res = x*x;
        int count = 0;
        while(res>0){
            count++;
            res /= 10;
        }
        int div;
        if(count % 2 == 0){
            div = (int)(Math.pow(10, (count/2)-1));
        }
        else{
            div = (int)(Math.pow(10, (count/2)));
        }
        int extract = (x*x)/div;
        int answer = (extract)%100;
        System.out.println("Square: "+ x*x);
        System.out.println("Mid Hash: "+answer);
        s1.close();


    }
}