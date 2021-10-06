package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JPanel pnlControls;
    private JButton quitButton;
    public JPanel mainPanel;
    private JButton pauseButton;
    private JButton resumeButton;
    private JLabel lblVolume;
    private JSlider sldVolume;
    private JButton btnMute;
    private JButton savebtn;
    private JButton loadbtn;
    private Game game;

    public ControlPanel(Game game) {
        this.game = game;
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.pause();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.resume();
            }
        });
        /*restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.restart();
            }
        });*/
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
