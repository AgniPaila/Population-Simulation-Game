//Agni Paila 

import java.util.Random;

class Grid {
    private final int SIZE = 20;
    private Cell[][] SIZExSIZE;

    public Grid() {
        SIZExSIZE = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                SIZExSIZE[i][j] = new Cell();
                if (i > 0) {
                    SIZExSIZE[i - 1][j].addNeighbor(SIZExSIZE[i][j]);
                    SIZExSIZE[i][j].addNeighbor(SIZExSIZE[i - 1][j]);
                }
                if (j > 0) {
                    SIZExSIZE[i][j - 1].addNeighbor(SIZExSIZE[i][j]);
                    SIZExSIZE[i][j].addNeighbor(SIZExSIZE[i][j - 1]);
                }
            }
        }
    }

    public void addRandomly(Animal anml) {
		Random random = new Random();
		while (true) {
			int i = random.nextInt(SIZE);
			int j = random.nextInt(SIZE);
			if (SIZExSIZE[i][j].isEmpty()) {
				SIZExSIZE[i][j].setAnimal(anml);
				anml.setCellZwou(SIZExSIZE[i][j]);
				break;
			}
		}
	}

    public String toString() {
		String empty = "_";
		String x = "";
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (SIZExSIZE[i][j].isEmpty()) {
					if (j == 19) {
						x = x + " " + empty + "\n";
					} else {
						x = x + " " + empty;
					}
				} else {
					if (j == 19) {
						x = x + " " + SIZExSIZE[i][j].getAnimal().toString() + "\n";
					} else {
						x = x + " " + SIZExSIZE[i][j].getAnimal().toString();
					}
				}
			}
		}
		return x;
	}

    public static void main(String[] args) {
        Grid myGrid = new Grid();
        System.out.println(myGrid);
    }
}
