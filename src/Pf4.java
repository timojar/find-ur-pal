import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Pf4 {
	Actions a = new Actions();
	SendMsg msg = new SendMsg();
	ArrayList<String> alist = new ArrayList<String>();
	public void getLocation(String s)
	{
		String num,place;
		String [] temp = s.split(":", 2);
		s = temp[1];
		temp = s.split(",", 2);
		num = temp[0];
		place = temp[1];
		if(num != null && place != null)
		{
			a.updateLocation(num, place);
			alist = a.selectFollow(num);
			for(int i = 0; i < alist.size(); i++)
				msg.sendLocation(num, place);
		}
		else
			System.exit(0);
	}
	public void fileDelete(String fileName)
	{
		File f = new File(fileName);

	    // Make sure the file or directory exists and isn't write protected
	    if (!f.exists())
	      throw new IllegalArgumentException(
	          "Delete: no such file or directory: " + fileName);

	    if (!f.canWrite())
	      throw new IllegalArgumentException("Delete: write protected: "
	          + fileName);

	    // If it is a directory, make sure it is empty
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException(
	            "Delete: directory not empty: " + fileName);
	    }

	    // Attempt to delete it
	    boolean success = f.delete();
	    //System.out.println(success);
	    if (!success)
	      throw new IllegalArgumentException("Delete: deletion failed");
	}
	public static void main(String[] args) throws Exception {
		String [] str = {"abc.txt"};
		Pf4 p = new Pf4();
		String str1;
		for(int i = 0; i < str.length; i++)
		{
			FileInputStream in = new FileInputStream(str[i]);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			str1 = br.readLine();
			if(str1 != null)
			{
				p.getLocation(str1);
				in.close();
				p.fileDelete(str[i]);
			}
			else
				System.out.println("Nothing in file");
		}
		
	}
}
