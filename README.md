# Cell Automata Project

Super simple cell simulation by Hoai Huong, based off UBC BMEG Bootcamp 2022

>> To start the simulation, run the main method in CellAutomata/src/main/java/Rendering/Program.java
>> Simulation:
	# TISSUE CELL (Light Gray): This cell will potentially turn one adjacent DEAD CELL into TISSUE CELL.
	# IMMUNE CELL (Orange): This cell will check around for CANCER CELL
		- If the CANCER CELL is weaker, the CANCER CELL is killed.
		- If the CANCER CELL is stronger but no more than 2 units stronger, there are 50% that the CANCER CELL is killed.
	# CANCER CELL (Blue):
		- If there is any number of DEAD CELL around, depends on the HOST CANCER CELL strength, it will transform at least one DEAD CELL into CANCER CELL with half the strength of the HOST CANCER CELL.
		- Count the number of TISSUE CELL and IMMUNE CELL around:
			+ If there are more TISSUE CELL: Depends on the HOST CANCER CELL strength, it will kill at least one TISSUE CELL.
			+ If there are more IMMUNE CELL: Depends on the HOST CANCER CELL strength, it will attack at least one IMMUNE CELL. If the IMMUNE CELL attacked is weaker but no more than 3 units weaker than the HOST CANCER CELL, there are 10% chance that the IMMUNE CELL is killed. If the IMMUNE CELL attacked is 4 or more units weaker than the HOST CANCER CELL, there are 5-% chance that the IMMUNE CELL is killed.
	# DEAD CELL (Black): This cell is dead. It does nothing.

SOURCE FILES (CellAutomata/src/main/java/)
	- Util: Consists of useful methods to convert between indices and coordinates -- Written by Umar Ali for the bootcamp
	- Rendering: Consists of Rendering classes and actual Program implementation -- Written by Umar Ali for the bootcamp
	- Simulation: Interaction between cells
		+ Logic: Simulation setup -- Written by Umar Ali for the bootcamp and Modified by Hoai Huong
		+ Cell classes: Cell characteristics and interaction -- Written by Hoai Huong
