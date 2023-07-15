import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        MusicCollection pop=new MusicCollection();
        MusicCollection jaz=new MusicCollection();
        MusicCollection rock=new MusicCollection();
        MusicCollection country=new MusicCollection();
        MusicCollection favorite=new MusicCollection();
        Scanner input=new Scanner(System.in);
        country.addFile("c:/music1.mp3","johnny cash","idk when");
        country.addFile("c:/music2","johnny folan","2000");
        pop.addFile("c:/music3","selena","2010");
        pop.addFile("c:/music4","selena","2013");
        jaz.addFile("c:/music5.mp3","whiplash-Soundtrack","2016");
        jaz.addFile("c:/JazzThingy.mp3","whiplash","2016");
        rock.addFile("c:/RockFromPeaky1.mp3","PeakyBlinders-SoundTrack","since 2014");
        rock.addFile("c:/RockFromPeaky2.mp3","PeakyBlinders-SoundTrack","since 2015");
        //Testing MusicCollection methods -------------------------------
        country.listAllFiles();
        System.out.println("which one do you wish to play ? : ");
        //input.nextLine();
        int choosenMusic=input.nextInt();
        input.nextLine();
        country.startPlaying(choosenMusic);
        System.out.println("press sth to stop playing.");
        input.nextLine();
        country.stopPlaying();
        //right now we remove first music of the pop list
        pop.listAllFiles();
        System.out.println("which one u wish to remove ? : ");
        choosenMusic=input.nextInt();
        pop.removeFile(choosenMusic);
        pop.listAllFiles();
        //we want to search  "Jazz" in jaz list
        jaz.findMusic("Jazz");
        //now we want to list specific file from rock category
        rock.listFile(1);
        //below one will print an error ...it index is invalid
        rock.listFile(2);
















    }
}
