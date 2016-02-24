
public class Nuplet {
	private int qi1;
	private int qi2;
	private String sd;
	
	
	public Nuplet(int qi1, int qi2, String sd) {
		super();
		this.qi1 = qi1;
		this.qi2 = qi2;
		this.sd = sd;
	}


	@Override
	public String toString() {
		return "\n [" + qi1 + "," + qi2 + "," + sd + "]";
	}

}
