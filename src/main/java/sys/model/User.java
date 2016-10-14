package sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="user")
public class User implements Serializable{

    private static final long serialVersionUID = -5265040781149288583L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "userName")
    private String userName;

    @Column(name="userPassword")
    private String userPassword;

    @Column(name = "userNickName")
    private String userNickname;

    @Column(name = "userRealname")
    private String userRealname;

    @Column(name = "userAge")
    private Integer userAge;

    @Column(name = "userSex")
    private String userSex;

    @Column(name = "userAddress")
    private String userAddress;

    @Column(name = "userPhone")
    private String userPhone;

    @Column(name = "userEmail")
    private String usermail;
    @Column(name = "userqQQ")
    private String userqQQ;

    @Column(name = "regTime")
    private Date regTime;

    @Column(name = "lastLogintime")
    private Date lastLogintime;

    @Column(name = "status")
    private String status;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", usermail='" + usermail + '\'' +
                ", userqQQ='" + userqQQ + '\'' +
                ", regTime=" + regTime +
                ", lastLogintime=" + lastLogintime +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getUserqQQ() {
        return userqQQ;
    }

    public void setUserqQQ(String userqQQ) {
        this.userqQQ = userqQQ;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}