package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

/**
 * The computer game.
 */
public class Game {

    public static int level;
    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

  //  private int level;

    private Controller controller;
    private static SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new UserView(world, 1244, 700);

        view = new BackgroundImage(world, 1700,700);
        //plays background music for level 1
        { try {
            gameMusic = new SoundClip("data/Level1background.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }}


        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // this lets the game window to be resized
        frame.setResizable(true);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer(), world, this);
        frame.addKeyListener(controller);

        ControlPanel P = new ControlPanel(this);
        frame.add(P.mainPanel, BorderLayout.NORTH);



        world.start();


    }
    //GetterMethods

    public static SoundClip getgameMusic(){
        return gameMusic;
    }

    public Zombie getPlayer() {
        return world.getPlayer();
    }

    public void pause(){
        world.stop();
    }
    public void resume(){
        world.start();
    }




    /** Is the current level of the game finished? */
    //This method is used to re-load the level the player was in when the game was saved.
    public void goToLevel(GameLevel lev) {
        world.stop();
        level = lev.getLevelNumber();
        world = lev;
        controller.setBody(world.getPlayer());
        controller.setWorld(world);
        // show the new world in the view
        view.setWorld(world);
        //Replays the music for whichever level that was re-loaded.
        if (level == 3) {
            try {
                gameMusic.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level3background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
        }

        else if (level == 2) {
            try {
                gameMusic.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level2background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }

        }

        else if (level == 4) {

            try {
                gameMusic.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level4background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
        }
        else if (level == 1) {

            try {
                gameMusic.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level1background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
        }
        world.start();
    }


    //This is the method that goes into the next level once the level is completed.
    //In addition to changing the background music in each level

    public void goNextLevel() {
        world.stop();
        if (level == 4) {
            System.exit(0);
        }
        if(level == 3) {
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            // show the new world in the view
            view.setWorld(world);
            try {
                gameMusic.stop();
            }   catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level4background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
            world.start();
        }
        if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            // show the new world in the view
            view.setWorld(world);
            try {
                gameMusic.stop();
            }   catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level3background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
            world.start();

        }
        if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            // show the new world in the view
            view.setWorld(world);
            try {
                gameMusic.stop();
            }   catch (Exception e) {
                e.printStackTrace();
            }
            try {
                gameMusic = new SoundClip("data/Level2background.wav");
                gameMusic.loop();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
            world.start();
        }

    }

    public void save() {
        GameSaver ws = new GameSaver("data/scores.txt");
        try {
            ws.saveGame(world);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void load() {
        GameLoader sr = new GameLoader("data/scores.txt", this);
        try {
            GameLevel loadedGame = sr.loadGame();
            this.goToLevel(loadedGame);
        } catch (IOException ex){
            ex.getStackTrace();
        }
    }




    //A getter method for level
    public int getLevel() {
        return level;
    }



    public static void main(String[] args) {
        new Game();


    }
}
