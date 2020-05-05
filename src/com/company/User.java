package com.company;

public class User {
   private Integer id;
   private String name;
   private String login;
   private String password;
   private String bodyType;

   public User() {
   }

   public User(String bodyType) {
      this.bodyType = bodyType;
   }

   public User(String login, String password) {
      this.login = login;
      this.password = password;
   }

   public User(Integer id, String name, String login, String password, String bodyType) {
      this.id = id;
      this.name = name;
      this.login = login;
      this.password = password;
      this.bodyType = bodyType;
   }

   public Integer getId() {
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getBodyType() {
      return bodyType;
   }

   public void setBodyType(String bodyType) {
      this.bodyType = bodyType;
   }

   public void setName(String name) {
      this.name = name;
   }


}
