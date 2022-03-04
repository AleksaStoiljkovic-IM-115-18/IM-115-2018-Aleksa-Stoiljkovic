package drawingGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	public boolean commited;
	static Point point;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldPointX;
	private JTextField textFieldPointY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPointX = new JLabel("X:");
			GridBagConstraints gbc_lblPointX = new GridBagConstraints();
			gbc_lblPointX.anchor = GridBagConstraints.EAST;
			gbc_lblPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblPointX.gridx = 0;
			gbc_lblPointX.gridy = 0;
			contentPanel.add(lblPointX, gbc_lblPointX);
		}
		{
			textFieldPointX = new JTextField();
			textFieldPointX.setText(String.valueOf(DrawingPanel.getPointX()));
			GridBagConstraints gbc_textFieldPointX = new GridBagConstraints();
			gbc_textFieldPointX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPointX.gridx = 1;
			gbc_textFieldPointX.gridy = 0;
			contentPanel.add(textFieldPointX, gbc_textFieldPointX);
			textFieldPointX.setColumns(10);
		}
		{
			JLabel lblPointY = new JLabel("Y:");
			GridBagConstraints gbc_lblPointY = new GridBagConstraints();
			gbc_lblPointY.anchor = GridBagConstraints.EAST;
			gbc_lblPointY.insets = new Insets(0, 0, 0, 5);
			gbc_lblPointY.gridx = 0;
			gbc_lblPointY.gridy = 1;
			contentPanel.add(lblPointY, gbc_lblPointY);
		}
		{
			textFieldPointY = new JTextField();
			textFieldPointY.setText(String.valueOf(DrawingPanel.getPointY()));
			GridBagConstraints gbc_textFieldPointY = new GridBagConstraints();
			gbc_textFieldPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPointY.gridx = 1;
			gbc_textFieldPointY.gridy = 1;
			contentPanel.add(textFieldPointY, gbc_textFieldPointY);
			textFieldPointY.setColumns(10);
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
							int x = Integer.parseInt(textFieldPointX.getText());
							int y = Integer.parseInt(textFieldPointY.getText());
							
							if(x>0 && y>0) {
								point.setX(x);
								point.setY(y);
								DrawingPanel.setPointX(x);
								DrawingPanel.setPointY(y);
								commited = true;
								dispose();
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Wrong data entry", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						catch (Exception ex) {
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
	
	public void setPoint(Point point) {
		this.point = point;
	}
	public static Point getPoint() {
		return point;
	}
	public boolean isCommited() {
		return commited;
	}
	public void setCommited(boolean commited) {
		this.commited = commited;
	}

}
