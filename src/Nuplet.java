
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


	public Nuplet() {
		// TODO Auto-generated constructor stub
	}


	public int getQi1() {
		return qi1;
	}


	public void setQi1(int qi1) {
		this.qi1 = qi1;
	}


	public int getQi2() {
		return qi2;
	}


	public void setQi2(int qi2) {
		this.qi2 = qi2;
	}


	public String getSd() {
		return sd;
	}


	public void setSd(String sd) {
		this.sd = sd;
	}


	@Override
	public String toString() {
		return "\n [" + qi1 + "," + qi2 + "," + sd + "]";
	}

}
