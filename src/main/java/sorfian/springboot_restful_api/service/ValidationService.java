package sorfian.springboot_restful_api.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sorfian.springboot_restful_api.model.RegisterUserRequest;

import java.util.Set;

@Service
public class ValidationService {
    @Autowired
    private Validator validator;

    public void validate(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw  new ConstraintViolationException(constraintViolations);
        }
    }
}
