package com.deepak.spring.LearningRestAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AddStudentRequestDto {

        public String getEmail() {
            return email;
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

        public AddStudentRequestDto(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public AddStudentRequestDto() {
        }

    @Override
    public String toString() {
        return "AddStudentRequestDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

        @Email
        @NotBlank(message = "Email is Required")
        private String email;
        private String name;




    }


