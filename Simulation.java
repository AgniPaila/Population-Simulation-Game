//Agni Paila 

import java.util.Scanner;

class Simulation{
	
	public static void main (String[] args){
		PopulationSimulator ps=new PopulationSimulator ();
		Scanner input=new Scanner(System.in);
		System.out.println("please give me the number of steps");
		int nos=input.nextInt();
		ps.simulate(nos);
	}
}