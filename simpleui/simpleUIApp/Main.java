package simpleUIApp;

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
		
		testItemList.add(new Planet(random.nextInt(130)+ 30, random.nextInt(440) + 30 , 60));
		testItemList.add(new Planet(random.nextInt(130)+210, random.nextInt(440) + 30, 60));
		
		int i = 0;
		int x, y;
		while(i<25){
			x = random.nextInt(400); y = random.nextInt(500);
			testItemList.add(new SpaceShip(x, y, 10));
			if (!testItemList.get(0).contains(testItemList.get(i+2).center) && !testItemList.get(1).contains(testItemList.get(i+2).center)){
				i++;
			}
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
