package com.cheetal.jornadaCandidato.validation;

import com.cheetal.jornadaCandidato.dto.PessoaDTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaDTO> {

    @Override
    public void initialize(PessoaInsert ann) {
    }

    @Override
    public boolean isValid(PessoaDTO objDto, ConstraintValidatorContext context) {

//        List<FieldMessage> list = new ArrayList<>();
//
//        // inclua os testes aqui, inserindo erros na lista
//        for (FieldMessage e : list) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(e.getMessage())
//                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
//        }
//        return list.isEmpty();
        return false;
    }
}