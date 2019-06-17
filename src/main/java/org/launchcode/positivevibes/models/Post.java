package org.launchcode.positivevibes.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int id;


    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    //@CreationTimestamp
    private Date createDate;

    @Column(name = "entry", columnDefinition = "TEXT")
    private String entry;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //private int userId;

   // private List<Post> posts = new ArrayList<>();


    public Post(){}

    public Post(Date createDate, String entry){ this.entry = entry;this.createDate = createDate;}


    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

   public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   //public List<Post> getPosts() { return posts; }

}
