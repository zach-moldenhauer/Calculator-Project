import java.util.ArrayList;


public class Calculator {
    
	
	private ArrayList<String> cache;
	
	
	public Calculator() throws NumberFormatException {
	    cache = new ArrayList<String>();
	}
	
	public void addToCache(String x){
		this.cache.add(x);
	}
	
	public double add(String varOne, String varTwo) {
	    return Double.parseDouble(varOne) + Double.parseDouble(varTwo);
	}
	
	public double subtract(String minuend, String subtrahend) {
		return Double.parseDouble(minuend) - Double.parseDouble(subtrahend);
	}
	
	public double multiply(String varOne, String varTwo) {
		return Double.parseDouble(varOne) * Double.parseDouble(varTwo);
	}
	
	public double divide(String dividend, String divisor) {
		return Double.parseDouble(dividend) / Double.parseDouble(divisor);
	}
	
	public void clear() {
		this.cache.clear();
	}
	
	public double equals() {
		double answer = 0;
	    
		
			
		for(int i = 0; i < this.cache.size(); i++){
			if(cache.get(i).equals("+")){
				answer += add(getFullNumberBackward(i - 1), getFullNumberForward(i + 1));
				clear();
				addToCache(String.valueOf(answer));
				
			} else if(cache.get(i).equals("-")){
				answer += subtract(getFullNumberBackward(i - 1), getFullNumberForward(i + 1));
				clear();
				addToCache(String.valueOf(answer));
				
			} else if(cache.get(i).equals("*")){
				answer += multiply(getFullNumberBackward(i - 1), getFullNumberForward(i + 1));
				clear();
				addToCache(String.valueOf(answer));
				
			} else if(cache.get(i).equals("/")){
				answer += divide(getFullNumberBackward(i - 1), getFullNumberForward(i + 1));
				clear();
				addToCache(String.valueOf(answer));
				
			} 
		}
		
		return answer;
	
	}
	
	//Helper Methods: Collect a String numbers before and after the operator
	
	public String getFullNumberForward(int index){
		String bigNumber = "";
		
		for(int i = index; i < cache.size(); i++){
			
			if(!cache.get(i).equals("+") || !cache.get(i).equals("-") || !cache.get(i).equals("*") || !cache.get(i).equals("/")){
				
			    bigNumber += cache.get(i);
				
			} else{
				
				return bigNumber;
			
			}
	    }
		
		return bigNumber;
		
	}
	
	public String getFullNumberBackward(int index){
		String bigNumber = "";
		
		for(int i = 0; i <= index; i++){
			
			if(!cache.get(i).equals("+") || !cache.get(i).equals("-") || !cache.get(i).equals("*") || !cache.get(i).equals("/")){
				
			    bigNumber += cache.get(i);
				
			} else{
				
				return bigNumber;
			
			}
	    }
		/*
		String flippedNumber = "";
		
		for(int i = 0; i < bigNumber.length(); i++){
			
			//Check for length test
			
			//System.out.println(bigNumber.length() - i);
		    //System.out.println(bigNumber.length() - (i + 1));
			
			flippedNumber += bigNumber.substring(bigNumber.length() - (i + 1) , bigNumber.length() - i); 
			System.out.println("Flip: " + flippedNumber);
			
		}
		
		return flippedNumber;
		*/
		
		return bigNumber;
		
	}
}