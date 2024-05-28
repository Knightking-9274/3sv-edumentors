    package com.edumentors.backend.entities;

    import java.util.Set;

import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long userId;

        @Column(name="user_name" ,unique=true)
        private String emailId;

        @Column(name="first_name")
        private String fName;

        @Column(name="last_name")
        private String lName;

        @Column(name="location")
        private String city;

        private String password;

        @Column(name="contact")
        private String mobileNumber;
        @Column(length = 100)
        private String about;

        @OneToMany(mappedBy = "user")
        private Set<Review> reviews;

        @OneToMany(mappedBy = "user")
        private Set<Comment> comments;

        @OneToMany(mappedBy = "user")
        private Set<Enrollment> enrollments;
    }
