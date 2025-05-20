public class Project2Runner {
    
    /*
     * Name: <Sanad Mustafa>
     * Student ID: <501305943>
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * My program is a fun game which consists of a maze and a dot. The user first inputs their name, then
     * they can press "Start/Restart" to begin moving. The player controls a red dot that navigates 
     * through the maze. They can move by using the arrow keys, only in the direction with no walls
     * in order to keep them from moving through the border of the maze. At any time, the user can restart 
     * their position if they are stuck or just want to start from the beginning. This can be done by pressing 
     * "Start/Restart" button. Eventually once they reach the end, a message is displayed to the frame to 
     * congratulate the player.
     *
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * Firstly, I used a JLabel. The line at which the logic behind the JLabel can be found at lines 28-29
     * and line 47. The whole purpose of the label is to display a message to the player saying "Good Luck". 
     * What makes it unique is that the user can add on to the label, which bring me on to the next Swing component
     * that I used. A JTextField is a swing component used to recieve user input by using swing GUI. I integrated it
     * with my JLabel to allow the user to add whatever name or sentance they want after the "Good Luck!" message.
     * The logic behind the JTextField can be found on lines 32-44. Lastly, I used a JButton. The purpose of the 
     * JButton was to allow the player to start the game and begin moving. If they get stuck and want to restart,
     * they can click the button and the ball relocates itself to the starting position. The lines for the JButton 
     * logic can be found between 61-63 and 72-80.
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * In the program, I have made my Maze class inherit from JPanel. The most important function that I used
     * was the paintComponent. It was overidden and used to draw the Dot and Border objects. This can 
     * be seen in lines 85 - 90. Within my Dot and Border classes, I made a draw function for each which
     *  emphasizes polymorphism. These draw() functions are located on lines 109-113 and 154 -167. What is unique
     * about the Border class is that each rect drawn is based on the array called "mazeList". A '1' represents a 
     * wall and a 0 represents space that the dot can move through. By using a for loop, I was able to draw a rect
     * to represent each '1' value from the Array.
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * My game uses an ActionListener via the JButton. The JButton, which is located at the bottom of the screen
     * is used to Start/Restart the game. When the user clicks it for the first time, this gives them the ability to move 
     * the dot, otherwise they wouldnt be able to move it. And once it's clicked after that, the dots position is reset
     * to where it was initially. Eventually, once the player reaches the end of the maze, I created a conditional 
     * in the keylistener class to trigger a statement to show up. This can be found on lines 201-223.
     * 
     */

    public static void main(String[] args) {
        Maze maze = new Maze();
    }
}
