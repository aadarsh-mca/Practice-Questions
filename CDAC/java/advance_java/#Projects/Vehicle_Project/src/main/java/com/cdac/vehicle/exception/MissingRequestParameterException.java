package com.cdac.vehicle.exception;

import java.util.Arrays;

public class MissingRequestParameterException extends RuntimeException {

    public MissingRequestParameterException(String ... missingParamList) {
        super("One of the Request Parameter is missing : " + Arrays.toString(missingParamList));
    }
}
