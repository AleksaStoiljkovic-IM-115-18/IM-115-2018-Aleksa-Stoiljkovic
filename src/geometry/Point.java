package geometry;

import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	
	public double distance(Point p) {
		int dx = this.x - p.x;
		int dy = this.y - p.y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point) obj;
			if(this.x == temp.x && this.y == temp.y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return distance(new Point(x,y)) <= 2 ;
	}
	
	@Override
	public void moveTo(int x, int y) {
		setX(x);
		setY(y);
		/*
		 * this.x = x;
		 * this.y = y;
		 */
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		x += byX;
		//this.x = x + byX
		y += byY;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point coordinateStart = new Point(0,0);
			System.out.println("Uporedjuje elemente");
			return (int)(distance(coordinateStart) - ((Point)o).distance(coordinateStart));
		}
		return 0;
	}

	
	//Konstruktori
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	
	//Get i set metode
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.x-1, this.y, this.x+1, this.y);
		g.drawLine(this.x, this.y-1, this.x, this.y+1);
		if(this.isSelected()) {
			g.drawRect(this.x - 3, this.y -3, 6, 6);
		}
	}

	
	
}