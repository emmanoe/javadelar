package src_basic;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import fr.ubordeaux.simpleUI.*;


public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		
		ArrayList<Item> objectList = new ArrayList<Item>();
		
		/**
		 * Assign 2 planets per players and add to Item ArrayList
		 * @param : 
		 * x: planet x position
		 * y: planet y position
		 * w: planet width
		 * o: planet owner
		 * r: planet space ship production rate in percent, [0,100]
		 */
		
		objectList.add(new Planet(random.nextInt(300)+ 30, random.nextInt(190) + 30 ,60,1,20));
		objectList.add(new Planet(random.nextInt(330)+320, random.nextInt(190) + 30, 60,2,100));
		
		/**
		 * Generates 2 (randomly) neutrals planets 
		 */
		
		objectList.add(new Planet(random.nextInt(320)+30, random.nextInt(190) + 280, 60,0,0));
		objectList.add(new Planet(random.nextInt(350)+320, random.nextInt(190) + 280, 60,0,0));
		
		/**
		 * Set all the space ships list in their planet (start from objectList index 4)
		 * @param:
		 * x: space ship x position
		 * y: space ship y position
		 * w: space ship width
		 * o: owner of the space ship 
		 */
		
		for(int i=0;i<250;i++)
			objectList.add(new SpaceShip(objectList.get(0).getLocation().getX(), objectList.get(0).getLocation().getY(), 5,1));
		for(int i=0;i<250;i++)
			objectList.add(new SpaceShip(objectList.get(1).getLocation().getX(), objectList.get(1).getLocation().getY(), 5,2));
		
		for(int i=0;i<250;i++)
			objectList.add(new SpaceShip(objectList.get(2).getLocation().getX(), objectList.get(2).getLocation().getY(), 5,0));
		for(int i=0;i<250;i++)
			objectList.add(new SpaceShip(objectList.get(3).getLocation().getX(), objectList.get(3).getLocation().getY(), 5,0));
		
		// Set Planet 1 spaceship list
		ArrayList<Item> l1 = new ArrayList<Item>(objectList);
		for(int x=0;x<4;x++)
			l1.remove(0);
		
		((Planet) objectList.get(0)).setSpaceShipsList(l1);
		
		
		// Set Planet 2 spaceship list
		ArrayList<Item> l2 = new ArrayList<Item>(objectList);
		for(int x=0;x<254;x++)
			l2.remove(0);
		
		((Planet) objectList.get(1)).setSpaceShipsList(l2);
		
		// Set neutral Planets inactive spaceship list
		ArrayList<Item> l3 = new ArrayList<Item>(objectList);
		for(int x=0;x<504;x++)
			l3.remove(0);
		
		((Planet) objectList.get(2)).setSpaceShipsList(l3);
		
		ArrayList<Item> l4 = new ArrayList<Item>(objectList);
		for(int x=0;x<754;x++)
			l4.remove(0);
		
		((Planet) objectList.get(3)).setSpaceShipsList(l4);
	
		
		Manager manager = new Manager();
		Run r = new Run(700, 500);

		/**
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(objectList, manager, r);
	}
}
