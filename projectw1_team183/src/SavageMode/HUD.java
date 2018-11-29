package SavageMode;

import java.awt.*;

public class HUD {
    private int amountStolen = 0;
    private int security = 0;

    public static int LUCK = 100;

    public void tick() {
        amountStolen++;
    }


    public void render(Graphics gh){
        gh.setColor(Color.BLACK);
        gh.fillRect(30,30,300,50);

        gh.setColor(Color.GREEN);
        gh.fillRect(30,30,LUCK*3,50);

        gh.setColor(Color.lightGray);
        gh.drawRect(30,30,300,50);

        gh.drawString("Money Stolen: $" + amountStolen,1200,58);
        gh.drawString("Security Level: " + security,1200,68);

    }

    public int getAmountStolen() {
        return amountStolen;
    }

    public void setAmountStolen(int amountStolen) {
        this.amountStolen = amountStolen;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }
}
