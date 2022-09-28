
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
		
		int endIndex = dna.indexOf(stopCodon, startIndex + 3);
		while (endIndex != -1)
		{
		    if ((endIndex - startIndex) % 3 == 0)
		    {
			return endIndex;
			}
			endIndex = dna.indexOf(stopCodon, endIndex + 3);
		}
		return dna.length();
	}
	
	public String findGene(String dna, int Index) {
	    
		int startIndex = dna.toLowerCase().indexOf("atg", Index);
		
		if (startIndex == -1) {
			return "";
		}
		
		int endIndexTAA = findStopCodon(dna.toLowerCase(), startIndex, "taa");
		int endIndexTAG = findStopCodon(dna.toLowerCase(), startIndex, "tag");
		int endIndexTGA = findStopCodon(dna.toLowerCase(), startIndex, "tga");
		
		int endIndex = Math.min(endIndexTAA, Math.min(endIndexTAG, endIndexTGA));
		
		String result = ""; 
		if (endIndex != dna.length()) {
		    result = dna.substring(startIndex, endIndex + 3);
		}
		return result;
	}
	
	public void testFindStopCodon() {
		String dna = "cccatggggtttaaatgataataataggagagagagagagagttt";
		//String gen = "atggggtttaaataataatag";
		//String dna = "atgcctag";
		//String gen = "";
		//String dna = "ATGCCCTAG";
		//String gen = "ATGCCCTAG";
		
		
		
		
	}
	
	public void testFindGene()
	{
	    String dna = "cccatggggtttaaatgataataataggagatgagagagtaagagttt";
	    System.out.println("Dna: " + dna);
	    printAllGenes(dna);
	}
	
	public void printAllGenes(String dna)
	{
	    int startIndex = 0; 
	    while (true)
	    {
	        String gen = findGene(dna, startIndex);
	        
	        if (gen.isEmpty())
	        {
	            break;
	        }
	        System.out.println("Gen " + startIndex + ": " + gen);
	        startIndex = dna.indexOf(gen, startIndex) + gen.length();
	    }
	}
	
	public void realTesting() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			String s = fr.asString();
			System.out.println("read " + s.length() + " characters");
			//String result = findProtein(s);
			//System.out.println("found " + result);
		}
	}
}
