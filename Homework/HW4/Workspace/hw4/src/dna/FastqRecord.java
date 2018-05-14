package dna;


//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord
{
	private String defline;
	private String sequence;
	private String quality;

	// Ctor that takes defline only if there is an '@' in the beginning 
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if (!(defline.substring(0,1).equals("@")))
		{
			RecordFormatException r = new RecordFormatException("Bad 1st char in "
					+ "defline in fastq record: saw " + defline.substring(0,1) + ", expected @");
			throw r;
		}
		else
		{
			this.defline = defline;
			this.sequence = sequence;
			this.quality = quality;
		}
	}
	
	public String getDefline()
	{
		return this.defline;
	}
	
	public String getSequence()
	{
		return this.sequence;
	}

	// Compares defline, then sequence, then quality; compatible with equals() 
	public int compareTo(FastqRecord that)
	{
		int dline = this.getDefline().compareTo(that.getDefline());
		int seqn = this.getSequence().compareTo(that.getSequence());
		int qua = this.quality.compareTo(that.quality);
		
		if (dline != 0)
		{
			return dline;
		}
		else if (seqn != 0)
		{
			return seqn;
		}
		else
			return qua;
		
	}
	
	@Override
	public boolean equals(Object x)
	{
		FastqRecord that = (FastqRecord) x;
		return (this.compareTo(that) == 0);
	}
	
	
	// Returns the sum of the hashcodes of defline, sequence, and quality.
	@Override
	public int hashCode()
	{
		return (defline.hashCode() + sequence.hashCode() + quality.hashCode());
	}
	
	// Returns true if quality contains at least 3 '!' chars.
	public boolean qualityIsHigh()
	{
		int markCount = 0;
		for (int i = 0; i < quality.length(); i++)
		{
			if (quality.substring(i, i+1).equals("!"))
			{
				markCount++;
			}
		}
		if(markCount >= 3)
		{
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return (this.defline + "\n" + this.sequence + "\n" + "+" + "\n" + this.quality + "\n");
	}
}