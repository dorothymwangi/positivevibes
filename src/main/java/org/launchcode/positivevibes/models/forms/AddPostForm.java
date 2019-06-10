package org.launchcode.positivevibes.models.forms;

import org.launchcode.positivevibes.models.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AddPostForm {

    @NotNull
    private int postId;

    @NotNull
    private Date createDate;

    private String entry;

    private User user;

    public AddPostForm(){}

    public int getPostId() {return postId;}

    public void setPostId(int postId) {this.postId = postId;}

    public Date getCreateDate() {return createDate;}

    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public String getEntry() {return entry;}

    public void setEntry(String entry) {this.entry = entry;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
