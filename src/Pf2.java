//pf2
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Pf2 {
	Actions a = new Actions();
	public void parse(String s)
	{
		System.out.println(s);
        String numA,numB;
        String [] temp = s.split(":", 2);
        s = temp[1];
        temp = s.split(",", 2);
        numA = temp[0];
        numB = temp[1];
        try{
                Integer.parseInt(numA);
                Integer.parseInt(numB);
                }
                catch(Exception e)
                {
                        System.out.print("\nThe 10 digits entered are not numbers.");
                        return;
                }
                if(numA.length()!=10 || numB.length()!=10)
                {
                        System.out.print("\nThe 10 digits entered are not numbers.");
                        return;
                }
        //System.out.println(numA);
        //System.out.println(numB);
        if(a.selectConnections(numA, numB))
        {
                a.updateFollow(numA, numB);
        }
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
	public void main2(String[] str) throws Exception {
		//String [] str = {"abc.txt"};
		System.out.println("inside PF2");
		System.out.println(str[0]);
		Pf2 p = new Pf2();
		String str1;
		for(int i = 0; i < str.length; i++)
		{
			FileInputStream in = new FileInputStream(str[i]);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			str1 = br.readLine();
			if(str1 != null)
			{
				if(str1.length()!=25)
                {
                        System.out.print("\nNot valid entry");
                        continue;
                }
				p.parse(str1);
				in.close();
				//p.fileDelete(str[i]);
			}
			else
				System.out.println("Nothing in file");
		}
		System.out.println("successful pf2");
	}
}
