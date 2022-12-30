import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * This abstract class extends JComponent to access and draw bounds of an
 * object. It then encapsulates the BigEnemy and SmallEnemy classes.
 * 
 * @author Chase
 *
 */
@SuppressWarnings("serial")
public abstract class Enemy extends JComponent {

    /**
     * enemySpeed is initialized as a instance variable to obtain the speed.
     * enemyColor is initialized as a instance variable to obtain the colors of
     * the enemy object.
     */
    private double enemySpeed;
    private Color enemyColor;

    /**
     * This constructor initializes the enemy's speed and bounds.
     * 
     * @param x          This variable is used for x values.
     * @param y          This is used for y values.
     * @param height     This is for the height of enemy.
     * @param width      This is for width of enemy.
     * @param enemySpeed This is used for the enemy's speed.
     */
    public Enemy(int x, int y, int height, int width, double enemySpeed) {
        this.enemySpeed = enemySpeed;
        this.setBounds(x, y, width, height);

    }

    /**
     * This abstract method determines when missiles hit the enemy. It is
     * overridden in child classes.
     * 
     * @param list  This ArrayList goes through the list of enemies.
     * @param enemy This variable refers to enemies.
     */
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    /**
     * This abstract method generates enemy color and is overridden in child
     * classes.
     */
    public abstract void setColor();

    /**
     * This abstract method updates the enemy's movement.
     */
    public abstract void move(int frameWidth, int frameHeight);

    /**
     * This method draws the enemy within the bounds and gets a color.
     */
    public void paintComponent(Graphics g) {
        final Rectangle bounds = this.getBounds();
        g.setColor(enemyColor);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);

    }

    /**
     * This method gets the enemy's speed.
     * 
     * @return returns the enemySpeed.
     */
    public double getEnemySpeed() {
        return enemySpeed;
    }

    /**
     * This setter sets enemySpeed.
     * 
     * @param enemySpeed Refers to current object.
     */
    public void setEnemySpeed(double enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    /**
     * This method gets the enemy's color.
     * 
     * @return returns the enemyColor.
     */
    public Color getEnemyColor() {
        return enemyColor;
    }

    /**
     * This setter sets the enemyColor.
     * 
     * @param enemyColor Refers to current object.
     */
    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }
}
