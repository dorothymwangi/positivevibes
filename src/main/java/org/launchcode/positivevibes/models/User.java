package org.launchcode.positivevibes.models;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @NotNull
    @Size(min = 3, max = 20, message = "Name must contain at least 3 characters and not exceed 20 characters")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20, message = "Name must contain at least 3 characters and not exceed 20 characters")
    private String lastName;

    @NotNull
    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Pattern(regexp = "(\\S){6,20}", message = "Password must have 6-20 non-whitespace characters")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Post> userPosts = new ArrayList<>();

   /* public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void addEntry(Post entry){
        posts.add(entry);
    }*/

    public User(){}

    public int getId() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    /*public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }*/
}




