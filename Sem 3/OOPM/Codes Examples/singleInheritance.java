class A{
    public void displayA(){
        System.out.println("Class A");
    }   
}

class B extends A{
    public void displayB(){
        System.out.println("Class B");
    }
}

public class singleInheritance {
    public static void main(String[] args) {
        B obj = new B();
        obj.displayA(); // Class A parent class method
        obj.displayB(); // Class B child class method
    }
}