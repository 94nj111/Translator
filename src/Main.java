import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Dictionary enua = new Dictionary();
		File file = new File("dictionary.txt");
		try {
			enua.loadDictionary(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enua.addWord("ass", "жопа");

		File to = new File("toTranslate.txt");
		try {
			enua.tarnslateFile(to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			enua.saveDictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
