//1268723

//Imports the required java.net classes
import java.net.InetAddress;
import java.net.UnknownHostException;

class resolveall
{
	public static void main(String [] args)
	{
		//Checks that at least one argument is supplied
		if(args.length == 0)
		{
			//If no arguments are supplied, output the usage and stops the program.
	    		System.err.println("Usage:  resolveall <name1> <name2> ... <nameN>");
	    		return;
   		}		
		//repeats for each arguments supplied.
   		for(int i = 0; i < args.length; i++)
		{
			try
			{
				//Puts all the InetAddress of the name supplied into an array
				InetAddress[] IP = InetAddress.getAllByName(args[i]);
				//For each of the Inetaddress objects found, display its host name
				for(int j = 0; j < IP.length; j++)
				{
					//Outputs the name supplied, and the IP address
					System.out.println(args[i] + " : " + IP[j].getHostAddress());
				}
			}
			catch(UnknownHostException ex)
			{
				//Catches any errors where the host is not known.
				System.err.println(args[i] + " : unknown host");
			}		
   		}
   	}
}
