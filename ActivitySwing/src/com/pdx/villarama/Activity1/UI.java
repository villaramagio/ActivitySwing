package com.pdx.villarama.Activity1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UI extends JFrame implements ActionListener{

	JLabel firstName, lastName, gender, birthDate;
	JTextField firstNameTF, lastNameTF, birthDateTF;
	JComboBox genderCB;
	JTable table;
	JScrollPane sp;
	JTableHeader tableStyle;
	JButton addNew, save, delete;
	DefaultTableModel tableModel;
	int id;
	String columnNames[] = {"ID", "Last Name", "First Name", "Gender", "Birthday"};
	String genders[] = { "Male" , "Female" };
	Object[] data;
	
	public UI() {
		

		
		firstName = new JLabel("First Name:");
		firstName.setBounds(20, 50, 100, 25);
		add(firstName);
		
		firstNameTF = new JTextField();
		firstNameTF.setBounds(90, 50, 200, 25);
		add(firstNameTF);
		
		lastName = new JLabel("Last Name:");
		lastName.setBounds(20, 90, 100, 25);
		add(lastName);
		
		lastNameTF = new JTextField();
		lastNameTF.setBounds(90, 90, 200, 25);
		add(lastNameTF);
		
		gender = new JLabel("Gender:");
		gender.setBounds(20, 130, 100, 25);
		add(gender);
		
		genderCB = new JComboBox(genders);
		genderCB.setBounds(90, 130, 200, 25);
		add(genderCB);
		
		birthDate = new JLabel("Birthday:");
		birthDate.setBounds(20, 170, 100, 25);
		add(birthDate);
		
		birthDateTF = new JTextField();
		birthDateTF.setBounds(90, 170, 200, 25);
		add(birthDateTF);
		
		addNew = new JButton("Add New");
		addNew.setBounds(20, 210, 100, 25);
		addNew.setBackground(Color.GREEN);
		add(addNew);
		
		save = new JButton("Save");
		save.setBounds(125, 210, 100, 25);
		save.setBackground(Color.BLUE);
		add(save);
		
		delete = new JButton("Delete");
		delete.setBounds(230, 210, 100, 25);
		delete.setBackground(Color.RED);
		add(delete);
		
	        tableModel = new DefaultTableModel(columnNames, 0);
       	        table = new JTable(tableModel);
     	        sp = new JScrollPane(table);
     	        sp.setBounds(20, 250, 750, 200);
      	        add(sp);
       	        tableStyle = table.getTableHeader();
       	        tableStyle.setBackground(Color.GRAY);
       	        tableStyle.setForeground(Color.WHITE);
		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		uponLaunch();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				delete.setEnabled(true);
				
			}
			
		});

		setTitle("Swing Practice");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		String gender = genderCB.getSelectedItem().toString();
		String birthDate = birthDateTF.getText();
		
		
		if(e.getSource() == addNew) {
			firstNameTF.setEnabled(true);
			lastNameTF.setEnabled(true);
			genderCB.setEnabled(true);
			birthDateTF.setEnabled(true);
			addNew.setEnabled(false);
			save.setEnabled(true);
			delete.setEnabled(false);
		}
		else if(e.getSource() == save) {
			id += 1;
			data = new Object[] {id, lastName, firstName, gender, birthDate};
			tableModel = (DefaultTableModel) table.getModel();
			tableModel.addRow(data);
			firstNameTF.setText("");
			lastNameTF.setText("");
			birthDateTF.setText("");
			firstNameTF.setEnabled(false);
			lastNameTF.setEnabled(false);
			genderCB.setEnabled(false);
			birthDateTF.setEnabled(false);
			addNew.setEnabled(true);
			save.setEnabled(false);
		}
		else if (e.getSource() == delete) {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			tblModel.removeRow(table.getSelectedRow());
			delete.setEnabled(true);
		}

		
	}
	public void uponLaunch() {
		
		addNew.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);
		
		lastNameTF.setEnabled(false);
		firstNameTF.setEnabled(false);
		genderCB.setEnabled(false);
		birthDate.setEnabled(false);
		save.setEnabled(false);
		delete.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new UI();
			
	}

}
