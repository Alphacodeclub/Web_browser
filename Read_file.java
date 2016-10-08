package com.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Read_file extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	 
	public Read_file(){
		super("Browser");
		addressBar = new JTextField("Enter a url");
		addressBar.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent event) {
						// TODO Auto-generated method stub
						loadCrap(event.getActionCommand());
					}
				
					}	
				);
			add(addressBar,BorderLayout.NORTH);
			
			display = new JEditorPane();
			display.setEditable(false);
			display.addHyperlinkListener(
					new HyperlinkListener() {
						
						@Override
						public void hyperlinkUpdate(HyperlinkEvent event){
							// TODO Auto-generated method stub
							if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadCrap(event.getURL().toString());
								
							}
						}
					}
				);
			add(new JScrollPane(display), BorderLayout.CENTER);
			setSize(500,300);
			setVisible(true);
		  }
		//load crap to display on GUI
	private void loadCrap(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	}



