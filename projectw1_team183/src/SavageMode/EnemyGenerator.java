package SavageMode;

import java.util.Random;

public class EnemyGenerator {
    private Handler handler;
    private HUD hud;
    private int stolenTracker = 0;
    private int securityTracker = 0;

    private int spawnFreq = 500;
    private Random rand = new Random();

    public EnemyGenerator(Handler handle, HUD disp) {
        this.handler = handle;
        this.hud = disp;

    }

    public void tick(){
        stolenTracker++;

        if(stolenTracker >= spawnFreq) {
            securityTracker++;
            stolenTracker = 0;
            hud.setSecurity(hud.getSecurity() + 1);

            handler.addObject(new Handcuff(rand.nextInt(1470),rand.nextInt(950),SpriteID.Handcuff));
        }
        if(securityTracker >= 7) {
            handler.addObject(new PrisonCell(500,500,SpriteID.PrisonCell));
            securityTracker = 0;
        }
    }

}
