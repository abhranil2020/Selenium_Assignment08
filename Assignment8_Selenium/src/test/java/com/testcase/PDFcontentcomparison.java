package com.testcase;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.*;


public class PDFcontentcomparison {

	@Test	
	public void PDFcomparetext() throws Exception  {
		
    	/************ Actual PDF load & Read **********************/
    
    	File file = new File("D:\\Selenium\\Assignment8_Selenium\\PDFile\\Testng_quick_guide-actual.pdf");
    	PDDocument document2 = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper2 = new PDFTextStripper();
        //Retrieving text from PDF document
        String text = pdfStripper2.getText(document2);
        // System.out.println(text);       
        //Closing the document
        document2.close();
    	 	
        /************ Expected PDF load & Read **********************/
        
    	URL url=new URL("https://www.tutorialspoint.com/testng/pdf/testng_quick_guide.pdf");	
    	InputStream is =url.openStream();	
    	BufferedInputStream filepar=new BufferedInputStream(is);
    	PDDocument document=null;
    	document=PDDocument.load(filepar);
    	String PDFContent =new PDFTextStripper().getText(document);
    	
    	
    	/************ File Write **********************************/
    	
    	String filename= ".\\PDFile\\ExpectedPDFContent.txt";
    	String filename2= ".\\PDFile\\ActualPDFContent.txt";

	
    	FileWriter fw = new FileWriter(filename); 
    	FileWriter fw1 = new FileWriter(filename2);
	
    	BufferedWriter Brr=new BufferedWriter(fw);
    	BufferedWriter Brr1=new BufferedWriter(fw1);
    
    	Brr.write(PDFContent);
    	Brr1.write(text);
    
  
    	/************ File Write & Compare 2 Text File**********************************/
    	BufferedReader br1 = null;
    	BufferedReader br2 = null;
    	String sCurrentLine;
    	List<String> list1 = new ArrayList<String>();
    	List<String> list2 = new ArrayList<String>();
    
    	br1 = new BufferedReader(new FileReader(filename));
    	br2 = new BufferedReader(new FileReader(filename2));
   
    
    	while ((sCurrentLine = br1.readLine()) != null) {
        list1.add(sCurrentLine);
    	}
    	while ((sCurrentLine = br2.readLine()) != null) {
        list2.add(sCurrentLine);
    	}
    
    
    	List<String> tmpList = new ArrayList<String>(list1);
    	tmpList.removeAll(list2);
    
    
    	System.out.println("Content from Expected.txt which is not there in ActualText.txt");
    	System.out.println("================================================================");
    
    	for(int i=0;i<tmpList.size();i++){
    		System.out.println(tmpList.get(i)); //content from test.txt which is not there in test2.txt       
    		             
        }             
    }   
}
