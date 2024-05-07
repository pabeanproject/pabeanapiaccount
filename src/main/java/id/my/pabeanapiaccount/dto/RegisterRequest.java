package id.my.pabeanapiaccount.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;

    private String role;

    private String userName;

    private String address;

    private String phoneNumber;

    private String about;



}
