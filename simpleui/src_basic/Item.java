package src_basic;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Any graphical element that will be handle by the application.
 *
 */

abstract class Item {

	protected final Point2D center;
	private final int width;
	protected int owner;

	public Item(double x, double y, int w, int o) {
		center = new Point2D.Double(x, y);
		width = w;
		owner = o;
	}

	public Point2D getLocation() {
		return center;
	}

	public int getWidth() {
		return width;
	}
	
	public int getOwner() {
		return owner;
	}
	
	public abstract void move();

	public abstract void draw(Graphics2D arg0);

	public abstract void setObjective(Item o);

	public abstract boolean contains(Point2D p);
}
