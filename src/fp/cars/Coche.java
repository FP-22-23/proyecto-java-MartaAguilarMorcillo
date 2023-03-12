package fp.cars;

import java.time.LocalDate;
import java.util.List;

public interface Coche extends Comparable<Coche>{
	public String getManufacturer();
	public void setManufacturer(String manufacturer);
	public Color getColor();
	public void setColor(Color color);
	public Double getManufacturerPrice();
	public void setManufacturerPrice(Double manufacturerPrice);
	public Boolean getDamagedVehicle();
	public void setDamagedVehicle(Boolean damagedVehicle);
	public Integer getHorsepower();
	public void setHorsepower(Integer horsepower);
	public Measurements getMeasurements();
	public void setMeasurements(Measurements measurements);
	public LocalDate getRegistrationDate();
	public void setRegistrationDate(LocalDate registrationDate);
	public List<String> getCharacteristics();
	public EstadoCoche getEstadoCoche();
	public Double getMarketPrice();
}
