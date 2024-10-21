package br.biblioteca.raul.configBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Funcionario;
import br.biblioteca.raul.repositoryBiblioteca.FuncionarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminFuncionarioSeeder {

    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminFuncionarioSeeder(FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder) {
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void seedAdminFuncionario() {
        if (funcionarioRepository.findByUsername("admin") == null) {
            Funcionario admin = new Funcionario();
            admin.setNome("Administrador");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setCargo("Gerente");
            admin.setEmail("admin@biblioteca.com");
            funcionarioRepository.save(admin);
        }
    }
}