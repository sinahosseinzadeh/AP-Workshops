/*
@author sina hz
this is the program to show the students full information

 */
public class Students {
    private String firstName;
    private String secondName;
    private int id;
    private int grade;
    /*
        @param fName tell us the first name
        @param sName tell us the second name
        @param idCard tell us their id
        @param level tell us which grade their in
     */
    public Students(String fName,String sName,int idCard,int level)
    {
        this.firstName=fName;
        this.secondName=sName;
        this.id=idCard;
        this.grade=level;

    }
    // @return firstName field
    public String getFName()
    {
        return firstName;
    }
    //return secondName field
    public String getSName()
    {
        return secondName;

    }
    // @return id field
    public int getId()
    {
        return id;
    }
    // @return grade field
    public int getGrade()
    {
        return grade;
    }
    // @param firstName this is the new name
    public void setFName(String fname)
    {
        this.firstName=fname;
    }
    // @param secondName this is the changed last name
    public void setSName(String sname)
    {
        this.secondName=sname;

    }
    // @param id this is the new id
    public void setId(int idCard)
    {
        this.id=idCard;
    }
    // @param grade this is the new grade
    public void setGrade(int grade)
    {
        this.grade=grade;
    }
    public void Print()
    {
        System.out.println("id card :"+id);
        System.out.println("name : "+firstName +" "+secondName+" grade :"+grade);
    }
}
