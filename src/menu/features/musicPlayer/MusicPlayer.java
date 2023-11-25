package menu.features.musicPlayer;

import entity.Song;
import services.observer.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MusicPlayer extends JFrame implements ActionListener, Observer {
    private JTextField filePathField;
    private JButton playButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton randomButton;
    private JButton loopButton;
    private List<Song> songList;
    private boolean isPaused;
    private boolean isContinued;
    private boolean isUpdate;
    private boolean isLooping;
    private boolean isRandom;
    private Clip currentClip;
    private int current;
    private static MusicPlayer instance;

    private int next;
    private int previous;

    public static MusicPlayer getInstance() {
        if (instance == null) instance = new MusicPlayer();
        return instance;
    }

    private MusicPlayer() {
        super("Music Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        filePathField = new JTextField(15);
        previousButton = new JButton("<");
        playButton = new JButton("Play");
        nextButton = new JButton(">");
        randomButton = new JButton("Random");
        loopButton = new JButton("Loop");

        previousButton.addActionListener(this);
        playButton.addActionListener(this);
        nextButton.addActionListener(this);
        randomButton.addActionListener(this);
        loopButton.addActionListener(this);

        add(filePathField);
        add(previousButton);
        add(playButton);
        add(nextButton);
        add(randomButton);
        add(loopButton);

        setSize(220, 150);
        setLocationRelativeTo(null);
        setVisible(true);

        songList = new ArrayList<>();
        isPaused = true;
        isUpdate = false;
        isLooping = false;
        current = 0;
        isRandom = false;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == playButton) {
            playMusic();
        } else if (event.getSource() == previousButton) {
            previousMusic();
        } else if (event.getSource() == nextButton) {
            nextMusic();
        } else if (event.getSource() == randomButton) {
            setRandom();
        } else if (event.getSource() == loopButton) {
            setLoop();
        }
    }

    public List<Song> getSongList() {
        return songList;
    }

//    public void setSongList(Song song) {
//        songList = new ArrayList<>();
//        songList.add(song);
//    }

    public void playMusic() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
            isPaused = true;
            playButton.setText("Resume");
        } else if (currentClip != null && isPaused) {
            currentClip.start();
            isPaused = false;
            playButton.setText("Pause");
        } else {
            try {
                isContinued = true;
                playClip(current);
//                playPlaylist(event);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void stopMusic() {
        isContinued = false;
        currentClip.stop();
    }

    private void playClip(int number) {
        try {
            current = number;
            File file = new File(songList.get(current).getMusicPath());
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);


            currentClip = AudioSystem.getClip();
            currentClip.open(audioIn);

            filePathField.setText(songList.get(current).getName() + " - " + songList.get(current).getArtist());

            if (isLooping) currentClip.loop(Clip.LOOP_CONTINUOUSLY);

            currentClip.start();
            isPaused = false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    private synchronized void playPlaylist() {
//        for (int i = 0; i < songList.size(); ) {
//            if (currentClip == null || !currentClip.isRunning()) {
//                playClip(i);
//            }
//            if (!isContinued) {
//                break;
//            }
//        }
//    }

    private void playPlaylist(ActionEvent event) throws InterruptedException {
        for (int i = 0; i < songList.size(); ) {
            playClip(i);
            long count = 0;
            long currentClipInLength = currentClip.getMicrosecondLength();
            long currentClipInLengthInSeconds = TimeUnit.SECONDS.convert(currentClipInLength, TimeUnit.MICROSECONDS);

            System.out.println("Debug here");
            System.out.println("count 1: " + count);
            System.out.println("length 1: " + currentClipInLengthInSeconds);

            System.out.println("position 1: " + TimeUnit.SECONDS.convert(currentClip.getMicrosecondPosition(), TimeUnit.MICROSECONDS));
            System.out.println("length != position 1: " + (currentClipInLengthInSeconds != TimeUnit.SECONDS.convert(currentClip.getMicrosecondPosition(), TimeUnit.MICROSECONDS)));

            while (currentClipInLengthInSeconds != count) {
                System.out.println("Debug here2");

                count++;
//                System.out.println("count 2: " + count);
//                System.out.println("length 2: " + currentClipInLengthInSeconds);
//                System.out.println("position 2: " + TimeUnit.SECONDS.convert(currentClip.getMicrosecondPosition(), TimeUnit.MICROSECONDS));
//
//                System.out.println(count == currentClipInLengthInSeconds);
//                System.out.println("length != position 1: " + (currentClipInLengthInSeconds != TimeUnit.SECONDS.convert(currentClip.getMicrosecondPosition(), TimeUnit.MICROSECONDS)));
//
//                if (currentClipInLengthInSeconds == TimeUnit.SECONDS.convert(currentClip.getMicrosecondPosition(), TimeUnit.MICROSECONDS)){
//                    System.out.println("Done");
//                    count = 0;
//                    break;
//                }
//
//                if (event.getSource() == stopButton) {
//                    System.out.println("Done");
//                    stopMusic();
//                }
            };
//            currentClip.stop();
            i++;
        }
    }

    private void previousMusic() {
        if (!isRandom) {
            if (songList.size() > 1 && current == 0) {
                previous = songList.size() - 1;
            } else if (songList.size() == 1) {
                previous = 0;
            } else {
                previous = current - 1;
            }
        } else {
            previous = (int) Math.floor(Math.random() * (songList.size() - 1));
        }

        if (currentClip != null) {
            try {
                stopMusic();
                playClip(previous);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                playClip(0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void nextMusic() {
        if (!isRandom) {
            if ((songList.size() > 1 && current == songList.size() - 1) || songList.size() == 1) {
                next = 0;
            } else {
                next = current + 1;
            }
        } else {
            next = (int) Math.floor(Math.random() * (songList.size() - 1));
        }

        if (currentClip != null) {
            try {
                stopMusic();
                playClip(next);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                playClip(0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public Clip getCurrentClip() {
        return currentClip;
    }

    private void setRandom() {
        if (isRandom) {
            isRandom = false;
            randomButton.setText("Random");
        } else {
            isRandom = true;
            randomButton.setText("Stop Random");
        }
    }

    private void setLoop() {
        if (isLooping) {
            isLooping = false;
            loopButton.setText("Loop");
        } else {
            isLooping = true;
            loopButton.setText("Stop Looping");
        }
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public void setCurrent(int number) {
        current = number;
    }

    public void setUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    @Override
    public void update() {
    }
}
