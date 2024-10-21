package br.biblioteca.raul.validationBiblioteca;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CargoValidator.class)
@Documented
public @interface CargoValido {
    String message() default "Cargo inválido. Os cargos permitidos são: Gerente, Atendente, Bibliotecário.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}