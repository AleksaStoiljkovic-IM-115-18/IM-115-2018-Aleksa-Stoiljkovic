package sortGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawingGui.DlgRectangle;
import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SortFrame extends JFrame {

	private int index;
	private JPanel contentPane;
	private static ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
	private static JTextField textFieldX;
	private static JTextField textFieldY;
	private static JTextField textFieldWidth;
	private static JTextField textFieldHeight;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnSort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SortFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		DefaultListModel model = new DefaultListModel();
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					index = list.getSelectedIndex();
					int x = rects.get(index).getUpperLeft().getX();
					int y = rects.get(index).getUpperLeft().getY();
					int width = rects.get(index).getWidth();
					int height = rects.get(index).getHeight();
					
					textFieldX.setText(String.valueOf(x));
					textFieldY.setText(String.valueOf(y));
					textFieldWidth.setText(String.valueOf(width));
					textFieldHeight.setText(String.valueOf(height));
				}
				catch(Exception ex) {
					
				}
				
			}
		});
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 4;
		gbc_list.gridheight = 6;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 0;
		contentPane.add(list, gbc_list);
						
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddSort dlg = new DlgAddSort();
				dlg.setModal(true);
				dlg.setRectangle(new Rectangle(new Point(-1, -1), -1, -1));
				dlg.setVisible(true);
				if(dlg.isAddCommited()) {
					rects.add(0, dlg.getRectangle());
					model.add(0, rects.get(0));
					list.setModel(model);
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				DlgDltSort dlg = new DlgDltSort();
				dlg.setModal(true);
				dlg.setVisible(true);
				if(dlg.isDltCommited()) {
					rects.remove(list.getSelectedIndex());
					model.remove(list.getSelectedIndex());
					list.setModel(model);
					textFieldX.setText("");
					textFieldY.setText("");
					textFieldWidth.setText("");
					textFieldHeight.setText("");
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 1;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		btnSort = new JButton("Sort By Area");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(rects, new Comparator<Rectangle>() {
					public int compare(Rectangle r1, Rectangle r2) {
						return Integer.valueOf(r1.area()).compareTo(r2.area());
					}
				});
				
				int rCount;
				for(rCount=0; rCount<rects.size(); rCount++) {
					model.removeAllElements();
					
					for(int i=0; i<rects.size(); i++) {
						model.add(i, rects.get(i));
						list.setModel(model);
					}
				}
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 0;
		gbc_btnSort.gridy = 2;
		contentPane.add(btnSort, gbc_btnSort);
		
		lblNewLabel = new JLabel("Upper Left X:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 6;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("UpperLeftY");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Width");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 6;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Height");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldX = new JTextField();
		textFieldX.setEditable(false);
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldX.gridx = 2;
		gbc_textFieldX.gridy = 7;
		contentPane.add(textFieldX, gbc_textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.setEditable(false);
		GridBagConstraints gbc_textFieldY = new GridBagConstraints();
		gbc_textFieldY.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldY.gridx = 3;
		gbc_textFieldY.gridy = 7;
		contentPane.add(textFieldY, gbc_textFieldY);
		textFieldY.setColumns(10);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setEditable(false);
		GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
		gbc_textFieldWidth.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWidth.gridx = 4;
		gbc_textFieldWidth.gridy = 7;
		contentPane.add(textFieldWidth, gbc_textFieldWidth);
		textFieldWidth.setColumns(10);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setEditable(false);
		GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
		gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHeight.gridx = 5;
		gbc_textFieldHeight.gridy = 7;
		contentPane.add(textFieldHeight, gbc_textFieldHeight);
		textFieldHeight.setColumns(10);
		
		

	}

	public static JTextField getTextFieldY() {
		return textFieldY;
	}
	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}
	public static JTextField getTextFieldWidth() {
		return textFieldWidth;
	}
	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}
	public static JTextField getTextFieldHeight() {
		return textFieldHeight;
	}
	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}
	public static JTextField getTextFieldX() {
		return textFieldX;
	}
	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}
	public static ArrayList<Rectangle> getRects() {
		return rects;
	}
	public static void setRects(ArrayList<Rectangle> rects) {
		SortFrame.rects = rects;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

}