import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * This class extends JComponent and encapsulates information about Missile.
 * 
 * @author Chase
 *
 */
@SuppressWarnings("serial")
public class Missile extends JComponent {

    /**
     * These instance variables are used to get missileSpeed and generate a
     * color.
     */
    private int missileSpeed;
    private Color missileColor;

    /**
     * This constructor sets missileSpeed and initializes a missile at random
     * coordinates.
     * 
     * @param x Random x value.
     * @param y Random y value.
     */
    public Missile(int x, int y) {
        missileSpeed = 5;
        missileColor = Color.BLACK;
        this.setBounds(x, y, 15, 15);

    }

    /**
     * This setter gets the missileColor.
     * 
     * @param missileColor Gets missileColor.
     */
    public void setMissileColor(Color missileColor) {

    }

    /**
     * This setter gets missileSpeed.
     * 
     * @param missileSpeed Uses missileSpeed.
     */
    public void setMissileSpeed(int missileSpeed) {

    }

    /**
     * This method draws a circle within bounds and grabs the missileColor.
     */
    public void paintComponent(Graphics g) {
        final Rectangle bounds = this.getBounds();
        g.setColor(missileColor);
        g.fillOval(getX(), getY(), (int) bounds.getWidth(),
                (int) bounds.getHeight());
    }

    /**
     * This method determines if a missile is off the screen and removes a
     * missile from the ArrayList.
     * 
     * @param width   Weight of missile.
     * @param height  Height of missile.
     * @param list    List of generated missiles.
     * @param missile The missiles.
     */
    public void move(int width, int height, ArrayList<Missile> list,
            int missile) {
        int newHeight = list.get(missile).getY() - missileSpeed;
        list.get(missile).setBounds(list.get(missile).getX(), newHeight,
                list.get(missile).getWidth(), list.get(missile).getHeight());

        if (newHeight < 0) {
            list.remove(missile);
        }

    }

    /**
     * This is a getter method for missileSpeed.
     * 
     * @return Returns the missileSpeed.
     */
    public int getMissileSpeed() {
        return missileSpeed;
    }
}
