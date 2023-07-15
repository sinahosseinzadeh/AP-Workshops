//package HospitalSystem;

/**
 * This is a Illness
 */
public class Illness
{
    private String name;
    private String security;

    /**
     * Create a new Illness
     */
    public Illness(String name,String security)
    {
        this.name = name;
        this.security = security;
    }

    /**
     * @return security
     */
    public String getSecurity() {
        return security;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name is Illness Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param security is Illness Security
     */
    public void setSecurity(String security) {
        this.security = security;
    }

}
