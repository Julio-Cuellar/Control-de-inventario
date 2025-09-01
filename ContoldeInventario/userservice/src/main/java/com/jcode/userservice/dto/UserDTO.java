package com.jcode.userservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String userName;
    private String phoneNumber;
    private boolean enabled;
    private Set<Long> StoreIds;

}
