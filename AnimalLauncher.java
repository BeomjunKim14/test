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
        hippo.eat();
        Dog dog = new Dog();
        dog.makeNoise();
        dog.eat();
        System.out.println(dog.sleep);
        Wolf wolf = new Wolf();
        wolf.makeNoise();
        wolf.eat();
        System.out.println(wolf.sleep);
    }
}