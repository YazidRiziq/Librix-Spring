package com.example.librix_spring.dto.Member;

public class PostMemberDTO {
    
    private String name;
    private String email;
    private String telp;
    private String address;
    private String password;

    public PostMemberDTO(String name, String email, String telp, String address, String password) {
        this.name = name;
        this.email = email;
        this.telp = telp;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelp() {
        return telp;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

}
