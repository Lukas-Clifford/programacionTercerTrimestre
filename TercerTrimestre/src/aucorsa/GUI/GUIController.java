package aucorsa.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aucorsa.GUI.panels.ToolBar;

public class GUIController {
	
	private JFrame mainFrame = new JFrame("AUCORSA");

	private ToolBar toolBar = new ToolBar();
	
	
	public GUIController() {
		configureMainFrame();
		
	}
	
	private void configureMainFrame() {
		
		this.mainFrame.setVisible(true);
		this.mainFrame.setSize(800, 700);
		this.mainFrame.setResizable(false);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLocation(400, 100);
		this.mainFrame.setLayout(new BorderLayout());
		
		this.mainFrame.add(toolBar, BorderLayout.NORTH);
		addListenersToToolBarButtons();
		
		
	}
	
	private void addListenersToToolBarButtons() {
		toolBar.getSearchButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		
		toolBar.getInsertButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
			}
			
		
		});
		
		
		
		toolBar.getDeleteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
			}
			
		});
	}
	
	
	
	

}
