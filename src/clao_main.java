
public class clao_main {

	public static void main(String[] args) {
		System.out.println(12);
		ArgsList a = new ArgsList(args);
		
		a.addKey("-m");
		a.addKey("-d");
		a.addKey("/path");
		
		a.findAllArgs();
		
		ArgPair[] aa = a.getPairs();
		for(ArgPair t : aa) {
			System.out.println(t.key+" "+t.value);
		}
		
	}

}
