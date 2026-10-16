// Soham Malla and Peter Zhaung
// Januray 13 2024
// Valentina Krasteva
// This is a game that allows the user to learn about survival during a tornado alert. Learned to scale images from the following source: https://stackoverflow.com/questions/5895829/resizing-image-in-java. Learned to convert char to string using the following source: https://www.javatpoint.com/java-char-to-string.
// Human cap was designed with free canva imported resource: canva.com (Canva does not require citation for free image resources)
import hsa.Console;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class twisterSurvival extends Thread
{
    Console c; // Variable Representation of the console
    int points; // Stores the points the user has from the game. Dictates program flow(if it goes to winScene or failScene).
    String choice = ""; // Store's the menu choice of the user

    int playerX; // x coord of human sprite
    int playerY; // y coord of human sprite
    char input; // direction input for sprite
    BufferedImage sprite; // Image for sprite
    final int size = 17; // Size of random object arrays
    int[] xRandomObject = new int [13]; // array stores the randomly generated x-coords of the pickable objects in game
    int[] yRandomObject = new int [13]; // array stores the randomly generated y-coords of the pickable objects in game
    int[] x2RandomObject = new int [size]; //objects for floor 2
    int[] y2RandomObject = new int [size]; //objects for floor 2
    double endTime1;
    boolean[] pickedUp = new boolean [size]; // Array stores the boolean value for if the object is picked up or not in game.
    int inventory = 0; // Stores how many items the sprite is currently holding and has to deposit in the shelter for game.
    int floor = 1; // The floor level the sprite is on in the game.

    public twisterSurvival ()
    {
	c = new Console ();
    } // Constructor initializes the console


    // Pauses the program by asking for user input. Made by Soham.
    private void pauseProgram ()
    {
	c.getChar ();
    }


    // Clears screen and prints title. Made by Soham
    private void title ()
    {
	c.clear ();
	c.println ("\n\n");
	c.print ("", 34);
	c.println ("Instructions");
    }


    /* This program will showcase the maze portion of our twisterSurvival game. Made by Peter

    Variable Name     Type               Description
    menuBackground    BufferedImage       Creates the puzzle style background for our maze file
    i                 Integer             Used for for-loop
    note              BufferedImage       Image of the notes that the user will walk on top of
    playerX           int              Allows the player to move in the x-direction
    playerY           int              Allows the player to move in the y-direction
    grey              Color            Used for animating the human, stops human from leaving trail
    human             BufferedImage    Image of the human which will be animated
    humanSurprised    BufferedImage    Image of the human with a surprised look
    humanThinking     BufferedImage    Image of the human lost in thought
    menuBackground    BufferedImage    Image used for both the puzzle background and the questions
    */
    public void livingRoomMaze ()
    {
	c.clear ();
	//Background
	try
	{

	    // Menu Image and opitons
	    try
	    { // imports image
		for (int i = 0 ; i <= 1 ; i++)
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		    c.drawImage (menuBackground, 0, 0, null);
		}
	    }
	    catch (IOException e)
	    {
	    }

	}
	catch (Exception e)
	{
	}

	//Notes
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}

	try
	{
	    BufferedImage human = ImageIO.read (new File ("human.png"));
	    c.drawImage (human, 0, 250, null);
	}
	catch (IOException e)
	{
	}

	Color grey = new Color (217, 217, 217);

	try
	{
	    c.setColor (Color.black);
	    c.drawString ("This is not good!", 5, 240);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (grey);
	    c.drawString ("This is not good!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("I am panicking!", 5, 240);
	    BufferedImage humanSurprised = ImageIO.read (new File ("humanSurprised.png"));
	    c.drawImage (humanSurprised, 0, 250, null);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (grey);
	    c.drawString ("I am panicking!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("Wait a minute!", 5, 240);
	    BufferedImage humanThinking = ImageIO.read (new File ("humanThinking.png"));
	    c.drawImage (humanThinking, 0, 250, null);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}

	try
	{
	    c.setColor (grey);
	    c.drawString ("Wait a minute!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("I have prepared for this very scenario!", 5, 240);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	;
	try
	{
	    c.setColor (grey);
	    c.drawString ("I have prepared for this very scenario!", 5, 240);
	    c.fillRect (0, 250, 80, 120);
	    try
	    {

		BufferedImage human = ImageIO.read (new File ("human.png"));
		c.drawImage (human, 0, 250, null);
	    }
	    catch (IOException e)
	    {
	    }
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("I have notes scattered across the room!", 5, 240);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (grey);
	    c.drawString ("I have notes scattered across the room!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("Each note contains some critical info", 5, 228);
	    c.drawString ("on how to stay safe during a tornado!", 5, 240);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (grey);
	    c.drawString ("Each note contains some critical info", 5, 228);
	    c.drawString ("on how to stay safe during a tornado!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (Color.black);
	    c.drawString ("I just need to find them and read them!", 5, 240);
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
	try
	{
	    c.setColor (grey);
	    c.drawString ("I just need to find them and read them!", 5, 240);
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	int playerX = 0;
	int playerY = 250;

	for (playerY = playerY ; playerY >= 187 ; playerY--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 47, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}

	for (playerX = playerX ; playerX <= 120 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }


	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }



	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("firstNote.png")); ////////////////////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;
	////////////////////////////////////////////////
	for (playerX = playerX ; playerX >= -10 ; playerX--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}

	for (playerY = playerY ; playerY >= 0 ; playerY--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("EFAScale.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX <= 215 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}



	for (playerY = playerY ; playerY <= 70 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("thirdNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX <= 265 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY >= -10 ; playerY--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("fourthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX <= 350 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("fifthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX >= 265 ; playerX--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY <= 95 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerX = playerX ; playerX <= 300 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY <= 180 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("sixthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX >= 220 ; playerX--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}

	for (playerY = playerY ; playerY <= 225 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("seventhNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}
	try
	{
	    BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 0, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 100, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 310, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 400, 0, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 250, 230, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 180, 220, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 430, 320, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 330, 200, null);
	    note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
	    c.drawImage (note, 200, 450, null);
	    note = ImageIO.read (new File ("endGate.png"));
	    c.drawImage (note, 600, 450, null);

	}
	catch (IOException e)
	{
	}
	;

	/////////////////////////////////////////////////////
	for (playerY = playerY ; playerY >= 180 ; playerY--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerX = playerX ; playerX <= 300 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY <= 320 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerX = playerX ; playerX >= 205 ; playerX--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY <= 420 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("eighthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}


	/////////////////////////////////////////////////////
	for (playerX = playerX ; playerX >= 180 ; playerX--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerX = playerX ; playerX <= 205 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	for (playerY = playerY ; playerY >= 320 ; playerY--)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}

	for (playerX = playerX ; playerX <= 430 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}
	try
	{
	    BufferedImage human = ImageIO.read (new File ("ninthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}


	/////////////////////////////////////////////////////
	for (playerY = playerY ; playerY <= 365 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }

	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}


	for (playerX = playerX ; playerX <= 550 ; playerX++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}






	for (playerY = playerY ; playerY <= 420 ; playerY++)
	{
	    try
	    {
		c.setColor (grey);
		c.fillRect (playerX + 46, playerY + 10, 28, 44); ///(+47, +10, 25,44)
		try
		{
		    BufferedImage human = ImageIO.read (new File ("human.png"));
		    c.drawImage (human, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}

		Thread.sleep (25);
	    }
	    catch (Exception e)
	    {
	    }

	    try
	    {
		BufferedImage note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 0, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 100, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 310, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 400, 0, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 250, 230, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 180, 220, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 430, 320, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 330, 200, null);
		note = ImageIO.read (new File ("frame-1-removebg-preview.png"));
		c.drawImage (note, 200, 450, null);
		note = ImageIO.read (new File ("endGate.png"));
		c.drawImage (note, 600, 450, null);

	    }
	    catch (IOException e)
	    {
	    }
	    ;
	}


	try
	{
	    BufferedImage human = ImageIO.read (new File ("tenthNote.png")); ////////////////////////////////
	    c.drawImage (human, 100, 0, null);
	}
	catch (IOException e)
	{
	}

	try
	{ // imports image
	    for (int i = 0 ; i <= 1 ; i++)
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("0.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	}
	catch (IOException e)
	{
	}

	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #1.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #1 Correct Answer.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #2.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #2 Correct Answer.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #3.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #3 Correct Answer.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #4.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.getChar ();
	try
	{
	    BufferedImage human = ImageIO.read (new File ("Question #4 Correct Answer.png")); ////////////////////////////////
	    c.drawImage (human, 0, 0, null);
	}
	catch (IOException e)
	{
	}


	endTime123 = (int) (System.currentTimeMillis () - startTime1) / 1000;


    }


    ///Created by Soham entirely
    /*
    splashScreen() is used to represent

    Name    Type                 Purpose

    s       splashScreen_S

    p       splashScreen_P

    i       int

    */
    public void splashScreen ()
    {
	c.fillRect (0, 0, 640, 500);

	splashScreen_S s = new splashScreen_S (c);
	splashScreen_P p = new splashScreen_P (c);
	s.start ();
	p.start ();
	try
	{
	    p.join ();
	    s.join ();
	}
	catch (InterruptedException e)
	{

	}
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);
	c.setColor (Color.gray);
	c.fillOval (270, 140, 100, 100);
	c.setColor (Color.gray);
	c.fillOval (270, 240, 100, 100);

	c.setColor (Color.black);
	c.drawString ("S", 315, 200);
	c.setColor (Color.black);
	c.drawString ("P", 315, 300);
	c.setColor (Color.gray);
	c.setFont (new Font ("Arial", Font.BOLD, 25));
	c.drawString ("Productions", 260, 380);


	try
	{
	    Thread.sleep (3000);
	}
	catch (InterruptedException e)
	{

	}

	///Loop #1: Draws a white rectangle moving to the right of the screen
	for (int i = 640 ; i >= 0 ; i--)
	{
	    c.setColor (Color.white);
	    c.drawLine (i, 0, i, 500);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (InterruptedException e)
	    {

	    }
	}
    }


    ///Design created by Peter, code created by Soham
    /*

    Name                Type               Purpose

    darkGray            Color              Used for colour of the rectangle buttons

    menuBackground      BufferedImage      Creates the background image for the menu

    key                 char               Checks what key user pressed
    choice              char               Directs user to next part of the game

    */
    public void mainMenu ()
    {
	c.clear ();
	Color darkGray = new Color (100, 100, 100);

	try
	{
	    BufferedImage menuBackground = ImageIO.read (new File ("pixil-frame-0.png"));
	    c.drawImage (menuBackground, -190, 0, null);
	    c.setColor (darkGray);
	    c.fillRect (20, 200, 350, 75);
	    c.setFont (new Font ("Courier", 1, 18));
	    c.setColor (Color.white);
	    c.drawString ("Press 'p' to play", 25, 220);
	    c.drawString ("Press 'e' to exit", 25, 245);
	    c.drawString ("Press 'd' to display high score", 25, 270);
	    char key;
	    while (true)
	    {
		try
		{
		    key = c.getChar ();
		    if (key != 'p' && key != 'e' && key != 'd')
		    {
			throw new IllegalArgumentException ();
		    }
		    break;
		}
		catch (IllegalArgumentException e)
		{
		    JOptionPane.showMessageDialog (null, "Please only press the menu options listed. 'p', 'e', or 'd' ", "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    choice = String.valueOf (key);
	}
	catch (IOException e)
	{

	}


    }


    /*
    Type                Name              Purpose
    bed              BufferedImage        Image of the bed.
    tmp                Image              Scaled image of the bed.
    lightYellow        Color              Background color.
    brown              Color              The color of the side table.
    i                  int                Repeats phone alert animation 3 times.
    j                  int                Used to animate the phone alerts by adjusting y-value.
    person           BufferedImage        Image of human sleeping.
    tmp2             Image                Scaled image of human sleeping.
    x1               int[]                x-coord of centre phone alert.
    x2               int[]                x-coord of left phone alert.
    x3               int[]                x-coord of right phone alert.
    person2         BufferedImage         Image of human waking up.
    tmp3            Image                 Scaled Image of human waking up.
    person3         BufferedImage         Image of human facing left.
    person4         BufferedImage         Image of human facing front.
    person5         BufferedImage         Image of human facing right and being distressed.
    tmp4            Image                Scaled image of human facing left.
    tmp5            Image                Scaled image of human facing front.
    tmp6            Image                Scaled image of human facing right and being distressed.
     */
    public void cutScene ()
    {
	c.clear ();
	Color lightYellow = new Color (255, 255, 224);
	c.setColor (lightYellow);
	c.fillRect (0, 0, 640, 500);

	BufferedImage bed = null;
	Image tmp = null;
	try
	{
	    bed = ImageIO.read (new File ("Untitled_design-removebg-preview.png"));
	    tmp = bed.getScaledInstance (900, 700, Image.SCALE_SMOOTH);
	    c.drawImage (tmp, -280, -190, null);
	}
	catch (IOException e)
	{

	}

	// Person
	try
	{
	    BufferedImage person = ImageIO.read (new File ("Copy of Untitled (1) (1).png"));
	    Image tmp2 = person.getScaledInstance (400, 200, Image.SCALE_SMOOTH);
	    c.drawImage (tmp2, 190, 60, null);
	}
	catch (IOException e)
	{

	}

	// Side Table

	Color brown = new Color (90, 37, 25);

	c.setColor (brown);
	c.fillRect (410, 410, 170, 90);

	// Phone
	c.setColor (Color.gray);
	c.fillRoundRect (455, 395, 100, 15, 10, 10);
	c.setColor (Color.black);
	c.drawRoundRect (520, 400, 20, 5, 10, 10);

	c.setColor (Color.white);
	c.fillRect (455, 390, 100, 5);


	for (int i = 0 ; i < 3 ; i++)
	{
	    int[] x1 = {490, 505, 498};
	    int[] x2 = {450, 465, 498};
	    int[] x3 = {530, 545, 498};
	    for (int j = 0 ; j < 40 ; j++)
	    {
		c.setColor (Color.red);
		int[] y = {390 - j, 390 - j, 390};
		c.fillPolygon (x1, y, 3);
		c.fillPolygon (x2, y, 3);
		c.fillPolygon (x3, y, 3);

		try
		{
		    Thread.sleep (25);
		}
		catch (InterruptedException e)
		{

		}
		c.setColor (lightYellow);
		c.fillPolygon (x1, y, 3);
		c.fillPolygon (x2, y, 3);
		c.fillPolygon (x3, y, 3);
	    }
	}

	c.setColor (lightYellow);
	c.fillRect (200, 50, 450, 320);
	c.setColor (Color.red);
	c.setFont (new Font ("Arial", Font.BOLD, 50));
	c.drawString ("!", 505, 390);
	try
	{
	    BufferedImage person2 = ImageIO.read (new File ("Copy of Untitled (1)-min.png"));
	    Image tmp3 = person2.getScaledInstance (400, 200, Image.SCALE_SMOOTH);
	    c.drawImage (tmp, -280, -190, null);
	    c.drawImage (tmp3, 190, 60, null);
	    Thread.sleep (1500);
	}
	catch (IOException e)
	{

	}
	catch (InterruptedException e)
	{

	}

	c.setColor (lightYellow);
	c.fillRect (200, 50, 450, 250);
	c.drawImage (tmp, -280, -190, null);
	Image tmp5 = null;
	try
	{
	    BufferedImage person3 = ImageIO.read (new File ("HumanLeft_Sprite.png"));
	    Image tmp4 = person3.getScaledInstance (200, 329, Image.SCALE_SMOOTH);
	    for (int i = 0 ; i < 300 ; i++)
	    {
		c.drawImage (tmp4, 300 - i, 30, null);
		c.drawImage (tmp, -280, -190, null);
		Thread.sleep (10);
		c.setColor (lightYellow);
		c.fillRect (300 - i, 30, 200, 329);
	    }
	    c.drawImage (tmp, -280, -190, null);
	    c.drawImage (tmp4, 0, 30, null);
	    c.fillRect (0, 30, 200, 329);

	    BufferedImage person4 = ImageIO.read (new File ("HumanFront.png"));
	    tmp5 = person4.getScaledInstance (200, 329, Image.SCALE_SMOOTH);
	    for (int y = 0 ; y < 200 ; y++)
	    {
		c.drawImage (tmp5, 0, 30 + y, null);
		Thread.sleep (10);
		c.setColor (lightYellow);
		c.fillRect (0, 30 + y, 200, 329);
	    }
	    c.drawImage (tmp5, 0, 230, null);
	    for (int x = 0 ; x < 210 ; x++)
	    {
		c.drawImage (tmp5, 0 + x, 230, null);
		Thread.sleep (10);
		c.setColor (lightYellow);
		c.fillRect (0 + x, 230, 200, 329);
		c.drawImage (tmp, -280, -190, null);
	    }
	    c.drawImage (tmp5, 210, 230, null);
	    Thread.sleep (1000);

	}
	catch (IOException e)
	{

	}
	catch (InterruptedException e)
	{

	}

	c.setColor (Color.yellow);
	c.fillRoundRect (70, 60, 500, 300, 10, 10);
	c.setColor (Color.black);
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.drawRect (70 + i, 60 + i, 500, 300);
	}

	c.setFont (new Font ("Arial", Font.BOLD, 50));
	c.drawString ("Warning!", 220, 120);
	c.drawString ("Tornado Alert!", 150, 170);
	c.setFont (new Font ("Arial", Font.PLAIN, 14));
	c.drawString ("A Tornado is approaching your city.", 100, 200);
	c.drawString ("As a storm shelter volunteer, it is your job to lead citizens to safety.", 100, 220);
	c.drawString ("As a part of your job as a volunteer, you need to collect materials around", 100, 240);
	c.drawString ("your house that will be important in a shelter.", 100, 260);
	c.drawString ("In your living room, you will", 388, 260);
	c.drawString ("find notes to help you remember which materials need to collect.", 100, 280);
	c.drawString ("Press a key to continue: ", 100, 300);
	pauseProgram ();


	c.setColor (lightYellow);
	c.fillRect (0, 0, 640, 500);
	c.drawImage (tmp, -280, -190, null);

	c.setColor (brown);
	c.fillRect (410, 410, 170, 90);
	c.setColor (Color.gray);
	c.fillRoundRect (455, 395, 100, 15, 10, 10);
	c.setColor (Color.black);
	c.drawRoundRect (520, 400, 20, 5, 10, 10);

	c.setColor (Color.white);
	c.fillRect (455, 390, 100, 5);

	c.setColor (Color.red);
	c.setFont (new Font ("Arial", Font.BOLD, 50));
	c.drawString ("!", 505, 390);
	c.drawImage (tmp5, 210, 230, null);


	try
	{
	    Thread.sleep (500);
	    BufferedImage person5 = ImageIO.read (new File ("HumanFrantic.png"));
	    Image tmp6 = person5.getScaledInstance (200, 329, Image.SCALE_SMOOTH);
	    for (int i = 0 ; i < 400 ; i++)
	    {
		c.drawImage (tmp6, 210 - i, 230, null);
		Thread.sleep (15);
		c.setColor (lightYellow);
		c.fillRect (210 - i, 230, 200, 329);
		c.drawImage (tmp, -280, -190, null);
	    }
	}
	catch (IOException e)
	{

	}
	catch (InterruptedException e)
	{

	}
    }


    //Created entirely by Soham
    /*
    instructions() will give instructions to the user so the user knows
    how to play the game and what the purpose of the game is


    Variable Name       Type       Description
    grey                Color      Main colour used for drawing lines
    sprite              BufferedImage  Used to import HumanLeft_Sprite.png
    spriteScaled        Image      Allows image to become smaller
    */
    public void instructions ()
    {
	title ();

	for (int i = 0 ; i < 20 ; i++)
	{
	    c.setColor (Color.blue);
	    c.drawLine (0, 0 + i, 640, 0 + i);
	    c.drawLine (0, 500 - i, 640, 500 - i);
	    c.drawLine (0 + i, 0, 0 + i, 500);
	    c.drawLine (640 - i, 0, 640 - i, 500);

	    Color grey = new Color (128, 128, 128);
	    c.setColor (grey);
	    c.drawLine (20, 20 + i, 620, 20 + i);
	    c.drawLine (20, 480 - i, 620, 480 - i);
	    c.drawLine (20 + i, 20, 20 + i, 480);
	    c.drawLine (620 - i, 20, 620 - i, 480);
	}

	c.setFont (new Font ("Arial", Font.PLAIN, 12));
	c.setColor (Color.black);
	c.drawString ("This is an educational program meant to teach you about what to do during a tornado", 55, 100);
	c.drawString ("alert. It will teach you what to take from your house when going to a tornado shelter.", 55, 115);
	c.drawString ("This is done from the perspective of a storm shelter volunteer who just got an alert", 55, 130);
	c.drawString ("from his phone. ", 55, 145);///////
	c.drawString ("There will be 2 levels, the first being a maze, which is the living room of the character. ", 55, 175);
	c.drawString ("As the character automatically navigates the maze, they will collect sticky notes that", 55, 190);
	c.drawString ("have instructions and helpful information about the situation. This information will be", 55, 205);
	c.drawString ("tested in the second level, the game. The game gives access to the rest of the house", 55, 220);
	c.drawString ("(2 floors). You will now be able to control the character using the WASD keys. W is up,", 55, 235);
	c.drawString (" A is left, S is down, D is right.", 55, 265);////////
	c.drawString ("There will be various items strewn around the level. Some of these items will be useful", 55, 280);
	c.drawString ("and items you need to pick up during a tornado, and others will be useless.", 55, 295);
	c.drawString ("There will be items in both the first and second floor. You will spawn in the first", 55, 310);
	c.drawString ("floor, and you can go back and forth between the first and second floors by entering the", 55, 325);
	c.drawString ("stairs at the top right corner. The goal is to pick up as many useful items as you can in", 55, 340);
	c.drawString ("and deposit them in the shelter on the bottom right in3 min. At the end, there will be a", 55, 355);
	c.drawString (" win or fail scene displayed. The win scene will display your score and top 10 highest", 55,370);
	c.drawString (" scores. The highest scores will be saved to a text file called HighScores.txt.", 55, 385);


	try
	{
	    BufferedImage sprite = ImageIO.read (new File ("HumanLeft_Sprite.png"));
	    Image spriteScaled = sprite.getScaledInstance (20, 33, Image.SCALE_SMOOTH);
	    c.drawImage (spriteScaled, 310, 475, null);
	}
	catch (IOException e)
	{

	}

	pauseProgram ();

    }


    /*
    Backgroundcontains background for floor 1.

    VariableName        Type              Description
    menuBackground      BufferedImage     Background for the first floor
    */
    public void background ()
    {

	try
	{
	    BufferedImage menuBackground = ImageIO.read (new File ("firstFloorImage.png"));
	    c.drawImage (menuBackground, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.setColor (Color.black);

    }





    /*
    Objects contain the coordinates of pickable items that the user can pick up

    VariableName       Type              Description

    xRandomObject       int               X-Coordinates for objects (floor 1)
    yRandomObject       int               Y-Coordinates for objects (floor 1)
    x2RandomObject      int               X-Coordinates for objects (floor 2)
    y2RandomObject      int               Y-Coordinates for objects (floor 2)
    i                   int               Used for loops
    pickedUp            Boolean           When objects are generated, they are set to "not picked up" status
    */
    public void objects ()
    {

	for (int i = 0 ; i <= 10 ; i++)
	{
	    pickedUp [i] = false;
	}

	xRandomObject [0] = (int) Math.floor (Math.random () * (70 - 50) + 50);
	yRandomObject [0] = (int) Math.floor (Math.random () * (180 - 170) + 170);
	xRandomObject [1] = (int) Math.floor (Math.random () * (70 - 50) + 50);
	yRandomObject [1] = (int) Math.floor (Math.random () * (130 - 60) + 60);
	xRandomObject [2] = (int) Math.floor (Math.random () * (300 - 290) + 200);
	yRandomObject [2] = (int) Math.floor (Math.random () * (100 - 80) + 80);
	xRandomObject [3] = (int) Math.floor (Math.random () * (500 - 270) + 270);
	yRandomObject [3] = (int) Math.floor (Math.random () * (50 - 40) + 40);

	xRandomObject [4] = (int) Math.floor (Math.random () * (90 - 50) + 90);
	yRandomObject [4] = (int) Math.floor (Math.random () * (350 - 300) + 300);
	xRandomObject [5] = (int) Math.floor (Math.random () * (550 - 520) + 520);
	yRandomObject [5] = (int) Math.floor (Math.random () * ((200 - 180) + 180));

	xRandomObject [6] = (int) Math.floor (Math.random () * (230 - 220) + 220);
	yRandomObject [6] = (int) Math.floor (Math.random () * (480 - 440) + 440);
	xRandomObject [7] = (int) Math.floor (Math.random () * (470 - 310) + 310);
	yRandomObject [7] = (int) Math.floor (Math.random () * (200 - 180) + 180);
	xRandomObject [8] = (int) Math.floor (Math.random () * (40 - 10) + 10);
	yRandomObject [8] = (int) Math.floor (Math.random () * (480 - 440) + 440);
	xRandomObject [9] = (int) Math.floor (Math.random () * (480 - 460) + 460);
	yRandomObject [9] = (int) Math.floor (Math.random () * (430 - 410) + 410);
	xRandomObject [10] = (int) Math.floor (Math.random () * (400 - 370) + 370);
	yRandomObject [10] = (int) Math.floor (Math.random () * (390 - 370) + 370);
	xRandomObject [11] = 600;
	yRandomObject [11] = 315;
	xRandomObject [12] = 600;
	yRandomObject [12] = 360;

	x2RandomObject [0] = 55;
	y2RandomObject [0] = 456;
	x2RandomObject [1] = 28;
	y2RandomObject [1] = 400;
	x2RandomObject [2] = (int) Math.floor (Math.random () * (520 - 480) + 480);
	y2RandomObject [2] = (int) Math.floor (Math.random () * (350 - 340) + 340);
	x2RandomObject [3] = 180;
	y2RandomObject [3] = 100;
	x2RandomObject [4] = 455;
	y2RandomObject [4] = 130;
	x2RandomObject [5] = 255;
	y2RandomObject [5] = 200;
	x2RandomObject [6] = 130;
	y2RandomObject [6] = 60;
	x2RandomObject [7] = 280;
	y2RandomObject [7] = 300;
	x2RandomObject [8] = 190;
	y2RandomObject [8] = 60;
	x2RandomObject [9] = 455;
	y2RandomObject [9] = 400;
	x2RandomObject [10] = 320;
	y2RandomObject [10] = 350;
	x2RandomObject [11] = 200;
	y2RandomObject [11] = 280;
	x2RandomObject [12] = 250;
	y2RandomObject [12] = 290;
	x2RandomObject [13] = 60;
	y2RandomObject [13] = 300;
	x2RandomObject [14] = 200;
	y2RandomObject [14] = 200;
	x2RandomObject [15] = 250;
	y2RandomObject [15] = 100;
	x2RandomObject [16] = 400;
	y2RandomObject [16] = 300;




    }


    /*
	secondObjectGen() generates all of the objects of the second floor

	VariableName       Type              Description


	x2RandomObject      int               X-Coordinates for objects (floor 2)
	y2RandomObject      int               Y-Coordinates for objects (floor 2)
	i                   int               Used for loops
	pickedUp            Boolean           Images can only be generated if they haven't picked up
	floor               int               What floor the user is on
	objectFloor2        Image             Image name for all floor 2 objects
	*/

    public void secondObjectGen ()
    {
	if (floor == 2)
	{
	    if (pickedup2 [0] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-05.png"));
		    c.drawImage (menuBackground, x2RandomObject [0], y2RandomObject [0], null);
		}

		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [1] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-06.png"));
		    c.drawImage (menuBackground, x2RandomObject [1], y2RandomObject [1], null);
		}

		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [2] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-08.png"));
		    c.drawImage (menuBackground, x2RandomObject [2], y2RandomObject [2], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [3] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-09.png"));
		    c.drawImage (menuBackground, x2RandomObject [3], y2RandomObject [3], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [4] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-10.png"));
		    c.drawImage (menuBackground, x2RandomObject [4], y2RandomObject [4], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [5] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-11.png"));
		    c.drawImage (menuBackground, x2RandomObject [5], y2RandomObject [5], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [6] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-12.png"));
		    c.drawImage (menuBackground, x2RandomObject [6], y2RandomObject [6], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [7] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-13.png"));
		    c.drawImage (menuBackground, x2RandomObject [7], y2RandomObject [7], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [8] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-14.png"));
		    c.drawImage (menuBackground, x2RandomObject [8], y2RandomObject [8], null);
		}


		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [9] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-24.png"));
		    c.drawImage (menuBackground, x2RandomObject [9], y2RandomObject [9], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [10] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-26.png"));
		    c.drawImage (menuBackground, x2RandomObject [10], y2RandomObject [10], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [11] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-27.png"));
		    c.drawImage (menuBackground, x2RandomObject [11], y2RandomObject [11], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [12] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-28.png"));
		    c.drawImage (menuBackground, x2RandomObject [12], y2RandomObject [12], null);
		}

		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [13] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-29.png"));
		    c.drawImage (menuBackground, x2RandomObject [13], y2RandomObject [13], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [14] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-30.png"));
		    c.drawImage (menuBackground, x2RandomObject [14], y2RandomObject [14], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedup2 [15] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-31.png"));
		    c.drawImage (menuBackground, x2RandomObject [15], y2RandomObject [15], null);
		}

		catch (IOException e)
		{
		}
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-32.png"));
		    c.drawImage (menuBackground, x2RandomObject [16], y2RandomObject [16], null);
		}
		catch (IOException e)
		{
		}
	    }
	}
    }


    /*
	objectGen() generates all of the objects of the first floor

	VariableName       Type              Description


	xRandomObject      int               X-Coordinates for objects (floor 1)
	yRandomObject      int               Y-Coordinates for objects (floor 1)
	pickedUp            Boolean           Images can only be generated if they haven't picked up
	floor               int               What floor the user is on
	objectFloor1        Image             Image name for all floor 2 objects
    */
    public void objectGen ()
    {
	if (floor == 1)
	{
	    if (pickedUp [0] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-02.png"));
		    c.drawImage (menuBackground, xRandomObject [0], yRandomObject [0], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [1] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-03.png"));
		    c.drawImage (menuBackground, xRandomObject [1], yRandomObject [1], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [2] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-04.png"));
		    c.drawImage (menuBackground, xRandomObject [2], yRandomObject [2], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [3] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-15.png"));
		    c.drawImage (menuBackground, xRandomObject [3], yRandomObject [3], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [4] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-16.png"));
		    c.drawImage (menuBackground, xRandomObject [4], yRandomObject [4], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [5] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-17.png"));
		    c.drawImage (menuBackground, xRandomObject [5], yRandomObject [5], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [6] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-18.png"));
		    c.drawImage (menuBackground, xRandomObject [6], yRandomObject [6], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [7] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-19.png"));
		    c.drawImage (menuBackground, xRandomObject [7], yRandomObject [7], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [8] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-20.png"));
		    c.drawImage (menuBackground, xRandomObject [8], yRandomObject [8], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [9] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-21.png"));
		    c.drawImage (menuBackground, xRandomObject [9], yRandomObject [9], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [10] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-22.png"));
		    c.drawImage (menuBackground, xRandomObject [10], yRandomObject [10], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [11] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-23.png"));
		    c.drawImage (menuBackground, xRandomObject [11], yRandomObject [11], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (pickedUp [12] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-07.png"));
		    c.drawImage (menuBackground, xRandomObject [12], yRandomObject [12], null);
		}
		catch (IOException e)
		{
		}
	    }
	}
    }



    /*
      human() Code for human interaction and human movement for floor 1

      VariableName       Type              Description

      pickedUp           Boolean           Checks if user has picked up the item (floor 1)
      startTime1         double            Starting time for the game
      endTime1           double            Ending time for the game
      playerX            int               Player x-movement
      playerY            int               Player y-movement
      inventory          int               # of items the user has
      points             int               Used to determine final score
      floor              int               What floor the human is on
      soham              BufferedImage     Name of human
      objects            BufferedImage     All objects
      input              char              Key user presses to go to another location
      */
    int endTime123;
    double startTime1 = System.currentTimeMillis ();
    public void human ()  ///////////////////////////////////////////////////////////////////////////////////

    {

	playerY += 200;
	endTime1 = ((System.currentTimeMillis () - startTime1)) / 1000 - endTime123;

	{

	    while (endTime1 < 180)
	    {
		endTime1 = ((System.currentTimeMillis () - startTime1)) / 1000 - endTime123;

		if (inventory < 3)
		{
		    try
		    {
			sprite = ImageIO.read (new File ("human2.png")); ///if less than 3, human is normal (only image code)
			c.drawImage (sprite, playerX, playerY, null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		else if (inventory == 3)
		{
		    try
		    {
			sprite = ImageIO.read (new File ("tooMuch.png")); ///if less than 3, human has sweat (only image code)
			c.drawImage (sprite, playerX, playerY, null);
		    }

		    catch (IOException e)
		    {
		    }
		}
		Color livingRoom = new Color (224, 242, 255);  ///blue
		Color livinglivingRoom = new Color (96, 69, 11); ///brown
		////////////////////////////////////////////////////////////////each line seperates a different object for FLOOR 1, following code is pickable ITEM and USER interaction
		if (playerX + 21 <= xRandomObject [0] + 35 && playerX + 21 >= xRandomObject [0] - 20 && (playerY + 3 >= yRandomObject [0] - 20 && playerY + 3 <= yRandomObject [0] + 20) && inventory < 3 && pickedUp [0] == false)
		{
		    c.setColor (Color.white);
		    c.fillRect (xRandomObject [0], yRandomObject [0], 20, 20);
		    inventory += 1;
		    pickedUp [0] = true;
		    points += 1;

		}
		else if (playerX + 21 <= xRandomObject [0] + 35 && playerX + 21 >= xRandomObject [0] - 20 && (playerY + 3 >= yRandomObject [0] - 20 && playerY + 3 <= yRandomObject [0] + 20) && inventory == 3 && pickedUp [0] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-02.png"));
			c.drawImage (menuBackground, xRandomObject [0], yRandomObject [0], null);
		    }
		    catch (IOException e)
		    {
		    }

		}
		//////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [1] + 35 && playerX + 21 >= xRandomObject [1] - 20 && (playerY + 3 >= yRandomObject [1] - 20 && playerY + 3 <= yRandomObject [1] + 20) && inventory < 3 && pickedUp [1] == false)
		{
		    c.setColor (Color.white);
		    c.fillRect (xRandomObject [1], yRandomObject [1], 20, 20);
		    inventory += 1;
		    pickedUp [1] = true;
		    points += 1;
		}
		else if (playerX + 21 <= xRandomObject [1] + 35 && playerX + 21 >= xRandomObject [1] - 20 && (playerY + 3 >= yRandomObject [1] - 20 && playerY + 3 <= yRandomObject [1] + 20) && inventory == 3 && pickedUp [1] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-03.png"));
			c.drawImage (menuBackground, xRandomObject [1], yRandomObject [1], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		///////////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [2] + 35 && playerX + 21 >= xRandomObject [2] - 20 && (playerY + 3 >= yRandomObject [2] - 20 && playerY + 3 <= yRandomObject [2] + 20) && inventory < 3 && pickedUp [2] == false)
		{
		    c.setColor (Color.white);
		    c.fillRect (xRandomObject [2], yRandomObject [2], 20, 20);
		    inventory += 1;
		    pickedUp [2] = true;
		    points += 1;
		}
		else if (playerX + 21 <= xRandomObject [2] + 35 && playerX + 21 >= xRandomObject [2] - 20 && (playerY + 3 >= yRandomObject [2] - 20 && playerY + 3 <= yRandomObject [2] + 20) && inventory == 3 && pickedUp [2] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-04.png"));
			c.drawImage (menuBackground, xRandomObject [2], yRandomObject [2], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [3] + 35 && playerX + 21 >= xRandomObject [3] - 20 && (playerY + 3 >= yRandomObject [3] - 20 && playerY + 3 <= yRandomObject [3] + 20) && inventory < 3 && pickedUp [3] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [3], yRandomObject [3], 20, 20);
		    inventory += 1;
		    pickedUp [3] = true;
		    points += 1;
		}
		else if (playerX + 21 <= xRandomObject [3] + 35 && playerX + 21 >= xRandomObject [3] - 20 && (playerY + 3 >= yRandomObject [3] - 20 && playerY + 3 <= yRandomObject [3] + 20) && inventory == 3 && pickedUp [3] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-15.png"));
			c.drawImage (menuBackground, xRandomObject [3], yRandomObject [3], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		/////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [4] + 35 && playerX + 21 >= xRandomObject [4] - 20 && (playerY + 3 >= yRandomObject [4] - 20 && playerY + 3 <= yRandomObject [4] + 20) && inventory < 3 && pickedUp [4] == false)
		{
		    c.setColor (livingRoom);
		    c.fillRect (xRandomObject [4], yRandomObject [4], 20, 20);
		    inventory += 1;
		    pickedUp [4] = true;
		    points += 2;
		}
		else if (playerX + 21 <= xRandomObject [4] + 35 && playerX + 21 >= xRandomObject [4] - 20 && (playerY + 3 >= yRandomObject [4] - 20 && playerY + 3 <= yRandomObject [4] + 20) && inventory == 3 && pickedUp [4] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-16.png"));
			c.drawImage (menuBackground, xRandomObject [4], yRandomObject [4], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		///////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [5] + 35 && playerX + 21 >= xRandomObject [5] - 20 && (playerY + 3 >= yRandomObject [5] - 20 && playerY + 3 <= yRandomObject [5] + 20) && inventory < 3 && pickedUp [5] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [5], yRandomObject [5], 20, 20);
		    inventory += 1;
		    pickedUp [5] = true;
		    points += 2;
		}
		else if (playerX + 21 <= xRandomObject [5] + 35 && playerX + 21 >= xRandomObject [5] - 20 && (playerY + 3 >= yRandomObject [5] - 20 && playerY + 3 <= yRandomObject [5] + 20) && inventory == 3 && pickedUp [5] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-17.png"));
			c.drawImage (menuBackground, xRandomObject [5], yRandomObject [5], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		//////////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [6] + 35 && playerX + 21 >= xRandomObject [6] - 20 && (playerY + 3 >= yRandomObject [6] - 20 && playerY + 3 <= yRandomObject [6] + 20) && inventory < 3 && pickedUp [6] == false)
		{
		    c.setColor (livingRoom);
		    c.fillRect (xRandomObject [6], yRandomObject [6], 20, 20);
		    inventory += 1;
		    pickedUp [6] = true;
		    points += 2;
		}
		else if (playerX + 21 <= xRandomObject [6] + 35 && playerX + 21 >= xRandomObject [6] - 20 && (playerY + 3 >= yRandomObject [6] - 20 && playerY + 3 <= yRandomObject [6] + 20) && inventory == 3 && pickedUp [6] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-18.png"));
			c.drawImage (menuBackground, xRandomObject [6], yRandomObject [6], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		///////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [7] + 35 && playerX + 21 >= xRandomObject [7] - 20 && (playerY + 3 >= yRandomObject [7] - 20 && playerY + 3 <= yRandomObject [7] + 20) && inventory < 3 && pickedUp [7] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [7], yRandomObject [7], 20, 20);
		    inventory += 1;
		    pickedUp [7] = true;
		    points += 2;
		}
		else if (playerX + 21 <= xRandomObject [7] + 35 && playerX + 21 >= xRandomObject [7] - 20 && (playerY + 3 >= yRandomObject [7] - 20 && playerY + 3 <= yRandomObject [7] + 20) && inventory == 3 && pickedUp [7] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-19.png"));
			c.drawImage (menuBackground, xRandomObject [7], yRandomObject [7], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		///////////////////////////////////////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [8] + 35 && playerX + 21 >= xRandomObject [8] - 20 && (playerY + 3 >= yRandomObject [8] - 20 && playerY + 3 <= yRandomObject [8] + 20) && inventory < 3 && pickedUp [8] == false)
		{
		    c.setColor (livingRoom);
		    c.fillRect (xRandomObject [8], yRandomObject [8], 20, 20);
		    inventory += 1;
		    pickedUp [8] = true;
		}
		else if (playerX + 21 <= xRandomObject [8] + 35 && playerX + 21 >= xRandomObject [8] - 20 && (playerY + 3 >= yRandomObject [8] - 20 && playerY + 3 <= yRandomObject [8] + 20) && inventory == 3 && pickedUp [8] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-20.png"));
			c.drawImage (menuBackground, xRandomObject [8], yRandomObject [8], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		/////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [9] + 35 && playerX + 21 >= xRandomObject [9] - 20 && (playerY + 3 >= yRandomObject [9] - 20 && playerY + 3 <= yRandomObject [9] + 20) && inventory < 3 && pickedUp [9] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [9], yRandomObject [9], 20, 20);
		    inventory += 1;
		    pickedUp [9] = true;
		}
		else if (playerX + 21 <= xRandomObject [9] + 35 && playerX + 21 >= xRandomObject [9] - 20 && (playerY + 3 >= yRandomObject [9] - 20 && playerY + 3 <= yRandomObject [9] + 20) && inventory == 3 && pickedUp [9] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-21.png"));
			c.drawImage (menuBackground, xRandomObject [9], yRandomObject [9], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		//////////////////////////////////////////////////////
		else if (playerX + 21 <= xRandomObject [10] + 35 && playerX + 21 >= xRandomObject [10] - 20 && (playerY + 3 >= yRandomObject [10] - 20 && playerY + 3 <= yRandomObject [10] + 20) && inventory < 3 && pickedUp [10] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [10], yRandomObject [10], 20, 20);
		    inventory += 1;
		    pickedUp [10] = true;
		}
		else if (playerX + 21 <= xRandomObject [10] + 35 && playerX + 21 >= xRandomObject [10] - 20 && (playerY + 3 >= yRandomObject [10] - 20 && playerY + 3 <= yRandomObject [10] + 20) && inventory == 3 && pickedUp [10] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-22.png"));
			c.drawImage (menuBackground, xRandomObject [10], yRandomObject [10], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		else if (playerX + 21 <= xRandomObject [11] + 35 && playerX + 21 >= xRandomObject [11] - 20 && (playerY + 3 >= yRandomObject [11] - 20 && playerY + 3 <= yRandomObject [11] + 20) && inventory < 3 && pickedUp [11] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [11], yRandomObject [11], 20, 20);
		    inventory += 1;
		    pickedUp [11] = true;
		}
		else if (playerX + 21 <= xRandomObject [11] + 35 && playerX + 21 >= xRandomObject [11] - 20 && (playerY + 3 >= yRandomObject [11] - 20 && playerY + 3 <= yRandomObject [11] + 20) && inventory == 3 && pickedUp [11] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-23.png"));
			c.drawImage (menuBackground, xRandomObject [11], yRandomObject [11], null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		else if (playerX + 21 <= xRandomObject [12] + 35 && playerX + 21 >= xRandomObject [12] - 20 && (playerY + 3 >= yRandomObject [12] - 20 && playerY + 3 <= yRandomObject [12] + 20) && inventory < 3 && pickedUp [12] == false)
		{
		    c.setColor (livinglivingRoom);
		    c.fillRect (xRandomObject [12], yRandomObject [12], 20, 20);
		    inventory += 1;
		    pickedUp [12] = true;
		}
		else if (playerX + 21 <= xRandomObject [12] + 35 && playerX + 21 >= xRandomObject [12] - 20 && (playerY + 3 >= yRandomObject [12] - 20 && playerY + 3 <= yRandomObject [12] + 20) && inventory == 3 && pickedUp [12] == false)
		{
		    try
		    {
			BufferedImage menuBackground = ImageIO.read (new File ("frame-07.png"));
			c.drawImage (menuBackground, xRandomObject [12], yRandomObject [12], null);
		    }
		    catch (IOException e)
		    {
		    }
		    points += 3;
		}
		else if (playerX > 570 && playerY > 420)
		{
		    try
		    {
			inventory = 0;
			c.setColor (Color.red);
			c.fillRect (600, 450, 50, 50);

		    }
		    catch (Exception e)
		    {
		    }

		}
		c.setColor (Color.black);
		c.fillRect (600, 450, 50, 50);


		///Following code will be floor 1 code collision for nonpickable objects, barriers essentially
		if (floor == 1)
		{

		    if (playerX > 520 && playerX < 999 && playerY < 110) //////////////////////////////////////////////////////Code to go to floor 2
		    { ///////////////////////////////////////////////
			floor = 2;

			floor2Background ();
			secondObjectGen ();
			floor2Human ();

		    }

		    c.drawImage (sprite, playerX, playerY, null);


		    c.setColor (livingRoom);
		    input = c.getChar ();
		    if (input == 'x')
		    {
		    }
		    if (input == 'w')
		    {
			playerY -= 1;
			if (playerY < -10)
			{
			    playerY += 1;
			}
			if (playerY == 197 && playerX < 220 && playerX > 165)  ///Refrigerator
			{
			    playerY += 2;
			}
			if (playerY == 173 && playerX > -999 && playerX < 20)
			{ ///Sink
			    playerY += 2;
			}

			if (playerY == 40 && playerX > -999 && playerX < 200)
			{ ///Rest of Kitchen
			    playerY += 2;
			}

			if (playerY == 170 && playerX > 50 && playerX < 150)
			{ ///Kitchen Table
			    playerY += 2;
			}
			if (playerY == 300 && playerX > 17 && playerX < 165)
			{ ///Sofa
			    playerY += 2;
			}

			if (playerX > 310 && playerX < 470 && playerY == 340)
			{ ///Carpet
			    playerY += 2;
			}
			if (playerX > 310 && playerX < 470 && playerY == 142)
			{ ///Table
			    playerY += 2;
			}




			c.setColor (livinglivingRoom);
			c.fillRect (243, 0, 20, 600);
			if (playerX > 220)
			{
			    c.setColor (livinglivingRoom);

			}

			else if (playerY < 197 && playerX < 220)
			{

			    c.setColor (livingRoom);
			    c.fillRect (0, 202, 240, 20);
			    c.setColor (Color.white);
			}


			else
			{
			    c.setColor (livingRoom);
			}
			c.fillRect (playerX + 21, playerY + 3, 20, 25);
		    }




		    ////////////////////////////////////////////////////////////////////////////////////////S
		    else if (input == 's')
		    {
			playerY += 1;
			if (playerY >= 490)
			{
			    playerY -= 2;
			}
			if (playerY == 430 && playerX < 500 && playerX > 325)
			{
			    playerY -= 2;
			} //fireplace
			if (playerY == 440 && playerX > 17 && playerX < 165)
			{
			    playerY -= 2;
			} //tv
			if (playerY == 107 && playerX < 220 && playerX > 165)
			{
			    playerY -= 2;
			} //regrigerator


			if (playerY == 60 && playerX > 50 && playerX < 150)
			{ ///Kitchen Table
			    playerY -= 2;
			}
			if (playerY == 223 && playerX > 17 && playerX < 165)
			{ ///Sofa
			    playerY -= 2;
			}

			if (playerX > 310 && playerX < 475 && playerY == 200)
			{ ///Carpet
			    playerY -= 2;
			}
			if (playerX > 310 && playerX < 475 && playerY == 40)
			{ ///Table
			    playerY -= 2;
			}

			c.setColor (livinglivingRoom);
			c.fillRect (243, 0, 20, 600);
			if (playerX > 220)
			{
			    c.setColor (livinglivingRoom);

			}
			else if (playerY < 197 && playerX < 220)
			{
			    c.setColor (livingRoom);
			    c.fillRect (0, 202, 240, 20);
			    c.setColor (Color.white);
			}
			else
			{
			    c.setColor (livingRoom);
			}
			c.fillRect (playerX + 23, playerY + 3, 20, 25);
		    }
		    ///////////////////////////////////////////////////////////////////////////////d

		    else if (input == 'd')
		    {
			playerX += 1;
			if (playerX >= 600)
			{
			    playerX -= 2;
			}
			if (playerX == 510 && playerY < 110)
			{
			    playerX -= 2;
			}
			if (playerY > 250 && playerY < 300 && playerX == 480)
			{
			    playerX -= 2;
			}
			if (playerY >= 430 && playerX == 334)
			{
			    playerX -= 2;
			} //fireplace
			if (playerY >= 440 && playerX == 17)
			{
			    playerX -= 2;
			}
			if (playerY > 107 && playerY < 197 && playerX == 159)
			{
			    playerX -= 2;
			}
			if (playerY > 225 && playerY < 300 && playerX == 17)
			{
			    playerX -= 2;
			} ///sofa
			if (playerY > 60 && playerY < 170 && playerX == 50)
			{
			    playerX -= 2;

			} ///kitchen table
			if (playerY > 200 && playerY < 340 && playerX == 310)
			{
			    playerX -= 2;
			    ///carpet
			}
			if (playerY > 40 && playerY < 142 && playerX == 310)
			{
			    playerX -= 2; //table
			}

			c.setColor (livinglivingRoom);
			c.fillRect (243, 0, 20, 600);
			if (playerX > 220)
			{

			    c.setColor (livinglivingRoom);

			}
			else if (playerY < 197 && playerX < 220)
			{
			    c.setColor (livingRoom);
			    c.fillRect (0, 202, 240, 20);
			    c.setColor (Color.white);
			}
			else
			{
			    c.setColor (livingRoom);
			}
			c.fillRect (playerX + 21, playerY + 3, 20, 25);

		    }
		    else if (input == 'a')
		    {

			if (playerX < -20)
			{
			    playerX += 2;
			}
			if (playerY >= 430 && playerX == 495)
			{
			    playerX += 2;
			} //fireplace
			if (playerY >= 440 && playerX == 165)
			{
			    playerX += 2;
			}

			c.setColor (livinglivingRoom);
			c.fillRect (243, 0, 20, 600);
			playerX -= 1;
			if (playerY > 107 && playerY < 197 && playerX == 220)
			{
			    playerX += 2;
			}
			if (playerY < 173 && playerY > 0 && playerX == 20)
			{
			    playerX += 2;
			}
			if (playerY > 225 && playerY < 300 && playerX == 165)
			{
			    playerX += 2;
			} ///sofa
			if (playerY > 60 && playerY < 170 && playerX == 150)
			{
			    playerX += 2;

			} ///kitchen table
			if (playerY > 200 && playerY < 340 && playerX == 475)
			{
			    playerX += 2;
			    ///carpet
			}
			if (playerY > 40 && playerY < 142 && playerX == 475)
			{
			    playerX += 2; //table
			}

			if (playerX > 220)
			{
			    c.setColor (livinglivingRoom);

			}
			else if (playerY < 197 && playerX < 220)
			{
			    c.setColor (livingRoom);
			    c.fillRect (0, 202, 240, 20);
			    c.setColor (Color.white);
			}
			else
			{
			    c.setColor (livingRoom);
			}
			c.fillRect (playerX + 23, playerY + 4, 14, 24);
		    }

		}

	    }
	}
    }


    /*
      floor2Background() draws the background of the second floor

      Variable Name       Type              Description

      floor               int               What floor the human is on
      menuBackground      BufferedImage     Background for floor 2

      */
    public void floor2Background ()
    {
	if (floor == 2)
	{
	    try
	    {
		BufferedImage menuBackground = ImageIO.read (new File ("secondFloorImage.png"));
		c.drawImage (menuBackground, 0, 0, null);
	    }
	    catch (IOException e)
	    {
	    }
	}
    }


    /*
	  floor2Human() Code for human interaction and human movement for floor 2

	  VariableName       Type              Description

	  pickedUp2           Boolean          Checks whether the object has been picked up or not (second floor)
	  startTime1         double            Starting time for the game
	  endTime1           double            Ending time for the game
	  playerX            int               Player x-movement
	  playerY            int               Player y-movement
	  inventory          int               # of items the user has
	  points             int               Used to determine final score
	  floor              int               What floor the human is on
	  soham              BufferedImage     Name of human
	  objects            BufferedImage     All objects
	  input2             char              Key user presses to go to another location (floor 2 edition)
	  grey               Color             Background colour
     */
    boolean[] pickedup2 = new boolean [17];
    ///Collision
    char input2;
    public void floor2Human ()
    {
	Color greyB = new Color (217, 217, 217);
	endTime1 = ((System.currentTimeMillis () - startTime1)) / 1000 - endTime123;
	while (endTime1 < 180)
	{
	    endTime1 = ((System.currentTimeMillis () - startTime1)) / 1000 - endTime123;

	    if (inventory < 3)
	    {
		try
		{
		    sprite = ImageIO.read (new File ("human2.png"));
		    c.drawImage (sprite, playerX, playerY, null);
		}
		catch (IOException e)
		{
		}
	    }


	    else if (inventory == 3)
	    {
		try
		{
		    sprite = ImageIO.read (new File ("tooMuch.png"));
		    c.drawImage (sprite, playerX, playerY, null);
		}

		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [0] + 35 && playerX + 21 >= x2RandomObject [0] - 20 && (playerY + 3 >= y2RandomObject [0] - 20 && playerY + 3 <= y2RandomObject [0] + 20) && inventory < 3 && pickedup2 [0] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [0], y2RandomObject [0], 20, 20);
		inventory += 1;
		pickedup2 [0] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [0] + 35 && playerX + 21 >= x2RandomObject [0] - 20 && (playerY + 3 >= y2RandomObject [0] - 20 && playerY + 3 <= y2RandomObject [0] + 20) && inventory == 3 && pickedup2 [0] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-05.png"));
		    c.drawImage (menuBackground, x2RandomObject [0], y2RandomObject [0], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [1] + 35 && playerX + 21 >= x2RandomObject [1] - 20 && (playerY + 3 >= y2RandomObject [1] - 20 && playerY + 3 <= y2RandomObject [1] + 20) && inventory < 3 && pickedup2 [1] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [1], y2RandomObject [1], 20, 20);
		inventory += 1;
		pickedup2 [1] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [1] + 35 && playerX + 21 >= x2RandomObject [1] - 20 && (playerY + 3 >= y2RandomObject [1] - 20 && playerY + 3 <= y2RandomObject [1] + 20) && inventory == 3 && pickedup2 [1] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-06.png"));
		    c.drawImage (menuBackground, x2RandomObject [1], y2RandomObject [1], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [2] + 35 && playerX + 21 >= x2RandomObject [2] - 20 && (playerY + 3 >= y2RandomObject [2] - 20 && playerY + 3 <= y2RandomObject [2] + 20) && inventory < 3 && pickedup2 [2] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [2], y2RandomObject [2], 20, 20);
		inventory += 1;
		pickedup2 [2] = true;
		points += 2;

	    }
	    else if (playerX + 21 <= x2RandomObject [2] + 35 && playerX + 21 >= x2RandomObject [2] - 20 && (playerY + 3 >= y2RandomObject [2] - 20 && playerY + 3 <= y2RandomObject [2] + 20) && inventory == 3 && pickedup2 [2] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-08.png"));
		    c.drawImage (menuBackground, x2RandomObject [2], y2RandomObject [2], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [3] + 35 && playerX + 21 >= x2RandomObject [3] - 20 && (playerY + 3 >= y2RandomObject [3] - 20 && playerY + 3 <= y2RandomObject [3] + 20) && inventory < 3 && pickedup2 [3] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [3], y2RandomObject [3], 20, 20);
		inventory += 1;
		pickedup2 [3] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [3] + 35 && playerX + 21 >= x2RandomObject [3] - 20 && (playerY + 3 >= y2RandomObject [3] - 20 && playerY + 3 <= y2RandomObject [3] + 20) && inventory == 3 && pickedup2 [3] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-09.png"));
		    c.drawImage (menuBackground, x2RandomObject [3], y2RandomObject [3], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [4] + 35 && playerX + 21 >= x2RandomObject [4] - 20 && (playerY + 3 >= y2RandomObject [4] - 20 && playerY + 3 <= y2RandomObject [4] + 20) && inventory < 3 && pickedup2 [4] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [4], y2RandomObject [4], 20, 20);
		inventory += 1;
		pickedup2 [4] = true;
		points += 2;

	    }
	    else if (playerX + 21 <= x2RandomObject [4] + 35 && playerX + 21 >= x2RandomObject [4] - 20 && (playerY + 3 >= y2RandomObject [4] - 20 && playerY + 3 <= y2RandomObject [4] + 20) && inventory == 3 && pickedup2 [4] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-10.png"));
		    c.drawImage (menuBackground, x2RandomObject [4], y2RandomObject [4], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [5] + 35 && playerX + 21 >= x2RandomObject [5] - 20 && (playerY + 3 >= y2RandomObject [5] - 20 && playerY + 3 <= y2RandomObject [5] + 20) && inventory < 3 && pickedup2 [5] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [5], y2RandomObject [5], 20, 20);
		inventory += 1;
		pickedup2 [5] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [5] + 35 && playerX + 21 >= x2RandomObject [5] - 20 && (playerY + 3 >= y2RandomObject [5] - 20 && playerY + 3 <= y2RandomObject [5] + 20) && inventory == 3 && pickedup2 [5] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-11.png"));
		    c.drawImage (menuBackground, x2RandomObject [5], y2RandomObject [5], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [6] + 35 && playerX + 21 >= x2RandomObject [6] - 20 && (playerY + 3 >= y2RandomObject [6] - 20 && playerY + 3 <= y2RandomObject [6] + 20) && inventory < 3 && pickedup2 [6] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [6], y2RandomObject [6], 20, 20);
		inventory += 1;
		pickedup2 [6] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [6] + 35 && playerX + 21 >= x2RandomObject [6] - 20 && (playerY + 3 >= y2RandomObject [6] - 20 && playerY + 3 <= y2RandomObject [6] + 20) && inventory == 3 && pickedup2 [6] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-12.png"));
		    c.drawImage (menuBackground, x2RandomObject [6], y2RandomObject [6], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [7] + 35 && playerX + 21 >= x2RandomObject [7] - 20 && (playerY + 3 >= y2RandomObject [7] - 20 && playerY + 3 <= y2RandomObject [7] + 20) && inventory < 3 && pickedup2 [7] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [7], y2RandomObject [7], 20, 20);
		inventory += 1;
		pickedup2 [7] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [7] + 35 && playerX + 21 >= x2RandomObject [7] - 20 && (playerY + 3 >= y2RandomObject [7] - 20 && playerY + 3 <= y2RandomObject [7] + 20) && inventory == 3 && pickedup2 [7] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-13.png"));
		    c.drawImage (menuBackground, x2RandomObject [7], y2RandomObject [7], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [8] + 35 && playerX + 21 >= x2RandomObject [8] - 20 && (playerY + 3 >= y2RandomObject [8] - 20 && playerY + 3 <= y2RandomObject [8] + 20) && inventory < 3 && pickedup2 [8] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [8], y2RandomObject [8], 20, 20);
		inventory += 1;
		pickedup2 [8] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [8] + 35 && playerX + 21 >= x2RandomObject [8] - 20 && (playerY + 3 >= y2RandomObject [8] - 20 && playerY + 3 <= y2RandomObject [8] + 20) && inventory == 3 && pickedup2 [8] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-14.png"));
		    c.drawImage (menuBackground, x2RandomObject [8], y2RandomObject [8], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [9] + 35 && playerX + 21 >= x2RandomObject [9] - 20 && (playerY + 3 >= y2RandomObject [9] - 20 && playerY + 3 <= y2RandomObject [9] + 20) && inventory < 3 && pickedup2 [9] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [9], y2RandomObject [9], 20, 20);
		inventory += 1;
		pickedup2 [9] = true;
		points += 1;

	    }
	    else if (playerX + 21 <= x2RandomObject [9] + 35 && playerX + 21 >= x2RandomObject [9] - 20 && (playerY + 3 >= y2RandomObject [9] - 20 && playerY + 3 <= y2RandomObject [9] + 20) && inventory == 3 && pickedup2 [9] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-24.png"));
		    c.drawImage (menuBackground, x2RandomObject [9], y2RandomObject [9], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [10] + 35 && playerX + 21 >= x2RandomObject [10] - 20 && (playerY + 3 >= y2RandomObject [10] - 20 && playerY + 3 <= y2RandomObject [10] + 20) && inventory < 3 && pickedup2 [10] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [10], y2RandomObject [10], 20, 20);
		inventory += 1;
		pickedup2 [10] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [10] + 35 && playerX + 21 >= x2RandomObject [10] - 20 && (playerY + 3 >= y2RandomObject [10] - 20 && playerY + 3 <= y2RandomObject [10] + 20) && inventory == 3 && pickedup2 [10] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-26.png"));
		    c.drawImage (menuBackground, x2RandomObject [10], y2RandomObject [10], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [11] + 35 && playerX + 21 >= x2RandomObject [11] - 20 && (playerY + 3 >= y2RandomObject [11] - 20 && playerY + 3 <= y2RandomObject [11] + 20) && inventory < 3 && pickedup2 [11] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [11], y2RandomObject [11], 20, 20);
		inventory += 1;
		pickedup2 [11] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [11] + 35 && playerX + 21 >= x2RandomObject [11] - 20 && (playerY + 3 >= y2RandomObject [11] - 20 && playerY + 3 <= y2RandomObject [11] + 20) && inventory == 3 && pickedup2 [11] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-27.png"));
		    c.drawImage (menuBackground, x2RandomObject [11], y2RandomObject [11], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [12] + 35 && playerX + 21 >= x2RandomObject [12] - 20 && (playerY + 3 >= y2RandomObject [12] - 20 && playerY + 3 <= y2RandomObject [12] + 20) && inventory < 3 && pickedup2 [12] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [12], y2RandomObject [12], 20, 20);
		inventory += 1;
		pickedup2 [12] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [12] + 35 && playerX + 21 >= x2RandomObject [12] - 20 && (playerY + 3 >= y2RandomObject [12] - 20 && playerY + 3 <= y2RandomObject [12] + 20) && inventory == 3 && pickedup2 [12] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-28.png"));
		    c.drawImage (menuBackground, x2RandomObject [12], y2RandomObject [12], null);
		}
		catch (IOException e)
		{
		}
	    }
	    if (playerX + 21 <= x2RandomObject [13] + 35 && playerX + 21 >= x2RandomObject [13] - 20 && (playerY + 3 >= y2RandomObject [13] - 20 && playerY + 3 <= y2RandomObject [13] + 20) && inventory < 3 && pickedup2 [13] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [13], y2RandomObject [13], 20, 20);
		inventory += 1;
		pickedup2 [13] = true;

	    }
	    else if (playerX + 21 <= x2RandomObject [13] + 35 && playerX + 21 >= x2RandomObject [13] - 20 && (playerY + 3 >= y2RandomObject [13] - 20 && playerY + 3 <= y2RandomObject [13] + 20) && inventory == 3 && pickedup2 [13] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-29.png"));
		    c.drawImage (menuBackground, x2RandomObject [13], y2RandomObject [13], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [14] + 35 && playerX + 21 >= x2RandomObject [14] - 20 && (playerY + 3 >= y2RandomObject [14] - 20 && playerY + 3 <= y2RandomObject [14] + 20) && inventory < 3 && pickedup2 [14] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [14], y2RandomObject [14], 20, 20);
		inventory += 1;
		pickedup2 [14] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [14] + 35 && playerX + 21 >= x2RandomObject [14] - 20 && (playerY + 3 >= y2RandomObject [14] - 20 && playerY + 3 <= y2RandomObject [14] + 20) && inventory == 3 && pickedup2 [14] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-30.png"));
		    c.drawImage (menuBackground, x2RandomObject [14], y2RandomObject [14], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [15] + 35 && playerX + 21 >= x2RandomObject [15] - 20 && (playerY + 3 >= y2RandomObject [15] - 20 && playerY + 3 <= y2RandomObject [15] + 20) && inventory < 3 && pickedup2 [15] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [15], y2RandomObject [15], 20, 20);
		inventory += 1;
		pickedup2 [15] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [15] + 35 && playerX + 21 >= x2RandomObject [15] - 20 && (playerY + 3 >= y2RandomObject [15] - 20 && playerY + 3 <= y2RandomObject [15] + 20) && inventory == 3 && pickedup2 [15] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-31.png"));
		    c.drawImage (menuBackground, x2RandomObject [15], y2RandomObject [15], null);
		}
		catch (IOException e)
		{
		}
	    }

	    if (playerX + 21 <= x2RandomObject [16] + 35 && playerX + 21 >= x2RandomObject [16] - 20 && (playerY + 3 >= y2RandomObject [16] - 20 && playerY + 3 <= y2RandomObject [16] + 20) && inventory < 3 && pickedup2 [16] == false)
	    {
		c.setColor (greyB);
		c.fillRect (x2RandomObject [16], y2RandomObject [16], 20, 20);
		inventory += 1;
		pickedup2 [16] = true;


	    }
	    else if (playerX + 21 <= x2RandomObject [16] + 35 && playerX + 21 >= x2RandomObject [16] - 20 && (playerY + 3 >= y2RandomObject [16] - 20 && playerY + 3 <= y2RandomObject [16] + 20) && inventory == 3 && pickedup2 [16] == false)
	    {
		try
		{
		    BufferedImage menuBackground = ImageIO.read (new File ("frame-32.png"));
		    c.drawImage (menuBackground, x2RandomObject [16], y2RandomObject [16], null);
		}
		catch (IOException e)
		{
		}
	    }
	    input2 = c.getChar ();
      
	    c.fillRect (playerX + 23, playerY + 4, 14, 24);
	    if (playerX > 480 && playerY < 80)
	    {
		floor = 1;
		background ();
		objectGen ();
		human ();
	    }
	    try
	    {
		sprite = ImageIO.read (new File ("human2.png"));
		c.drawImage (sprite, playerX, playerY, null);
	    }

	    catch (IOException e)
	    {
	    }
	    if (floor == 2)
	    {

		if (input2 == 'w')
		{
		    playerY -= 1;
		    if (playerY < -10)
		    {
			playerY += 1;
		    }
		    if (playerY == 170 && playerX > -40 && playerX < 210)
		    {
			playerY += 2;
		    }
		    if (playerY == 170 && playerX > 290 && playerX < 430)
		    {
			playerY += 2;
		    }
		    if (playerY == 310 && playerX > 480 && playerX < 999)
		    {
			playerY += 2;
		    }
		    if (playerY == 10 && playerX > 150 && playerX < 395)
		    {
			playerY += 2;
		    }
		    if (playerX < 153 && playerX > 0 && playerY == 42)
		    {
			playerY += 2;
		    }
		    if (playerY == 45 && playerX > 10 && playerX < 100)
		    {
			playerY -= 2;
		    }
		    if (playerY == 450 && playerX > 10 && playerX < 100)
		    {
			playerY += 2;
		    }
		}
		if (input2 == 's')
		{
		    playerY += 1;
		    if (playerY >= 490)
		    {
			playerY -= 2;
		    }

		    if (playerX < 150 && playerX > 0 && playerY == 62)
		    {
			playerY -= 2;
		    }
		    if (playerY == 345 && playerX > 10 && playerX < 170)
		    {
			playerY -= 2;
		    }
		    if (playerY == 270 && playerX > 480 && playerX < 999)
		    {
			playerY -= 2;
		    }
		    if (playerY == 135 && playerX > 125 && playerX < 210)
		    {
			playerY -= 2;
		    }
		    if (playerY == 460 && playerX > 10 && playerX < 100)
		    {
			playerY -= 2;
		    }

		}
		if (input2 == 'd')
		{
		    playerX += 1;
		    if (playerX >= 600)
		    {
			playerX -= 2;
		    }
		    if (playerX == 481 && playerY >= 270 && playerY <= 310)
		    {
			playerX -= 2;
		    }
		    if (playerY > 345 && playerY < 445 && playerX == 20)
		    {
			playerX -= 2;
		    }
		    if (playerY > 470 && playerX == 20)
		    {
			playerX -= 2;
		    }
		    if (playerY > 450 && playerX == 60)
		    {
			playerX -= 2;
		    }
		    if (playerX == 295 && playerY < 170 && playerY > -30)
		    {
			playerX -= 2;
		    }

		}
		if (input2 == 'a')
		{
		    playerX -= 1;
		    if (playerX < -20)
		    {
			playerX += 2;
		    }
		    if (playerX == 100 && playerY >= 42 && playerY < 62)
		    {
			playerX += 2;
		    }
		    if (playerX == 153 && playerY <= 42 && playerY > 0)
		    {
			playerX += 2;
		    }
		    if (playerY > 62 && playerY < 170 && playerX == 148)
		    {
			playerX += 2;
		    }
		    if (playerY > 345 && playerX == 170)
		    {
			playerX += 2;
		    }
		    if (playerY < 170 && playerY > -30 && playerX == 430)
		    {
			playerX += 2;
		    }

		}
		if (input2 == 'b')
		{
		    playerX = 430;
		    playerY = 100;
		}
	    }
	    Color grey = new Color (217, 217, 217);
	    c.setColor (grey);
	}
    }


    private void game ()
    {
	if (floor == 1)
	{
	    background ();
	    objectGen ();
	    human ();
	    endScreens ();
	}
	if (floor == 2)
	{
	    floor2Background ();
	    secondObjectGen ();
	    floor2Human ();
	    endScreens ();
	}
    }


    /*
    The game of twisterSurvival(), there are random
    objects scattered across the house which the user must collect. There is an
    inventory system which limits the number of objects the user can collect to 3.
    Not all of the objects the user collects will give equal amounts of points, based
    on the importance of the objects to the shelter. Objects that hold
    little value in the shelter and were not discussed in the maze give 0 points.
    The user will deposit the items into the shelter (black square, bottom right corner of floor 1) to free inventory.
    The user will be able to go upstairs and downstairs to collect more items and points
    The user has 3 minutes to collect as much items as possible
    The user cannot go through walls or the screen

    Parts done by Soham: WASD movement for floor 2
    Parts done by Peter: backgrounds, object/item collision for floor 1 and 2, file reading/writing, WASD movement for floor 1

    */
    public void houseGame ()
    {
	objects ();
	game ();
    }


    /*
	  endScreens() Code is to put out end screens after timer hits 3 minutes

	  VariableName       Type              Description


	  points             int               Checks number of points user has collected
	  endTime1           int               Checks time elapsed
    */
    public void endScreens ()
    {
	if (points >= 8)
	{
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 640, 500);
	    c.setColor (Color.yellow);
	    c.setFont (new Font ("Arial", Font.BOLD, 50));
	    c.drawString ("Congrats! You Won!", 105, 230);
	    c.setFont (new Font ("Arial", Font.BOLD, 25));
	    c.drawString ("Score: " + points, 300, 270);
	    c.drawString ("Time: " + endTime1 + "sec", 300, 310);
	    c.getChar ();
	}
	else
	{
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 640, 500);
	    c.setColor (Color.yellow);
	    c.setFont (new Font ("Arial", Font.BOLD, 50));
	    c.drawString ("You lost!", 105, 230);
	    c.setFont (new Font ("Arial", Font.BOLD, 25));
	    c.drawString ("Score: " + points, 300, 270);
	    c.drawString ("Time: " + endTime1 + "sec", 300, 310);
	    c.getChar ();
	    writeFile ();
	    readFile ();
	}
    }


    /*
	  writeFile() writes final score to highScores.txt

	  VariableName       Type              Description

	  output            PrintWriter        Writes score to highScores.txt

    */
    private int change (int a, int b)
    {

	int c = a - b;
	return c;
    }


    PrintWriter output; // Prints to the text file
    String linesFile[]; // Arrays contains all the lines in the text file.
    public void writeFile ()
    { //declares object of the PrintWriter class
	String fileName = "highScores.txt";
	try
	{

	    output = new PrintWriter (new FileWriter ("highScores.txt", true));


	    output.println (points);
	    output.close ();
	}
	catch (IOException e)
	{
	}
    }


    /*
	  readFile() reads scores from highScores.txt

	  VariableName       Type              Description

	  linesFile          String            Represents all of the scores inside highScores.txt
	  line               String            Empty "" used for counting amount of scores in the txt file
	  numberOfLine       int               Counts how many lines there are in the file
	  currentAmount      int               Checks the value of the current score
	  highestAmount      int               Compares the value of the current score to the highest score, converts current score to highest score if current score is higher than highest score

	  */

    int highestAmount = 0; // Highest Score
    public void readFile ()
    {
	String line = "";
	int numberOfLine = 0; ///Number of lines
	try
	{
	    BufferedReader reader = new BufferedReader (new FileReader ("highScores.txt"));
	    while (line != null) ///While line is not empty, will continously increase the number of lines
	    {
		line = reader.readLine ();
		numberOfLine++;
	    }
	    reader.close (); ///Closes at the total number of lines
	}
	catch (IOException e)
	{
	    System.out.println (e);
	}

	linesFile = new String [numberOfLine];

	try
	{
	    BufferedReader r = new BufferedReader (new FileReader ("highScores.txt"));

	    for (int i = 0 ; i < linesFile.length - 2 ; i++)
	    {
		linesFile [i] = r.readLine (); ///array linesFile dictated by the different lines within the pizzaPrices text file
		int currentAmount = Integer.parseInt (linesFile [i]);

		if (i > 0)
		{
		    if (currentAmount > highestAmount)
		    {
			highestAmount = currentAmount;
		    }
		}
	    }

	    r.close ();
	    int thing = change (8, points);
	    try{
	    BufferedImage menuBackground = ImageIO.read (new File ("displayHighScore.png"));
	    c.drawImage (menuBackground, 0, 0, null);
	    }
	    catch(IOException e){}
	    c.drawString ("Difference from win condition: " + thing, 300, 390);
	    c.drawString ("HIGH SCORE: " + highestAmount, 300, 350);
	    pauseProgram();

	}
	catch (IOException e)
	{
	    System.out.println (e);
	}

    }


    // Goodbye method, says goodbye to the user and gives credit.
    public void goodbye ()
    {
	c.clear ();
	c.println ("Thanks for using the program! - Soham and Peter");
    }



    public static void main (String[] args)
    {
	twisterSurvival p = new twisterSurvival ();
	/*
	p.splashScreen ();
	p.cutScene ();
	*/
	while (!p.choice.equalsIgnoreCase ("e"))
	{
	    p.mainMenu ();
	    if (p.choice.equalsIgnoreCase ("e"))
	    {
		break;
	    }
	    else if (p.choice.equalsIgnoreCase ("p"))
	    {
	    
		p.instructions ();
		
		p.livingRoomMaze ();
		
		p.houseGame ();
	    }
	    else if (p.choice.equalsIgnoreCase ("d"))
	    {
		p.readFile ();
	    }
	}
	p.goodbye ();

    }



}







