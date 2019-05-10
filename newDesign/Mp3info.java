import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

class Mp3info{
   

private static String getDuration(File file) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof AudioFileFormat) {
        Map<String,Object> properties = ((AudioFileFormat) fileFormat).properties();
        String key = "duration";
        Long microseconds = (Long) properties.get(key);
        int mili = (int) (microseconds / 1000);
        int sec = (mili / 1000) % 60;
        int min = (mili / 1000) / 60;
        String time=( min + ":" + sec);
        return time;
    } else {
        throw new UnsupportedAudioFileException();
    }

}
private static String getArtist(File file) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof AudioFileFormat) {
        Map<String,Object> properties = ((AudioFileFormat) fileFormat).properties();
        String key = "author";
        String artist = (String) properties.get(key);
        return artist;
    } else {
        throw new UnsupportedAudioFileException();
    }

}
private static String getName(File file) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof AudioFileFormat) {
        Map<String,Object> properties = ((AudioFileFormat) fileFormat).properties();
        String key = "title";
        String name = (String) properties.get(key);
        return name;
    } else {
        throw new UnsupportedAudioFileException();
    }

}

}