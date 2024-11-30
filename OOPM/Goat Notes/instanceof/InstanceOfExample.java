class Animal { }
class Dog extends Animal { }

public class InstanceofExample {
    public static void main(String[] args) {
        Animal a = new Dog(); // Dog object assigned to Animal reference
        Animal b = new Animal(); // Animal object assigned to Animal reference
        
        // Test if 'a' is an instance of Dog
        if (a instanceof Dog) {
            System.out.println("a is an instance of Dog.");
        } else {
            System.out.println("a is not an instance of Dog.");
        }

        // Test if 'b' is an instance of Dog
        if (b instanceof Dog) {
            System.out.println("b is an instance of Dog.");
        } else {
            System.out.println("b is not an instance of Dog.");
        }
    }
}

