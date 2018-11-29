package SavageMode;
import ui.BankStart;


import java.awt.*;
import java.awt.image.BufferStrategy;


public class BankSafe extends Canvas implements Runnable {
    private final int width = 1470;
    private final int height = 950;
    private Thread thread;      //Single threaded game, path the program takes (APPARENTLY NOT RECOMMENDED)
    private boolean state;      //HELPS program know when it is running or not (self-awareness), not explained i assume
    private Handler handler;
    private HUD hud;
    private EnemyGenerator generator;

    /*
     * very much inspired by: https://www.youtube.com/watch?v=1gir2R7G9ws&t=45s but with noticeable difference
     * used video more as a guide or foundation, but essentially my program is like a DLC of his.
     * ALSO USED ELEMENTS OF: https://www.youtube.com/watch?v=RcvABhflOkI AND ALSO THANK YOU TAs FOR HELP
     */


    // https://stackoverflow.com/questions/14353302/displaying-image-in-java variation of this

    public BankSafe() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));      //canvas instead of JFrame

        new Window(width,height,"Rob The Bank!",this);
        handler.addObject(new Player(200,200,SpriteID.Player,handler));
        hud = new HUD();
        generator = new EnemyGenerator(handler,hud);

        // RIPPPPPPP

    }

    public static void initializeRobbery(){
        String[] args = BankStart.getArgs();
        main(args);
    }


//STARTS THREAD
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        state = true;
    }

    public synchronized void end() {
       try {
           thread.join();    //ends thread
           state = false;
       } catch(Exception a) {
           a.printStackTrace();
       }
    }


    //PRETTY MUCH IDENTICAL GAME LOOP TO MANY GAMES, POPULAR< USED IN MANY GAMES
    @Override
    public void run() {
        this.requestFocus();                       // screen time
        long lastTime = System.nanoTime();
        double tickAmount = 60.0;
        double ns = 1000000000 / tickAmount;
        double epsilon = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(state) {
            long now = System.nanoTime();
            epsilon += (now - lastTime) / ns;
            lastTime = now;

            while (epsilon>=1) {
                tick();
                epsilon--;
            }

            if(state)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        end();
    }


    public static void main(String[] args) {
       new BankSafe();
    }

    private void tick() {
        handler.tick();
        hud.tick();
        generator.tick();
    }

    private void render() {
        BufferStrategy bb = this.getBufferStrategy();
        if (bb == null){
            this.createBufferStrategy(3);   //
            return;
        }

        Graphics g = bb.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,width,height);   //graphics for window (IE BACKGROUND COLOR)

        handler.render(g);
        hud.render(g);
        g.dispose();
        bb.show();

    }
}


