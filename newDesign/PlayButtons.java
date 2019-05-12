import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class PlayButtons{
    Long currentFrame; 
    Clip clip; 
    String status; 
    ArrayQueue<PlayerItem> songlist;  
    AudioInputStream audioInputStream; 
    static String filePath; 

PlayButtons(ArrayQueue playlist)throws UnsupportedAudioFileException,IOException, LineUnavailableException
{  
    { 
        songlist = playlist;
        PlayerItem remove = songlist.dequeue();
        // create AudioInputStream object 
        audioInputStream =  
                AudioSystem.getAudioInputStream(new File("/home/fredrik/FRAKMusic/Music/"+remove.getFilename()).getAbsoluteFile()); 
        
        // create clip reference 
        clip = AudioSystem.getClip(); 
        
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
        
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
}   
public void play(){
clip.start();
status ="play";
}
public void pause(){
    if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
}
public void stop(){
    currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
}
public void next(){
    clip.stop();
    PlayerItem remove = songlist.dequeue();
    audioInputStream =  
    AudioSystem.getAudioInputStream(new File("/home/fredrik/FRAKMusic/Music/"+remove.getFilename()).getAbsoluteFile()); 
    clip.play();

}
public void add(){
    songlist.enqueue();
}
    
}