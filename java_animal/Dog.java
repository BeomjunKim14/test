package java_animal;

import java.io.Serializable;

public class Dog extends Canine implements Pet,Serializable{
    private static final long serialVersionUID = 1L;
    transient String name = "D";
    String breed = "dog";
    int age = 7;

    public void makeNoise(){
        System.out.println("Dog make noise");

    }
    public void eat(){
        System.out.println("Dog eat");
    }
    public void petinfo(){
        System.out.println(breed+" "+age);
    }
    public void showName(){
        System.out.println(name);
    }
    
}