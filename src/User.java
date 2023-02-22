import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password;
    private String email;
    public int age;

    public User(String name, String password, int age){
        this.name=name;
        this.password=password;
        this.email=email;
        this.age=age;
    }

    public String toString(){
        return "("+name+", "+password+", "+email+", "+age+")";
    }
}
