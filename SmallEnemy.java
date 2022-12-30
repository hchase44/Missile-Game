import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class extends Enemy and implements its methods.
 * 
 * @author Chase
 *
 */
@SuppressWarnings("serial")
public class SmallEnemy extends Enemy {

    /**
     * Creates a SmallEnemy within a certain size, bounds, color, and
     * initializes speed.
     * 
     * @param panelWidth  Guideline to not go past this width.
     * @param panelHeight Guideline to not go past this height.
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        super((int) Math.random() * (panelWidth - 30),
                (int) Math.random() * (panelHeight - 30), 30, 30, 6.0);
        setColor();

    }

    /**
     * This overridden method randomly generates a color.
     */
    @Override
    public void setColor() {

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        this.setEnemyColor(randomColor);
    }

    /**
     * This overridden method utilizes the enemySpeed to change the x values.
     * And increases Small enemySpeed by 0.05.
     */
    @Override
    public void move(int frameWidth, int frameHeight) {
        if (getX() + (int) getEnemySpeed() > frameWidth
                || getX() + (int) getEnemySpeed() < 0) {
            setEnemySpeed(getEnemySpeed() * -1);
        }

        if (getEnemySpeed() > 0) {
            this.setEnemySpeed(getEnemySpeed() + Math.abs(0.05));
        } else {
            this.setEnemySpeed(getEnemySpeed() - Math.abs(0.05));
        }

        this.setBounds(getX() + (int) getEnemySpeed(), getY(), this.getWidth(),
                this.getHeight());

    }

    /**
     * This overridden method is called when a missile makes contact. Reduces
     * the enemy size, while getting rid of a Small enemy in enemyList.
     */
    @Override
    public void processCollision(ArrayList<Enemy> list, int smallEnemy) {
        int newWidth = getWidth() - 10;

        int newHeight = getHeight() - 10;

        if (newWidth <= 0 || newHeight <= 0) {
            list.remove(smallEnemy);
        } else {
            setSize(newWidth, newHeight);
        }

    }
}
