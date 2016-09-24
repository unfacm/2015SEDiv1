import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Scanner;



public class Simplicity {

	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		String testCase = input.nextLine();
		Hashtable<String,Symbol> dict = new Hashtable<String, Symbol>();
		for(char c : testCase.toCharArray()){
			String sample = ""+ c;
			if(dict.get(sample) != null){
				 Symbol oldSymbol = dict.get(sample);
				 //System.out.println("Symbol : "+oldSymbol.c+" - "+oldSymbol.counter);
				 oldSymbol.counter += 1;
				 //System.out.println("Symbol : "+dict.get(sample).c+" - "+dict.get(sample).counter);
			}
			else{
				dict.put(sample, new Symbol(sample));
			}
		}
		Collection<Symbol> listOfSymbols = dict.values();
		for(Symbol s : listOfSymbols){
			//System.out.println("Symbol : "+s.c+" - "+s.counter);
		}
		int simple = listOfSymbols.size();
		int removedCounter = 0; 
		while(simple > 2){
			int minSize = 100;
			for(Symbol s : listOfSymbols){
				if (s.counter < minSize)
					minSize = s.counter;
			}
			Symbol deleteThis = new Symbol();
			for(Symbol s : listOfSymbols){
				if (s.counter == minSize)
					deleteThis = s;
			}
			listOfSymbols.remove(deleteThis);
			removedCounter += 1;
			simple -= 1;
		}
		System.out.println(removedCounter);
	}

}

class Symbol{
	public int counter;
	public String c;
	Symbol(){
		this.counter = 1;
	}
	Symbol(String sym){
		this.counter = 1;
		c = sym;
	}
}
