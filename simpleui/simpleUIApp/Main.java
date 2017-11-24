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
		 * Randomly position 25 Ships in the Arena zone (defined afterwards)
		 */
		
		testItemList.add(new Planet(random.nextInt(130)+ 30, random.nextInt(440) + 30 , 40));
		testItemList.add(new Planet(random.nextInt(130)+210, random.nextInt(440) + 30, 40));
		
		int i = 0;
		
		while(i<25){
			Point2D.Double point = new Point2D.Double(random.nextInt(400),random.nextInt(500));
			while (testItemList.get(0).contains(point) && testItemList.get(1).contains(point)){
				point.setLocation(random.nextInt(400), random.nextInt(500));
			}
			testItemList.add(new SpaceShip(point.getX(), point.getY(), 10));
			i++;
		}
		
		
		Manager manager = new Manager();
		Run r = new Run(400, 500);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(testItemList, manager, r);
	}
}
