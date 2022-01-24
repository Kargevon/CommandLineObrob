import java.util.ArrayList;
import java.util.Iterator;

public class ArgsList {

	private ArrayList<ArgPair> pairsList = new ArrayList<ArgPair>();

	private ArrayList<String> keys = new ArrayList<String>();

	private String args[];

	public ArgsList(String args[]) {
		this.args = args;

	}

	public void addKey(String key) {
		keys.add(key);
	}

	public String[] getKeys() {
		String arr[] = new String[keys.size()];
		arr = keys.toArray(arr);
		return arr;
	}

	public ArgPair[] getPairs() {
		ArgPair arr[] = new ArgPair[pairsList.size()];
		arr = pairsList.toArray(arr);
		return arr;
	}

	public String getValueFor(String key) {
		Iterator<ArgPair> iter;
		iter = pairsList.iterator();
		ArgPair pair;
		while (iter.hasNext()) {
			pair = iter.next();
			if (pair.key.equals(key)) {
				return pair.value;
			}
		}

		return "";
	}

	public void findAllArgs() {
		Iterator<String> iter;
		String currentKey = "";
		for (int i = 0; i != args.length - 1; ++i) {

			iter = keys.iterator();
			while (iter.hasNext()) {

				currentKey = iter.next();
				if (currentKey.equals(args[i])) {
					pairsList.add(new ArgPair(currentKey, args[i+1]));

				}
			}
		}

	}

}
