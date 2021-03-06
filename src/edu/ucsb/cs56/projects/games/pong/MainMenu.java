package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Class for Main Menu selection
public class MainMenu {
    private int levelDifficulty;
    private int newWindowWidth;
    private int newWindowHeight;

    public JRadioButton easy;
    public JRadioButton medium;
    public JRadioButton hard;

    Instructions i;
    Screen s;

    public MainMenu() {
	
       	JFrame frame = new JFrame( "Main Menu" );
	JPanel panel = new JPanel();
	JButton instructions = new JButton( "Instructions" );
	JButton play = new JButton( "Play" );
	JButton highScores = new JButton( "High Scores" );

	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.add( panel );
	
	panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

	instructions.setAlignmentX( JFrame.CENTER_ALIGNMENT );
	highScores.setAlignmentX( JFrame.CENTER_ALIGNMENT );
	play.setAlignmentX( JFrame.CENTER_ALIGNMENT );
	
	panel.add( instructions );
	panel.add( highScores );
       
	JPanel ButtonPanel = new JPanel();

	ButtonGroup difficulty = new ButtonGroup();
	easy = new JRadioButton( "Easy" );
	medium = new JRadioButton( "Medium" );
	hard = new JRadioButton( "Hard" );

	
	difficulty.add(easy);
	difficulty.add(medium);
	difficulty.add(hard);

	easy.setSelected(true);

	ButtonPanel.add(easy);
	ButtonPanel.add(medium);
	ButtonPanel.add(hard);

	panel.add(ButtonPanel);
	panel.add( play );
	frame.setSize( 640, 480 );
	frame.setLocationRelativeTo( null );
	frame.setVisible( true );
	frame.setResizable( false );
	
	//Button Listener for Play Button
	play.addActionListener( new PlayListener());
	instructions.addActionListener( new InstructionsListener());
	highScores.addActionListener( new HighScoresListener() );

    }
    //Sets level difficulty based on user input
    public int getLevelDifficulty()
    {
	if( easy.isSelected() )
	    levelDifficulty = 80;
	
	if( medium.isSelected() )
	    levelDifficulty = 100;
	
	if( hard.isSelected() )
	    levelDifficulty = 120;

	return levelDifficulty;
    }
    //sets new window parameters based on level difficulty
    class PlayListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    levelDifficulty = getLevelDifficulty();
	    newWindowWidth = 8 * levelDifficulty;
	    newWindowHeight = 6 * levelDifficulty;
	    s = new Screen( newWindowWidth, newWindowHeight );
	}
    }
    //Button Listener for instructions button
    class InstructionsListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    if( i == null )
		i = new Instructions();
	    else
		i.setToVisible();
	}

    }
    
    //Button Listener for instructions button
    class HighScoresListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    DisplayHighScores displayhs = new DisplayHighScores( "", 0 );
	}
    }
    
    public static void main (String[] args) {

	MainMenu m = new MainMenu();
    }

}
