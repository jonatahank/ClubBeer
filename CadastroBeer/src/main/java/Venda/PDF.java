package Venda;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	
	public PDF(String paragrafo1, String paragrafo2, Object [][] produto, String nome,int valor) {

		Document pdf = new Document();
		Font f = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD);
		Font p = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
		try {
			/**
			 * Criando a instancia para referenciar onde o pdf vai ser craido
			 */
			
			PdfWriter
					.getInstance(pdf, new FileOutputStream("E:\\PDF\\"+nome+".pdf"));

			pdf.open();// abrindo
			pdf.setPageSize(PageSize.A4);// tamanho dp pdf
			pdf.setMargins(10, 10, 10, 10);
			// imagem
			Image img = Image
					.getInstance("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\nota.png");

			// set tamanho da imagem

			img.scaleToFit(550, 190);

			img.setAlignment(Image.ALIGN_LEFT);
			pdf.add(img);
			 
			
			// criando paragrafo
			Paragraph p1 = new Paragraph("Relatório de Vendas", f);
			// Setando o alinhamento p/ o centro
	        p1.setAlignment(Paragraph.ALIGN_CENTER);

	        // Definindo
	        p1.setSpacingAfter(20);
	        pdf.add(p1);
	        
//	        Paragraph p2 = new Paragraph("Club Beer", f);
//			// Setando o alinhamento p/ o centro
//	        p2.setAlignment(Paragraph.ALIGN_CENTER);
//	 
//	        // Definindo
//	        p2.setSpacingAfter(50);
//	        pdf.add(p2);
	        
	        Paragraph separar = new Paragraph("____________________________________________________", f);
			// Setando o alinhamento p/ o centro
	        separar.setAlignment(Paragraph.ALIGN_CENTER);
	 
	        // Definindo
	        separar.setSpacingAfter(20);
	        pdf.add(separar);
	        
	        Paragraph p3 = new Paragraph("Cliente : " + paragrafo1, p);
			// Setando o alinhamento p/ o centro
	        p3.setAlignment(Paragraph.ALIGN_LEFT);
	 
	        // Definindo
	        p3.setSpacingAfter(20);
	        pdf.add(p3);
	        
	        Paragraph separar1 = new Paragraph("____________________________________________________", f);
			// Setando o alinhamento p/ o centro
	        separar1.setAlignment(Paragraph.ALIGN_CENTER);
	 
	        // Definindo
	        separar1.setSpacingAfter(20);
	        pdf.add(separar1);
	        
	        Paragraph p4 = new Paragraph("Vendedor : " + paragrafo2, p);
			// Setando o alinhamento p/ o centro
	        p4.setAlignment(Paragraph.ALIGN_LEFT);
	 
	        // Definindo
	        p4.setSpacingAfter(50);
	        pdf.add(p4);
	        
	        Paragraph separar2 = new Paragraph("____________________________________________________", f);
			// Setando o alinhamento p/ o centro
	        separar2.setAlignment(Paragraph.ALIGN_CENTER);
	 
	        // Definindo
	        separar2.setSpacingAfter(20);
	        pdf.add(separar2);
	        
	        boolean parar = true;
	        int i=0;
	        
	        Paragraph produtos = new Paragraph("Produtos",f);
	        produtos.setAlignment(Paragraph.ALIGN_LEFT);
	        produtos.setSpacingAfter(50);
	       pdf.add(produtos);
	        
	 while(parar){
		
	       if(produto[i][0] != null){
	    	   
	    	   Paragraph p6 = new Paragraph(produto[i][0] + "  ", p);
				// Setando o alinhamento p/ o centro
		        p6.setAlignment(Paragraph.ALIGN_LEFT);
        
		        // Definindo
		       p6.setSpacingAfter(10);
		        pdf.add(p6);   
	       }else{
	    	   parar = false;
	       }
	       i++;
	        	
			}
	 char[] letras = null;  
	 String palavra = "Java";  
	   
	 letras = palavra.toCharArray();  
	 // feito isso em letras vc ter�:  
	 // letras[0] = 'J';  
	 // letras[1] = 'a';  
	 // letras[2] = 'v';  
	 // letras[3] = 'a';  
	// System.out.println("quantidade de letras: " + letras.length);
	 

	 String v = NumberFormat.getCurrencyInstance().format(valor);
	 
	 Paragraph p5 = new Paragraph("Valor total : " + v, f);
		// Setando o alinhamento p/ o centro
     p5.setAlignment(Paragraph.ALIGN_RIGHT);

     // Definindo
     p5.setSpacingAfter(50);
     pdf.add(p5);
     
     Image code = Image
				.getInstance("C:\\Users\\Andriotti\\Desktop\\Algoritmo\\code.png");

		// set tamanho da imagem

		code.scaleToFit(310, 77);

		code.setAlignment(Image.ALIGN_LEFT);
		pdf.add(code);
	        

//	 
//	        List<String> list = new ArrayList<String>();
//	 
//	        Object[][] produto = tabelaProdutos;
//	        
//	       // list.add(paragrafo3);
////	        list.add("Testando linha 1, coluna 2");
////	        list.add("Testando linha 1, coluna 3");
////	        list.add("Testando linha 2, coluna 1");
////	        list.add("Testando linha 2, coluna 2");
////	        list.add("Testando linha 2, coluna 3");
////	        list.add("Testando linha 3, coluna 1");
////	        list.add("Testando linha 3, coluna 2");
////	        list.add("Testando linha 3, coluna 3");
//	 
//	        for (int i =0;i< produto.length;i++) {
//	            table.addCell(paragrafo2);
//	        }
//	 
//	        pdf.add(table);

			// paragra 1

			pdf.newPage();// nova pagina // nova pagina
			// pdf.add(new Paragraph("2� paragrafo"));// 2 paragrafo

			// add img ao pdf

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			pdf.close();
		}
	}
}
