package java_animal;
public class PetOwner{
    public void shot(){
        Vet v = new Vet();
        Cat c = new Cat();
        Dog d = new Dog();

        v.giveShot(c);
        v.giveShot(d);
    }
}