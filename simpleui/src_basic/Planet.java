package src_basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Planet extends Item {
	
	/**
	 * A planet contain a fleet of space ship represented by an ArrayList
	 * the number of space ships left in the fleet is represented by nb_spaceship
	 */
	private ArrayList<Item> spaceShipList; 
	private double nb_spaceShip;
	private int fleet, team, rate;

	public Planet(double x, double y, int w, int o, int r) {
		super(x, y, w,o);
		this.rate = r; // production rate
		this.fleet = 100; // Nb space ships left in the fleet
	}
	
	/**
	 * Initialize our planet space ships list wich represents the planet fleet
	 * @param spaceShipsList a space ships list
	 */
	public void setSpaceShipsList(ArrayList<Item> spaceShipsList) {
		this.spaceShipList = spaceShipsList;
	}
	
	/**
	 * @param p1 first point
	 * @param p2 second point
	 * @return	the distance between two Point2D points
	 */
	private static double squareDistance(Point2D p1, Point2D p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return dx * dx + dy * dy;
	}
	
	/**
	 * Set the owner of our planet
	 * @param owner the player number [1-2]
	 */
	private void setOwner(int owner) {
		this.owner = owner;
	}
	
	/**
	 * Production speed of our space ships
	 * @param rate planet space ship production rate in percent, [0,100]
	 */
	private void setRate(int rate) {
		this.rate = rate;
	}
	
	/**
	 * Initialize our planet space ship fleet
	 * @param fleet the size of the fleet to create
	 */
	private void setFleet(int fleet) {
		this.fleet = fleet;
	}
	
	/**
	 * tell if a Point2D point is inside our planet
	 * @param p the point to check
	 */
	@Override
	public boolean contains(Point2D p) {
		return squareDistance(this.center, p) <= (getWidth() / 2) * (getWidth() / 2);
	}
	
	/**
	 * Render our planet in the Arena
	 * @param arg0 the graphic representation of the object planet
	 */
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
		
		/**
		 *  Render the number of space ships left on the planet 
		 */
		arg0.setColor(Color.white);
		arg0.drawString(String.valueOf((int)this.nb_spaceShip), (int)(this.center.getX()), (int)this.center.getY());
	}
	
	/**
	 * Conquer another planet
	 * @param p the planet to conquer
	 */
	public void conquer(Planet p) {
		if(p.owner ==0)
			for (int i=0; i<250; i++) {
				((SpaceShip) p.spaceShipList.toArray()[i]).setOwner(this.owner);
			}
		p.setOwner(this.owner);
		p.setRate(this.rate);
		p.setFleet(this.fleet);
		p.incrSpaceShips();
	}
	
	/**
	 * Method that don't do anything
	 */
	@Override
	public void move() {}
	
	/**
	 * Create new space ships in the planet
	 */
	public void incrSpaceShips() {
		if (this.nb_spaceShip < this.fleet)
			this.nb_spaceShip+=(double)this.rate/100;
	}

	/**
	 * Send planet objective to it's troops
	 * @param o the objective to reach
	 */
	@Override
	public void setObjective(Item o) {
		Planet p = ((Planet)o);
		if (this.owner > 0) {
			
			int attackStrength;
			
			for(int i=team; i<team+5; i++) {
				this.spaceShipList.get(i+4).setObjective(o);
				if ( p.nb_spaceShip > 0 && p.getOwner() != this.owner ) {
					attackStrength = ((SpaceShip)this.spaceShipList.get(i+4)).getStrength();
					p.nb_spaceShip-= attackStrength;
					p.fleet-= attackStrength;
					this.nb_spaceShip--;}
				else {
					if (p.nb_spaceShip>0 && p.getOwner() == this.owner) {
					}
					this.nb_spaceShip--;
					conquer(((Planet)o));
					}
				}
			this.team +=5;
			}
		}
	}
