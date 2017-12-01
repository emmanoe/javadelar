package simpleUIApp;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import fr.ubordeaux.simpleUI.*;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		
		ArrayList<Item> testItemList = new ArrayList<Item>();
		/*
		 * Assign 2 planets per players
		 */
		
		testItemList.add(new Planet(random.nextInt(130)+ 30, random.nextInt(220) + 30 , 40,1));
		testItemList.add(new Planet(random.nextInt(130)+210, random.nextInt(220) + 30, 40,2));
		
		/*
		 * Set the space ships in their planet
		 */
		for(int i=0;i<5;i++) {
			testItemList.add(new SpaceShip(testItemList.get(0).getLocation().getX()+i*8, testItemList.get(0).getLocation().getY()+i*8, 5,0));
			((Planet) testItemList.get(0)).setSpaceShipsList(testItemList);
		}
		ArrayList<Item> fiveElemArray = new ArrayList<Item>();
		for (int i = 0; i<5; i++)
			fiveElemArray.add(new SpaceShip(testItemList.get(0).getLocation().getX(), testItemList.get(0).getLocation().getY()+i*3, 10,1));
		((Planet) testItemList.get(1)).setSpaceShipsList(fiveElemArray);
		
		/*
		 * Generates neutral planets
		 */
		for(int i=0;i< random.nextInt(2)+1;i++) {
			testItemList.add(new Planet(random.nextInt(370)+30, random.nextInt(220) + 250, 40,0));
		}
		/*
		int i = 0;
		
		while(i<25){
			Point2D.Double point = new Point2D.Double(random.nextInt(400),random.nextInt(500));
			while (testItemList.get(0).contains(point) && testItemList.get(1).contains(point)){
				point.setLocation(random.nextInt(400), random.nextInt(500));
			}
			testItemList.add(new SpaceShip(point.getX(), point.getY(), 10));
			i++;
		}*/
		
		
		Manager manager = new Manager();
		Run r = new Run(400, 500);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(testItemList, manager, r);
	}
}
