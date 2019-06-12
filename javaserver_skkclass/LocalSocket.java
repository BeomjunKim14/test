package javaserver_skkclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class LocalSocket{
    public static void main(String [] args){
    try{
        Socket s = new Socket("127.0.0.1", 4242);//port

        InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);
        
        String advice = reader.readLine();
        System.out.println("Success "+s);
        reader.close();
    } catch(IOException ex){
        System.out.println(ex);
    }
}
}