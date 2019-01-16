/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author faisal-shakiba
 */
public class trainer_details {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public trainer_details(String id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
    private String name;
    private String email;
    private String mobile;
    private String education;
    private String expYear;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public trainer_details(String name, String email, String mobile, String education, String expYear) {
       
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.education = education;
        this.expYear = expYear;
    }
    public trainer_details() {
    }

    public trainer_details(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "trainer_details{" + "id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + '}';
    }

    
    
    
     
    
}
