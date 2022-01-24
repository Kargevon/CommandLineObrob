package CommandLineArgsObrob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FileObrob implements ArgsList {

	private ArrayList<ArgPair> pairsList = new ArrayList<ArgPair>();

	private ArrayList<String> keys = new ArrayList<String>();

	private String path;
	private String separator = "=";
	private String[] lines;
	

	public FileObrob(String path) {
		this.path = path;

	}

	public FileObrob(String path, String separator) {
		this.path = path;
		this.separator = separator;
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

	public void findAllArgs() throws Exception {
		//here some error. Need fix with empty line and something anothers
		readFile();
		
		if(lines.length<1) {
			throw new Exception("args list is empty");
		}
		
		String[] pair = new String[2];
		
		for(int i=0; i!=lines.length; ++i) {
			pair=lines[i].split(separator, 2);
			pairsList.add(new ArgPair(pair[0], pair[1]));
		}

	}

	private void readFile() throws Exception {
		File f = new File(path);
		if(!f.exists()) {
			throw new Exception("This file !exist");
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> strs = new ArrayList<String>();
		while(br.ready()) {
			strs.add(br.readLine());
		}
		lines = strs.toArray(lines);
		
		
		
		
	}
}