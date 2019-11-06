package datastructure.hash;

public class HashTableTest {

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.put("4", 40);
		ht.put("6", 60);
		ht.put("7", 70);
		ht.put("8", 80);
		ht.put("9", 90);
		ht.put("5", 50);
		System.out.println(ht.keyExists("2"));
		System.out.println(ht.keyExists("4"));
		System.out.println(ht.get(2));
	}
	
}
