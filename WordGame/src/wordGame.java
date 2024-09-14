import java.io.*;
import java.util.*;

public class wordGame {

	String[] words;
	boolean outcome;
	boolean continueORtermiate;
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordGame game = new wordGame();
		game.words = new String[]{"empathy"};
		game.continueORtermiate = true;
		while(game.continueORtermiate) {
			game.Application();
		}
		System.out.println("Game Over");
		
	}
	
	void gameStart(String word) {
		outcome = false;
		for(int x = 0; x < words.length; x++) {
			if(words[x].equals(word)) {
				outcome = true;
				gameRestart(word);
			}
		}
		
		if(word.charAt(0) == words[words.length-1].charAt(words[words.length-1].length()-1)) {
			wordValid(word);
		}else {
			System.out.println("Entered word is invalid or does not exist in the dictionary, please try again");
		}
	}
	
	void wordValid(String word) { 
		
		String line = "";
		boolean valid = false;
		FileReader fr;
		try {
			fr = new FileReader("dictionary.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				String[] dictionary = line.split(" ");
				
				
				for(int x = 0; x < dictionary.length; x++) {
					if(word.equals(dictionary[x])) {
						valid = true;
					}
				}
		
			}
			
			br.close();
			if(valid) {
				gameRestart(word);
			}else {
				System.out.println("Entered word is invalid or does not exist in the dictionary, please try again");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
	
	void gameRestart(String word) {
		if(outcome == true) {
			continueORtermiate = false;
		}else {
			String[] newWords = new String[words.length + 1];
			
			for(int x = 0; x < words.length; x++) {
				newWords[x] = words[x];
			}
			newWords[newWords.length-1] = word;
			
			words = newWords;
		}
	}
	
	void Application() {
		System.out.println("The current words are: ");
		for(int x = 0; x < words.length; x++) {
			System.out.print(words[x] + " ");
		}
		System.out.println("");
		System.out.println("Type in a new word (Case sensitve) such as empathy-yet-top");

		String word = scan.nextLine();
		if(word.isEmpty()) {
			System.out.println("Word is empty. Try again");
		}else {
			gameStart(word);
		}
		
	}

}
