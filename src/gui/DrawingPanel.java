package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics;
import java.awt.Color;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
	
	private static int circleCenterX;
	private static int circleCenterY;
	private static int donutCenterX;
	private static int donutCenterY;
	private static int pointX;
	private static int pointY;
	private static int lineStartPointX;
	private static int lineStartPointY;
	private static int lineEndPointX;
	private static int lineEndPointY;
	private static int upperLeftX;
	private static int upperLeftY;
	private static Shape selected;
	private Point startPoint;
	private DrawingFrame frame;
	private static ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public DrawingPanel(DrawingFrame frame) {
		this.frame = frame;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}
	
	protected void thisMouseClicked(MouseEvent e) {
		Shape newShape = null;
		if (frame.getTglbtnSelection().isSelected()) {
			selected = null;
			Iterator<Shape> it = shapes.iterator();
			while (it.hasNext()) {
				Shape shape = it.next();
				shape.setSelected(false);
				if (shape.contains(e.getX(), e.getY()))
					selected = shape;
			}
			if (selected != null)
			selected.setSelected(true);
		}	
		else if (frame.getTglbtnPoint().isSelected()) {
			pointX = e.getX();
			pointY = e.getY();
			DlgPoint dlg = new DlgPoint();
			dlg.setModal(true);
			dlg.setPoint(new Point(e.getX(), e.getY()));
			dlg.setVisible(true);
			if (!dlg.isCommited())
				return;
			try {
				newShape = dlg.getPoint();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
		else if (frame.getTglbtnLine().isSelected()) {
			if (startPoint == null) {
				lineStartPointX = e.getX();
				lineStartPointY = e.getY();
				startPoint = new Point(e.getX(), e.getY());
			}
			else {
				lineEndPointX = e.getX();
				lineEndPointY = e.getY();
				DlgLine dlg = new DlgLine();
				dlg.setModal(true);
				dlg.setLine(new Line(new Point(lineStartPointX, lineStartPointY), new Point(lineEndPointX, lineEndPointY)));
				dlg.setVisible(true);
				if (!dlg.isCommited())
					return;
				try {
					newShape = dlg.getLine();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
				}
				startPoint = null;
			}
			
		}
			else if (frame.getTglbtnRectangle().isSelected()) {
			upperLeftX = e.getX();
			upperLeftY = e.getY();
			DlgRectangle dlg = new DlgRectangle();
			dlg.setModal(true);
			dlg.setRectangle(new Rectangle(new Point(e.getX(), e.getY()), -1, -1));
			dlg.setVisible(true);
			if (!dlg.isCommited()) {
				return;
			}
			try {
				newShape = dlg.getRectangle();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}		else if (frame.getTglbtnCircle().isSelected()) {
			circleCenterX = e.getX();
			circleCenterY = e.getY();
			DlgCircle dlg = new DlgCircle();
			dlg.setModal(true);
			dlg.setCircle(new Circle(new Point(e.getX(), e.getY()), -1));
			dlg.setVisible(true);
			if (!dlg.isCommited())
				return;
			try {
				newShape = dlg.getCircle();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}		else if (frame.getTglbtnDonut().isSelected()) {
			donutCenterX = e.getX();
			donutCenterY = e.getY();
			DlgDonut dlg = new DlgDonut();
			dlg.setModal(true);
			dlg.setDonut(new Donut(new Point(e.getX(), e.getY()), -1, -1));
			dlg.setVisible(true);
			if (!dlg.isCommited())
				return;
			try {
				newShape = dlg.getDonut();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}
		if (newShape != null)
			shapes.add(newShape);
		repaint();
	}

	public void paint (Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext())
			it.next().draw(g);
		}
	
	//Get and set methods
	
	public static Shape getSelected() {
		return selected;
	}
	public static ArrayList<Shape> getShapes() {
		return shapes;
	}
	public static int getLineEndPointX() {
		return lineEndPointX;
	}
	public static void setLineEndPointX(int lineEndPointX) {
		DrawingPanel.lineEndPointX = lineEndPointX;
	}
	public static int getLineEndPointY() {
		return lineEndPointY;
	}
	public static void setLineEndPointY(int lineEndPointY) {
		DrawingPanel.lineEndPointY = lineEndPointY;
	}
	public static int getCircleCenterX() {
		return circleCenterX;
	}
	public static void setCircleCenterX(int circleCenterX) {
		DrawingPanel.circleCenterX = circleCenterX;
	}
	public static int getCircleCenterY() {
		return circleCenterY;
	}
	public static void setCircleCenterY(int circleCenterY) {
		DrawingPanel.circleCenterY = circleCenterY;
	}
	public static int getDonutCenterX() {
		return donutCenterX;
	}
	public static void setDonutCenterX(int donutCenterX) {
		DrawingPanel.donutCenterX = donutCenterX;
	}
	public static int getDonutCenterY() {
		return donutCenterY;
	}
	public static void setDonutCenterY(int donutCenterY) {
		DrawingPanel.donutCenterY = donutCenterY;
	}
	public static int getPointX() {
		return pointX;
	}
	public static void setPointX(int pointX) {
		DrawingPanel.pointX = pointX;
	}
	public static int getPointY() {
		return pointY;
	}
	public static void setPointY(int pointY) {
		DrawingPanel.pointY = pointY;
	}
	public static int getLineStartPointX() {
		return lineStartPointX;
	}
	public static void setLineStartPointX(int lineStartPointX) {
		DrawingPanel.lineStartPointX = lineStartPointX;
	}
	public static int getLineStartPointY() {
		return lineStartPointY;
	}
	public static void setLineStartPointY(int lineStartPointY) {
		DrawingPanel.lineStartPointY = lineStartPointY;
	}
	public static int getUpperLeftX() {
		return upperLeftX;
	}
	public void setUpperLeftX(int upperLeftX) {
		this.upperLeftX = upperLeftX;
	}
	public static int getUpperLeftY() {
		return upperLeftY;
	}
	public void setUpperLeftY(int upperLeftY) {
		this.upperLeftY = upperLeftY;
	}
}
