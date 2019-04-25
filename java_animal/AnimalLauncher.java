package java_animal;
public class AnimalLauncher{
    public static void main(String[] args){
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
        //mydog.petinfo(); Animal class로 선언했기 때문에 dog class method 사용불가
        PetOwner owner = new PetOwner();
        owner.shot();
    }
}