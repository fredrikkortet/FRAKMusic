import java.io.File;
import java.io.IOException;

import jaco.mp3.player.MP3Player;

import java.util.Map;
import java.util.Queue;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayerMethod {
    /**
     * Next song to be played with buttonpress
     */
    public void next() {
        playlist.remove();
        playlist.play();
    }
    /**
     * Queue a song
     * @param song; the song to be queued
     */
    public void queueSong(File song) {
        playlist.add(song);
    }
}
