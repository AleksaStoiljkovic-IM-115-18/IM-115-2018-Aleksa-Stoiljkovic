package drawingGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Shape;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private static int dlgRadius;
	static Circle circle;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCircleCenterX;
	private JTextField textFieldCircleCenterY;
	private JTextField textFieldRadius;
	private boolean commited;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCircleCenterX = new JLabel("Center X:");
			GridBagConstraints gbc_lblCircleCenterX = new GridBagConstraints();
			gbc_lblCircleCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCircleCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleCenterX.gridx = 0;
			gbc_lblCircleCenterX.gridy = 0;
			contentPanel.add(lblCircleCenterX, gbc_lblCircleCenterX);
		}
		{
			textFieldCircleCenterX = new JTextField();
			textFieldCircleCenterX.setText(String.valueOf(DrawingPanel.getCircleCenterX()));
			GridBagConstraints gbc_textFieldCircleCenterX = new GridBagConstraints();
			gbc_textFieldCircleCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCircleCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCircleCenterX.gridx = 1;
			gbc_textFieldCircleCenterX.gridy = 0;
			contentPanel.add(textFieldCircleCenterX, gbc_textFieldCircleCenterX);
			textFieldCircleCenterX.setColumns(10);
		}
		{
			JLabel lblCircleCenterY = new JLabel("Center Y:");
			GridBagConstraints gbc_lblCircleCenterY = new GridBagConstraints();
			gbc_lblCircleCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblCircleCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleCenterY.gridx = 0;
			gbc_lblCircleCenterY.gridy = 1;
			contentPanel.add(lblCircleCenterY, gbc_lblCircleCenterY);
		}
		{
			textFieldCircleCenterY = new JTextField();
			textFieldCircleCenterY.setText(String.valueOf(DrawingPanel.getCircleCenterY()));
			GridBagConstraints gbc_textFieldCircleCenterY = new GridBagConstraints();
			gbc_textFieldCircleCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCircleCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCircleCenterY.gridx = 1;
			gbc_textFieldCircleCenterY.gridy = 1;
			contentPanel.add(textFieldCircleCenterY, gbc_textFieldCircleCenterY);
			textFieldCircleCenterY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			if(circle != null) {
				if(circle.getRadius() == -1) {
					textFieldRadius.setText("");
				}
				else {
					textFieldRadius.setText(String.valueOf(circle.getRadius()));
				}
			}
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 2;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							circle.setRadius(Integer.parseInt(textFieldRadius.getText()));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						circle.setCenter(new Point(Integer.parseInt(textFieldCircleCenterX.getText()), Integer.parseInt(textFieldCircleCenterY.getText())));
						commited = true;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						commited = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	//Get and set methods
	
	public boolean isCommited() {
		return commited;
	}
	public void setCommited(boolean commited) {
		this.commited = commited;
	}
	public static int getDlgRadius() {
		return dlgRadius;
	}
	public static void setDlgRadius(int dlgRadius) {
		DlgCircle.dlgRadius = dlgRadius;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Shape getCircle() {
		return circle;
	}

}
