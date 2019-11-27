package ua.org.training;

import java.util.ArrayList;
import javafx.util.Pair;

import static ua.org.training.GlobalConstants.*;

/**
 * Created by @kissik on 27 NOV 2019
 */
public class Model {
    private String name, middleName, lastName, nickName, comment, homePhone, cellularPhone, cellularPhoneTwo;
    private GroupName groupName;
    private void initModel(){
        cellularPhoneTwo = null;
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

    public String getGroupName() {return groupName.toString();}

    public void setGroupName(GlobalConstants.GroupName groupName) {
        this.groupName = groupName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellularPhone() {
        return cellularPhone;
    }

    public void setCellularPhone(String cellularPhone) {
        this.cellularPhone = cellularPhone;
    }

    public String getCellularPhoneTwo() {
        if (cellularPhoneTwo != null)
            return cellularPhoneTwo;
        return GlobalConstants.DEFAULT_STRING;
    }

    public void setCellularPhoneTwo(String cellularPhoneTwo) {
        this.cellularPhoneTwo = cellularPhoneTwo;
    }

    public String getFullName(){
        StringBuffer fullName = new StringBuffer(getLastName());
        fullName.append(" ").append(getName().substring(0,1)).append(".");
        return fullName.toString();
    }

    @Override
    public String toString(){
        StringBuffer form = new StringBuffer();
        appendViewModelField(form, VIEW_LAST_NAME, getLastName());
        appendViewModelField(form, VIEW_NAME, getName());
        appendViewModelField(form, VIEW_MIDDLE_NAME, getMiddleName());
        appendViewModelField(form, VIEW_NICK_NAME, getNickName());
        appendViewModelField(form, VIEW_COMMENT, getComment());
        appendViewModelField(form, VIEW_GROUP, getGroupName());
        appendViewModelField(form, VIEW_HOME_PHONE, getHomePhone());
        appendViewModelField(form, VIEW_CELLULAR_PHONE, getCellularPhone());
        appendViewModelField(form, VIEW_CELLULAR_PHONE_TWO, getCellularPhoneTwo());

        return form.toString();
    }

    private void appendViewModelField(StringBuffer form, String viewField, String field) {
        form.append(viewField)
                .append(BREAK_LINE + TAB_SYMBOLS)
                .append(field)
                .append(BREAK_LINE);
    }

}
