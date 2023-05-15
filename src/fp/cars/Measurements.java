package fp.cars;

public record Measurements(Double engineSize, Double width, Double length) {
	
	public int compareTo(Measurements m) {
		int r;
		r=this.engineSize().compareTo(m.engineSize());
		if (r==0) {
			r=this.length().compareTo(m.length());
				if (r==0) {
					r=this.width().compareTo(m.width());
				}
		}
		return r;
	}
	
	
	public Double volumenCoche() {
		Double alturaVehiculo=1.5;
		Double volumen=alturaVehiculo*this.width()*this.length();
		return volumen;
	}
	
	public TipoCoche tipoCoche() {
		TipoCoche res;
		if(this.volumenCoche()<=11.0) {
			res=TipoCoche.TURISMO;
		}else if(this.volumenCoche()>11.0 && this.volumenCoche()<=14.0 && this.engineSize()>3.0) {
			res=TipoCoche.DEPORTIVO;
		}else if (this.volumenCoche()>14.0 && this.engineSize()<=3.0){
			res=TipoCoche.MONOVOLUMEN;
		}else{
			res=TipoCoche.TODOTERRENO;
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
