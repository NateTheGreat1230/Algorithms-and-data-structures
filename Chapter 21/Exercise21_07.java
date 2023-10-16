import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		List<Map.Entry<String, Integer>> set = new ArrayList<> (map.entrySet());
		ArrayList<WordOccurrence> wordOccurrences = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : set) {
			wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()) {
			});
		}
		set.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()) == 0 ? entry1.getKey().compareTo(entry2.getKey()) : entry1.getValue().compareTo(entry2.getValue()));
		for (Map.Entry<String, Integer> entry : set) {
			System.out.println(entry.getValue()+", "+ entry.getKey());
		}
	}
}
class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	int count;
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	@Override
	public String toString() {
		return "occurrence{"+"word= '"+word+", count= "+count+'}';
	}
	 @Override
	 public int compareTo(WordOccurrence o) {
		 if (this.count > o.count){
			 return 1;
		 } else if (this.count == o.count) {
			 return 0;
		 } else {
			 return -1;
		 }
	 }
 }