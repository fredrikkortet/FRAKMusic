
public class PlayerItem {
	private String name;
	private String artist;
	private String filename;
	private int time;
	
	public PlayerItem(String theName, String theArtist, String theFilename, int theTime) {
		name = theName;
		artist = theArtist;
		filename = theFilename;
		time = theTime;
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
