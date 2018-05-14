package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqReader.
//

public class FastqReader 
{
	private BufferedReader theBufferedReader;
	
	public FastqReader(BufferedReader br)
	{
		theBufferedReader = br;
	}
	
	// Returns next record in the file, or null if it is End of file.
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String line = theBufferedReader.readLine();
		if(line==null)
		{
			return null;
		}
		
		String def = line;
		String sq = theBufferedReader.readLine();
		theBufferedReader.readLine();
		String qual = theBufferedReader.readLine();
		
		FastqRecord reco = new FastqRecord(def,sq,qual);
		return reco;
		
		
		
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.

	}
}
