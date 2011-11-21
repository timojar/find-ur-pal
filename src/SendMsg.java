import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class SendMsg {

	public void send(String numA,String numB)throws Exception
	{
		FileWriter fstream = new FileWriter("var/spool/sms/outgoing/out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		out.write("To: " + numB);
		out.write("\n"+ numA + " wants to follow you. Reply pf3:follower,urNo");
		File file = new File("out.txt");
		//String msg1 = numA + " wants to follow you. Accept?";
		//System.out.println("Msg sent to numB with msg content as: numA wants to follow u");
	}
	public void sendLocation(String numA, String numB, String place)throws Exception
	{
		FileWriter fstream = new FileWriter("var/spool/sms/outgoing/out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		out.write("To: " + numA);
		out.write("\n"+ numB + " at " + place);
		File file = new File("out.txt");
	}
}
