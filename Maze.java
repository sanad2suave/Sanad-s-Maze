import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maze extends JPanel {

    private Dot d;
    private Border b;
    private JLabel title;
    private final int width = 900;
    private final int height = 800;
    
    // storing the starting and ending coordinates as instance variables.
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Maze() {
        JFrame frame = new JFrame("Sanad's Maze Game!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());

        // Create a top panel with vertical layout to hold the title label and text field.
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Title label initially set to "Good Luck!"
        title = new JLabel("Good Luck!", SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a text field to ask for the user's name.
        JTextField userInp = new JTextField("Enter your name");
        userInp.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        
        // when the user presses Enter update the title with their name or whatever they inputted.
        userInp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userInp.getText().trim();
                if (!name.isEmpty()) {
                    title.setText("Good Luck " + name + "!");
                }
            }
        });

        topPanel.add(title);
        topPanel.add(userInp);
        frame.add(topPanel, BorderLayout.NORTH);

        // the actual panel where the maze and dot are drawn
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new dotMover());
        frame.add(this, BorderLayout.CENTER);

        // bottom panel has a restart button in the center
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton resetButton = new JButton("Start/Restart");
        bottomPanel.add(resetButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // starting point for the red dot
        startX = 200 + 1 * 20;
        startY = 90 + 23 * 20;
        endX = 200 + 23 * 20;
        endY = 90 + 0 * 20;
        d = new Dot(startX, startY);
        b = new Border(200, 90);

        // Action listener for the Reset button.
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setPosition(startX, startY);
                repaint();
                Maze.this.requestFocusInWindow();
            }
        });

        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        d.draw(g);
        b.draw(g);
    }

    // this class represents the red dot (aka player)
    public class Dot {
        private int x, y;
        private final int size = 20;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.fillOval(x, y, size, size);
        }
    }

     // this class draws the maze and also checks for wall collisions
    public class Border {
        private final int[][] mazeList = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1},
            {1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1},
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
            {1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1},
            {1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
            {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
            {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        private final int wallSize = 20;
        public int corx;
        public int cory;

        public Border(int corx, int cory) {
            this.corx = corx;
            this.cory = cory;
        }

        // draw the maze walls
        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (int row = 0; row < mazeList.length; row++) {
                for (int col = 0; col < mazeList[0].length; col++) {
                    int x = (col * wallSize) + corx;
                    int y = (row * wallSize) + cory;

                    if (mazeList[row][col] == 1) {
                        g2d.setColor(Color.BLACK);
                        g2d.fillRect(x, y, wallSize, wallSize);
                    }
                }
            }
        }

        // check if the given position is inside a wall
        public boolean isWall(int x, int y) { 
            int size = 20;
            int[][] corners = {
                {x, y},
                {x + size - 1, y},
                {x, y + size - 1},
                {x + size - 1, y + size - 1}
            };

            for (int[] corner : corners) {
                int col = (corner[0] - corx) / wallSize;
                int row = (corner[1] - cory) / wallSize;

                if (row < 0 || row >= mazeList.length || col < 0 || col >= mazeList[0].length) {
                    return true; // out of bounds = wall
                }

                if (mazeList[row][col] == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    // handles arrow key movement for the red dot
    private class dotMover implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int newX = d.getX();
            int newY = d.getY();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: newX -= 10; break;
                case KeyEvent.VK_RIGHT: newX += 10; break;
                case KeyEvent.VK_UP: newY -= 10; break;
                case KeyEvent.VK_DOWN: newY += 10; break;
            }

            if (!b.isWall(newX, newY)) {
                d.setPosition(newX, newY);
                repaint();
            
                // checking if the dot reached the end of the maze
                if (d.getX() == endX && d.getY() == endY) {
                    title.setText("Congratulations you have completed Sanad's maze!");
                }
            }
        }

        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
}
