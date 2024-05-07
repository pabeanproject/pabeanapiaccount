package id.my.pabeanapiaccount.controller;

import id.my.pabeanapiaccount.dto.AuthenticationRequest;
import id.my.pabeanapiaccount.dto.AuthenticationResponse;
import id.my.pabeanapiaccount.dto.RegisterRequest;
import id.my.pabeanapiaccount.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody AuthenticationRequest request
    ) {
        logger.info("masuk ke login controller dengan email: " + request.getEmail());
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ) {
        logger.info("masuk ke register controller dengan email: " + request.getEmail());
        return ResponseEntity.ok(authService.register(request));
    }


}
