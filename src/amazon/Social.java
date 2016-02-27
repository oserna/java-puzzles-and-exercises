package amazon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Social {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] res;

		int _input_size = Integer.parseInt(in.nextLine());
		String[] _input = new String[_input_size];
		String _input_item;
		for (int _input_i = 0; _input_i < _input_size; _input_i++) {
			try {
				_input_item = in.nextLine();
			} catch (Exception e) {
				_input_item = null;
			}
			_input[_input_i] = _input_item;
		}

		res = graph(_input);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(String.valueOf(res[res_i]));
		}

	}

	static String[] graph(String[] input) {

		HashSet<String> friends = new HashSet<>();
		
		ArrayList<String> linesToPrint = new ArrayList<>();
		
		for (int i = 0; i < input.length; i++) {
			
			StringBuffer buff = new StringBuffer();
			
			String line = input[i];
			String[] split = line.split(":");
			if (!friends.contains(split[0])) {				
				friends.add(split[0]);
			}
			if (split.length > 1 && split[1] != null) {
				String[] friendNodes = split[1].split(",");
				for (int j = 0; j < friendNodes.length; j++) {
					String friendNode = friendNodes[j];
					if (!friends.contains(friendNode)) {
						friends.add(friendNode);
						buff.append(friendNode);
						buff.append(",");
					}
				}
			}
			
			String lineToPrint = buff.toString();
			if(lineToPrint != null && !lineToPrint.equals("")){				
				String finalLine = lineToPrint.substring(0, lineToPrint.length()-1);
				linesToPrint.add(finalLine);
			}
		}
		
		return linesToPrint.toArray(new String[linesToPrint.size()]);

	}

}
