package javaserver_skkclass;

import java.io.Serializable;

public class GameSaveTest implements Serializable{
    static final long serialVersionUID = -684979447075466L;

    int power;
    int hp;
    int mp;
    public GameSaveTest(int p, int h, int m){
        power = p;
        hp = h;
        mp = m;
    }
    
}