package lab5proj;
import java.io.*;

public class lister 
{
	private File file;
	private boolean showHidden;
	
	public lister(File file, boolean showHidden)
	{
		this.file=file;
		this.showHidden=showHidden;
	}
	
	public void list()
	{
		listRecurse(file,"");
	}
	
	private void listRecurse(File file, String indent)
	{
		System.out.println(indent+ file.getName()+":");
		File[] flist = file.listFiles();
		
		for(File f: flist)
		{
			if(!f.isHidden() && showHidden == false)
			{
				if(f.isDirectory())
				{
					listRecurse(f,indent+"  ");
				}
				else
				{
					System.out.println(indent + " "+ f.getName());
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		File file = new File("/C:/Users/Darpan/Documents/CS 46B/lab/lab5/");
		lister listr = new lister(file, false);
		listr.list();
	}
}
