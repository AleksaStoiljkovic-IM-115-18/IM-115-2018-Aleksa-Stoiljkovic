package drawingGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrame extends JFrame {
	
	private JButton btnModify;
	private JButton btnDelete;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnSelection;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnDonut;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private DrawingPanel panel = new DrawingPanel(this);
	
	protected void delete() {
		Shape selected = DrawingPanel.getSelected();
		if(selected != null)
			DrawingPanel.getShapes().remove(selected);
		panel.repaint();
	}
	
	protected void modify() {
		Shape selected = DrawingPanel.getSelected();
		if(selected != null) {
			if(selected instanceof Point) {
				Point point = (Point) selected;
				DlgPoint dlg = new DlgPoint();
				dlg.setPoint(point);
				dlg.setModal(true);
				dlg.setVisible(true);
			} else if(selected instanceof Line) {
				Line line = (Line) selected;
				DlgLine dlg = new DlgLine();
				dlg.setLine(line);
				dlg.setModal(true);
				dlg.setVisible(true);
			} else if(selected instanceof Rectangle) {
				Rectangle rect = (Rectangle) selected;
				DlgRectangle dlg = new DlgRectangle();
				dlg.setRectangle(rect);
				dlg.setModal(true);
				dlg.setVisible(true);
			} else if(selected instanceof Donut) {
				Donut donut = (Donut) selected;
				DlgDonut dlg = new DlgDonut();
				dlg.setDonut(donut);
				dlg.setModal(true);
				dlg.setVisible(true);
			} else if(selected instanceof Circle) {
				Circle circle = (Circle) selected;
				DlgCircle dlg = new DlgCircle();
				dlg.setCircle(circle);
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		}
		panel.repaint();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
					frame.setTitle("Aleksa Stoiljkovic - IM 115/18");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		DrawingPanel panel_5 = new DrawingPanel(this);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel.add(panel_5, gbc_panel_5);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		tglbtnSelection = new JToggleButton("Selection");
		buttonGroup.add(tglbtnSelection);
		panel_1.add(tglbtnSelection);
		
		tglbtnPoint = new JToggleButton("Point");
		buttonGroup.add(tglbtnPoint);
		panel_1.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		buttonGroup.add(tglbtnLine);
		panel_1.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		buttonGroup.add(tglbtnRectangle);
		panel_1.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		buttonGroup.add(tglbtnCircle);
		panel_1.add(tglbtnCircle);
		
		tglbtnDonut = new JToggleButton("Donut");
		buttonGroup.add(tglbtnDonut);
		panel_1.add(tglbtnDonut);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				repaint();
			}
		});
		panel_3.add(btnDelete);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
				repaint();
			}
		});
		panel_3.add(btnModify);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
	}
	
	//Get and set methods
	
	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}
	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}
	public JToggleButton getTglbtnSelection() {
		return tglbtnSelection;
	}
	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}
	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}
	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}
}
