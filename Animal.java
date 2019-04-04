abstract class Animal{
    boolean picture;
    private String food;
    boolean hunger;
    boolean boundaries = true;
    String location;

    public void makeNoise(){
        System.out.println("Animal make noise");
    }
    public void eat(){
        System.out.println("Animal eat");
    }
    public void sleep(){
        System.out.println("Animal sleep");
    }
    public void roam(){
        System.out.println("Animal roam");
    }
    public void setFood(String _food){
        food = _food;
    }
    public String getFood(){
        return food;
    }
}