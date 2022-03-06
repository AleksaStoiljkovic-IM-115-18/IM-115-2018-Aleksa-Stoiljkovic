package stackGui;

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

public class DlgDlt extends JDialog {
	
	private boolean dltCommited;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUpperLeftX;
	private JTextField textFieldUpperLeftY;
	static JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private int index;
	static Rectangle dltRectangle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAdd dialog = new DlgAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDlt() {
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
			textFieldUpperLeftX.setEditable(false);
			try {
				textFieldUpperLeftX.setText(StackFrame.getTextFieldX().getText());
			}
			
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
			}
			textFieldUpperLeftX.setEditable(false);
			GridBagConstraints gbc_textFieldUpperLeftX = new GridBagConstraints();
			gbc_textFieldUpperLeftX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftX.gridx = 1;
			gbc_textFieldUpperLeftX.gridy = 0;
			contentPanel.add(textFieldUpperLeftX, gbc_textFieldUpperLeftX);
			textFieldUpperLeftX.setColumns(10);
		}
		{
			JLabel lblUpperLeftY = new JLabel("Upper Left Y:");
			GridBagConstraints gbc_lblUpperLeftY = new GridBagConstraints();
			gbc_lblUpperLeftY.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftY.gridx = 0;
			gbc_lblUpperLeftY.gridy = 1;
			contentPanel.add(lblUpperLeftY, gbc_lblUpperLeftY);
		}
		{
			textFieldUpperLeftY = new JTextField();
			textFieldUpperLeftY.setEditable(false);
			try {
				textFieldUpperLeftY.setText(StackFrame.getTextFieldY().getText());
			}
			
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
			}
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
			JLabel lblHeight = new JLabel("Height:");
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
						dltCommited = true;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				textFieldWidth = new JTextField();
				textFieldWidth.setEditable(false);
				try {
					textFieldWidth.setText(StackFrame.getTextFieldWidth().getText());
				}
				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
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
				try {
					textFieldHeight.setText(StackFrame.getTextFieldHeight().getText());
				}
				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
				}
				textFieldHeight.setEditable(false);
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
						dltCommited = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	//Get and set methods

	public boolean isDltCommited() {
		return dltCommited;
	}
	public void setDltCommited(boolean addCommited) {
		this.dltCommited = addCommited;
	}
	public static Rectangle getDltRectangle() {
		return dltRectangle;
	}
	public static void setDltRectangle(Rectangle dltRectangle) {
		DlgDlt.dltRectangle = dltRectangle;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

}