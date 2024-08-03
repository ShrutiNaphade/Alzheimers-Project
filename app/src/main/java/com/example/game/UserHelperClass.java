package com.example.game;

class UserHelperClass {
    String userid,username,email,date,total,percent;
    public UserHelperClass() {
    }

    public UserHelperClass(String userid, String username, String email, String date, String total, String percent) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.date = date;
        this.total = total;
        this.percent = percent;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
