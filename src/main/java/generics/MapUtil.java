package generics;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/** The class contains a parameterized method for creating a map out of a set of keys and a set of values.
 *  Note that MapUtil is not a parameterized class.
 */
class MapUtil {
	
	/** createMap is a parameterized method in a regular class MapUtil.
	 *  It takes two sets and returns a map, where the keys are from set1
	 *  and the values are from set2. 
	 *  The type of keys and the type of values are parameters to the method.
	 */
	public static <K, V> Map<K, V> createMap(Set<K> keys, Set<V> vals) {
		Map<K,V> map = new LinkedHashMap<>();
		Iterator<V> it = vals.iterator();
		for (K key: keys) {
			V val = it.next();
			map.put(key, val);
		}
		return map;
	}
    
	public static void main(String[] args) {

		// In a LinkedHashSet, the elements are stored in the insertion order
		Set<String> keys = new LinkedHashSet<>(); 
		keys.add("red");
		keys.add("green");
		keys.add("blue");
		
		Set<Integer> values = new LinkedHashSet<>();
		values.add("red".length());
		values.add("green".length());
		values.add("blue".length());

	    // Shows how to invoke a parameterized method createMap:
		Map<String, Integer> map = MapUtil.createMap(keys, values);
		System.out.println(map);
	}
}
