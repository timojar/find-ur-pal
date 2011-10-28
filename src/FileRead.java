import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileRead {
	public int findtag(String filename){
		try
		{
			FileInputStream in = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			filename = br.readLine();
			in.close();
			
			char char1, char2, char3;
			
			char1 = filename.charAt(0);
			char2 = filename.charAt(1);
			char3 = filename.charAt(2);
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
	
	public String filelist(File dir)
	{
		boolean flag = false;
		if(dir.isDirectory())
			flag = true;
		ArrayList<String> files = new ArrayList<String>();
		while(flag)
		{
			flag = false;
			String [] list = dir.list();
			for (int i = 0; i < list.length; i++) 
			{
				File f = new File(dir + "/" + list[i]);
				if(f.isFile())
				{
					files.add(f.toString());
				}
				else
				{
					dir = f;
					flag = true;
					break;
				}
			}
		}
		return files.toString();
	}
	
	public static void main(String[] args) {
		FileRead f = new FileRead();
		File directory = new File("C:\\Users\\user\\workspace\\findurpalol\\src\\Incoming");
		String allfiles = f.filelist(directory);
		String [] list = allfiles.split(",");
		
		/*
		for (int i = 0 ; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
		*/
		
	}
}
