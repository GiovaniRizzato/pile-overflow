package br.com.giovanirizzato.treeelo.controller.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giovanirizzato.treeelo.config.security.TokenProvider;
import br.com.giovanirizzato.treeelo.model.security.User;
import br.com.giovanirizzato.treeelo.model.security.User.JwtDto;
import br.com.giovanirizzato.treeelo.model.security.User.SignInDto;
import br.com.giovanirizzato.treeelo.model.security.User.SignUpDto;
import br.com.giovanirizzato.treeelo.service.security.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private AuthService service;
  @Autowired
  private TokenProvider tokenService;

  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
    try {
      service.signUp(data);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch(IllegalStateException signUpError) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var authUser = authenticationManager.authenticate(usernamePassword);
    var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
    return ResponseEntity.ok(new JwtDto(accessToken));
  }
}
