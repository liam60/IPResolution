//1268723

//Imports appropriate java.net classes
import java.net.InetAddress;
import java.net.UnknownHostException;

class resolve
{
	public static void main(String [] args)
	{
		//Checks to make sure at least one argument is given
		if(args.length == 0)
		{
			//Prints the usage of the program and stops
      			System.err.println("Usage:  resolve <name1> <name2> ... <nameN>");
      			return;
		}
		//Repeats for each argument specified
   		for(int i = 0; i < args.length; i++)
		{
			//Tries to find ip address
			try
			{	
				//Gets the InetAddress by name
				InetAddress IP = InetAddress.getByName(args[i]);
				//prints the website along with the Ip address in a readable format.
				System.out.println(args[i] + " : " + IP.getHostAddress());
			}
			catch(UnknownHostException ex)
			{
				//with throw an error if the argument specified is not a reachable website.
				System.err.println(args[i] + " : unknown host");
			}
   		}
  	}
}
