import java.io.*;
import java.net.*;

public static class Network {
	
	public static void Host(int port) throws IOException{
	
		try (//Temporary Resources
		
			//Server Socket
			ServerSocket serverSocket = new ServerSocket(port));
			
			//Listen for client
			Socket clientSocket = serverSocket.accept(); 
			
			//PrintWriter to socket with autoflush set to true
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
			
			//Object for reading in
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		) {
			
			//Read Input from socket
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				//Echo response
				out.println(inputLine);
			}
		}
		 catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port "
				+ portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
    
	}
	
	
	
	public static Client(String host, int port) throws IOException{
		

        try (//Resources
		
			//Socket to host
            Socket socket = new Socket(host, port);
			
			//Print Writer to socket with auto flush true
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			//Object to read in from socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Input from User
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
			
			//USER INPUT
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
				//Send Input to socket
                out.println(userInput);
				//Read response
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
		
}