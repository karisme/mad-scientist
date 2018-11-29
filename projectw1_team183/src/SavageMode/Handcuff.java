package SavageMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Handcuff extends GameSprite {
    public Handcuff(int x, int y, SpriteID id) {
        super(x, y, id);

        speedX = 5;
        speedY = 5;
    }

    @Override
    public void tick() {
        x = x + speedX;
        y = y + speedY;

        if (y <= 0 || y >= 850)  speedY = speedY * -1;
        if (x <= 0 || x >= 1420) speedX = speedX * -1;
    }

    @Override
    public void render(Graphics gh) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("cuffs.png"));
            gh.drawImage(img, x, y, (img1, infoflags, x, y, width, height) -> false);
        } catch (IOException e) {
            System.out.println("Sorry bro.");
        }
    }

    @Override
    public Rectangle getPlace() {
        return new Rectangle(x,y,40,47);
    }
}
