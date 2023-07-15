package ceit.model;

import java.io.Serializable;

// TODO: Phase2: uncomment this code
public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    /**
     * constructs a note
     * @param title the title of the note
     * @param content the content of the note
     * @param date the date that note created
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     *
     * @return the title of the note
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return the creation-date of the note
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @return the content of the note
     */
    public String getContent() {
        return content;
    }

    /**
     * creates a string representing the note
     * @return the note in string
     */
    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

