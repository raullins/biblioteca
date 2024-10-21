package br.biblioteca.raul.controllerBiblioteca;

import br.biblioteca.raul.dtoBiblioteca.ChangePasswordRequestDTO;
import br.biblioteca.raul.dtoBiblioteca.FuncionarioLoginRequestDTO;
import br.biblioteca.raul.dtoBiblioteca.TokenResponseDTO;
import br.biblioteca.raul.securityBiblioteca.JwtUtilBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilBiblioteca jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public TokenResponseDTO createAuthenticationToken(@RequestBody FuncionarioLoginRequestDTO loginRequestDTO) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new TokenResponseDTO(token);

    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
        return "Senha alterada com sucesso";
    }
}