package kr.co.ssalon.Controller;

import kr.co.ssalon.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signup(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok("signup");
    }
}
