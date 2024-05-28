package com.edumentors.backend.dto;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;

    // @NotBlank(message = "field cannot be blank!")
    // @Size(min = 2,max = 20,message = "characters range must be between 2-20!")
  
    private String fName;

    // @NotBlank(message = "field cannot be blank!")
    // @Size(min = 2,max = 20,message = "characters range must be between 2-20!")
    
    private String lName;

    // @NotBlank(message="provide city name!")
    private String city;

    // @Email(message="invalid email!")
    // @NotBlank(message = "field cannot be blank")
    private String email;

    // @Size(min = 8, message = "Password must be at least 8 characters long")
    // @NotBlank
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", 
    //          message = "Password must contain at least one digit, one uppercase letter, one lowercase letter, one special character, and no whitespace")
    private String password;
    
    
    // @NotBlank(message="Please enter mobile number")
    // @Pattern(regexp="^(?:\\+?91)?[789]\\d{9}$", message="Invalid mobile number")
    private String contact;

    
    // @NotBlank(message="please provide about details")
    @Size(min=5, max=50, message="About details must be between 5 and 50 characters")
    private String about;

    // @AssertTrue(message="You must accecpt terms and condition!")
    boolean terms;
}
