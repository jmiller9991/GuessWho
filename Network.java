import java.io.*;
import java.net.*;

public class Network {
	
	public static void Host(int port) throws IOException{
	
		try (//Temporary Resources
		
			//Server Socket
			ServerSocket serverSocket = new ServerSocket(port);
			
			//Listen for client
			Socket clientSocket = serverSocket.accept(); 
			
			//PrintWriter to socket with autoflush set to true
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
			
			//Object for reading in
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			//Input from User
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
		) {
			 
			Thread server = new Thread(){
				public void run(){
					
					try{
						String receiveString;
						//Read input from socket
						while ((receiveString = in.readLine()) != null) {
							if(receiveString.equals("quit")){
								System.out.println("User has quit. Ending host.");
								break;
							}
							System.out.println(receiveString);
							
					}
					}catch(IOException e){
						System.out.println(e);
					}
				}
			};
			server.start();
			
			String userInput;
			while((userInput = stdIn.readLine()) != null){
				
				out.println(userInput);
				if(userInput.equals("quit")){
					server.stop();
					break;
				}
				
			}
			

		}
		 catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port "
				+ port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
    
	}
	
	

	
	
	
	
	
	
	public static void Client(String host, int port) throws IOException{
		

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
			
			Thread server = new Thread(){
				public void run(){
					try{
						String receiveString;
						while((receiveString = in.readLine()) != null){
							//Read response
							System.out.println("Host: " + receiveString);
						}
					}catch(IOException e){
						//TODO
					}
				}
			};
			server.start();
			

			
			
			//USER INPUT
			String userInput;
			while ((userInput = stdIn.readLine()) != null) {
				//Send Input to socket
				out.println(userInput);
				
				//Exit
				if(userInput.equals("quit"))
					break;
			}

			
			

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                host);
            System.exit(1);
        } 
    }
		
}