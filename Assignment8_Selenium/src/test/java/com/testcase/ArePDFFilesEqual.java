package com.testcase;

import org.testng.annotations.Test;
import de.redsix.pdfcompare.PdfComparator;


public class ArePDFFilesEqual {
	
	@Test	
	public void PDFcomparecontent() throws Exception  {	
		
	String PDFfile1=".\\PDFile\\Selenium-Actual.pdf";
	String PDFfile2=".\\PDFile\\Selenium-Expected.pdf";	
	String Result= ".\\PDFile\\Resultfile\\results";
	
    boolean isEquals = new PdfComparator(PDFfile1, PDFfile2).compare().writeTo(Result);
		
	System.out.println("=================Process Completed=================");

	if (!isEquals) {
	    System.out.println("PDF content differences found!");
	}	
	else 
	{
		System.out.println(" PDF content differences NOT found!");
		
	}				

}
	
}
