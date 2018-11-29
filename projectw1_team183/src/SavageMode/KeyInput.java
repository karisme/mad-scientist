package SavageMode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
     private Handler handle;  //self explanatory



    public KeyInput(Handler handler) {
        this.handle = handler;
    }


    /**
     * Invoked when a key has been pressed.
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(GameSprite obj : handle.listOfObjects) {
            if(obj.getId() == SpriteID.Player) {
                if(key == KeyEvent.VK_W) obj.setSpeedY(-10);
                if(key == KeyEvent.VK_S) obj.setSpeedY(10);
                if(key == KeyEvent.VK_A) obj.setSpeedX(-10);
                if(key == KeyEvent.VK_D) obj.setSpeedX(10);
                // all the sauce movement we want our player  to have
            }
        }

        if(key==KeyEvent.VK_ESCAPE) {System.exit(0);}
    }

    /**
     * Invoked when a key has been released.
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(GameSprite obj : handle.listOfObjects) {
            if (obj.getId() == SpriteID.Player) {
                if (key == KeyEvent.VK_W) obj.setSpeedY(0);
                if (key == KeyEvent.VK_S) obj.setSpeedY(0);
                if (key == KeyEvent.VK_A) obj.setSpeedX(0);
                if (key == KeyEvent.VK_D) obj.setSpeedX(0);
                // all the stop sauce sauce
            }

        }
    }
}

