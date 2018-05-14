package dotlab;

import java.io.*;


public class DotReader 
{
	private BufferedReader			br;
	
	public DotReader(BufferedReader br)
	{
		this.br = br;
	}
	
	public Dot readDot() throws IOException,DotException
	{
		String line = br.readLine();
		if(line==null)
		{
			return null;
		}
		String[] line1 = line.split(",");
		if(line1.length==4){
			Dot dot1 = new Dot(line1[0],Integer.parseInt(line1[1]),Integer.parseInt(line1[2]),Integer.parseInt(line1[3]));
			return dot1;
		}
		else{
			DotException de = new DotException("Wrong arugument number");
			throw de;
		}
	}
	

}