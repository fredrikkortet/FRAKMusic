import java.io.File;
import java.io.File;
import jaco.mp3.player.MP3Player;
import java.util.Queue;

public class PlayerMethod {

	
    /**
     * Next song to be played
     */
    public void nextToPlay() {
    	addedList.remove();
    	addedList.play();
    }
    /**
     * Queue a song 
     * @param song; the song to be queued
     */
    public void queueSong(File song) {
    	addedList.add(song);
    }
}
