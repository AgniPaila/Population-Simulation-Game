// Agni Paila 

import java.util.Random;

public abstract class Animal {

    private Cell cellZwou;
    private int stepsZwou;  

    public abstract boolean isRabbit();
    public abstract boolean timeToBreed();
    public abstract Animal giveBirth();
    public abstract void move();

    public Cell getCellZwou() {
        return cellZwou;
    }

    public void setCellZwou(Cell cellZwou) {
        this.cellZwou = cellZwou;
    }

    public int getStepsZwou() {
        return stepsZwou;
    }

    public void setStepsZwou(int stepsZwou) {
        this.stepsZwou = stepsZwou;
    }

    public void survived() {
        stepsZwou++;
    }

    public void randomMove() {
    Cell currentCell = getCellZwou();
    Cell randomNeighbor = currentCell.getRandomNeighbor();
    
    if (randomNeighbor != null && randomNeighbor.isEmpty()) {
        currentCell.removeAnimal();         
        randomNeighbor.setAnimal(this);      
        setCellZwou(randomNeighbor);         
    }
    survived();
}


    public Animal breed() {
	if (timeToBreed()) {
		for (int i = 0; i < cellZwou.getNeighbors().size(); i++) {
			if (cellZwou.getNeighbors().get(i).isEmpty()) {
				Animal baby = giveBirth();
				cellZwou.getNeighbors().get(i).setAnimal(baby);
				baby.setCellZwou(cellZwou.getNeighbors().get(i));
				return baby;
			}
		}
	}
	return null;
}
}
