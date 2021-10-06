package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioControls {
    private JPanel pnlControls;
    private JLabel lblVolume;
    private JSlider sldVolume;
    private JButton btnMute;
    private Game game;
    private JButton savebtn;
    private JButton loadbtn;
    //This creates a GUI for the audio which includes changing the volume and muting, unmuting the volume.

    public AudioControls(Game game) {
        this.game = game;
        btnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getgameMusic().setVolume(0.0001);
                sldVolume.setValue(1);
            }
        });

        sldVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float volume = scale(sldVolume.getValue(), 1, 10, 0.0001f, 2);
                Game.getgameMusic().setVolume(volume);
                System.out.println(volume);
            }
        });
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.save();


            }
        });
        loadbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.load();


            }
        });
    }

    private float scale(float value, float minInput, float maxInput, float minRange, float maxRange)    {
        return ((maxRange - minRange)*(value - minInput) / (maxInput - minInput)) + minRange;
    }


    public JPanel getPnlControls() {
        return pnlControls;
    }
}
