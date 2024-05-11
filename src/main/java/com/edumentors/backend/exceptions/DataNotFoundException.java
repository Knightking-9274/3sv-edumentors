package com.edumentors.backend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataNotFoundException extends RuntimeException {
    String dataName;
    String fieldName;
    long fieldValue;

    public DataNotFoundException(String dataName, String fieldName, long fieldValue){
        super(String.format("%s not found with %s : %l",dataName,fieldName,fieldValue));
        this.dataName = dataName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
