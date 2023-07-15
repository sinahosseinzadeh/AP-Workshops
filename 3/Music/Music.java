public class Music {
    private String address;
    private String singerName;
    private String yearPublished;

    /**
     *
     * @param address the address of the music file
     * @param singerName the singer of music
     * @param yearPublished the year music was published
     */
    public Music(String address,String singerName,String yearPublished){
        this.address=address;
        this.singerName=singerName;
        this.yearPublished=yearPublished;
    }

    /**
     *
     * @return returns the address of music
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address takes the address and assign it to field variable
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return returns the singer name
     */
    public String getSingerName() {
        return singerName;
    }

    /**
     *
     * @param singerName takes the singer name and assign it to field variable
     */
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    /**
     *
     * @return returns the year music was published
     */
    public String getYearPublished() {
        return yearPublished;
    }

    /**
     *
     * @param yearPublished takes the year and assign it to yearPublished field variable
     */
    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * prints the music details
     */
    public void printMusic(){
        System.out.println("Address: "+address+" | Singer: "+singerName+" | Year published : "+yearPublished);
    }
}
