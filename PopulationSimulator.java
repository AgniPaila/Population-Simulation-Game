// Agni Paila 

import java.util.*;

public class PopulationSimulator {

	private Grid myGrid;
	private HashSet<Rabbit> rabbits = new HashSet<Rabbit>();
	private HashSet<Fox> foxes = new HashSet<Fox>();
	private int NUM_OF_FOXES=5;
	private int NUM_OF_RABBITS=100;

	public void populateGrid() {
		for (int i = 0; i < NUM_OF_RABBITS; i++) {
			Rabbit rabbit = new Rabbit();
			rabbits.add(rabbit);
			myGrid.addRandomly(rabbit);
		}
		for (int i = 0; i < NUM_OF_FOXES; i++) {
			Fox fox = new Fox();
			foxes.add(fox);
			myGrid.addRandomly(fox);
		}
	}

	public void handleFoxes() {
		Set<Fox> foxestoadd = new HashSet<Fox>();
		Set<Fox> foxestoremove = new HashSet<Fox>();

		Fox[] foxesArray = foxes.toArray(new Fox[0]);
		for (int i = 0; i < foxesArray.length; i++) {
			Fox f = foxesArray[i];
			f.move();

			if (f.starve()) {
				foxestoremove.add(f);
				i--;
				continue;
			}

			if (f.timeToBreed()) {
				Animal baby = f.breed();
				if (baby != null && baby instanceof Fox) {
					foxestoadd.add((Fox) baby);
				}
			}
		}

		foxes.addAll(foxestoadd);
		foxes.removeAll(foxestoremove);
	}

	public void handleRabbits() {
		Set<Rabbit> rabbitstoadd = new HashSet<Rabbit>();
		Set<Rabbit> rabbitstoremove = new HashSet<Rabbit>();

		Rabbit[] rabbitsArray = rabbits.toArray(new Rabbit[0]);
		for (int i = 0; i < rabbitsArray.length; i++) {
			Rabbit r = rabbitsArray[i];
			r.move();

			if (r.timeToBreed()) {
				Animal baby = r.breed();
				if (baby != null && baby instanceof Rabbit) {
					rabbitstoadd.add((Rabbit) baby);
				}
			}
			if (r.isEaten()){
				rabbitstoremove.add(r);
			}
		}
		rabbits.addAll(rabbitstoadd);
		rabbits.removeAll(rabbitstoremove);
	}

	public void simulate(int numofsteps) {
		myGrid = new Grid();
		populateGrid();      

		for (int i = 0; i < numofsteps; i++) {
			System.out.println(myGrid);
			System.out.println( rabbits.size() + " rabbits and " + foxes.size() + " foxes\n");
			Scanner input=new Scanner(System.in);
			System.out.println("press enter to continue");
			new Scanner(System.in).nextLine();
			handleFoxes();
			handleRabbits();
		}
	}
}
