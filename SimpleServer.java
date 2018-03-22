//1268723

//Imports the required java.net and io classes.
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;

class SimpleServer
{
	public static void main(String args[])
	{	
		try
		{
			//Makes a new server socket listening on port 1234
			ServerSocket server = new ServerSocket(0);
			System.out.println("Your port is " + server.getLocalPort());
			//Makes a new client object and waits for a client to accept
			Socket client = server.accept();

			//System.out.println(client.getPort());

			//once a client has connected, displays a message.
			//System.out.println("Connected");

			//Creates a writer object tied to the clients output stream.
			//We will use this to send information to the client.
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
					
			//gets the IP address and IP address in textual form of the client
			InetAddress IP = client.getInetAddress();
			String ipString = IP.getHostAddress();

			//Gets the name behind the clients IP address
			String name = IP.getHostName();

			//Greets the client by writting to it's writer object.
			writer.println("Hello, " + name);
			writer.println("Your IP address is " + ipString);

			//Closes the client.
			client.close();			
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
}



class SimpleClient
{
	public static void main(String args[])
	{
		//Checks that 2 arguments are supplied
		if(args.length != 2)
		{
			//Displays the usage if 2 arguments are not supplied and stops.
			System.err.println("Usage: SimpleClient <ServerName> <Port>");
			return;
		}
		try
		{
			//gets the value of the port string supplied
			int i = Integer.valueOf(args[1]);
			//sets a socket object to a socket supplied with the host address and port number
			Socket s = new Socket(args[0], i);
			//Prints that the client is connected
			//System.out.println("Connected");
		
			//Creates a buffered reader to read information from the server
			//Used the input stream reader object to do this.
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

			//Creates a loop that break when the message is null
			while(true)
			{
				//gets the message from the reader
				String message = reader.readLine();
				//If the message is not null, display the message
				if(message != null)
				{
					System.out.println(message);
				}
				else
				{
					//Stops if the message is null
					break;
				}
			}
			s.close();
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
