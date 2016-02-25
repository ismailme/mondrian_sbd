import java.util.List;


public class ClasseEqui {
	
	private List eq1;
	private List eq2;
	private  String SD;
	
	public ClasseEqui(List eq1, List eq2, String sD) {
		super();
		this.eq1 = eq1;
		this.eq2 = eq2;
		SD = sD;
	}

	@Override
	public String toString() {
		return "ClasseEqui [eq1=" + eq1 + ", eq2=" + eq2 + ", SD=" + SD + "]";
	}
	
	

}
