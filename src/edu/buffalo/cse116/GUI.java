package edu.buffalo.cse116;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.buffalo.fractal.FractalPanel;

public class GUI implements ActionListener {
	
	private main _main;
	private FractalPanel _fractalPanel;
	private JFrame _frame;
	private JPanel _optionsMenu;
	
	
	private int[][] _array;

		public GUI(){
		
			_main = new main();
			_frame = new JFrame();
			_fractalPanel = new FractalPanel();
			_optionsMenu = new JPanel();
			
			
			 JButton multiBrot = new JButton("MultiBrot");	//creates fractal type buttons
			 JButton mandelBrot = new JButton("MandelBrot");
			 JButton burningShip = new JButton("BurningShip");
			 JButton Julia = new JButton("Julia");
			 multiBrot.addActionListener(this);
			 mandelBrot.addActionListener(this);
			 burningShip.addActionListener(this);
			 Julia.addActionListener(this);
			 
			 _optionsMenu.add(multiBrot);
			 _optionsMenu.add(mandelBrot);
			 _optionsMenu.add(burningShip);
			 _optionsMenu.add(Julia);
	
	
	
			_frame.add(_fractalPanel);
			_frame.add(_optionsMenu, BorderLayout.PAGE_END);
			
			_frame.setSize(1000, 800);
			_frame.setVisible(true);
			_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	
		
		public void setArrayType(int[][] arr){
			_array = arr;
		}
		

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals("MultiBrot")){
				
				setArrayType(_main.setArrMultiBrot());
				_fractalPanel.updateImage(_array);
				
				for(int y = 0; y < 512; y++){
					for(int x = 0; x < 512; x++){
						System.out.println("[" + x + "]" + "[" + y + "]");
						IndexColorModel model = ColorModelFactory.createBluesColorModel(_array[x][y]);
						_fractalPanel.setIndexColorModel(model);
						
					}
				}
				
				
				System.out.println("MultiBrot Selected");
			}
			
			if(event.getActionCommand().equals("MandelBrot")){
				
				System.out.println("MandelBrot Selected");
			}
			
			if(event.getActionCommand().equals("BurningShip")){
			
				System.out.println("BurningShip Selected");
			}
			
			if(event.getActionCommand().equals("Julia")){
				
				System.out.println("Julia Selected");
			}
			
		}
	
	
}
