package dna;


//
// FastaRecord contains the defline and sequence 
// from a record in a fasta file.
//


public class FastaRecord implements DNARecord
{	
	private String defline;
	private String sequence;

	// Ctor that takes defline only if there is an '>' in the beginning 
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (!(defline.substring(0,1).equals(">")))
		{
			RecordFormatException rex = new RecordFormatException("Bad 1st char in "
					+ "defline in fastq record: saw " + defline.substring(0,1) + ", expected >");
			throw rex;
		}
		else
		{
			this.defline = defline;
			this.sequence = sequence;
		}
	}
	
	// Second ctor that takes a FastqRecord and outputs a FastaRecord 
	public FastaRecord(FastqRecord fastqRec)
	{
		String def = fastqRec.getDefline();
		String overlap = def.substring(1, def.length());
		this.defline = ">" + overlap;
		this.sequence = fastqRec.getSequence();
	}

	public String getDefline()
	{
		return this.defline;
	}
	
	public String getSequence()
	{
		return this.sequence;
	}
	
	// Compares defline, then sequence; compatible with equals() 
	public int compareTo(FastaRecord that)
	{
		int deff = this.getDefline().compareTo(that.getDefline());
		int seqs = this.getSequence().compareTo(that.getSequence());
		
		if (deff != 0)
		{
			return deff;
		}
		else
			return seqs;
		
	}
	
	@Override
	public boolean equals(Object x)
	{
		FastaRecord that = (FastaRecord) x;
		return (this.compareTo(that) == 0);
	}
	
	@Override
	public String toString()
	{
		return (defline + "\n" + sequence + "\n");
	}

	// Returns the sum of the hashcodes of defline and sequence. 
	@Override
	public int hashCode()
	{
		return (defline.hashCode() + sequence.hashCode());
	}
}