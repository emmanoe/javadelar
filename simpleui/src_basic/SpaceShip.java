package src_basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

class SpaceShip extends Item {

	private Item objective;
	private int strength = 1; // Space ship attack power
	private int speed = 4; // Space ship fastness

	public SpaceShip(double x, double y, int w, int o) {
		super(x, y, w, o);
	}

	public void setObjective(Item o) {
		this.objective = o;
	}
	
	public void setOwner(int o) {
		this.owner = o;
	}
	
	public int getStrength() {
		return this.strength;
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

	public void move() {
			if(objective != null) {	
				if (!objective.contains(this.center)) {
					double newx = center.getX();
					double newy = center.getY();
					if (newx > objective.getLocation().getX()) {
						newx-= this.speed;
					} else {
						newx+= this.speed;
					}
					if (newy > objective.getLocation().getY()) {
						newy-= this.speed;
					} else {
						newy+= this.speed;
					}
					center.setLocation(newx, newy);
					}else {
						objective = this;
						}			
				}
			}
	/*
	 * Attack the objective by increase or decrease the number of space ships
	 */
	public void attack() {
		if(this.objective.owner == this.owner) {
			System.out.println("coucou");
			//((Planet)this.objective).setStock(((Planet)this.objective).stockSize()+1);
		}
	}

	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		if (this.owner == 1)
			arg0.setColor(Color.blue);
		if (this.owner == 2)
			arg0.setColor(Color.magenta);
		if (this.owner == 0)
			arg0.setColor(Color.gray);
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
	}
}
