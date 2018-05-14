package dna;

import java.io.*;
import java.util.*;

public class FileConverter
{
	private File fastq;
	private File fasta;
	
	public FileConverter(File fastq, File fasta)
	{
		this.fastq = fastq;
		this.fasta = fasta;
	}
	
	//
	// Writes a fasta file consisting of conversion of all records from the fastq with
	// sufficient quality and unique defline.
	//
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// Read each fastq record until end of fastq file is reached; for valid records w/ unique 
		// defline and enough quality, create a fasta record 
		
		HashSet<String> hSet = new HashSet<String>();
		FastqRecord checker;
		boolean done = false;
		
		while (!done)
		{
			try
			{
				while ((checker = fqr.readRecord()) != null) // Read fastq record till end of file reached 
				{
					boolean add = hSet.add(checker.getDefline());
					// If quality is proper and you can add checker to the hashSet, write to the fasta record 
					if ((checker.qualityIsHigh()) && add)
					{
						FastaRecord theAns = new FastaRecord(checker);
						faw.writeRecord(theAns);
					}
				}
				done = true;
			}
			catch(RecordFormatException r) {
				// Don't do anything if record not valid 
			}
		}
		
		// Closes fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
	
		
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}