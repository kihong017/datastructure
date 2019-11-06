package datastructure.hash;

/*
 * Originally from Linkedin Learning
 * By Raghavendra Dixit
 */
public class HashTable {
	
	private static final int TABLE_SIZE = 100;
	private Record[] tableData = new Record[TABLE_SIZE]; // Assuming there won't be more than 100 records
	
	public void put(Object key, Object value) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (!isEmpty(slot)) {
			slot = hash(keyCode, ++step);
		}
		tableData[slot] = new Record(key, value);
	}
	
	public boolean keyExists(Object key) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (tableData[slot] != null && !tableData[slot].getKey().equals(key)) {
			slot = hash(keyCode, ++step);
		}
		if (tableData[slot] != null) return true;
		return false;
	}
	
	public Object get(Object key) {
		int keyCode = key.hashCode();
		int step = 0;
		int slot = hash(keyCode, step);
		while (tableData[slot] != null && !tableData[slot].getKey().equals(key)) {
			slot = hash(keyCode, ++step);
		}
		if (tableData[slot] != null) return tableData[slot].getData();
		return null;
	}
	
	private int hash(int key, int step) {
		if (step == 0)
			return key % TABLE_SIZE;
		return (key % TABLE_SIZE + step*step) % TABLE_SIZE;
	}
	
	private boolean isEmpty(int slot) {
		return tableData[slot] == null;
	}
	
	private class Record {
		Object key;
		Object data;
		
		public Record(Object key, Object data) {
			this.key = key;
			this.data = data;
		}
		
		public Object getKey() {
			return this.key;
		}
		
		public Object getData() {
			return this.data;
		}
	}
	
}
