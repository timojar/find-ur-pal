import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
				File f = new File(dir + "\\" + list[i]);
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
	
	public ArrayList<String> CreateStringList(String ... values)
	{
	    ArrayList<String> results = new ArrayList<String>();
	    Collections.addAll(results, values);
	    return results;
	}
	public String[] ConvertToStringArray(ArrayList list)
	{
	    return (String[])list.toArray(new String[0]);
	}
	public String[] AppendItemToArray(String[] array, String newValue)
	{
	    ArrayList<String> list = CreateStringList(array);
	    list.add(array.length, newValue);
	    return ConvertToStringArray(list);
	}
	
	public static void main(String[] args) {
		FileRead f = new FileRead();
		File directory = new File("C:\\Users\\user\\workspace\\findurpalol\\src\\Incoming");
		String allfiles = f.filelist(directory);
		String [] list = allfiles.split(",");
		
		for (int i = 0 ; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
		
		String [] pf1 = null;
		String [] pf2 = null;
		String [] pf3 = null;
		String [] pf4 = null;
		if(list.length != 0)
		{
		for(int i = 0; i < list.length; i++)
		{
			int j = f.findtag(list[i]);
			if(j == 1)
				f.AppendItemToArray(pf1, list[i]);
			else if(j == 2)
				f.AppendItemToArray(pf2, list[i]);
			else if(j == 3)
				f.AppendItemToArray(pf3, list[i]);
			else if(j == 4)
				f.AppendItemToArray(pf4, list[i]);
		}
		
		for (int i = 0 ; i < pf1.length; i++)
		{
			System.out.println(pf1[i]);
		}
		for (int i = 0 ; i < pf2.length; i++)
		{
			System.out.println(pf2[i]);
		}
		for (int i = 0 ; i < pf3.length; i++)
		{
			System.out.println(pf3[i]);
		}
		for (int i = 0 ; i < pf4.length; i++)
		{
			System.out.println(pf4[i]);
		}
		
		}
		
	}
}
