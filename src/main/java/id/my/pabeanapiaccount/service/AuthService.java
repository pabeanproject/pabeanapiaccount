package id.my.pabeanapiaccount.service;

import id.my.pabeanapiaccount.dto.AuthenticationRequest;
import id.my.pabeanapiaccount.dto.AuthenticationResponse;
import id.my.pabeanapiaccount.dto.RegisterRequest;

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    AuthenticationResponse register(RegisterRequest request);
}
