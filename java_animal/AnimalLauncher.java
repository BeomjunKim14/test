package java_animal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AnimalLauncher {
    public static void main(String[] args) throws IOException {
        Lion lion = new Lion();
        System.out.println(lion.boundaries);
        lion.makeNoise();
        lion.eat();
        Tiger tiger = new Tiger();
        tiger.makeNoise();
        tiger.eat();
        Cat cat = new Cat();
        cat.makeNoise();
        cat.eat();
        Hippo hippo = new Hippo();
        hippo.makeNoise();
        hippo.makeNoise();
        hippo.eat();
        Dog dog = new Dog();
        dog.makeNoise();
        dog.eat();
        dog.petinfo();
        dog.showName();
        System.out.println(dog.sleep);
        Wolf wolf = new Wolf();
        wolf.makeNoise();
        wolf.eat();
        wolf.setFood("meat");
        System.out.println(wolf.sleep);
        System.out.println(wolf.getFood());
        System.out.println(wolf.lifespan);
        Robodog robodog = new Robodog();
        robodog.petinfo();
        robodog.showName();
        Animal mydog = new Dog();
        mydog.sleep();
        
        PetOwner owner = new PetOwner();
        owner.shot();
        FileOutputStream fs = new FileOutputStream("~/pet.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(dog);
        os.close();
        
    }
}