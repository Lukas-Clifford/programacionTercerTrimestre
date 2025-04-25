package aucorsa.GUI.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel{

	private JButton searchButton = new JButton("SEARCH");
	private JButton insertButton = new JButton("INSERT");
	private JButton deleteButton = new JButton("DELETE");
	
	public ToolBar() {
		configurePanel();
	}
	
	private void configurePanel() {
		
		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());
		
		addButtons();
		
	}
	
	private void addButtons() {
		this.add(this.searchButton);
		this.add(this.insertButton);
		this.add(this.deleteButton);
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JButton getInsertButton() {
		return insertButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	
}
