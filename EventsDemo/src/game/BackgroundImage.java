package game;

import city.cs.engine.UserView;
import city.cs.engine.World;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class BackgroundImage extends UserView {

    private GameLevel world;
    private BufferedImage bg1;
    private BufferedImage bg2;
    private BufferedImage bg3;
    private BufferedImage bg4;


    //This class changes the background image when the level changes.
    BackgroundImage(GameLevel w, int width, int height) {
        super(w, width, height);
        this.world = w;
        try {
            //storing the background image of each level in here
            bg1 = ImageIO.read(new File("data/background1.jpg"));
            bg2 = ImageIO.read(new File("data/background2.png"));
            bg3 = ImageIO.read(new File("data/background3.png"));
            bg4 = ImageIO.read(new File("data/background4.png"));
        } catch (IOException ex){
    }}


    protected void paintBackground(Graphics2D g){
        super.paintBackground(g);
        if (Game.level == 1) {
            g.drawImage(bg1, 0, 0, this);
        } else if (Game.level == 2) {
            g.drawImage(bg2, 0, 0, this);
        } else if (Game.level == 3) {
            g.drawImage(bg3, 0, 0, this);
        } else if (Game.level == 4) {
            g.drawImage(bg4, 0, 0, this);


    }}
    protected void paintForeground(Graphics2D g){

    }
}

