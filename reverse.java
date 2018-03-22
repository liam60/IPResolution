//1268723

//Imports the required java.net classes
import java.net.InetAddress;
import java.net.UnknownHostException;

class reverse
{
	public static void main(String [] args)
	{
		//Checks to ensure at least 1 argument is supplied
		if(args.length == 0)
		{
			//Describes usage of program and stops
	      		System.err.println("Usage:  reverse <IPv4address1> <IPv4address2> ... <IPv4addressN>");
	    		return;
		}		
		//For loops repeats for each argument supplied
		for(int i = 0; i < args.length; i++)
		{
			try
			{
				//gets the InetAddress obects with the IP address supplied
				InetAddress IP = InetAddress.getByName(args[i]);
				//Puts the name of the host into a name string
				String name = IP.getHostName();
				//If the name returned is just the IP address supplied
				if(name.equals(args[i]))
				{
					//Output that no name can be found for this IP address.
					System.out.println(args[i] + " : no name");
				}
				else
				{
					//Output the ip address supplied as the argument and the name of the host
					System.out.println(args[i] + " : " + name);
				}	
			}
			catch(UnknownHostException ex)
			{
				//To catch any error, outputs the error message.
				System.err.println(ex.getMessage());
			}
      		}
  	}
}
