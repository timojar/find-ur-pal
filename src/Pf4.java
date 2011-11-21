//pf4
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Pf4 {
	Actions a = new Actions();
	SendMsg msg = new SendMsg();
	ArrayList<String> alist = new ArrayList<String>();
	public void getLocation(String s) throws Exception
	{
		System.out.println(s);
		String num,place;
        String [] temp = s.split(":", 2);
        s = temp[1];
        temp = s.split(",", 2);
        num = temp[0];
        place = temp[1];
        try{
                Integer.parseInt(num);
                }
                catch(Exception e)
                {
                        System.out.print("\nThe 10 digits entered is not number.");
                        return;
                }
                if(num.length()!=10 )
                {
                        System.out.print("\nThe 10 digits entered is not number.");
                        return;
                }
        if(num != null && place != null)
        {
                a.updateLocation(num, place);
                alist = a.selectFollow(num);
                for(int i = 0; i < alist.size(); i++)
                        msg.sendLocation(alist.get(i), num, place);
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
	public void main4(String[] str) throws Exception {
		//String [] str = {"check.txt"};
		System.out.println("inside PF4");
		Pf4 p = new Pf4();
		String str1;
		for(int i = 0; i < str.length; i++)
		{
			FileInputStream in = new FileInputStream(str[i]);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			str1 = br.readLine();
			System.out.println(str1);
			if(str1 != null)
			{
				if(str1.length()<16)
                {
                        System.out.print("\nNot valid entry");
                        continue;
                }
				p.getLocation(str1);
				in.close();
				//p.fileDelete(str[i]);
			}
			else
				System.out.println("Nothing in file");
		}
		System.out.println("successful pf4");
	}
}
