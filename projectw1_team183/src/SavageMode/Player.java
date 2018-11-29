package SavageMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends GameSprite {
    Handler handler;

    public Player(int x, int y, SpriteID id, Handler handle) {
        super(x, y, id);
        this.handler = handle;

    }

    @Override
    public void tick() {
        x = x + speedX;
        y = y + speedY;

        if (y < 0) {
            setY(0);
        } else if(y > 810) {
            setY(810);
        } else if (x < 0) {
            setX(0);
        } else if (x > 1370) {
            setX(1370);
        }

        checkContact();
    }

    private void checkContact() {
        for(GameSprite enem: handler.listOfObjects) {
            if(SpriteID.Handcuff == enem.getId()) {
                if (getPlace().intersects(enem.getPlace())) {
                    HUD.LUCK = HUD.LUCK - 2;
                }
            } else if(SpriteID.PrisonCell == enem.getId()) {
                if(getPlace().intersects(enem.getPlace())) {
                    HUD.LUCK = HUD.LUCK - 50;
                }
            }
        }
    }

    @Override
    public void render(Graphics gh) {
      //  gh.setColor(Color.WHITE);
     //   gh.fillRect(x,y,96,96);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("thief.png"));
            gh.drawImage(img, x, y, (img1, infoflags, x, y, width, height) -> false);
        } catch (IOException e) {
            System.out.println("Sorry bro.");
        }

    }

    @Override
    public Rectangle getPlace() {
        return new Rectangle(x,y,84,84);
    }
}
