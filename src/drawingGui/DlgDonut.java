package drawingGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;
import geometry.Shape;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {
	
	static Donut donut;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDonutCenterX;
	private JTextField textFieldDonutCenterY;
	private JTextField textFieldOuterRadius;
	private JTextField textFieldInnerRadius;
	private boolean commited;

	public JTextField getTextFieldDonutCenterX() {
		return textFieldDonutCenterX;
	}

	public void setTextFieldDonutCenterX(JTextField textFieldDonutCenterX) {
		this.textFieldDonutCenterX = textFieldDonutCenterX;
	}

	public JTextField getTextFieldDonutCenterY() {
		return textFieldDonutCenterY;
	}

	public void setTextFieldDonutCenterY(JTextField textFieldDonutCenterY) {
		this.textFieldDonutCenterY = textFieldDonutCenterY;
	}

	public JTextField getTextFieldOuterRadius() {
		return textFieldOuterRadius;
	}

	public void setTextFieldOuterRadius(JTextField textFieldOuterRadius) {
		this.textFieldOuterRadius = textFieldOuterRadius;
	}

	public JTextField getTextFieldInnerRadius() {
		return textFieldInnerRadius;
	}

	public void setTextFieldInnerRadius(JTextField textFieldInnerRadius) {
		this.textFieldInnerRadius = textFieldInnerRadius;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
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
			JLabel lblDonutCenterX = new JLabel("Center X:");
			GridBagConstraints gbc_lblDonutCenterX = new GridBagConstraints();
			gbc_lblDonutCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblDonutCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblDonutCenterX.gridx = 0;
			gbc_lblDonutCenterX.gridy = 0;
			contentPanel.add(lblDonutCenterX, gbc_lblDonutCenterX);
		}
		{
			textFieldDonutCenterX = new JTextField();
			textFieldDonutCenterX.setText(String.valueOf(DrawingPanel.getDonutCenterX()));
			GridBagConstraints gbc_textFieldDonutCenterX = new GridBagConstraints();
			gbc_textFieldDonutCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDonutCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDonutCenterX.gridx = 1;
			gbc_textFieldDonutCenterX.gridy = 0;
			contentPanel.add(textFieldDonutCenterX, gbc_textFieldDonutCenterX);
			textFieldDonutCenterX.setColumns(10);
		}
		{
			JLabel lblDonutCenterY = new JLabel("Center Y:");
			GridBagConstraints gbc_lblDonutCenterY = new GridBagConstraints();
			gbc_lblDonutCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblDonutCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblDonutCenterY.gridx = 0;
			gbc_lblDonutCenterY.gridy = 1;
			contentPanel.add(lblDonutCenterY, gbc_lblDonutCenterY);
		}
		{
			textFieldDonutCenterY = new JTextField();
			textFieldDonutCenterY.setText(String.valueOf(DrawingPanel.getDonutCenterY()));
			GridBagConstraints gbc_textFieldDonutCenterY = new GridBagConstraints();
			gbc_textFieldDonutCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDonutCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDonutCenterY.gridx = 1;
			gbc_textFieldDonutCenterY.gridy = 1;
			contentPanel.add(textFieldDonutCenterY, gbc_textFieldDonutCenterY);
			textFieldDonutCenterY.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer Radius:");
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 0;
			gbc_lblOuterRadius.gridy = 2;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			textFieldOuterRadius = new JTextField();
			//textFieldOuterRadius.setText(String.valueOf(DrawingPanel.get));
			GridBagConstraints gbc_textFieldOuterRadius = new GridBagConstraints();
			gbc_textFieldOuterRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldOuterRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOuterRadius.gridx = 1;
			gbc_textFieldOuterRadius.gridy = 2;
			contentPanel.add(textFieldOuterRadius, gbc_textFieldOuterRadius);
			textFieldOuterRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner Radius:");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 3;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInnerRadius = new JTextField();
			if(donut != null) {
				if(donut.getInnerRadius() == -1) {
					textFieldInnerRadius.setText("");
				}
				else {
					textFieldInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
				}
			}
			GridBagConstraints gbc_textFieldInnerRadius = new GridBagConstraints();
			gbc_textFieldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInnerRadius.gridx = 1;
			gbc_textFieldInnerRadius.gridy = 3;
			contentPanel.add(textFieldInnerRadius, gbc_textFieldInnerRadius);
			textFieldInnerRadius.setColumns(10);
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
							int radiusO = Integer.parseInt(textFieldOuterRadius.getText());
							int radiusI = Integer.parseInt(textFieldInnerRadius.getText());
							int centerX = Integer.parseInt(textFieldDonutCenterX.getText());
							int centerY = Integer.parseInt(textFieldDonutCenterY.getText());
							
							if(radiusI==radiusO || radiusI>radiusO) {
								JOptionPane.showMessageDialog(null, "Inner radius value must be smaller than outer radius value", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else if(radiusI>0 && radiusO>0 && centerX>0 && centerY>0) {
								donut.setCenter(new Point(centerX, centerY));
								donut.setRadius(radiusO);
								donut.setInnerRadius(radiusI);
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
						/*
						if((Integer.parseInt(textFieldInnerRadius.getText()) > (Integer.parseInt(textFieldOuterRadius.getText())))) {
							JOptionPane.showMessageDialog(null, "Inner radius value exceeds outer radius value", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						else {
							try {
								donut.setRadius(Integer.parseInt(textFieldOuterRadius.getText()));
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
							donut.setInnerRadius(Integer.parseInt(textFieldInnerRadius.getText()));
							donut.setCenter(new Point(Integer.parseInt(textFieldDonutCenterX.getText()), Integer.parseInt(textFieldDonutCenterY.getText())));
						}
						commited = true;
						dispose();
						*/
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
	public void setDonut(Donut donut) {
		this.donut = donut;
	}
	public Shape getDonut() {
		return donut;
	}

}
