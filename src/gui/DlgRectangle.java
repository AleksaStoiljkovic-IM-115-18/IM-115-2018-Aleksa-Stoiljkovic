package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private int dlgWidth;
	private boolean commited;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUpperLeftX;
	private JTextField textFieldUpperLeftY;
	static JTextField textFieldWidth;
	private JTextField textFieldHeight;
	static Rectangle rectangle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperLeftX = new JLabel("Upper Left X:");
			GridBagConstraints gbc_lblUpperLeftX = new GridBagConstraints();
			gbc_lblUpperLeftX.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftX.gridx = 0;
			gbc_lblUpperLeftX.gridy = 0;
			contentPanel.add(lblUpperLeftX, gbc_lblUpperLeftX);
		}
		{
			textFieldUpperLeftX = new JTextField();
			textFieldUpperLeftX.setText(String.valueOf(DrawingPanel.getUpperLeftX()));
			GridBagConstraints gbc_textFieldUpperLeftX = new GridBagConstraints();
			gbc_textFieldUpperLeftX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftX.gridx = 1;
			gbc_textFieldUpperLeftX.gridy = 0;
			contentPanel.add(textFieldUpperLeftX, gbc_textFieldUpperLeftX);
			textFieldUpperLeftX.setColumns(10);
		}
		{
			JLabel lblUpperLeftX = new JLabel("Upper Left Y:");
			GridBagConstraints gbc_lblUpperLeftX = new GridBagConstraints();
			gbc_lblUpperLeftX.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftX.gridx = 0;
			gbc_lblUpperLeftX.gridy = 1;
			contentPanel.add(lblUpperLeftX, gbc_lblUpperLeftX);
		}
		{
			textFieldUpperLeftY = new JTextField();
			textFieldUpperLeftY.setText(String.valueOf(DrawingPanel.getUpperLeftY()));
			GridBagConstraints gbc_textFieldUpperLeftY = new GridBagConstraints();
			gbc_textFieldUpperLeftY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftY.gridx = 1;
			gbc_textFieldUpperLeftY.gridy = 1;
			contentPanel.add(textFieldUpperLeftY, gbc_textFieldUpperLeftY);
			textFieldUpperLeftY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 2;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
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
							int height = Integer.parseInt(textFieldHeight.getText());
							int width = Integer.parseInt(textFieldWidth.getText());
							int upperX = Integer.parseInt(textFieldUpperLeftX.getText());
							int upperY = Integer.parseInt(textFieldUpperLeftY.getText());
							
							if(height>0 && width>0 && upperX>0 && upperY>0) {
								rectangle.setHeight(height);
								rectangle.setWidth(width);
								rectangle.setUpperLeft(new Point(upperX, upperY));
								dlgWidth = Integer.parseInt(textFieldWidth.getText());
								commited = true;
								dispose();
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				textFieldWidth = new JTextField();
				if(rectangle != null) {
					if(rectangle.getWidth() == -1) {
						textFieldWidth.setText("");
					}
					
					else {
						textFieldWidth.setText(String.valueOf(rectangle.getWidth()));
					}
				}
				GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
				gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldWidth.gridx = 1;
				gbc_textFieldWidth.gridy = 2;
				contentPanel.add(textFieldWidth, gbc_textFieldWidth);
				textFieldWidth.setColumns(10);
			}
			
			{
				textFieldHeight = new JTextField();
				if(rectangle != null) {
					if(rectangle.getHeight() == -1) {
						textFieldHeight.setText("");
					}
					else {
						textFieldHeight.setText(String.valueOf(rectangle.getHeight()));
					}
				}
				GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
				gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldHeight.gridx = 1;
				gbc_textFieldHeight.gridy = 3;
				contentPanel.add(textFieldHeight, gbc_textFieldHeight);
				textFieldHeight.setColumns(10);
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

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public Shape getRectangle() {
		return rectangle;
	}
	public int getDlgWidth() {
		return dlgWidth;
	}
	public void setDlgWidth(int dlgWidth) {
		this.dlgWidth = dlgWidth;
	}
	public boolean isCommited() {
		return commited;
	}
	public void setCommited(boolean commited) {
		this.commited = commited;
	}

}
