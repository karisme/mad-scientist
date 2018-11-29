package SavageMode;

import java.awt.*;

public abstract class GameSprite {
    protected int x;
    protected int y;
    protected SpriteID id;
    protected int speedX;
    protected int speedY;

    public GameSprite(int x, int y, SpriteID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics gh);
    public abstract Rectangle getPlace();      // library, intersects umbai;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public SpriteID getId() {
        return id;
    }

    public void setId(SpriteID id) {
        this.id = id;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
