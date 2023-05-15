package fp.cars.test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import fp.cars.Coche;
import fp.cars.CocheImpl;
import fp.cars.Color;
import fp.cars.Concesionario;
import fp.cars.Measurements;

public class TestCoche {

	public static void main(String[] args) {
		List<Coche> listaCoches = new LinkedList<Coche>();
		Concesionario coches = new Concesionario(listaCoches);
		coches.creaListaCoches("data/carSales.csv");
		
		List<String> lista = new LinkedList<String>();
		List<Coche> coches2 = new LinkedList<Coche>();
		lista.add("techo solar");
		lista.add("GPS");
		Coche c1= new CocheImpl("Acura",Color.BLACK, 16919.5, false, 140, new Measurements(1.8, 67.3, 172.4), LocalDate.of(2014, 9, 20), lista);
		Coche c2= new CocheImpl("Acura",Color.WHITE, 16919.5, false, 150, new Measurements(1.8, 67.3, 172.4), LocalDate.of(2014, 9, 20), lista);
		coches2.add(c2);
		
		coches.anadirCoche(c1);
		coches.anadirCoches(coches2);
		
		System.out.println(coches.getCoches());
		System.out.println(coches.existeCocheMarcaColorDados("Acura", Color.BLACK));
		System.out.println(coches.MediaPotenciaCochesAnyoDado(2009));
		System.out.println(coches.getMonovolumenesMenorPrecio(12000.0));
		System.out.println(coches.getListaCochesPorMarca());
		System.out.println(coches.getNumeroCochesPorColor());
		System.out.println(coches.getNumeroCoches());
		System.out.println(coches.existeCocheMarcaColorDadosStream("Acura", Color.BLACK));
		System.out.println(coches.MediaPotenciaCochesAnyoDadoStream(2009));
		System.out.println(coches.getMonovolumenesMenorPrecioStream(12000.0));
		System.out.println(coches.getCocheNoAveriadoMarcaDadaMenorPrecioStream("Acura"));
		System.out.println(coches.getMarcasOrdenadasPorPreciosCochesMatriculadosDespuesAñoDadoStream(2014, 3));
		System.out.println(coches.getNumeroCochesPorColorStream());
		System.out.println(coches.getListaPotenciasPorCadaTipoDeCocheStream());
		System.out.println(coches.getCocheMenorPrecioPorMarcaStream());
		System.out.println(coches.getListaNMayoresVolumenesDeCochePorAño(2));
		System.out.println(coches.getMarcaMayorPotenciaAcumulada());
		

	}

}
