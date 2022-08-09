import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<String, String> word = new HashMap<>();

	public Dictionary(Map<String, String> word) {
		super();
		this.word = word;
	}
	

	public Dictionary() {
		super();
	}


	public Map<String, String> getWord() {
		return word;
	}

	public void setWord(Map<String, String> word) {
		this.word = word;
	}

	public void addWord() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input word: ");
			String word = sc.nextLine();
			System.out.println("Input word's translation: ");
			String trans = sc.nextLine();
			this.getWord().put(word, trans);
		}
	}
	
	public void addWord(String word, String trans) {
			this.getWord().put(word, trans);
	}

	public void loadDictionary(File file) throws FileNotFoundException {
		try (Scanner sc = new Scanner(file, "UTF-8")) {
			for (; sc.hasNextLine();) {
				String[] word = sc.nextLine().toLowerCase().split("_");
				this.getWord().put(word[0], word[1]);
			}
		}
	}

	public void tarnslateFile(File from) throws IOException {
		try (Scanner sc = new Scanner(from)) {
			String save = "";
			for (; sc.hasNextLine();) {
				save += translateString(sc.nextLine()) + System.lineSeparator();
			}
			saveTo(save);
		}
	}

	private String translateString(String toTranslate) {
		String translate = "";
		String[] key = toTranslate.toLowerCase().split(" ");
		for (int i = 0; i < key.length; i++) {
			translate += this.getWord().get(key[i]) + " ";
		}
		return translate;
	}

	private void saveTo(String toSave) throws IOException {
		File to = new File("Переклад.txt");
		to.createNewFile();
		try (PrintWriter pw = new PrintWriter(to)) {
			pw.println(toSave);
		}
	}
	
	public void saveDictionary () throws IOException {
		File dictionary = new File("Dictionary1.txt");
		dictionary.createNewFile();
		try (PrintWriter pw = new PrintWriter(dictionary)) {
			for(String key : this.getWord().keySet()) {
				pw.println(key + " _ " + this.getWord().get(key));
			}
		}
		
	}

}
