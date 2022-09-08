package nestedClasses;
/** The class that represents a Hash Map. Demonstrates the use of a static class.
 *  Based on Java's built-in HashMap class. */
public class MyMap {
    private MyEntry[] hashtable;
    private int maxSize;

    public MyMap(int maxSize) {
        hashtable = new MyEntry[maxSize];
        this.maxSize = maxSize;
        for (int i = 0; i < hashtable.length; i++)
            hashtable[i] = null;
    }

    /**
     * Nested static class, MyEntry.
     * Not able to access instance variables of MyMap, the hashtable and maxSize.
     * */
    static class MyEntry {
        private String key;
        private Object value;

        public MyEntry(String key, Object value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

    }

    // Uses closed hashing/linear probing
    public void put(String key, Object value) {
        if (key == null)
            throw new IllegalArgumentException("Key can not be null.");

        MyEntry entry = new MyEntry(key, value);
        int ind = hash(key);
        int originalInd = ind;
        // linear probing: we assume we do not allow deletion
        while (hashtable[ind] != null && (!hashtable[ind].getKey().equals(key))) { //while valid entries, keep searching
            ind = (ind + 1) % maxSize;
            if (ind == originalInd) { // came back to the same element
                System.out.println(" The table is full");
                return;
            }
        }
        hashtable[ind] = entry;
    }

    public Object get(String key) {
        int ind = hash(key);
        // We assume that we do not allow deletions
        while (hashtable[ind] != null && (!hashtable[ind].getKey().equals(key))) { //while valid entries, keep searching
            ind = (ind + 1) % maxSize;
        }
        return hashtable[ind].getValue();

    }


    public int hash(String key) {
        return key.hashCode() % maxSize;
    }

    public static void main(String[] args) {
        MyMap m = new MyMap(5);
        m.put("hello", 2);
        System.out.println(m.get("hello"));
        MyEntry entry = new MyEntry("hello", 6);
        System.out.println(entry.key);

    }

}
