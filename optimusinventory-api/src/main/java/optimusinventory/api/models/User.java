package optimusinventory.api.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Acha Bill on 7/17/2017.
 */
public class User {
    @Id
    private String id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private List<Previleges> previleges;
    private String phoneNumber;
    private String email;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String id, String username, String password, List<Previleges> previleges, String phoneNumber, String email, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.previleges = previleges;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Previleges> getPrevileges() {
        return previleges;
    }

    public void setPrevileges(List<Previleges> previleges) {
        this.previleges = previleges;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}