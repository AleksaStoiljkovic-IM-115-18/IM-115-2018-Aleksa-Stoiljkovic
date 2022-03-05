package stackGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddRect extends JDialog {

	private boolean commited;
	

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUpLeftX;
	private JTextField textFieldUpLeftY;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private int dlgX;
	private int dlgY;
	private int dlgWidth;
	private int dlgHeight;
	private Rectangle rect;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddRect dialog = new DlgAddRect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddRect() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpLeftX = new JLabel("Upper left X:");
			GridBagConstraints gbc_lblUpLeftX = new GridBagConstraints();
			gbc_lblUpLeftX.anchor = GridBagConstraints.EAST;
			gbc_lblUpLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpLeftX.gridx = 0;
			gbc_lblUpLeftX.gridy = 0;
			contentPanel.add(lblUpLeftX, gbc_lblUpLeftX);
		}
		{
			textFieldUpLeftX = new JTextField();
			GridBagConstraints gbc_textFieldUpLeftX = new GridBagConstraints();
			gbc_textFieldUpLeftX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpLeftX.gridx = 1;
			gbc_textFieldUpLeftX.gridy = 0;
			contentPanel.add(textFieldUpLeftX, gbc_textFieldUpLeftX);
			textFieldUpLeftX.setColumns(10);
		}
		{
			JLabel lblUpLeftY = new JLabel("Upper Left Y:");
			GridBagConstraints gbc_lblUpLeftY = new GridBagConstraints();
			gbc_lblUpLeftY.anchor = GridBagConstraints.EAST;
			gbc_lblUpLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpLeftY.gridx = 0;
			gbc_lblUpLeftY.gridy = 1;
			contentPanel.add(lblUpLeftY, gbc_lblUpLeftY);
		}
		{
			textFieldUpLeftY = new JTextField();
			GridBagConstraints gbc_textFieldUpLeftY = new GridBagConstraints();
			gbc_textFieldUpLeftY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpLeftY.gridx = 1;
			gbc_textFieldUpLeftY.gridy = 1;
			contentPanel.add(textFieldUpLeftY, gbc_textFieldUpLeftY);
			textFieldUpLeftY.setColumns(10);
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
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 1;
			gbc_textFieldWidth.gridy = 2;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 1;
			gbc_textFieldHeight.gridy = 3;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
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
							int x = Integer.parseInt(textFieldUpLeftX.getText());
							int y = Integer.parseInt(textFieldUpLeftY.getText());
							int width = Integer.parseInt(textFieldWidth.getText());
							int height = Integer.parseInt(textFieldHeight.getText());
							Point upperLeft = new Point(x, y);
							
							if(x>0 && y>0 && width>0 && height>0) {
								rect.setUpperLeft(upperLeft);
								rect.setWidth(width);
								rect.setHeight(height);
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean isCommited() {
		return commited;
	}
	public void setCommited(boolean commited) {
		this.commited = commited;
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	public int getDlgWidth() {
		return dlgWidth;
	}
	public void setDlgWidth(int dlgWidth) {
		this.dlgWidth = dlgWidth;
	}
	public int getDlgHeight() {
		return dlgHeight;
	}
	public void setDlgHeight(int dlgHeight) {
		this.dlgHeight = dlgHeight;
	}
	public int getDlgX() {
		return dlgX;
	}
	public void setDlgX(int dlgX) {
		this.dlgX = dlgX;
	}
	public int getDlgY() {
		return dlgY;
	}
	public void setDlgY(int dlgY) {
		this.dlgY = dlgY;
	}
	

}
