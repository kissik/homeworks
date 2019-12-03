package ua.org.training.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.util.Pair;
import ua.org.training.GlobalConstants;

import static ua.org.training.GlobalConstants.*;

/**
 * Created by @kissik on 27 NOV 2019
 */
public class Model {
    private String name;
    private String middleName;
    private String lastName;
    private String nickName;
    private String comment;
    private String homePhone;
    private String cellularPhone;
    private String cellularPhoneTwo;
    private String email;
    private Group group;

    public String getCreateDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(createDate);
    }

    public String getUpdateDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(updateDate);
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    private Date createDate;
    private Date updateDate;

    private Address address;
    private ArrayList<Pair<String, String>> map;

    public void setViewName(String viewName) {
        map.add(new Pair("name",viewName));
    }
    public void setViewMiddleName(String viewMiddleName) {
        map.add(new Pair("middleName",viewMiddleName));
    }
    public void setViewLastName(String viewLastName) {
        map.add(new Pair("lastName",viewLastName));
    }
    public void setViewNickName(String viewNickName) {
        map.add(new Pair("nickName",viewNickName));
    }
    public void setViewComment(String viewComment) {
        map.add(new Pair("comment",viewComment));
    }
    public void setViewHomePhone(String viewHomePhone) {
        map.add(new Pair("homePhone",viewHomePhone));
    }
    public void setViewCellularPhone(String viewCellularPhone) {
        map.add(new Pair("cellularPhone",viewCellularPhone));
    }
    public void setViewCellularPhoneTwo(String viewCellularPhoneTwo) {
        map.add(new Pair("cellularPhoneTwo",viewCellularPhoneTwo));
    }
    public void setViewEmail(String viewEmail){ map.add(new Pair("email",viewEmail)); }
    public void setViewGroup(String viewGroup){ map.add(new Pair("group",viewGroup)); }
    public void setViewAddress(String viewAddress) {
        map.add(new Pair("address",viewAddress));
    }
    public void setViewCreateDate(String viewCreateDate) {
        map.add(new Pair("createDate",viewCreateDate));
    }
    public void setViewUpdateDate(String viewUpdateDate) {
        map.add(new Pair("updateDate",viewUpdateDate));
    }

    private void initModel(){
        map = new ArrayList<>();
        cellularPhoneTwo = null;
        createDate = new Date();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getGroup() {return group.toString();}

    public void setGroup(Group group) {
        this.group = group;
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getFullName(){
        StringBuffer fullName = new StringBuffer(getLastName());
        fullName.append(" ").append(getName().substring(0,1)).append(".");
        return fullName.toString();
    }

    @Override
    public String toString(){
        StringBuffer form = new StringBuffer(BUFFER_SIZE);
        appendViewModelField(form, getViewString("lastName"), getLastName());
        appendViewModelField(form, getViewString("name"), getName());
        appendViewModelField(form, getViewString("middleName"), getMiddleName());
        appendViewModelField(form, getViewString("nickName"), getNickName());
        appendViewModelField(form, getViewString("comment"), getComment());
        appendViewModelField(form, getViewString("group"), getGroup());
        appendViewModelField(form, getViewString("homePhone"), getHomePhone());
        appendViewModelField(form, getViewString("cellularPhone"), getCellularPhone());
        appendViewModelField(form, getViewString("cellularPhoneTwo"), getCellularPhoneTwo());
        appendViewModelField(form, getViewString("email"), getEmail());
        appendViewModelField(form, getViewString("address"), getAddress().toString());
        appendViewModelField(form, getViewString("createDate"), getCreateDate());
        appendViewModelField(form, getViewString("updateDate"), getUpdateDate());
        return form.toString();
    }
    String getViewString(String key){
        for(Pair<String, String> pair : map){
            if (pair.getKey()==key) return pair.getValue();
        }
        return DEFAULT_STRING;
    }

    private void appendViewModelField(StringBuffer form, String viewField, String field) {
        form.append(viewField)
                .append(BREAK_LINE + TAB_SYMBOLS)
                .append(field)
                .append(BREAK_LINE);
    }

}
