package com.qf.pojo;

import java.sql.Date;

/*
 * author:袁学港
 * Date:2019/7/10 9:48
 * info:
 * */
public class Leave {
    private Integer lid;
    private String username;
    private User user;
    private Date startdate;
    private Date enddate;
    private String reason;
    private Integer flag;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "lid=" + lid +
                ", user=" + user +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", reason='" + reason + '\'' +
                ", flag=" + flag +
                '}';
    }
}
