package kr.co.ssalon.auth;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.ssalon.Controller.AuthController;
import kr.co.ssalon.dto.MemberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 API(/auth/signup) 테스트")
    @WithMockUser(username = "test")
    public void signup() throws Exception {
        // Given
        MemberDTO memberDTO = MemberDTO.builder()
                .email("test@example.com")
                .nickname("testNickname")
                .profilePictureUrl("https://example.com/profile.jpg")
                .gender('M')
                .address("Seoul, Korea")
                .role("USER")
                .blackReason("None")
                .joinDate(LocalDateTime.now())
                .lastLoginDate(LocalDateTime.now())
                .build();

        // When - Then
        mockMvc.perform(post("/auth/signup")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberDTO)))
                .andExpect(status().isOk());
    }
}