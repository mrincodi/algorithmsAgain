package other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class NearbyWordsFB {
	String DICT_FILE = "dictionary.txt";

	HashMap <Character, ArrayList <Character>> neighbors = new HashMap <Character, ArrayList <Character>> ();
	HashSet <String> dict = new HashSet <String> ();

	public NearbyWordsFB() throws IOException{

		File file = new File( DICT_FILE);
		if ( !file.exists()){
			System.out.println("Wait. Downloading dictionary.");
			URL website = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("dictionary.txt");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		}

		//Fill up the dictionary HashSet.
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				dict.add(line);
				//System.out.println(line);
			}
		}

		//Fill up the neighbors hashMap.
		String line1="qwertyuiop";
		String line2="asdfghjkl";
		String line3="zxcvbnm";

		char [] array1 = line1.toCharArray();
		char [] array2 = line2.toCharArray();
		char [] array3 = line3.toCharArray();

		char [][] qwerty = new char [3][10];

		for ( int j = 0; j < 10; j++){
			qwerty[0][j] = array1[j];
			qwerty[1][j] = j >= line2.length()?'.':array2[j];
			qwerty[2][j] = j >= line3.length()?'.':array3[j];
		}

		//Now, fill the HashMap.
		for (int i = 0; i < 3; i++){
			for (int j=0;j<10;j++){
				char letter = qwerty [i][j];
				if ( letter == '.' ) continue;
				neighbors.put(letter, new ArrayList<Character>());
				for ( int k = i-1 ; k <= i+1; k++ ){
					if ( k >=0 && k <=2){
						for (int l = j-1; l <= j+1; l++){
							if (l >=0 && l < 10 ){
								char neighbor = qwerty[k][l];
								if (neighbor != '.'){
									neighbors.get(letter).add(neighbor);
								}
							}
						}
					}
				}
			}
		}
	}

	public ArrayList <Character> getNearbyChars (char c){
		return neighbors.get(c);
	}

	public boolean isWord (String word){
		return dict.contains(word);
	}

	public ArrayList <String> getNearbyWords (String s){
		ArrayList <String> result = new ArrayList <String> ();
		if ( s.length() == 0 ) return result;
		result = getNearbyWords (s, 0);
		Collections.sort(result);
		return result;
	}

	private ArrayList<String> getNearbyWords(String s, int i) {
		ArrayList<String> result = new ArrayList<String> ();
		if ( i == s.length() ){
			if (isWord (s)) 
				return new ArrayList <String> (Arrays.asList(s));
			else
				return result;
		}

		for ( char c: getNearbyChars(s.charAt(i))){
			String s2 = s.substring(0,i) + c + s.substring(i+1);
			result.addAll(getNearbyWords(s2, i+1));
		}

		return result;
	}

	public static void main ( String [] args ) throws IOException{
		String word = "hello";
		ArrayList<String> nearbyWords = new NearbyWordsFB().getNearbyWords(word);
		for ( String w:nearbyWords){
			System.out.println(w);
		}
	}
}
