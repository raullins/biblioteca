// CustomUserDetailsService.java
package br.biblioteca.raul.securityBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Funcionario;
import br.biblioteca.raul.repositoryBiblioteca.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomFuncionarioDetailsService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Funcionario funcionario = funcionarioRepository.findByUsername(username);
        if (funcionario == null) {
            throw new UsernameNotFoundException("Funcionario não encontrado");
        }
        return new org.springframework.security.core.userdetails.User(funcionario.getUsername(), funcionario.getPassword(), new ArrayList<>());
    }
}