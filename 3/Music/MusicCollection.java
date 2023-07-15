import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> musicList;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        musicList=new ArrayList<Music>();
        player=new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param fileName The name of music to be added.
     * @param singerName the name of singer to be added.
     * @param yearPublished the year music to be added was published.
     */
    public void addFile(String fileName,String singerName,String yearPublished)
    {
        musicList.add(new Music(fileName,singerName,yearPublished));
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return musicList.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)){
            musicList.get(index).printMusic();
        }else {
            System.out.println("index is not valid");
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        int index=0;
        for(Music selcetedMusic: musicList){
            System.out.print(index+"- ");
            selcetedMusic.printMusic();
            index++;
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)){
            musicList.remove(index);
        }else
            System.out.println("index is not valid");
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)){
            player.startPlaying(musicList.get(index).getAddress());
        }else
            System.out.println("index is not valid");
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * this method search the pattern in musics located in musicList and print
     * the specific music when it finds it
     * @param pattern the pattern to be searched in music address and singerName and published year
     */
    public void findMusic(String pattern){
        boolean found=false;
        for(Music tempMusic:musicList){
            if(tempMusic.getAddress().contains(pattern)||tempMusic.getSingerName().contains(pattern)
                    ||tempMusic.getYearPublished().contains(pattern)){
                tempMusic.printMusic();
                found=true;
                break;
            }
        }
        if (!found)
            System.out.println("Music not found");
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        return (index>=0 && index<getNumberOfFiles());
    }
}