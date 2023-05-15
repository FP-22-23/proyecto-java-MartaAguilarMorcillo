package fp.cars;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import fp.utiles.Checkers;

public class CocheImpl implements Coche{

	private String manufacturer;
	private Color color;
	private Double manufacturerPrice;
	private Boolean damagedVehicle;
	private Integer horsepower;
	private Measurements measurements;
	private LocalDate registrationDate;
	private List<String> characteristics;
	
	
	public CocheImpl(String manufacturer, Color color, Double manufacturerPrice, Boolean damagedVehicle,
			Integer horsepower, Measurements measurements, LocalDate registrationDate, List<String> characteristics) {
		
		Checkers.check("El fabricante no puede ser una cadena vacía", !manufacturer.isEmpty());
		Checkers.check("El precio puesto por el fabricante debe ser positivo", manufacturerPrice > 0.0);
		Checkers.check("La fecha debe ser igual o anterior a la de hoy", registrationDate.isBefore(LocalDate.now()));
		
		this.manufacturer = manufacturer;
		this.color = color;
		this.manufacturerPrice = manufacturerPrice;
		this.damagedVehicle = damagedVehicle;
		this.horsepower = horsepower;
		this.measurements = measurements;
		this.registrationDate = registrationDate;
		this.characteristics = characteristics;
	}


	public CocheImpl(String manufacturer, Color color, Double manufacturerPrice, Boolean damagedVehicle,
			Integer horsepower, LocalDate registrationDate) {
		
		Checkers.check("El fabricante no puede ser una cadena vacía", !manufacturer.isEmpty());
		Checkers.check("El precio puesto por el fabricante debe ser positivo", manufacturerPrice > 0.0);
		Checkers.check("La fecha debe ser igual o anterior a la de hoy", registrationDate.isBefore(LocalDate.now()));
		
		this.manufacturer = manufacturer;
		this.color = color;
		this.manufacturerPrice = manufacturerPrice;
		this.damagedVehicle = damagedVehicle;
		this.horsepower = horsepower;
		Measurements medidas = new Measurements(1.0, 50.0, 100.0);
		measurements = medidas;
		this.registrationDate = registrationDate;
		characteristics = new LinkedList<String>();
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		Checkers.check("El fabricante no puede ser una cadena vacía", !manufacturer.isEmpty());
		this.manufacturer = manufacturer;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Double getManufacturerPrice() {
		return manufacturerPrice;
	}


	public void setManufacturerPrice(Double manufacturerPrice) {
		Checkers.check("El precio puesto por el fabricante debe ser positivo", manufacturerPrice > 0.0);
		this.manufacturerPrice = manufacturerPrice;
	}


	public Boolean getDamagedVehicle() {
		return damagedVehicle;
	}


	public void setDamagedVehicle(Boolean damagedVehicle) {
		this.damagedVehicle = damagedVehicle;
	}


	public Integer getHorsepower() {
		return horsepower;
	}


	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}


	public Measurements getMeasurements() {
		return measurements;
	}


	public void setMeasurements(Measurements measurements) {
		this.measurements = measurements;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		Checkers.check("La fecha debe ser igual o anterior a la de hoy", registrationDate.isBefore(LocalDate.now()));
		this.registrationDate = registrationDate;
	}


	public List<String> getCharacteristics() {
		return characteristics;
	}


	public void setCharacteristics(List<String> characteristics) {
		this.characteristics = characteristics;
	}

	
	public EstadoCoche getEstadoCoche() {
		EstadoCoche res= EstadoCoche.MODERNO;
		if (registrationDate.getYear()<=2014) {
			res= EstadoCoche.ANTIGUO;
		}
		return res;
	}
	
	public Double getMarketPrice() {
		Double iva;
		if (getEstadoCoche().equals(EstadoCoche.ANTIGUO)) {
			iva=0.1;
		} else {
			iva=0.21;
		}
		Double marketPrice=getManufacturerPrice() + iva*getManufacturerPrice();
		return marketPrice;
	}

	public int hashCode() {
		return Objects.hash(characteristics, color, damagedVehicle, horsepower, manufacturer, measurements,
				registrationDate, manufacturerPrice);
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CocheImpl other = (CocheImpl) obj;
		return Objects.equals(characteristics, other.characteristics) && color == other.color
				&& Objects.equals(damagedVehicle, other.damagedVehicle) && Objects.equals(horsepower, other.horsepower)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(measurements, other.measurements)
				&& Objects.equals(registrationDate, other.registrationDate)
				&& Objects.equals(manufacturerPrice, other.manufacturerPrice);
	}


	public String toString() {
		return "CocheImpl [manufacturer=" + manufacturer + ", color=" + color + ", manufacturerPrice="
				+ manufacturerPrice + ", damagedVehicle=" + damagedVehicle + ", horsepower=" + horsepower
				+ ", measurements=" + measurements + ", registrationDate=" + registrationDate + ", characteristics="
				+ characteristics + ", getEstadoCoche()=" + getEstadoCoche() + ", getMarketPrice()=" + getMarketPrice()
				+ "]";
	}


	public int compareTo(Coche o) {
		int r;
		r=this.getHorsepower().compareTo(o.getHorsepower());
		if (r==0) {
			r=this.getRegistrationDate().compareTo(o.getRegistrationDate());
				if (r==0) {
					r=this.getMarketPrice().compareTo(o.getMarketPrice());
				}
		}
		return r;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
