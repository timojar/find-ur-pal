import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
	
public class FileRead {
	public int findtag(File filename1){
			//String words;
			try
			{
				String one;
				FileInputStream in1 = new FileInputStream(filename1);
				BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
				one = br1.readLine();
				if(one.trim()==null)
				{
					System.out.print("File is empty");
					System.exit(0);
				}
				//System.out.println(one);
				in1.close();
				char char1, char2, char3;
				
				char1 = one.charAt(0);
				char2 = one.charAt(1);
				char3 = one.charAt(2);
				
				if(char1 == 'p' && char2 == 'f')
				{
					if(char3 == '1')
					{
						return 1;
					}
					if(char3 == '2')
					{
						return 2;
					}
					if(char3 == '3')
					{
						return 3;
					}
					if(char3 == '4')
					{
						return 4;
					}
					
				}
				else
					return 0;
		         	  
			}
			catch(Exception e)
			{
		        System.out.println("End of File ");
				System.err.println(e);
		              
			}
			return 0;
		}
		
		
		
		public static void main(String[] args) throws Exception
		{
			
		
			//File inc = new File("C:\\Users\\user\\workspace\\findurpalol\\src\\Incoming");
			File inc = new File("var/spool/sms/pf");
			boolean isDirec = inc.isDirectory();
			 
			if(isDirec == true)
			{
				File[] files = new File("var/spool/sms/pf").listFiles();
				FileRead f = new FileRead();
				int x =files.length;
				
				int i;
				
				ArrayList<String> pf1 = new ArrayList<String>(); 
				ArrayList<String> pf2 = new ArrayList<String>();
				ArrayList<String> pf3 = new ArrayList<String>();
				ArrayList<String> pf4 = new ArrayList<String>();
				
				for(i = 0; i < x; i++)
				{
					int j = f.findtag(files[i]);
					//System.out.println(files[i]);
					
					if(j == 1 )
					{
						pf1.add(files[i].toString());			
					}
					else if(j == 2)
					{
						pf2.add(files[i].toString());
				    }
					else if(j == 3)
					{
						pf3.add(files[i].toString());
					}
					else if(j == 4)
					{	
						pf4.add(files[i].toString());
					}
				}

			String[] spf1 = new String[pf1.size()];
			for (int k = 0; k < pf1.size(); k++) {
				spf1[k] = pf1.get(k);
				//System.out.println(spf1[k]);
			}
			String[] spf2 = new String[pf2.size()];
			for (int k = 0; k < pf2.size(); k++) {
				spf2[k] = pf2.get(k);
				//System.out.println(spf2[k]);
			}
			String[] spf3 = new String[pf3.size()];
			for (int k = 0; k < pf3.size(); k++) {
				spf3[k] = pf3.get(k);
				//System.out.println(spf3[k]);
			}

			String[] spf4 = new String[pf4.size()];
			for (int k = 0; k < pf4.size(); k++) {
				spf4[k] = pf4.get(k);
				//System.out.println(spf4[k]);
			}
			Pf1 first = new Pf1();
			first.main1(spf1);
			Pf2 second = new Pf2();
			second.main2(spf2);
			Pf3 third = new Pf3();
			third.main3(spf3);
			Pf4 fourth = new Pf4();
			fourth.main4(spf4);
			}
			else
			{
				System.out.println("no files found!");
			}
		
		}
}