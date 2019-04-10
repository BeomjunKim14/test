package java_animal;
public class Robodog extends Robot implements Pet{
    String breed = "robot";
    String name = "robodog";
    int age = 1;
    public void bark(){
        System.out.println("Robodog : Bark!");
    }
    public void petinfo(){
        System.out.println(breed+" "+age);
    }
    public void showName(){
        System.out.println(name);
    }
}