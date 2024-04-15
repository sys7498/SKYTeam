package kr.co.ssalon.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String email;
    private String nickname;
    private String profilePictureUrl;
    private Character gender;
    private String address;
    private String role;
    private String blackReason;
    private LocalDateTime joinDate;
    private LocalDateTime lastLoginDate;
}