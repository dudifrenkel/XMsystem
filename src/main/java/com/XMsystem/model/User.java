//package com.XMsystem.Model;
//
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
//import javax.persistence.*;
//
//@Entity
//public class User extends AbstractPersistable<Long> {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    Long userId;
//    String userName;
//    String password;
//
//    public User() { }
//
//    public User(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    public Long getId() {
//        return userId;
//    }
//
//    public void setId(Long id) {
//        this.userId = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//}
