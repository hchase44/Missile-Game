
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the
 * 
 * @author DJ Rao
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    /**
     * The list of enemies in the game. Objects are added in the addEnemy method
     * and removed in the detectCollison method.
     */
    private ArrayList<Enemy> enemyList;

    /**
     * The list of missiles in the game. Objects are added in the addMissile
     * method and removed in the detectCollison method.
     */
    private ArrayList<Missile> missileList;

    /**
     * The current score in the game. This value is updated in the
     * detectCollision method.
     */

    /**
     * Instance variables established.
     */
    private int totalScore = 0;

    private boolean isNextEnemyBig;

    private Turret turret;

    /**
     * Constructor to initialize instance variables.
     */
    public GamePanel() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        this.totalScore = 0;
        this.isNextEnemyBig = false;
        this.turret = new Turret();
        this.enemyList = new ArrayList<Enemy>();
        this.missileList = new ArrayList<Missile>();

        BigEnemy be = new BigEnemy(this.getPreferredSize().width / 2,
                this.getPreferredSize().height);
        SmallEnemy se = new SmallEnemy(this.getPreferredSize().width / 4,
                this.getPreferredSize().height);

        enemyList.add(se);
        enemyList.add(be);
    }

    /**
     * Goes through enemyList and missileList to get their paintComponents.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).paintComponent(g);
        }
        for (int i = 0; i < missileList.size(); i++) {
            missileList.get(i).paintComponent(g);
        }
        turret.paintComponent(g);
    }

    // For action movement.
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    // Allows you to use left and right arrow keys
    public void keyPressed(KeyEvent e) {
        
        int funct = e.getKeyCode();

        if (funct == KeyEvent.VK_LEFT) {
            System.out.println("left");
            turret.left();
            this.turret.repaint();

        }
        if (funct == KeyEvent.VK_RIGHT) {
            turret.right(this.getPreferredSize().width);
            System.out.println("right");
            this.turret.repaint();
        }
    }

    /**
     * Method detects the collision of the missile and all the enemies. This is
     * done by drawing invisible rectangles around the enemies and missiles, if
     * they intersect, then they collide.
     */
    public void detectCollision() {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                    if (enemyList.get(i) instanceof BigEnemy) {
                        totalScore += 100;
                    } else {
                        totalScore += 150;
                    }
                }
            }
        }
    }

    /**
     * Gets the total score.
     * 
     * @return the total score.
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Constructor to add enemies to list depending on size.
     */
    public void addEnemy() {

        BigEnemy be = new BigEnemy(this.getPreferredSize().width / 2,
                this.getHeight());
        SmallEnemy se = new SmallEnemy(this.getWidth() / 4, this.getHeight());
        isNextEnemyBig = !isNextEnemyBig;
        if (isNextEnemyBig == false) {
            enemyList.add(be);
        } else {
            enemyList.add(se);
        }

    }

    /**
     * Adds a new missile to list.
     */
    public void addMissile() {
        Missile m1 = new Missile(this.turret.getTurretX(), 350);
        missileList.add(m1);
    }

    /**
     * Movement for the game of enemies and missiles.
     */
    @SuppressWarnings("deprecation")
    public void move() {
        final int width = this.getWidth();
        final int height = this.getHeight();
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).move(width, height);
        }
        for (int i = 0; i < missileList.size(); i++) {
            missileList.get(i).move(width, height, missileList, i);

        }

    }

    /**
     * Auto generated for key movement.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
