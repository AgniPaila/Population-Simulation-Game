// Agni Paila 

import java.util.ArrayList;
import java.util.Random;

class Cell {
	private ArrayList<Cell> neighbors = new ArrayList<Cell>();
	private Animal animal = null;

	private int sthlh;
	private int grammh;

	public Cell(int sthlh, int grammh) {
		this.sthlh = sthlh;
		this.grammh = grammh;
	}

	public Cell() {
	}

	public String toString() {
		return sthlh + "  " + grammh;
	}

	public ArrayList<Cell> getNeighbors() {
		return neighbors;
	}

	public void addNeighbor(Cell cell) {
		neighbors.add(cell);
	}

	public Cell getRandomNeighbor() {
		Random random = new Random();
		if (neighbors.size() == 2) {
			int randomNumber = random.nextInt(2);
			return neighbors.get(randomNumber);
		}
		if (neighbors.size() == 3) {
			int randomNumber = random.nextInt(3);
			return neighbors.get(randomNumber);
		}
		if (neighbors.size() == 4) {
			int randomNumber = random.nextInt(4);
			return neighbors.get(randomNumber);
		}
		return null;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void removeAnimal() {
		this.animal = null;
	}

	public boolean isEmpty() {
		if (animal != null) {
			return false;
		}
		return true;
	}

	public boolean containsRabbit() {
		if (animal != null) {
			if (animal.isRabbit()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Cell cell1 = new Cell(1, 2);
		System.out.println(cell1);
	}
}
