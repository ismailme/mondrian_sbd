import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class LaunchMe {

	int n, minQUID1, maxQUID1,minQUID2, maxQUID2, nbSD, k;



	public LaunchMe(int n, int minQUID1, int maxQUID1, int minQUID2,
			int maxQUID2, int nbSD, int k) {
		super();
		this.n = n;
		this.minQUID1 = minQUID1;
		this.maxQUID1 = maxQUID1;
		this.minQUID2 = minQUID2;
		this.maxQUID2 = maxQUID2;
		this.nbSD = nbSD;
		this.k = k;
	}



	public int getN() {
		return n;
	}



	public int getMinQUID1() {
		return minQUID1;
	}



	public int getMaxQUID1() {
		return maxQUID1;
	}



	public int getMinQUID2() {
		return minQUID2;
	}



	public int getMaxQUID2() {
		return maxQUID2;
	}



	public int getNbSD() {
		return nbSD;
	}



	public int getK() {
		return k;
	}



	static int randomWithRange(int min, int max)
	{
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	//choosedimension
		public ClasseEqui chooseDimension(Nuplet nu){
			
			return null;
			
		}
		
	
	//mondrian
	public ClasseEqui mondrian(Nuplet nu,int k){
		return null;
		
	}
	
	

	public static void main(String[] args) throws IOException {

		LaunchMe launchme = new LaunchMe(10,75001,75010,22,40,5,2);
		String tabchaines[] = {"chaine1", "chaine2", "chaine3" , "chaine4"};
		String tabSD[] = null;;
		int nbr=launchme.getN();

		Nuplet[] tableau = new Nuplet[nbr];

		//tableau SD
		for(int i=0; i<nbr;i++){

			int idx = new Random().nextInt(tabchaines.length);
			String randomSD = (tabchaines[idx]);
			tableau[i] = new Nuplet(randomWithRange(launchme.getMinQUID1(),launchme.getMaxQUID1()), randomWithRange(launchme.getMinQUID2(),launchme.getMaxQUID2()),randomSD );
		}

		System.out.println(Arrays.toString(tableau));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File ( "./monJeuDeDonnees.csv" ),
						false
						)
				);

		bw.append (Arrays.toString(tableau) );
		bw.flush();
		bw.close();


	}


}
