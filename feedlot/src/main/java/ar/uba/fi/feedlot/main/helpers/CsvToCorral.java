package ar.uba.fi.feedlot.main.helpers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ar.uba.fi.feedlot.main.*;

public class CsvToCorral {

	    public static ArrayList<Corral> getCorralesFromCsv(String csvFile) {
	        String line = "";
	        ArrayList <Corral> listaCorrales = new ArrayList <Corral>();
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        	
	            while ((line = br.readLine()) != null) {

	                String[] lineaCorral = line.split(";");

	                
	                int cabezas = Integer.parseInt(lineaCorral[0]);
	                int dia= Integer.parseInt(lineaCorral[1]); 
	                double pesoInicial = Double.parseDouble(lineaCorral[2]); 
	                int temperatura = Integer.parseInt(lineaCorral[3]);
	                Corral c = new Corral(cabezas,dia,pesoInicial,temperatura);
	                listaCorrales.add(c);
	            }

	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
            return listaCorrales;
	    }

	}
