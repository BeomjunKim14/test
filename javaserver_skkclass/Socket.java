package javaserver_skkclass;

import java.io.InputStream;
import java.net.ServerSocket;

public class Socket{

	public static void main(String [] args){
    try{
    ServerSocket serverSock = new ServerSocket(4242);
    while(true){
        Socket sock = serverSock.accept();
        PrintWriter writer = new PrintWriter(sock.getOutputStream());
        String advice = getAdvice();
    }
    }
}

	public InputStream getInputStream() {
		return null;
	}
}
