import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private int xPosition;
    private int yPosition;
    private int xSpeed;
    private int ySpeed;
    private int diameter;
    private Color color;
    private final Rectangle bounds; 
    private Canvas canvas;
    
    

    

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos, int yPos, int xSpeed, int ySpeed, int ballDiameter, Color ballColor, 
                    Rectangle boundRectangle, Canvas drawCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos; 
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        diameter = ballDiameter; 
        color = ballColor;
        bounds = boundRectangle;
        canvas = drawCanvas; 
    }
    
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    public void move()
    {
        erase();
        
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        if(xPosition >= (bounds.getMaxX() - diameter) && xSpeed > 0){
            xPosition = (int)(bounds.getMaxX() - diameter);
            xSpeed = -xSpeed; 
            if(xSpeed > 0)
                 xSpeed = 0;
        }
        else if(xPosition <= (bounds.getMinX()) && xSpeed < 0) {
            xPosition = (int)(bounds.getMinX());
            xSpeed = -xSpeed;
             if(xSpeed < 0)
                 xSpeed = 0;
        }
        else if(yPosition >= (bounds.getMaxY() - diameter) && ySpeed > 0) {
            yPosition = (int)(bounds.getMaxY() - diameter);
             ySpeed = -ySpeed; 
             if(ySpeed > 0)
               ySpeed = 0;
        }
         else if(yPosition <= (bounds.getMinY()) && ySpeed < 0) {
             yPosition = (int)(bounds.getMinY());
             ySpeed = -ySpeed; 
             if(ySpeed < 0)
                 ySpeed = 0;
        }
        
        draw();
        
    }
    
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
}
