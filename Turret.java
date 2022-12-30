import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

//Creates Turret Class
public class Turret extends JComponent {

    // instance variables for turret
    private static final long serialVersionUID = -2695243249178626614L;
    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;

    /**
     * Default constructor for instance variables.
     */
    public Turret() {
        this.base = new Rectangle(330, 350, 20, 60);
        this.turret = new Rectangle(300, 375, 80, 50);
        this.turretColor = Color.GREEN;

    }

    // Allows turret to move left and right
    public void left() {
        if (base.x - 10 <= 0) {

        } else {

            this.base.setBounds(base.x - 10, base.y, base.width, base.height);

            this.turret.setBounds(turret.x - 10, turret.y, turret.width,
                    turret.height);
        }

    }

    public void right(int panelWidth) {
        if (base.x + 10 >= panelWidth) {
            
        } else {

            this.base.x = base.x + 10;
             
            System.out.println(panelWidth);

            this.turret.setBounds(turret.x + 10, turret.y, turret.width,
                    turret.height);
        }
    }

    /**
     * Draws and colors in the turret base and turret.
     */
    public void paintComponent(Graphics g) {
        g.setColor(turretColor);
        g.fillRect(turret.x, turret.y, turret.width, turret.height);
        g.fillRect(base.x, base.y, base.width, base.height);

    }
    
    public int getTurretX() {
        return this.turret.x;
    }

}
