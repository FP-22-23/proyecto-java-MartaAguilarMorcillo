package fp.cars;

public enum Color {
	BLACK, WHITE, RED, BLUE, GREY;
	
	 public static Color parse(String text){
	        if(BLACK.name().equalsIgnoreCase(text)){
	            return BLACK;
	        } else if(WHITE.name().equalsIgnoreCase(text)){
	            return WHITE;
	        }else if(RED.name().equalsIgnoreCase(text)) {
	        	return RED;
	        }else if(BLUE.name().equalsIgnoreCase(text)) {
	        	return BLUE;
	        }else {
	        	return GREY;
	        }
	    }
	
}
