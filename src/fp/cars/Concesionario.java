package fp.cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concesionario {
	
	private List<Coche> coches;

	public Concesionario() {
		this.coches = new ArrayList<Coche>();
	}

	public Concesionario(Collection<Coche> coches) {
		this.coches = new ArrayList<Coche>(coches);
	}
	
	public Concesionario(Stream<Coche> coches) {
		this.coches = coches.collect(Collectors.toList());
	}

	public int hashCode() {
		return Objects.hash(coches);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concesionario other = (Concesionario) obj;
		return Objects.equals(coches, other.coches);
	}

	public String toString() {
		return "Concesionario [coches=" + coches + "]";
	}
	
	public void creaListaCoches(String nombreFichero) {
		coches=FactoriaConcesionario.leerCoche(nombreFichero);
	}
	
	public List<Coche> getCoches(){
		return new ArrayList<Coche>(this.coches);
	}
	
	public Integer getNumeroCoches() {
		return Integer.valueOf(this.coches.size());
	}
	
	public void anadirCoche(Coche c) {
		this.coches.add(c);
	}
	
	public void anadirCoches(Collection<Coche> coleccionCoches) {
		this.coches.addAll(coleccionCoches);
	}
	
	public void eliminarCoche(Coche c) {
		this.coches.remove(c);
	}
	
	public Boolean existeCocheMarcaColorDados(String marca, Color color){
		//Este método devuelve un booleano indicando si alguno de los objetos de la clase Coche de la lista coches es de la marca y el color pasados por parámetros
		Boolean res=false;
		for(Coche c:coches) {
			if(c.getManufacturer().equals(marca) && c.getColor().equals(color)){
				res=true;
				break;
			}
		}
		return res;
	}
	
	public Double MediaPotenciaCochesAnyoDado(Integer anyo) {
		//Este método devuelve la media de la potencia que tienen todos los coches que se matricularon en el año pasado como parámetro
		Integer suma=0;
		Integer contador=0;
		for(Coche c:coches) {
			if(Integer.valueOf(c.getRegistrationDate().getYear()).equals(anyo)) {
				suma+=c.getHorsepower();
				contador++;
			}
		}
		Double res;
		if(contador.equals(0)) {
			res=null;
		}else {
			res=Double.valueOf(suma/contador);
		}
		return res;
	}
	
	
	public Set<Coche> getMonovolumenesMenorPrecio(Double precio){
		//Este método devuelve el conjunto de coches que son considerados monovolumenes y cuyo precio es menor que el pasado como parámetro
		Set<Coche> res= new HashSet<Coche>();
		for(Coche c:coches) {
			if(c.getMeasurements().tipoCoche().equals(TipoCoche.MONOVOLUMEN) && c.getManufacturerPrice()<=precio) {
				res.add(c);
			}
		}
		return res;	
	}
	
	
	public Map<String, List<Coche>> getListaCochesPorMarca(){
		//Este método devuelve un map en el que las claves son las distintas marcas de coches y los valores la lista de los coches que pertenecen a la marca pertinente
		Map<String, List<Coche>> res= new HashMap<String, List<Coche>>();
		for(Coche c:coches) {
			if(res.containsKey(c.getManufacturer())) {
				List<Coche> value=res.get(c.getManufacturer());
				value.add(c);
				res.put(c.getManufacturer(), value);
			}else {
				List<Coche> value=new ArrayList<Coche>();
				value.add(c);
				res.put(c.getManufacturer(), value);
			}
		}
		return res;
	}
	
	
	public Map<Color, Integer> getNumeroCochesPorColor(){
		//El método devuelve un map en el que las claves son los colores de coche y los valores el numero total de coches de dicho color
		Map<Color, Integer> res= new HashMap<Color, Integer>();
		for (Coche c:coches) {
			if(res.containsKey(c.getColor())) {
				Integer contador= res.get(c.getColor());
				contador++;
				res.put(c.getColor(),contador);
			}else {
				Integer contador=1;
				res.put(c.getColor(), contador);
			}
		}
		return res;
	}
	
	
	public Boolean existeCocheMarcaColorDadosStream(String marca, Color color){
		//Este método devuelve un booleano indicando si alguno de los objetos de la clase Coche de la lista coches es de la marca y el color pasados por parámetros
		return coches.stream()
				.anyMatch(c-> c.getManufacturer().equals(marca) && c.getColor().equals(color));
	}
	
	
	
	public Double MediaPotenciaCochesAnyoDadoStream(Integer anyo) {
		//Este método devuelve la media de la potencia que tienen todos los coches que se matricularon en el año pasado como parámetro
		return coches.stream()
				.filter(c-> Integer.valueOf(c.getRegistrationDate().getYear()).equals(anyo))
				.mapToInt(c->c.getHorsepower())
				.average()
				.orElse(0);
	}
	
	
	public Set<Coche> getMonovolumenesMenorPrecioStream(Double precio){
		//Este método devuelve el conjunto de coches que son considerados monovolumenes y cuyo precio es menor que el pasado como parámetro
		return coches.stream()
				.filter(c->c.getManufacturerPrice()<=precio && c.getMeasurements().tipoCoche().equals(TipoCoche.MONOVOLUMEN))
				.collect(Collectors.toSet());
	}
	
	
	public Coche getCocheNoAveriadoMarcaDadaMenorPrecioStream(String marca) {
		//Este método devuelve el coche que no esté averiado y que sea de la marca pasada como parámetro que menos cuesta, es decir, cuyo precio es menor
		return coches.stream()
				.filter(c-> c.getDamagedVehicle().equals(false) && c.getManufacturer().equals(marca))
				.min(Comparator.comparing(Coche::getManufacturerPrice))
				.orElse(null);
	}
	
	
	public List<String> getMarcasOrdenadasPorPreciosCochesMatriculadosDespuesAñoDadoStream(Integer anyo, Integer n){
		//Este método devuelve una lista ordenada por precios de las n marcas de los n coches matriculados después del año pasado por parámetro
		return coches.stream()
				.filter(c-> Integer.valueOf(c.getRegistrationDate().getYear())>=anyo)
				.sorted(Comparator.comparing(Coche::getManufacturerPrice))
				.limit(n)
				.map(c-> c.getManufacturer())
				.collect(Collectors.toList());
	}
	
	public Map<Color, Integer> getNumeroCochesPorColorStream(){
		//El método devuelve un map en el que las claves son los colores de coche y los valores el numero total de coches de dicho color
		return coches.stream()
				.collect(Collectors.groupingBy(Coche::getColor, Collectors.collectingAndThen(Collectors.counting(), l->l.intValue())));
	}
	
	public Map<TipoCoche, List<Integer>> getListaPotenciasPorCadaTipoDeCocheStream(){
		//El método devuelve un map en el que las claves son los distintos tipos de coches que hay y los valores una lista las potencias que tienen todos los coches que son de dicho tipo
		return coches.stream()
				.collect(Collectors.groupingBy(c->c.getMeasurements().tipoCoche(), Collectors.mapping(c->c.getHorsepower(), Collectors.toList())));
	}
	
	
	public Map<String, Coche> getCocheMenorPrecioPorMarcaStream(){
		//Este método devuelve un map en el que las claves son las distintas marcas de coche y los valores el coche de dicha marca con el menor precio de mercado
		return coches.stream()
				.collect(Collectors.groupingBy(c->c.getManufacturer(),
						Collectors.collectingAndThen(
								Collectors.minBy(Comparator.comparing(Coche::getMarketPrice)),opt -> opt.orElse(null))));
	}
	
	
	public SortedMap<Integer, Set<Double>> getListaNMayoresVolumenesDeCochePorAño(Integer n){
		//Este método devuelve un map en el que las claves son los años de matriculación de los coches y los valores una lista ordenada de los n mayores volumenes que tienen los coches matriculados ese año
		return coches.stream()
				.collect(Collectors.groupingBy(c->c.getRegistrationDate().getYear(), TreeMap:: new, Collectors.collectingAndThen(Collectors.toList(), lista-> faux(lista, n))));
	}
	
	
	private static Set<Double> faux(List<Coche> coches, Integer n){
		//Esta función auxiliar transforma una lista de coches en un conjunto de los n mejores volumenes de coches
		return coches.stream()
				.sorted(Comparator.comparing(c->c.getMeasurements().volumenCoche()))
				.limit(n)
				.map(c->c.getMeasurements().volumenCoche())
				.collect(Collectors.toSet());
	}
	
	
	public String getMarcaMayorPotenciaAcumulada() {
		//Este método devuelve la marca de coche que tiene una mayor potencia acumulada entre todos los coches de dicha marca
		Map <String, Integer> aux = coches.stream()
									.collect(Collectors.groupingBy(c-> c.getManufacturer(), Collectors.summingInt(c-> c.getHorsepower())));
		return aux.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
	}
	
	
	
	
	
	
	
	
	
	
	
}
