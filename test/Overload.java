package test;
public class Overload{
    public int addNums(int a, int b){
        return a+b;
    }
    public float addNums(float a, float b){
        return a+b;
    }
    public double addNums(double a, double b){
        return a+b;
    }
    public int addNums(int a, int b ,int c){
        return a+b+c;
    }
    public int addNums(){
        return addNums(1,2,3);
    }
}