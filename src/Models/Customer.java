package Models;

/**
 *
 * @author work
 */
public class Customer 
{
    private int id;
    private String name;
    private String lastname;
    
    public Customer(){}
    
    public Customer(int id, String name, String lastname)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public String getname()
    {
        return name;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
        
    public void setId(int id)
    {
        this.id = id;
    }
}
