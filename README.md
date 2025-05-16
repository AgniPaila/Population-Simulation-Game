# 🦊🐰Population-Simulation-Game - (Java)

## Description

This program simulates the evolution of a population of rabbits and foxes in Java. Animals are confined within a 2D grid of cells with dimensions 20×20. Only one animal can be in a cell at any time. Animals can only move between neighboring cells (up, down, right, left) and cannot go out of the grid. The simulation time flows in discrete steps. Every animal makes some actions at every step.

### 🐰Rabbit Actions:
- **Movement:** At each step, a rabbit randomly chooses one of the neighboring cells. If the cell is inside the grid and is not occupied, the rabbit moves to this cell. Otherwise, it stays in its current cell.
- **Reproduction:** If the rabbit survives for three steps, at the end of the third step, it tries to reproduce. This is simulated by creating a new rabbit in a neighboring cell which is empty. If there is no empty neighboring cell, then the rabbit does not breed. 
  
### 🦊Fox Actions:
- **Movement:** At each step, if there is a neighboring cell containing a rabbit, the fox moves to that cell and eats the rabbit. Otherwise, it moves like a rabbit.
- **Reproduction:** Reproduction happens every eight steps, similar to the rabbits' reproduction process.
- **Death by Starvation:** If a fox does not eat a rabbit for three steps, it dies due to starvation.

## 📌Notes
In the simulation, the foxes act first, and then the rabbits.
Rabbits are represented as "o".
Foxes are represented as "x".
Empty cells are represented as "*".

## 🚀How to Run
Compile the Java files using: javac *.java

Run the simulation using: java PopulationSimulator
