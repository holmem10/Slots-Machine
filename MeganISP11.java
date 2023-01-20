/*
    Megan Holmes
    Krasteva
    January 16, 2019
    This program is a virtual slot machine whih includes instructions and an administrative level. Game play includes spinning the slots
    and betting money until you are happy or have ran out! Also, come back to the game at any time and continue playing.
	The splash screen gives a brief introduction and a fun animation of rolling casino chips. It also continues to the main menu.
	The main menu displays each continue option and includes graphics of slots symbols. This also controls the program flow.
	The instrutions display how to play the game and use the program. They then return to the main menu.
	The game play screen has a slsot machine and continues to display, or stays and spins until the balance is 0.
	The display screen will ask for or display the userName, and save the user scores and highscores.
	The continue game screen accesses a game that has alreaady been created and then continues to game play.
	The admin screen is password protected and will either allow a specific user score to be edited or the highscores to be cleared.
	The exit screen displays a goodbye message and credits, before closing the program.
		     VARIABLES
    NAME               TYPE        DESCRIPTION
    --------------------------------------------------
    results            boolean     Stores the slot results (win or lose: true or false)
    moneyBet           int         Stores the amount the user bets each round.
    balance            int         Users balance that is added to or taken from depending on results. Balance starts at $100.
    continueChoice     char        User input in the main menu that controls program flow
    mainFont           int         Font used throughout the program
    graphicsSevenFont  int         Used in graphics needed for machine
    barGraphicsFont    int         Used in other graphics needed for machine
    winCount           int         Keeps count of how many times a user wins
    lossCount          int         Keep count of how many times a user loses
    userName           String      Used to access previous games and inputted in the display.
    background         Color (int) Sets the background color for the entire program.         

*/
import java.awt.*;
import hsa.*;
import javax.swing.JOptionPane; //imports the J pane console
import java.io.*;
import java.util.Random;

public class MeganISP11
{
    Console c;            // c is variable representation of Console
    //global variable declarations

    boolean results = false;
    int moneyBet = 0;
    int balance = 100;
    int winCount = 0;
    int lossCount = 0;
    String userName = " ";
    char continueChoice;
    Font mainFont = (new Font ("Times New Roman", 1, 20));
    Font graphicsSevenFont = (new Font ("Times New Roman", 3, 85));
    Font barGraphicsFont = (new Font ("Times New Roman", 3, 35));
    Color background = new Color (201, 235, 255);

    public MeganISP11 ()    //constructor
    {
	c = new Console ();   //creates new instance of Console for use by the class
    }


    /*
	  This method clears the screen and displays the title.
	  ----------------------------------------------------------
	  Local Variables:
	  NAME        TYPE        DESCRIPTION
	  ----------------------------------------------------------
	  title       Color       Color of title.
    */
    private void title ()
    {
	Color title = new Color (93, 12, 255); //one time variable to set the colour of the title
	c.clear (); //clears screen
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);
	c.setColor (title);
	c.setFont (new Font ("Algerian", -10, 30));
	c.drawString ("Virtual Slots Machine", 145, 30);
    }


    /*
	  This method waits for user input and displays a prompt.
    */
    private void pauseProgram ()
    {
	c.setColour (Color.black);
	c.setTextBackgroundColor (Color.white);
	c.setFont (mainFont);
	c.drawString ("Press any key to continue...", 210, 450);
	c.getChar ();
    }


    /*
	  This method outputs the splashScreenduction that explains the purpose of the program and has has graphics..
	  ----------------------------------------------------------
	  Local Variables:
	  NAME        TYPE        DESCRIPTION
	  ----------------------------------------------------------
	  middlePurple Color       Used in the graphics.
	  darkPurple   Color       Used in the graphics.
	  splashFont   Font        Big font for menu.
	  ----------------------------------------------------------
	forloop is used to animate the rolling chips on the screen. Thread.sleep is used to delay the animation.
    */
    public void splashScreen ()
    {
	background = (new Color (252, 142, 121));
	Color middlePurple = new Color (212, 185, 229);
	Color darkPurple = new Color (153, 102, 255);
	Font splashFont = (new Font ("Times New Roman", 3, 20));
	title ();
	c.setFont (splashFont);
	c.setColour (Color.white);
	c.drawString ("Welcome to the Virtual Slot Machine!", 170, 130);
	c.drawString ("This program will allow you to try your luck at the slots!", 90, 150);
	c.drawString ("Good Luck!", 240, 170);
	//graphics
	for (int i = 0 ; i <= 760 ; i++)
	{
	    c.setColor (background);
	    c.fillOval (-120 + i, 220, 50, 50); //chip erases
	    c.fillOval (-70 + i, 270, 50, 50);
	    c.fillOval (-20 + i, 320, 50, 50);
	    c.setColor (Color.white);
	    c.fillOval (-119 + i, 220, 51, 51); //rolling chip leaving trail
	    c.setColor (middlePurple);
	    c.fillOval (-69 + i, 270, 51, 51); //rolling chip leaving trail
	    c.setColor (darkPurple);
	    c.fillOval (-19 + i, 320, 51, 51); //rolling chip leaving trail
	    c.setColor (Color.black);
	    c.fillArc (-16 + i, 323, 48, 48, 0 + i, 25); // third chip details
	    c.fillArc (-16 + i, 323, 48, 48, 40 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 80 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 120 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 160 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 200 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 240 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 280 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 320 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 0 + i, 25); // second chip details
	    c.fillArc (-66 + i, 273, 48, 48, 40 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 80 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 120 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 160 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 200 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 240 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 280 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 320 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 0 + i, 25); // first chip details
	    c.fillArc (-116 + i, 223, 48, 48, 40 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 80 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 120 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 160 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 200 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 240 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 280 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 320 + i, 25);
	    c.fillOval (-108 + i, 230, 31, 31); //rolling chip center
	    c.fillOval (-58 + i, 280, 31, 31); //rolling chip center
	    c.fillOval (-8 + i, 330, 31, 31); //rolling chip center
	    c.setColor (Color.white);
	    c.fillOval (-105 + i, 233, 25, 25);
	    c.setColor (middlePurple);
	    c.fillOval (-55 + i, 283, 25, 25);
	    c.setColor (darkPurple);
	    c.fillOval (-5 + i, 333, 25, 25);
	    //used to delay the animation
	    try
	    {
		Thread.sleep (8);
	    }
	    catch (Exception e)
	    {
	    }
	}
	pauseProgram ();
    }


    /*
	  This method displays continue options and prompts to enter continueChoice. There are also casino graphics.
	  ----------------------------------------------------------
	  Local Variables:
	  NAME                TYPE        DESCRIPTION
	  ----------------------------------------------------------
	  stripeRed           Color       This color is used for graphics.
	  stripeLightPurple   Color       This color is used for graphics.
	  stripePurple        Color       This color is used for graphics.
	  barGrey             Color       This color is used for graphics.
	  menuFont            Font        This font is used to print the options.
	  ----------------------------------------------------------
	  The first, second, and third for loops are used to draw the casino chips in a fan fasion.
	  The while loop is used to error trap the user continueChoice.
	  The input in this method is continueChoice.
    */
    public void mainMenu ()
    {
	background = (new Color (255, 188, 81));
	Color stripeRed = (new Color (153, 0, 0));
	Color stripeLightPurple = (new Color (212, 185, 229));
	Color stripePurple = (new Color (71, 0, 179));
	Color barGrey = (new Color (120, 115, 122));
	Font menuFont = (new Font ("Times New Roman", 1, 22));
	title (); //clear screen and display title
	userName = " "; //reset user name
	//create pattern
	c.setColor (stripeLightPurple);
	c.fillRect (0, 460, 640, 500);
	c.setColor (stripePurple);
	c.fillRect (0, 455, 640, 10);
	c.drawLine (0, 452, 640, 452);
	c.drawLine (0, 450, 640, 450);
	c.drawLine (0, 448, 640, 448);
	c.setColour (Color.black);
	c.setFont (menuFont);
	c.drawString ("Enter an Option:", 20, 120);
	c.drawString ("New Game: n", 20, 160);
	c.drawString ("Continue Game: c", 20, 190);
	c.drawString ("Instructions: i", 20, 220);
	c.drawString ("Administrative: a", 20, 305);
	c.drawString ("Exit: e", 20, 275);
	//graphics
	c.setFont (graphicsSevenFont);
	c.setColor (Color.black);
	c.drawString ("7", 409, 239);
	c.setColor (stripeRed);
	c.drawString ("7", 405, 240);
	c.setColor (Color.black);
	//bar sign
	c.setColor (barGrey);
	c.fillRoundRect (420, 260, 150, 80, 50, 50);
	c.setFont (barGraphicsFont);
	c.setColor (background);
	c.drawString ("b a r", 460, 310);
	//draw chip
	c.setColor (Color.white);
	c.fillOval (300, 150, 100, 100);
	c.fillOval (450, 100, 100, 100);
	//draw chip details
	for (int l = 0 ; l < 340 ; l = l + 40) // move angle starting point
	    for (int i = 0 ; i < 25 ; i++) //grow angle
		for (int n = 0 ; n < 100 ; n++) //grow width and height
		{
		    c.setColor (stripePurple);
		    c.drawArc (350 - n / 2, 200 - n / 2, n, n, l, i);
		    c.setColor (Color.black);
		    c.drawArc (500 - n / 2, 150 - n / 2, n, n, l, i);
		}
	//draw chip center
	c.setColor (stripePurple);
	c.fillOval (315, 165, 70, 70);
	c.setColor (Color.black);
	c.fillOval (465, 115, 70, 70);
	c.setColor (Color.white);
	c.fillOval (322, 172, 55, 55);
	c.fillOval (472, 122, 55, 55);
	//get user continue choice
	while (true)
	{
	    continueChoice = c.getChar ();
	    /*The purpose of this conditional statement is to either let the user continue or exit the program based on their input.
	    If they input something that isn't an option, it will give an error message.*/
	    if (continueChoice == 'n' || continueChoice == 'c' || continueChoice == 'i' || continueChoice == 'a' || continueChoice == 'e')
		break;
	    else
		JOptionPane.showMessageDialog (null, "Please enter only one of the options given.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the prompt words
	}
    }


    /*
	  This method controls game play, and displays the slot machine. If after spinning all images are the same, winCount, balance, and lossCount are changed.
	  ----------------------------------------------------------
	  Local Variables:
	  NAME               TYPE        DESCRIPTION
	  ----------------------------------------------------------
	  output             PrintWriter Writes to a file.
	  inputStr           String      Used to store strings for use laster or to be parsed.
	  gameChoice         char        Used to hold game play decision: exit (e) or spin (s)
	  rand               Random      Used to generate random numbers for each wheel in the slot machine.
	  pickedNumber       int         Holds each random number.
	  randInt            int array   Stores picked number before it changes.
	  userBar            Color       Used for graphics.
	   ----------------------------------------------------------
	  The fisrt while loop is used to run the code unless userName = e.
	  The second while loop is used to get userInput for their gameChoice.
	  The first if statement is to break if user enters e
	  The second while loop is used to error trap the amount of money bet.
	  The first for loop is used to choose three random numbers
	  The if structure after is used to display a different image depending on the random integer.
	  The next if structure is used to determine whether the user won or lost.
	  The final if statement is to exit if the user balance = 0 or less
    */
    public void gamePlay ()
    {
	PrintWriter output;
	String inputStr;
	char gameChoice;
	Random rand = new Random ();
	int pickedNumber = rand.nextInt (8) + 1;
	int[] randInt = new int [3];
	Color userBar = (new Color (212, 195, 229));
	background = (new Color (150, 190, 255)); //change background color to be used in title
	title ();
	//draw slot machine
	c.setColor (Color.black);
	c.fillRect (200, 185, 250, 200);
	//draw slot machine details
	c.setColor (Color.white);
	c.drawLine (220, 205, 430, 205);
	c.drawLine (220, 275, 430, 275);
	c.drawLine (220, 205, 220, 275);
	c.drawLine (430, 205, 430, 275);
	c.drawLine (290, 205, 290, 275);
	c.drawLine (360, 205, 360, 275);
	c.drawRect (220, 335, 90, 20);
	c.drawRect (340, 335, 90, 20);
	c.fillRect (225, 295, 60, 20);
	c.fillRect (295, 295, 60, 20);
	c.fillRect (365, 295, 60, 20);
	while (true)
	{
	    if (userName.equals ("e")) //skip game play when an accesed game is already at $0, or user has chosen to exit
		break;
	    //draw user info bar that will erase scores after each spin
	    for (int i = 0 ; i < 540 ; i++)
	    {
		c.setColor (userBar);
		c.drawLine (40 + i, 420, 40 + i, 480);
	    }
	    c.setColor (Color.black);
	    c.drawRect (40, 420, 540, 60);
	    c.setTextBackgroundColor (background);
	    c.setFont (mainFont);
	    c.drawString ("Your Money: $" + balance, 60, 450); //user info
	    c.drawString ("Wins: " + winCount, 300, 450);
	    c.drawString ("Losses: " + lossCount, 475, 450);
	    c.drawString ("Press s to spin, or e to exit.", 210, 80); //prompt
	    while (true)
	    {
		gameChoice = c.getChar (); //user input for game play choice and error trap

		if (gameChoice != 's' && gameChoice != 'e')
		{
		    JOptionPane.showMessageDialog (null, "Please enter either e or s.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
		    break;
		}
	    }
	    if (gameChoice == 'e') //exit if user chooses to exit
		break;
	    c.drawString ("Enter how much money would you like to bet:", 145, 105); //prompt
	    c.drawString ("$1, $2, or $5?", 270, 130);
	    while (true)
	    {
		c.setCursor (8, 40);
		c.println (" ");
		c.setCursor (8, 40);
		inputStr = c.readLine (); //user input for amount bet and error trap
		try
		{
		    moneyBet = Integer.parseInt (inputStr);
		    if (moneyBet != 1 && moneyBet != 2 && moneyBet != 5)
			JOptionPane.showMessageDialog (null, "Please enter either 1, 2, or 5", "ERROR", JOptionPane.ERROR_MESSAGE);
		    else
			break;
		}
		catch (NumberFormatException e)
		{
		    JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    //cover last spin
	    c.fillRect (221, 206, 69, 65);  //space 1
	    c.fillRect (291, 206, 69, 65);   //space 2
	    c.fillRect (361, 206, 69, 65);   //space 3
	    for (int j = 0 ; j < 3 ; j++) //choose three random integers
	    {
		randInt [j] = rand.nextInt (pickedNumber);
		//used to delay between symbols
		try
		{
		    Thread.sleep (500);
		}
		catch (Exception e)
		{
		}
		//draw slot symbol for each reel
		if (randInt [j] == 0)
		{
		    c.setFont (graphicsSevenFont); //symbol 1 "7"
		    c.setColor (Color.red);
		    c.drawString ("7", 230 + j * 70, 270);
		}
		else if (randInt [j] == 1)
		{
		    //draw bell top
		    c.setColor (Color.yellow);
		    c.fillOval (235 + j * 70, 215, 40, 40);
		    //draw bell middle
		    c.setColor (Color.orange);
		    c.fillOval (230 + j * 70, 230, 50, 30);
		    //draw bell bottom
		    c.setColor (Color.yellow);
		    c.fillOval (230 + j * 70, 240, 50, 20);
		    //draw bell ball
		    c.setColor (Color.orange);
		    c.fillOval (248 + j * 70, 250, 15, 15);
		}
		else if (randInt [j] == 2)
		{
		    //draw orange
		    c.setColor (Color.orange);
		    c.fillOval (230 + j * 70, 220, 50, 50);
		    //draw stem
		    c.setColor (Color.green);
		    c.fillOval (255 + j * 70, 225, 5, 5);

		}
		else if (randInt [j] == 3)
		{
		    //draw plum
		    c.setColor (Color.magenta);
		    c.fillOval (225 + j * 70, 220, 59, 50);
		    //draw stem
		    c.setColor (Color.green);
		    c.drawArc (250 + j * 70, 210, 30, 30, 270, 90);
		}
		else if (randInt [j] == 4)
		{
		    //draw watermelon
		    c.setColor (Color.green);
		    c.fillOval (230 + j * 70, 220, 50, 50);
		    c.fillOval (225 + j * 70, 220, 50, 50);
		    c.fillOval (235 + j * 70, 220, 50, 50);
		    c.setColor (Color.red);
		    c.drawOval (245 + j * 70, 220, 20, 50);
		}
		else if (randInt [j] == 5)
		{
		    //draw cherries
		    c.setColor (Color.green);
		    c.drawLine (250 + j * 70, 230, 260 + j * 70, 225);
		    c.drawLine (265 + j * 70, 240, 260 + j * 70, 225);
		    c.drawLine (260 + j * 70, 225, 256 + j * 70, 210);
		    c.setColor (Color.red);
		    c.fillOval (243 + j * 70, 230, 15, 15);
		    c.fillOval (233 + j * 70, 240, 15, 15);
		    c.fillOval (258 + j * 70, 240, 15, 15);
		}
		else if (randInt [j] == 6)
		{
		    c.setColor (Color.yellow);
		    c.fillOval (230 + j * 70, 220, 50, 40);
		    c.fillOval (225 + j * 70, 235, 10, 10);
		    c.fillOval (275 + j * 70, 235, 10, 10);
		}
		else if (randInt [j] == 7)
		{
		    c.setColor (Color.white);
		    c.setFont (barGraphicsFont);
		    c.drawString ("bar", 230 + j * 70, 250);
		}
	    }
	    if (randInt [0] == randInt [1] && randInt [1] == randInt [2]) //test for matching ints
	    {
		results = true;
		winCount = winCount + 1;
	    }
	    else
	    {
		results = false;
		lossCount = lossCount + 1;
	    }
	    balance = balanceCalc (results, moneyBet, balance); //calculate balance
	    if (balance <= 0) //end if out of funds
	    {
		break;
	    }
	}
    }


    /*
	    This method displays the game results and allows the user to create a file and save their data, or saves to an existing file.
	    ----------------------------------------------------------
	    Local Variables:
	    NAME               TYPE        DESCRIPTION
	    ----------------------------------------------------------
	    output           PrintWriter   Writes to a file.
	    outputScores     PrintWriter   Writes to highscore file.
	    fileName         String        Used to create a file name from user name.
	    boxBlue          Color         Used to draw user box.
	     ----------------------------------------------------------
	    First if statement skips code if userName is e.
	    Second if statement displays a different message if balance is 0.
	    Third if statement displays different messages if the game is new or continued.
	    Next block of code is where data is saved to user files and the highscore file.
    */
    public void display ()
    {
	PrintWriter output;
	PrintWriter outputScores;
	String fileName;
	Color boxBlue = (new Color (150, 190, 255));
	background = (new Color (252, 142, 121)); //change color to be used in title
	title ();
	if (!userName.equals ("e"))
	{
	    //box graphics
	    c.drawRect (130, 90, 380, 150);
	    c.setColor (boxBlue);
	    c.fillRect (130, 300, 190, 60);
	    c.setColor (Color.white);
	    c.fillRect (320, 300, 190, 60);
	    c.setColor (Color.black);
	    c.setFont (mainFont);
	    if (balance == 0) // when balance is $0
		c.drawString ("Oh No! You ran out of money!", 200, 140);
	    else
		c.drawString ("Good game! You ended with $" + balance + ".", 180, 140);
	    c.drawString ("Game Name:", 150, 335);
	    if (continueChoice == 'n') //only display if this is a new game
	    {
		c.drawString ("Before you leave, give this round a name", 150, 165);
		c.drawString ("so you can come back later!", 195, 190);
		c.drawString ("Wins: " + winCount + "     Losses: " + lossCount, 235, 215);
		c.setTextBackgroundColor (Color.white);
		c.setCursor (17, 45);
		userName = c.readLine (); //get user name
		//cover end of enter line
		c.setColor (background);
		c.fillRect (511, 310, 150, 30);
	    }
	    else
	    {
		c.drawString ("This round is still saved as", 220, 165);
		c.drawString ("" + userName, 300, 190);
		c.drawString ("Wins: " + winCount + "     Losses: " + lossCount, 235, 215);
		c.drawString ("" + userName, 350, 335);
	    }
	    fileName = userName + ".slots";
	    try
	    {
		output = new PrintWriter (new FileWriter (fileName)); //save name and balance to file
		// write data to the file
		output.println (userName);
		output.println (balance);
		output.println (winCount);
		output.println (lossCount);
		// close the stream
		output.close ();
	    }
	    catch (IOException e)
	    {
	    }
	    try
	    {
		//establish a stream called outputFile to the file myoutdata.txt
		outputScores = new PrintWriter (new BufferedWriter (new FileWriter ("highScores.txt", true)));
		// write data to the file
		outputScores.println (userName);
		outputScores.println (balance);
		outputScores.println (winCount);
		outputScores.println (lossCount);
		// close the stream
		outputScores.close ();
	    }
	    catch (IOException e)
	    {
	    }
	    balance = 100; //reset initial balance
	    winCount = 0; //reset initial wins
	    lossCount = 0; //reset initial loses
	    pauseProgram ();
	}
    }


    /*
	  This method opens a file to be used in game play (allows user to continue a game previosly saved).
	  ----------------------------------------------------------
	  Local Variables:
	  NAME           TYPE            DESCRIPTION
	  ----------------------------------------------------------
	  input          BufferedReader  Reads file.
	  inputStr       String          Used to hold user input before converting integers or before need to be used.
	  boxRed         Color           Used in graphics.
	  fileName       String          Used to create file name from user input.
	  file           File            Used to check if file exists.
	  ----------------------------------------------------------
	  The first while loop is to skip the code when the user enters e.
	  The first if structure controls when to break and if a name is entered, checks if that file exists.
	  If file exists, the file is read in a try-catch structure.
    */
    public void accessGame ()
    {
	BufferedReader input;
	String inputStr = null;
	Color boxRed = (new Color (252, 142, 121));
	String fileName;
	File file;
	title (); //clear screen and display title
	//box graphics
	c.drawRect (90, 60, 460, 150);
	c.setColor (boxRed);
	c.fillRect (130, 260, 190, 60);
	c.setTextBackgroundColor (background);
	c.setColor (Color.black);
	c.setFont (mainFont);
	c.drawString ("Enter the name of the round you would like to play.", 108, 90);
	c.drawString ("Only files that exist and were created", 155, 120);
	c.drawString ("with this program can be opened", 175, 150);
	c.drawString ("If you would like to exit, press 'e'", 173, 180);
	c.drawString ("Enter Name: ", 145, 295);
	while (true)
	{
	    c.setColor (Color.white);
	    c.fillRect (320, 260, 190, 60); //draw enter bar
	    c.setCursor (15, 45);
	    c.setTextBackgroundColour (Color.white);
	    userName = c.readLine ();
	    fileName = userName + ".slots";
	    //cover enter line
	    c.setColor (background);
	    c.fillRect (511, 280, 150, 20);
	    if (userName.equals ("e")) //leave if user chooses to exit
	    {
		break;
	    }
	    else if (fileName.substring (fileName.length () - 6, fileName.length ()).equals (".slots"))
	    {
		try
		{
		    file = new File (fileName);
		    if (file.exists ())
		    {
			input = new BufferedReader (new FileReader (fileName));
			//read from file
			userName = input.readLine ();
			balance = Integer.parseInt (input.readLine ());
			winCount = Integer.parseInt (input.readLine ());
			lossCount = Integer.parseInt (input.readLine ());
			input.close ();
			c.setColor (Color.black);
			c.drawString ("Your balance is $" + balance + "!", 230, 370);
			c.drawString ("Wins: " + winCount + "   Losses: " + lossCount, 230, 395);
			if (balance <= 0)
			{
			    c.drawString ("You have no money to play with! Instead, create a new game.", 75, 420);
			    userName = "e";
			    pauseProgram ();
			}
			else
			{
			    c.drawString ("Get Ready to play!", 240, 420);
			    pauseProgram (); //press any key
			}
			break;
		    }
		    else if (!(file.exists ()))
		    {
			JOptionPane.showMessageDialog (null, "That user name does not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
		catch (IOException e)
		{
		    JOptionPane.showMessageDialog (null, "Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);

		}
	    }
	}
    }


    /*
	This method displays the game instrcutions and then continues back to mainMenu.
	----------------------------------------------------------
	Code block is all output of instructions using mainFont
    */
    public void instructions ()
    {
	title ();
	c.setColour (Color.black);
	c.setFont (mainFont);
	c.drawString ("Instructions", 280, 100);
	c.drawString ("1.   To play, press the 'New Game' button in the main menu, or", 15, 155);
	c.drawString ("     'Continue Game'", 15, 180);
	c.drawString ("2.   Press s to spin, and enter your bet. ", 15, 230);
	c.drawString ("      If you win, you will earn 5 times your bet.", 15, 255);
	c.drawString ("3.   Play until you have $0, or press e to exit.", 15, 305);
	c.drawString ("4.   Give your game a name if you have not already.", 15, 355);
	pauseProgram ();
    }


    /*
	 This method is admin level and is password protected. There are two options, one to view and clear high scores and one to view and edit a specific user's balance.
	 ----------------------------------------------------------
	 Local Variables:
	 NAME          TYPE             DESCRIPTION
	 ----------------------------------------------------------
	 input          BufferedReader   Reads a file.
	 output         PrintWriter      Writes to a file.
	 file           File             Used to check if file exists.
	 inputInt       Int              Used to hold user input ints before they are used.
	 inputStr       String           Used to hold user input strings before they are used.
	 password       String           Password is slotsFun, and if the user does not enter corectly code is skipped.
	 fileName       String           Used to hold a file name created with userName.
	 continueChoice String           Used to determine which block of code to run depending on user input.
	 lineCount      int              Used to count how many lines are in a file and then run a loop of that length.
	 line           String           Place holder string used to read file until null.
	 newBalance     int              User can choose a new balance foe a user of their choice.
	 highScore      int array        This array holds all highScores read from a file and then is sorted.
	 highScoreNames String array     This array holds all highScoreNames read from a file and then is sorted.
	 ----------------------------------------------------------
	 The first while loop is used to error trap the password and only breaks when the password is correct.
	 The first if structure controls the next user input and is only displayed if password is correct.
	 The second while loop error traps the user choice to edit score or highscores.
	 The second if statement checks to make sure only the two options are entered.
	 The third if structure controls whether the code for user edits or high score is displayed and run.
	 The each while loop allows the user to exit when the enter e.
	 The rest of the if statements are to make sure that only what is prompted is entered.
	 The while loops that run while reading a file count lines or run until a file line is null.
	 Nested in the else if (continueChoice = "h") is an if statement that sorts highScore while reading from highScore file by moving each value down the list if the value read is larger than the last

    */
    public void admin ()
    {
	BufferedReader input;
	PrintWriter output;
	File file;
	String inputStr = " ";
	String password;
	String fileName = " ";
	String continueChoice = " ";
	int lineCount = 0;
	String line = " ";
	int newBalance = 0;
	int inputInt = 0;
	int[] highScore = new int [10];
	String[] highScoreNames = new String [10];
	title ();
	c.setColour (Color.black);
	c.setTextBackgroundColor (background);
	c.setFont (mainFont);
	c.drawString ("Administration", 260, 110);
	c.drawString ("Enter 'e' at any time to exit.", 210, 400);
	while (true)
	{
	    c.drawString ("Please enter the admin password, or enter e to exit.", 108, 130); //user input for admin password, error trapped
	    c.setCursor (8, 37);
	    c.println ();
	    c.setCursor (8, 37);
	    password = c.readLine ();
	    if (!password.equals ("slotsFun") && !password.equals ("e")) //includes exit option
		JOptionPane.showMessageDialog (null, "The password is incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
	    else if (password.equals ("e"))
		break;
	    else
	    {
		while (true)
		{
		    c.drawString ("Would you like to access a specific user (u) or highscores (h)?", 70, 175);
		    c.setCursor (10, 37);
		    c.println ();
		    c.setCursor (10, 37);
		    continueChoice = c.readLine ();
		    if (continueChoice.equals ("u") || continueChoice.equals ("h"))
			break;
		    else if (continueChoice.equals ("e"))
		    {
			password = "e";
			break;
		    }
		    else
			JOptionPane.showMessageDialog (null, "Enter u or h!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		break;
	    }
	}
	if (continueChoice.equals ("u"))
	{

	    while (true)
	    {
		c.drawString ("Enter a game you would like to view and edit: ", 130, 215);
		c.setCursor (12, 37);
		c.println ();
		c.setCursor (12, 37);
		userName = c.readLine (); //user input for user name
		fileName = userName + ".slots";
		if (userName.equals ("e"))
		    break; //exit
		try
		{
		    file = new File (fileName);
		    if (file.exists ()) //check if file exists
		    {
			input = new BufferedReader (new FileReader (fileName));
			userName = input.readLine (); //read user name
			balance = Integer.parseInt (input.readLine ()); //read balance
			winCount = Integer.parseInt (input.readLine ());
			lossCount = Integer.parseInt (input.readLine ());
			c.drawString ("User Name: " + userName, 20, 270);
			c.drawString ("Balance is $" + balance, 20, 295); //display balance
			input.close ();
			break;
		    }
		    else if (!(file.exists ()))
		    {
			new Message ("Error! File does not exist.", "Error!");
		    }
		}
		catch (IOException e)
		{
		    new Message ("Error! File does not exist.", "Error!");
		}
	    }

	    while (!userName.equals ("e") && !password.equals ("e"))  //exit if e has been entered
	    {
		c.drawString ("Enter new balance to be saved: ", 20, 315); //prompt
		while (true)
		{
		    c.setCursor (17, 14);
		    c.println ();
		    c.setCursor (17, 14);
		    inputStr = c.readLine (); //read balance
		    try
		    {
			if (inputStr.equals ("e"))
			{
			    newBalance = balance; //if e is entered keep balance the same
			    break;
			}
			else
			{
			    newBalance = Integer.parseInt (inputStr);
			    if (newBalance < 0)
				JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
			    else
				break;
			}
		    }
		    catch (NumberFormatException e)
		    {
			new Message ("Positive integers only!", "Error!");
		    }
		}
		try
		{
		    output = new PrintWriter (new FileWriter (fileName)); //write to file selected
		    //write to file
		    output.println (userName);
		    output.println (newBalance);
		    output.println (winCount);
		    output.println (lossCount);
		    //end file
		    output.close ();
		}
		catch (IOException e)
		{
		    JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		break;
	    }
	    try
	    {
		input = new BufferedReader (new FileReader ("highScores.txt")); //write to file selected
		while (true)
		{
		    line = input.readLine ();
		    if (line == null)
			break;
		    lineCount++;
		}
		input.close ();
	    }
	    catch (IOException e)
	    {
	    }
	    try
	    {
		input = new BufferedReader (new FileReader ("highScores.txt")); //write to file selected
		for (int i = 0 ; i < lineCount / 4 ; i++)
		{
		    highScoreNames [i] = input.readLine ();
		    highScore [i] = Integer.parseInt (input.readLine ());
		    inputInt = Integer.parseInt (input.readLine ());
		    inputInt = Integer.parseInt (input.readLine ());
		}
		input.close ();
	    }
	    catch (IOException e)
	    {
	    }
	    try
	    {
		output = new PrintWriter (new FileWriter ("highScores.txt")); //write to file selected
		for (int i = 0 ; i < lineCount / 4 ; i++)
		{
		    output.println (highScoreNames [i]);
		    if (highScoreNames [i].equals (userName))
		    {
			output.println (newBalance);
		    }
		    else
		    {
			output.println (highScore [i]);
		    }
		    output.println (1);
		    output.println (1);
		}
		//end file
		output.close ();
	    }
	    catch (IOException e)
	    {
	    }
	}
	else if (continueChoice.equals ("h"))
	{
	    try
	    {
		file = new File ("highScores.txt");
		if (file.exists ()) //check if file exists
		{
		    input = new BufferedReader (new FileReader ("highScores.txt")); //reset BufferedReader
		    while (inputStr != null)
		    {
			inputStr = input.readLine (); //read user name
			if (inputStr == null)
			    break;
			inputInt = Integer.parseInt (input.readLine ()); //read balance
			if (inputInt > highScore [1]) //if balance is larger than last balance
			{
			    highScore [9] = highScore [8]; //move all balances one place down
			    highScore [8] = highScore [7];
			    highScore [7] = highScore [6];
			    highScore [6] = highScore [5];
			    highScore [5] = highScore [4];
			    highScore [4] = highScore [3];
			    highScore [3] = highScore [2];
			    highScore [2] = highScore [1];
			    highScore [1] = highScore [0];
			    highScore [0] = inputInt;
			    highScoreNames [9] = highScoreNames [8]; //move all names one place down
			    highScoreNames [8] = highScoreNames [7];
			    highScoreNames [7] = highScoreNames [6];
			    highScoreNames [6] = highScoreNames [5];
			    highScoreNames [5] = highScoreNames [4];
			    highScoreNames [4] = highScoreNames [3];
			    highScoreNames [3] = highScoreNames [2];
			    highScoreNames [2] = highScoreNames [1];
			    highScoreNames [1] = highScoreNames [0];
			    highScoreNames [0] = inputStr;
			}
			winCount = Integer.parseInt (input.readLine ()); //hold wins and losses
			lossCount = Integer.parseInt (input.readLine ());
		    }
		    input.close ();
		    for (int i = 0 ; i < 10 ; i++)
		    {
			if (i != 9 && highScore [i] < highScore [i + 1]) //switch any wrong orders
			{
			    inputInt = highScore [i]; //store lower number
			    highScore [i] = highScore [i + 1]; //replace lower number
			    highScore [i + 1] = inputInt; //replace higher number with stored number
			    inputStr = highScoreNames [i];
			    highScoreNames [i] = highScoreNames [i + 1];
			    highScoreNames [i + 1] = inputStr;
			}
			c.drawString ("Highscores", 20, 225);
			if (i <= 4 && highScoreNames [i] != null)
			{
			    c.drawString ("" + (i + 1) + ". " + highScoreNames [i] + " $" + highScore [i], 20, 250 + 25 * i); //print high scores
			    inputStr = "notClear";
			}
			else if (i > 4 && highScoreNames [i] != null)
			{
			    c.drawString ("" + (i + 1) + ". " + highScoreNames [i] + " $" + highScore [i], 180, 125 + 25 * i); //print high scores
			    inputStr = "notClear";
			}
			else if (inputStr != "notClear")
			{
			    c.drawString ("All scores have been cleared! Try starting a new round!", 20, 250);
			    inputStr = "clear";
			}
		    }
		    while (inputStr != "clear")
		    {
			try
			{

			    c.drawString ("Would you like to clear the high scores?", 280, 245);
			    c.drawString ("(Y or N)", 280, 270);
			    c.setCursor (15, 38);
			    c.println ();
			    c.setCursor (15, 38);
			    inputStr = c.readLine ();
			    if (inputStr.equalsIgnoreCase ("y") || inputStr.equalsIgnoreCase ("n") || (inputStr.equalsIgnoreCase ("e")))
			    {
				break;
			    }
			    else
			    {
				new Message ("Please enter y or n", "Error!");
			    }

			}
			catch (NumberFormatException e)
			{
			    new Message ("Please enter a possitive integer!", "Error!");

			}
		    }
		    if (inputStr.equalsIgnoreCase ("y"))
		    {
			output = new PrintWriter (new FileWriter ("highScores.txt"));
			output.close ();
			for (int i = 0 ; i < 10 ; i++)
			{
			    fileName = highScoreNames [i] + ".slots";
			    file = new File (fileName);
			    if (file.exists ())
				file.delete ();
			}
		    }
		}
		else
		{
		    new Message ("Error! File does not exist.", "Error!");
		}
	    }
	    catch (IOException e)
	    {
		new Message ("Error! Something went wrong!", "Error!");
	    }

	}
	pauseProgram ();
	balance = 100;
	winCount = 0;
	lossCount = 0;
    }


    /*
	This method is a return method that will return the int new balance using global variables results, moneyBet, and balance as parameters.
	----------------------------------------------------------
	Local Variables:
	NAME               TYPE        DESCRIPTION
	----------------------------------------------------------
	returnBalance      int         Variable being calculated then returned.
	 ----------------------------------------------------------
	If structure used to determine calculation made (+ if user won, - if user lost)
    */
    private int balanceCalc (boolean results, int moneyBet, int balance)
    {
	int returnBalance = 0;
	if (results == true)
	    returnBalance = balance + (5 * moneyBet);
	else if (results == false)
	    returnBalance = balance - moneyBet;
	return returnBalance;
    }


    /*
	 This method displays a goodbye message and closes the console.
	 ----------------------------------------------------------
	 Try-catch sructure for Thread.sleep() before c.close()
    */
    public void goodBye ()
    {
	title (); //clear screen and display title
	c.setColour (Color.black);
	c.drawString ("Thank you for using the ", 135, 190);
	c.drawString ("Virtual Slot Machine", 165, 230);
	c.drawString ("Program by Megan Holmes", 125, 270);
	//used to delay closing
	try
	{
	    Thread.sleep (2000);
	}
	catch (Exception e)
	{
	}
	c.close ();
    }


    public static void main (String[] args)
    {
	MeganISP11 v = new MeganISP11 ();
	v.splashScreen ();
	while (true)
	{
	    v.mainMenu ();
	    if (v.continueChoice == 'e')
	    {
		break;
	    }
	    else if (v.continueChoice == 'n')
	    {
		v.gamePlay ();
		v.display ();
	    }
	    else if (v.continueChoice == 'c')
	    {
		v.accessGame ();
		v.gamePlay ();
		v.display ();
	    }
	    else if (v.continueChoice == 'i')
	    {
		v.instructions ();
	    }
	    else if (v.continueChoice == 'a')
	    {
		v.admin ();
	    }
	}
	v.goodBye ();
    }
} // MeganISP11 class close


