package fp.cars.test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fp.cars.Coche;
import fp.cars.CocheImpl;
import fp.cars.Color;
import fp.cars.Measurements;

public class TestCoche {

	public static void main(String[] args) {
		Measurements medidas = new Measurements(1.8, 67.3, 172.4);
		LocalDate f1=LocalDate.of(2014, 9, 20);
		LocalDate f2=LocalDate.of(2015, 4, 3);
		LocalDate f3=LocalDate.of(2025, 1, 1);
		List<String> lista = new LinkedList<String>();
		lista.add("techo solar");
		lista.add("GPS");
		Coche c1= new CocheImpl("Acura",Color.BLACK, 16919.5, false, 140, medidas, f1, lista);
		Coche c2= new CocheImpl("Audi",Color.GREY, 20397.6, true, 150, f2);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.getMeasurements().engineSize());
		c2.setManufacturerPrice(3000.0);
		System.out.println(c2.getMarketPrice());
		System.out.println(c1.getEstadoCoche());
		System.out.println(c1.equals(c2));
		
		int r= c1.compareTo(c2);
		if (r==0) {
			System.out.println("c1 y c2 son iguales");
		}else if (r<0) {
			System.out.println("c1 está antes en el orden que que c2");
		}else {
			System.out.println("c1 está después en el orden que que c2");
		}

		try {
			Coche c3= new CocheImpl("",Color.BLACK, 16919.5, false, 140, medidas, f1, lista);
			System.out.println(c3);
		}catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada: La cadena con el nombre del fabricante está vacía");
		}
		try {
			Coche c4= new CocheImpl("Acura",Color.BLACK, -1.5, false, 140, medidas, f1, lista);
			System.out.println(c4);
		}catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada: El precio del coche es un número negativo");
		}
		try {
			Coche c5= new CocheImpl("Acura",Color.BLACK, 16919.5, false, 140, medidas, f3, lista);
			System.out.println(c5);
		}catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada: La fecha de matriculación es anterior a la fecha actual");
		}
		
		
		
		
		
		
		
		

	}

	
}
