package com.example.algo_0.labb3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class upp7 {

    public static class User{
        private final int id;
        private final String userName;
        private String displayName;
        private String password;

        private ArrayList<Bolg> blogs;

        public User(int id, String userName, String displayName, String password) {
            this.id = id;
            this.userName = userName;
            setDisplayName(displayName.toUpperCase());
            setPassword(password);

            this.blogs = new ArrayList<Bolg>();
        }

        public int getId(){
            return id;
        }

        public String getUserName(){
            return userName;
        }

        public String getDisplayName(){
            return displayName;
        }

        public void setDisplayName(String newDName){
            this.displayName = newDName.toUpperCase();
        }

        public void setPassword(String newPW){
            this.password = newPW;
        }

        private boolean isCorrectPassword(String password){
            return this.password.equals(password);
        }

        @Override
        public String toString(){
            return id + " " + userName + " " + displayName;
        }
    }

    public static class Bolg{
        private String title;
        private String massage;
        private Date date;
        private User user;

        public Bolg(String title, String massage, Date date, User user) {
            this.title = title;
            this.massage = massage;
            this.date = date;
            this.user = user;
        }
    }

    public static void main(String[] args) {
        User user = new User(10, "Ahmad", "addee", "1234567");
        System.out.println(user);
    }
}
