package com.mcenterprise.tipt.models;


import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ShiptMate {


    @Id
    @GeneratedValue
    private int id;


    @NotBlank(message = "Please provide a username!")
    @Size(min = 5, max= 15, message = "Username must be between 5 and 15 characters!")
    private String username;

    @Email(message = "Invalid email!")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 6, message = "Password must be at least 6 characters!")
    private String password;
    @NotNull(message= "Passwords Do Not Match!")
    private String verifyPassword;



    public ShiptMate() {

    }

    public ShiptMate(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
        checkPassword();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword(){
        if((getPassword() != null) && (getVerifyPassword() != null) && (getPassword() != getVerifyPassword())) {
            verifyPassword = null;
        }

    }
}


