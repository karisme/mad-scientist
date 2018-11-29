package SavageMode;
//advanced observer nd that

import java.awt.*;
import java.util.ArrayList;


public class Handler {
    ArrayList<GameSprite> listOfObjects = new ArrayList<>();

    public void tick() {
        for (GameSprite obj : listOfObjects) {
            obj.tick();
        }
    }

    public void render(Graphics g) {
        for (GameSprite obj : listOfObjects) {
            obj.render(g);
        }
    }

    public void addObject(GameSprite obj) {
        listOfObjects.add(obj);
    }

    public void removeObject(GameSprite obj) {
        listOfObjects.remove(obj);
    }
}
