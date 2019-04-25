package java_animal;
class Wolf extends Canine{
    public Wolf(){
        lifespan = 10;
    }
    boolean sleep = false;
    public void makeNoise(){
        System.out.println("Wolf make noise");
    }
    public void eat(){
        System.out.println("Wolf eat");
    }
}