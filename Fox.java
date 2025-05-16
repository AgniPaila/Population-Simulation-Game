// Agni Paila 

public class Fox extends Animal {

	private int stepsFromLastMeal = 0;

	public boolean isRabbit() {
		return false;
	}

	public boolean timeToBreed() {
		if (getStepsZwou() % 8 == 0) {
			return true;
		}
		return false;
	}

	public Animal giveBirth() {
		Fox newborn = new Fox();
		return newborn;
	}

	public void move() {
		for (int i = 0; i < getCellZwou().getNeighbors().size(); i++) {
			if (getCellZwou().getNeighbors().get(i).containsRabbit()) {
				Rabbit a=(Rabbit) getCellZwou().getNeighbors().get(i).getAnimal(); 
				a.becomeEaten();
				getCellZwou().getNeighbors().get(i).removeAnimal();
				getCellZwou().removeAnimal();
				getCellZwou().getNeighbors().get(i).setAnimal(this);
				setCellZwou(getCellZwou().getNeighbors().get(i));
				stepsFromLastMeal = 0;
				return;
			}
		}
		randomMove();
		survived();
		stepsFromLastMeal++;
	}

	public boolean starve() {
		if (stepsFromLastMeal >= 3) {
			getCellZwou().removeAnimal();
			return true;
		}
		return false;
	}

	public String toString() {
		return "x";
	}
}
