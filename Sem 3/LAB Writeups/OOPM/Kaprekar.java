
public class Kaprekar
{
    static int kaprekar(int n)
    {
        int count = 0, num = 0, temp=n, s = 0;
        while(n!=0)
        {
            n=n/10;
            count++;
        }
        n = temp*temp;
        for(int i=0;i<count;i++)
        {
            num = (int)(n % (Math.pow(10,count)));
        }
        s = (int) (n/(Math.pow(10,count)));
        return (s+num);
    }
    public static void main(String [] args)
    {
        System.out.println("The Kaprekar Numbers less than 1000 are:");
        for(int i = 1; i<1000; i++){
        if(kaprekar(i) == i)
        {
            System.out.println(i);
        }
        }
       
    }
}
