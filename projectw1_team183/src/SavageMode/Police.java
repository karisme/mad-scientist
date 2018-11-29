package SavageMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Police extends GameSprite {

    public Police(int x, int y, SpriteID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics gh) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("guard.jpg"));
            gh.drawImage(img, x, y, (img1, infoflags, x, y, width, height) -> false);
        } catch (IOException e) {
            System.out.println("Sorry bro.");
        }
    }


    @Override
    public Rectangle getPlace() {
        return null;
    }
}
