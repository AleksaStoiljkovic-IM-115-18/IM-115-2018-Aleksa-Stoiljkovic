package drawingGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {
	
	private boolean commited;
	static Line line;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartPointX;
	private JTextField textFieldStartPointY;
	private JTextField textFieldEndPointX;
	private JTextField textFieldEndPointY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
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
			JLabel lblStartPointX = new JLabel("Start Point X:");
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 0;
			gbc_lblStartPointX.gridy = 0;
			contentPanel.add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			setTextFieldStartPointX(new JTextField());
			getTextFieldStartPointX().setText(String.valueOf(DrawingPanel.getLineStartPointX()));
			GridBagConstraints gbc_textFieldStartPointX = new GridBagConstraints();
			gbc_textFieldStartPointX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartPointX.gridx = 1;
			gbc_textFieldStartPointX.gridy = 0;
			contentPanel.add(getTextFieldStartPointX(), gbc_textFieldStartPointX);
			getTextFieldStartPointX().setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("Start Point Y:");
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 0;
			gbc_lblStartPointY.gridy = 1;
			contentPanel.add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			textFieldStartPointY = new JTextField();
			textFieldStartPointY.setText(String.valueOf(DrawingPanel.getLineStartPointY()));
			GridBagConstraints gbc_textFieldStartPointY = new GridBagConstraints();
			gbc_textFieldStartPointY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartPointY.gridx = 1;
			gbc_textFieldStartPointY.gridy = 1;
			contentPanel.add(textFieldStartPointY, gbc_textFieldStartPointY);
			textFieldStartPointY.setColumns(10);
		}
		{
			JLabel lblEndPointX = new JLabel("End Point X:");
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 0;
			gbc_lblEndPointX.gridy = 2;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			textFieldEndPointX = new JTextField();
			textFieldEndPointX.setText(String.valueOf(DrawingPanel.getLineEndPointX()));
			GridBagConstraints gbc_textFieldEndPointX = new GridBagConstraints();
			gbc_textFieldEndPointX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndPointX.gridx = 1;
			gbc_textFieldEndPointX.gridy = 2;
			contentPanel.add(textFieldEndPointX, gbc_textFieldEndPointX);
			textFieldEndPointX.setColumns(10);
		}
		{
			JLabel lblEndPointY = new JLabel("End Point Y:");
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointY.insets = new Insets(0, 0, 0, 5);
			gbc_lblEndPointY.gridx = 0;
			gbc_lblEndPointY.gridy = 3;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			textFieldEndPointY = new JTextField();
			textFieldEndPointY.setText(String.valueOf(DrawingPanel.getLineEndPointY()));
			GridBagConstraints gbc_textFieldEndPointY = new GridBagConstraints();
			gbc_textFieldEndPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndPointY.gridx = 1;
			gbc_textFieldEndPointY.gridy = 3;
			contentPanel.add(textFieldEndPointY, gbc_textFieldEndPointY);
			textFieldEndPointY.setColumns(10);
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
							int	startX = Integer.parseInt(getTextFieldStartPointX().getText());
							int	startY = Integer.parseInt(textFieldStartPointY.getText());
							int endX = Integer.parseInt(textFieldEndPointX.getText());
							int endY = Integer.parseInt(textFieldEndPointY.getText());

							if(startX>0 && startY>0 && endX>0 && endY>0) {
								line.setStartPoint(new Point(startX, startY));
								line.setEndPoint(new Point(endX, endY));
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

	public void setLine(Line line) {
		this.line = line;
	}
	public boolean isCommited() {
		return commited;
	}
	public void setCommited(boolean commited) {
		this.commited = commited;
	}
	public static Line getLine() {
		return line;
	}

	public JTextField getTextFieldStartPointX() {
		return textFieldStartPointX;
	}
	public JTextField getTextFieldStartPointY() {
		return textFieldStartPointY;
	}

	public void setTextFieldStartPointX(JTextField textFieldStartPointX) {
		this.textFieldStartPointX = textFieldStartPointX;
	}


	public JTextField getTextFieldEndPointX() {
		return textFieldEndPointX;
	}

	public void setTextFieldEndPointX(JTextField textFieldEndPointX) {
		this.textFieldEndPointX = textFieldEndPointX;
	}

	public JTextField getTextFieldEndPointY() {
		return textFieldEndPointY;
	}

	public void setTextFieldEndPointY(JTextField textFieldEndPointY) {
		this.textFieldEndPointY = textFieldEndPointY;
	}

	public void setTextFieldStartPointY(JTextField textFieldStartPointY) {
		this.textFieldStartPointY = textFieldStartPointY;
	}

}
