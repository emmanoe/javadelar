package simpleUIApp;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import fr.ubordeaux.simpleUI.*;


public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		
		ArrayList<Item> objectList = new ArrayList<Item>();
		
		/*
		 * Assign 2 planets per players and add to Item ArrayList
		 * @param : 
		 * x: planet x position
		 * y: planet y position
		 * w: planet width
		 * o: planet owner
		 * r: planet space ship production rate in percent, [0,100]
		 */
		
		objectList.add(new Planet(random.nextInt(130)+ 30, random.nextInt(220) + 30 , 40,1,20));
		objectList.add(new Planet(random.nextInt(130)+210, random.nextInt(220) + 30, 40,2,100));
		
		/*
		 * Generates 1 or 2 (randomly) neutrals planets 
		 */
		
		for(int i=0;i< random.nextInt(2)+1;i++) {
			objectList.add(new Planet(random.nextInt(370)+30, random.nextInt(220) + 250, 40,0,0));
		}
		
		/*
		 * Set all the space ships list in their planet (start from objectList index 4)
		 * @param:
		 * x: space ship x position
		 * y: space ship y position
		 * w: space ship width
		 * o: owner of the space ship 
		 */
		
		for(int i=0;i<500;i++) {
			objectList.add(new SpaceShip(objectList.get(0).getLocation().getX(), objectList.get(0).getLocation().getY(), 5,1));
		}
		// Planet 1
		((Planet) objectList.get(0)).setSpaceShipsList(objectList);
		
		
		// Planet 2		
		((Planet) objectList.get(1)).setSpaceShipsList(objectList);
	
		
		Manager manager = new Manager();
		Run r = new Run(400, 500);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(objectList, manager, r);
	}
}
