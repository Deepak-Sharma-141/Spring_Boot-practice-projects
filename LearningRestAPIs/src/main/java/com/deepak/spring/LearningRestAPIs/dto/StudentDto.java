package com.deepak.spring.LearningRestAPIs.dto;

public class StudentDto {
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StudentDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public StudentDto() {
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private Long id;
    private String email;
    private String name;




}
