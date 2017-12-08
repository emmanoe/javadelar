package simpleUIApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Planet extends Item {
	/*
	 * A planet contain a fleet of space ship represented by an ArrayList
	 * the number of space ships left in the fleet is represented by nb_spaceship
	 */
	private ArrayList<Item> spaceShipList; 
	private double nb_spaceShip;
	private int max, rate;

	public Planet(double x, double y, int w, int o, int r) {
		super(x, y, w,o);
		this.rate = r; // production rate
		this.max = 100; // Nb space ships max
	}

	public ArrayList<Item> getSpaceShipsList() {
		return spaceShipList;
	}
	
	public int stockSize() {
		return spaceShipList.size();
	}

	public void setSpaceShipsList(ArrayList<Item> spaceShipsList) {
		this.spaceShipList = spaceShipsList;
	}
	
	public void destructSpaceship(int index) {
		this.spaceShipList.remove(index);
	}
	
	private static double squareDistance(Point2D p1, Point2D p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return dx * dx + dy * dy;
	}
	
	@Override
	public boolean contains(Point2D p) {
		return squareDistance(this.center, p) <= (getWidth() / 2) * (getWidth() / 2);
	}
	
	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		if(this.owner == 0)
			arg0.setColor(Color.GRAY);
		else if(this.owner == 1)
			arg0.setColor(Color.blue);
		else
			arg0.setColor(Color.magenta);
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
		
		/*
		 *  Render the number of space ships left in the planet 
		 */
		arg0.setColor(Color.white);
		arg0.drawString(String.valueOf((int)this.nb_spaceShip), (int)this.center.getX(), (int)this.center.getY());
	}

	@Override
	public void move() {}
	
	public void incrSpaceShips() {
		if (this.nb_spaceShip < this.max)
			this.nb_spaceShip+=(double)this.rate/100;
	}
	
	public void createSpaceShips() {
		
	}
	
	/*
	 *  Send planet objective to its troops
	 */
	
	@Override
	public void setObjective(Item o) {
		createSpaceShips();
		for(int i=0;i<5;i++) {
			this.spaceShipList.get(i+4).setObjective(o);
			//((SpaceShip)this.spaceShipList.get(i+4)).attack();
			((Planet)o).max--;
			this.max--;
			((Planet)o).nb_spaceShip--;
			this.nb_spaceShip--;
			}
	}
}
