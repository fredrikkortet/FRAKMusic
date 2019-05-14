import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class PlayButtons{
    Long currentFrame; 
    Clip clip; 
    String status; 
    ArrayQueue<PlayerItem> songlist = new ArrayQueue();  
    AudioInputStream audioInputStream; 
    static String filePath = "/home/fredrik/FRAKMusic/Music";

PlayButtons()throws UnsupportedAudioFileException,IOException, LineUnavailableException
{  
    { 
        adding(new File(filePath));
        audioInputStream =  
                AudioSystem.getAudioInputStream(new File("/home/fredrik/FRAKMusic/Music/"+songlist.dequeue().getFilename())); 
        
        // create clip reference 
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    } 
}   
public void play()throws LineUnavailableException,IOException{
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
public void next()throws UnsupportedAudioFileException,IOException, LineUnavailableException{
    clip.stop();
    clip.close();
    PlayerItem remove = songlist.dequeue();
    audioInputStream =  
    AudioSystem.getAudioInputStream(new File("/home/fredrik/FRAKMusic/Music/"+remove.getFilename()).getAbsoluteFile()); 
    clip.open(audioInputStream);
    clip.start();

}
public void add(PlayerItem next){
    songlist.enqueue(next);
}
public void adding(final File source) {
                final File[] listOfFiles = source.listFiles();

                for (File file : listOfFiles) {
                        if (file.isDirectory()) {
                                adding(file);
                        } else {
                                
                                PlayerItem musicItem = new PlayerItem(file);
                                songlist.enqueue(musicItem);
                                

                        }
                }
        }
}