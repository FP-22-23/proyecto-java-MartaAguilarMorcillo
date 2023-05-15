package fp.cars;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaConcesionario {
	
	public static List<Coche> leerCoche(String nombreFichero) {
		List<Coche> res=new ArrayList<Coche>();
		try {
			List<String> lineas=Files.readAllLines(Paths.get(nombreFichero));
			for(String linea:lineas) {
				try {
				res.add(parseaCoche(linea));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e) {
			System.out.println("No se ha encontrado el fichero "+nombreFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static Coche parseaCoche(String lineaCSV) {
		String[] campos=lineaCSV.split(",");
		Checkers.check("Error en la lectura", campos.length==10);
		String manufacturer=campos[0].trim();
		Color color=Color.parse(campos[1].trim().toUpperCase());
		//Color color=Color.valueOf(campos[1].trim().toUpperCase());
		Double manufacturerPrice=Double.parseDouble(campos[2].trim());
		Boolean damagedVehicle=parseoBoolean(campos[3].trim());
		Integer horsepower=Integer.valueOf(campos[4].trim());
		Double engineSize=Double.valueOf(campos[5].trim());
		Double width=Double.valueOf(campos[6].trim());
		Double length=Double.valueOf(campos[7].trim());
		Measurements measurements=new Measurements(engineSize, width, length);
		LocalDate registrationDate=LocalDate.parse(campos[8].trim(),DateTimeFormatter.ofPattern("d/M/y"));
		//String[] camposFecha=campos[8].trim().split("/");
		//LocalDate registrationDate=LocalDate.of(Integer.valueOf(camposFecha[0]), Integer.valueOf(camposFecha[1]), Integer.valueOf(camposFecha[2]));
		String[] camposLista=campos[9].trim().split("&");
		List<String> characteristics= new ArrayList<String>();
		for (String campo:camposLista) {
			characteristics.add(campo.trim());
		}
		
		Coche c= new CocheImpl(manufacturer, color, manufacturerPrice, damagedVehicle, horsepower, measurements, registrationDate, characteristics);
		return c;
	}
	
	private static Boolean parseoBoolean(String s) {
		Boolean res;
		if (s.equals("TRUE")) {
			res=true;
		}else {
			res=false;
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
}

