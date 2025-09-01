package com.jcode.userservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "store_id", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "store_id")
    private Set<Long> storeIds = new HashSet<>();

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String username;

    private String email;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "phone_number")
    private String phoneNumber;


}
