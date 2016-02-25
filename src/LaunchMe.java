import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;




public class LaunchMe {

	int n, minQUID1, maxQUID1,minQUID2, maxQUID2, nbSD, k;
	static Nuplet[] classEq;



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
	
	//frequencySet
	static Map<Integer, Integer> frequencySet(Nuplet [] nu, int dim) {
		Map<Integer, Integer> frequencyset = new HashMap<Integer,Integer>();
		//calcul de frequence de valeur distincts
		for (int i=0; i< nu.length;i++){
			int cle;
			if (dim == 1)
				cle = nu[i].getQi1();
			else
				cle = nu[i].getQi2();

			Integer v = frequencyset.get(cle);
			v++;
			frequencyset.put(cle, v);
		}

		return frequencyset;
		}
	
	
	//choosedimension
		public static int chooseDimension(Nuplet [] nu){
			int min1 = 999999;
			int max1 = -1;
			int min2 = 999999;
			int max2 = -1;
			for (int i=0; i< nu.length;i++){
				if(nu[i].getQi1()< min1)
					min1 = nu[i].getQi1();
				
				 if(nu[i].getQi1() > max1)
					max1 =nu[i].getQi1();
				
				if(nu[i].getQi2() < min2)
					min2 =nu[i].getQi1();
				
				if(nu[i].getQi1() > max2)
					max2 = nu[i].getQi1();
			}
			//retourner la dimension la plus large
			if(max1-min1> max2-min2)
				return 1;
			else
				return 2;
		}
		
		
	
	//median 
	public static int findMedian(Map<Integer, Integer> frequency,int taille){
		
			int Madian = 0;
			int n = 0;
			Iterator<Entry<Integer, Integer>> it = frequency.entrySet().iterator();
			while (it.hasNext()){
				if(n<=taille/2){
				Entry<Integer, Integer> e = it.next();
				Madian = e.getKey();
				n += e.getValue();
			}}
			return Madian;
		}
	
	//Mondrian
	public static void mondrian(Nuplet [] nu, int k){
		if(k>nu.length/2)
		{  classEq = nu;}
		int dim = chooseDimension(nu);
		Map<Integer, Integer> frequency = frequencySet(nu, dim);
		int median = findMedian(frequency, nu.length);
		Nuplet[] L=null;
		Nuplet[] R=null;
		int il=0;
		int ir=0;
		
		if(dim == 1){
			for (int i=0; i< nu.length;i++){
				if(nu[i].getQi1() <= median){
					L[il]=nu[i];
					il++;
				}else{
					R[ir]=nu[i];
					ir++;
				}
			}
			
		}
		else{
			for (int i=0; i< nu.length;i++){
				if(nu[i].getQi1() <= median){
					R[ir]=nu[i];
					ir++;
				}else{
					L[il]=nu[i];
					il++;
				}
			}
			
		}
		
		mondrian(L,k);
		mondrian(R,k);
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
		
		 //change array to list
		//List classequi = Arrays.asList(tableau);
		mondrian(tableau,launchme.getK());
		System.out.println(Arrays.toString(launchme.classEq));
	}
	
			


}
