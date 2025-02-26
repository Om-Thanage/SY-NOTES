package mypack;

class Trignometry {
    static double sine(int deg){
        if(deg == 0)
            return 0;
        else if(deg == 30)
            return 0.5;
        else if(deg == 60)
            return 0.866;
        else if(deg == 90)
            return 1;
        return -1;
    }
    static double cos(int deg){
        if(deg == 0)
            return 1;
        else if(deg == 30)
            return 0.866;
        else if(deg == 60)
            return 0.5;
        else if(deg == 90)
            return 0;
        return -1;
    }
    static double tan(int deg){
        if(deg == 0)
            return 0;
        else if(deg == 30)
            return 0.577;
        else if(deg == 60)
            return 1.732;
        else if(deg == 90)
            return -1;
        return -1;
    }
    static double cot(int deg){
        if(deg == 0)
            return -1;
        else if(deg == 30)
            return 1.732;
        else if(deg == 60)
            return 0.577;
        else if(deg == 90)
            return 0;
        return -1;
    }
    static double sec(int deg){
        if(deg == 0)
            return 1;
        else if(deg == 30)
            return 1.155;
        else if(deg == 60)
            return 2;
        else if(deg == 90)
            return 0;
        return -1;
    }
    static double cosec(int deg){
        if(deg == 0)
            return 0;
        else if(deg == 30)
            return 2;
        else if(deg == 60)
            return 1.155;
        else if(deg == 90)
            return 1;
        return -1;
    }
}
