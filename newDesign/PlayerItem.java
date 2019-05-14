//import java.io.File;
import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class PlayerItem {
	private String name;
	private String artist;
	private String filename;
	private String time;
	
	public PlayerItem(File file) {
		filename = file.getName();
		String[] getSongorAuthor = {"0","0"};
		getSongorAuthor = filename.split("[-.]");
		artist = getSongorAuthor[0];
		name = getSongorAuthor[1];
		time = getDuration(file);

	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public String getFilename() {
		return filename;
	}

	public String getTime() {
		return time;
	}
	
    public int compareName(String other) {
    	return name.compareTo(other);
    }

	public int compareArtist(String other) {
		return artist.compareTo(other);
	}
	    
	public int compareFilename(String other) {
		return filename.compareTo(other);
	}
	    
	/*public int compareTime(int other) {
		if(time > other) {
			return 1;
		}
		else if(time < other) {
			return -1;
		}
		else {
			return 0;
		}
	}*/
	private static String getDuration(File file){
		try{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long frames = audioInputStream.getFrameLength();
		double durationInSeconds = (frames+0.0) / format.getFrameRate(); 
		int durationInSeconds2 = (int)durationInSeconds;
		String sec = durationInSeconds2/60 +":"+(int)durationInSeconds%60;
		
		return sec; 
		}catch(UnsupportedAudioFileException e){
			 e.fillInStackTrace();
			 return null;
		}catch(IOException e){
			 e.fillInStackTrace();
			 return null;
		}
	
	}
	
	
}

