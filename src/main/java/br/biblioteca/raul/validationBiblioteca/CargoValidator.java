package br.biblioteca.raul.validationBiblioteca;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CargoValidator implements ConstraintValidator<CargoValido, String> {

    //Definindo os cargos válidos para a aplicação
    private final List<String> cargosValidos = Arrays.asList("Gerente", "Atendente", "Bibliotecário");

    @Override
    public boolean isValid(String cargo, ConstraintValidatorContext context) {
        //Verifica se o cargo está na lista de cargos válidos
        return cargosValidos.contains(cargo);
    }
}