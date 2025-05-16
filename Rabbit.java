// Agni Paila 

public class Rabbit extends Animal {

	private boolean eaten = false;

	public boolean isRabbit() {
		return true;
	}

	public boolean timeToBreed() {
		if (getStepsZwou() % 3 == 0) {
			return true;
		}
		return false;
	}

	public Animal giveBirth() {
		Rabbit newborn = new Rabbit();
		return newborn;
	}

	public void move() {
		randomMove();
		survived();
	}

	public void becomeEaten() {
		this.eaten = true;
	}

	public boolean isEaten() {
		return eaten;
	}

	public String toString() {
		return "o";
	}
}
