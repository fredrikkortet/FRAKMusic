import java.io.File;

public class PlayerItem {
	private String name;
	private String artist;
	private String filename;
	private String time;
	private Mp3info DJ;
	
	public PlayerItem(File file) {
		name = DJ.getName(file);
		artist = DJ.getArtist(file);
		filename = file.getName();
		time = DJ.getDuration(file);
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

	public int getTime() {
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
	    
	public int compareTime(int other) {
		if(time > other) {
			return 1;
		}
		else if(time < other) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
