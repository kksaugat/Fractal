package edu.buffalo.cse116;
import edu.buffalo.cse116.ColorModelFactory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.buffalo.fractal.FractalPanel;
import java.awt.image.IndexColorModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public  class GUI implements ActionListener {
	
private static Main _main;
	private JFrame _frame;
	private static FractalPanel _fractalPanel;
	private JPanel _optionsMenu;
	private JButton file;
	private JButton ColorScheme;
	private JButton Fractals;
    private static final int WIDTH = 600;;
    private static final int HEIGHT = 600;
	private static int [][] _array;
	
	public GUI(){
		_main = new Main();
		ColorModelFactory CMF = new ColorModelFactory();
		_fractalPanel = new FractalPanel();
		_frame = new JFrame("Fractals Images");
		_frame.setVisible(true);
		_frame.setSize(WIDTH,HEIGHT);
		_optionsMenu = new JPanel();
		_optionsMenu.setBackground(Color.BLACK);
		file = new JButton ("File");
		ColorScheme = new JButton ("ColorScheme");
		Fractals = new JButton("Fractals");
		file.setSize(20, 20);
		ColorScheme.setSize(20, 20);
		_optionsMenu.add(file);
		_optionsMenu.add(ColorScheme);
		_optionsMenu.add(Fractals);
		_frame.add(_optionsMenu);
	Fractals.addActionListener(new Action());
	file.addActionListener(new Action2());
	ColorScheme.addActionListener(new Action4 ());
	}

	public static void setArrayType(int[][] arr){
		 			_array = arr;
		 		}
	
	
	
	
static class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame2 = new JFrame("Fractals");
		JButton MultiBrot = new JButton("MultiBrot");
		JButton BurningShip = new JButton("BurningShip");
		JButton Julia = new JButton("Julia");
		JButton MandelBrot = new JButton("MandelBrot");
		frame2.setVisible(true);
		frame2.setSize(300, 200);
		JPanel panel = new JPanel();
		panel.add(MultiBrot);
		panel.add(BurningShip);
		panel.add(Julia);
		panel.add(MandelBrot);
		frame2.add(panel);
		MultiBrot.addActionListener(new Action3());
	
	
	}

	
}
static class Action2 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
JFrame frame3 = new JFrame("File");
JLabel label = new JLabel("You are about to exit",JLabel.CENTER);
frame3.setSize(300, 300);
frame3.setVisible(true);
frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
frame3.add(label);	
}
	
}
static class Action3 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("MultiBrot")){
		
		setArrayType(_main.setArrMultiBrot());
		
		
		for(int y = 0; y < 512; y++){
			for(int x = 0; x < 512; x++){
				System.out.println("[" + x + "]" + "[" + y + "]");
				IndexColorModel model = ColorModelFactory.createBluesColorModel(_array[x][y]);
				_fractalPanel.setIndexColorModel(model);
				
			}
		}
		
		
		System.out.println("MultiBrot Selected");
	}
	
	if(e.getActionCommand().equals("MandelBrot")){
		
		System.out.println("MandelBrot Selected");
	}
	
	if(e.getActionCommand().equals("BurningShip")){
	
		System.out.println("BurningShip Selected");
	}
	
	if(e.getActionCommand().equals("Julia")){
		
		System.out.println("Julia Selected");
	}
	
}


}


static class Action4 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	JFrame ColorFrame = new JFrame("Colors");
	ColorFrame.setSize(200, 200);
	JPanel ColorPanel = new JPanel();
	JButton Rainbow = new JButton("Rainbow");
	JButton Blues = new JButton("Blues");
	JButton Grays = new JButton("Grays");
	ColorPanel.add(Rainbow);
	ColorPanel.add(Blues);
	ColorPanel.add(Grays);
	ColorFrame.add(ColorPanel);
	ColorFrame.setVisible(true); 
}

static class Action5 implements ActionListener{
public void actionPerformed1(ActionEvent e) {
	if(e.getActionCommand().equals("Rainbow"));
	
		_fractalPanel.updateImage(_array);
		
			for(int y = 0; y < 512; y++){
				for(int x = 0; x < 512; x++){
					System.out.println("[" + x + "]" + "[" + y + "]");
				IndexColorModel model = ColorModelFactory.createRainbowColorModel(_array[x][y]);
					_fractalPanel.setIndexColorModel(model);
				_fractalPanel.getColorModel(); 
				
				}}}					

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}}}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}}