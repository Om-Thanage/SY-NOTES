class X {
    public void showX() {
        System.out.println("Class X");
    }
}

class Y extends X {
    public void showY() {
        System.out.println("Class Y");
    }
}

class Z extends Y {
    public void showZ() {
        System.out.println("Class Z");
    }
}

public class multilevelInheritance {
    public static void main(String[] args) {
        Z obj = new Z();
        obj.showX();
        obj.showY();
        obj.showZ();
    }
}
