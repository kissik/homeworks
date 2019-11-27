package ua.org.training;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 * Created by @kissik on 27 NOV 2019
 */
public class Model {
    private String name, middleName, lastName, nickName, comment;

    private void initModel(){
    }

    public Model(){
        initModel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName(){
        StringBuffer fullName = new StringBuffer(getLastName());
        fullName.append(" ").append(getName().substring(0,1)).append(".");
        return fullName.toString();
    }
}
