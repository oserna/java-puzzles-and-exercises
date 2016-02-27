package amazon;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;


public class Grades {
	
//	public static void main(String[] args) throws IOException{
//        Scanner in = new Scanner(System.in);
//        String[] res;
//        
//        int _grades_size = Integer.parseInt(in.nextLine());
//        String[] _grades = new String[_grades_size];
//        String _grades_item;
//        for(int _grades_i = 0; _grades_i < _grades_size; _grades_i++) {
//            try {
//                _grades_item = in.nextLine();
//            } catch (Exception e) {
//                _grades_item = null;
//            }
//            _grades[_grades_i] = _grades_item;
//        }
//        
//        res = grade(_grades);
//        for(int res_i=0; res_i < res.length; res_i++) {
//        	System.out.println(String.valueOf(res[res_i]));
//        }
//    }
	
	public static void main(String[] args) {
		
		String line1 = "Foo,Bar,79,81,98,40,85";
		String line2 = "Baz,Quux,90,90,90,90";
		
		String[] grade = grade(new String[]{line1, line2});
		for (int i = 0; i < grade.length; i++) {
			System.out.println(grade[i]);
			
		}
	}
	
    static String[] grade(String[] grades) {
    	
    	Map<String, int[]> gradesMap = createGrades();

    	TreeMap<Integer, String> linesToPrint = new TreeMap<>();

    	for (int i = 0; i < grades.length; i++) {
    		
    		StringBuffer buff = new StringBuffer();
    		
			String inputLine = grades[i];
			String[] rawStudent = inputLine.split(",");
			
			//normalization
			int [] valuesToAverage = new int[]{0,0,0,0,0}; 			
			for (int j = 0; j < rawStudent.length; j++) {
				String value = rawStudent[j].trim();
				if (j <= 1) {
					buff.append(value);
					buff.append(",");
					continue;
				}
				valuesToAverage[j-2] = Integer.parseInt(value);
			}
			
			//average
            int sum = 0;
            for (int j = 0; j < valuesToAverage.length; j++) {
				sum = sum + valuesToAverage[j];
				
			}
            double average = sum / valuesToAverage.length;
            
            //round up
            double roundedUp = Math.ceil(average);
            int finalAverage = new Double(roundedUp).intValue();
            buff.append(Integer.toString(finalAverage));
			buff.append(",");
            
			//the grade
            Set<Entry<String, int[]>> entrySet = gradesMap.entrySet();
            for (Entry<String, int[]> entry : entrySet) {
				int[] js = entry.getValue();
            	if (roundedUp <= js[0] && roundedUp >= js[1]) {
            		buff.append(entry.getKey());
					buff.append(",");
            	}
			}
            
            //the values
            Arrays.sort(valuesToAverage);
            for (int j = 0; j < valuesToAverage.length; j++) {
				int k = valuesToAverage[j];
				buff.append(Integer.toString(k));
				buff.append(",");
			}
            
            //append the line
			String lineToPrint = buff.toString();
			String finalLine = lineToPrint.substring(0, lineToPrint.length()-1);
			linesToPrint.put(finalAverage,finalLine);

		}
    	
    	NavigableMap<Integer, String> descendingMap = linesToPrint.descendingMap();
    	Collection<String> values = descendingMap.values();
    	String[] array = values.toArray(new String[values.size()]);
    	return array;

    }
    
    public static Map<String, int[]> createGrades(){
    	
    	return new HashMap<String, int[]>(){{
    		put("A" , new int[]{100,93});
    		put("A-", new int[]{92,90});
    		put("B+", new int[]{89,87});
    		put("B" , new int[]{86,83});
    		put("B-", new int[]{82,80});
    		put("C+", new int[]{79,77});
    		put("C" , new int[]{76,73});
    		put("C-", new int[]{72,70});
    		put("D+", new int[]{69,67});
    		put("D" , new int[]{66,63});
    		put("D-", new int[]{62,60});
    		put("F" , new int[]{59,0});
    	}};
    	
    }

}
