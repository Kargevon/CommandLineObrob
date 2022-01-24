package CommandLineArgsObrob;
import java.util.ArrayList;
import java.util.Iterator;

 interface ArgsList {

	 
	
	 

	public void addKey(String key);
	
	public String[] getKeys();

	public ArgPair[] getPairs();

	public String getValueFor(String key);
	
	public void findAllArgs() throws Exception;
}
