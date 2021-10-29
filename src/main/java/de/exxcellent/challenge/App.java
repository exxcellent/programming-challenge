
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Challenge {
	
	//Execute
	
	public static void main(String[] args) throws IOException {
		
  		Challenge object = new Challenge();

  		object.outputData(pl, 5, 6);
	
}


	//Variables
	
	//Columns 1(MaxT) and 2(MinT)
	static String weather = "/Users/Robin/Desktop/programming-challenge-challenge-weatherdata/src/main/resources/de/exxcellent/challenge/weather.csv";
	
	//Columns 5(Goals Scored) and 6(Goals conceded)
	static String pl = "/Users/Robin/Desktop/programming-challenge-challenge-weatherdata/src/main/resources/de/exxcellent/challenge/football.csv";
	
	String dataList[] = null;
	
	int max = 0;
	int min = 100;
	int minDiff = 100;
	int diff;
	
	String line = "";
	String maxTarget = "";
	String minTarget = "";
	String diffTarget = "";

	
	
	//Functions
	
	
	
	public void outputData (String path, int maxColumn, int minColumn) throws IOException {
		
		
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path)); //Declaring CSV Reader
			
			br.readLine();
			
			
		    while((line = br.readLine()) != null) {
		     
		    	dataList = line.split(","); //Splitting each Value within String by "," in Order to fit them into Array
		    	
		    	diff = Integer.parseInt(dataList[maxColumn])-Integer.parseInt(dataList[minColumn]);
		    	
		    	
		    	if (diff >= 0) { //Positive Difference?
		    	    if(diff < minDiff) {
		    		   minDiff = diff;
		               max = Integer.parseInt(dataList[maxColumn]);
		               min = Integer.parseInt(dataList[minColumn]);
		    		   diffTarget = dataList[0];
		    		}
		    	}else { //Negative Difference?
		    		
		    		diff = diff + diff*(-2);
		    		
		    		if(diff < minDiff) {
		    			minDiff = diff;
			               max = Integer.parseInt(dataList[maxColumn]);
			               min = Integer.parseInt(dataList[minColumn]);
			    		   diffTarget = dataList[0];
		    		}
		    	}
		    	/*
		    	else if(Integer.parseInt(dataList[1]) > max) {
		    		max = Integer.parseInt(dataList[1]);
		    		maxTarget = dataList[0];
		    	}
		    	else if(Integer.parseInt(dataList[2]) < min) {
		    		min = Integer.parseInt(dataList[2]);
		    		minTarget = dataList[0];
		    	}*/
		     
		    }
            System.out.println(diffTarget + " " + max + " " + min);
			
		} catch (FileNotFoundException e) {
			System.out.println("Can not read Data");
		}
		
	}
	
	
	
	
	
}
