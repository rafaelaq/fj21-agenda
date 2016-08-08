package br.com.caelum.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataFormatada {

       	public static Calendar DataFormata(String data){
		  
		  try {
			  Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			  Calendar dataNascimento = Calendar.getInstance();
			  dataNascimento.setTime(date);
			  return dataNascimento;
		 } catch (java.text.ParseException e) {
			 throw new RuntimeException("Erro de conversão da data");
		 } 
	
      }
  }
