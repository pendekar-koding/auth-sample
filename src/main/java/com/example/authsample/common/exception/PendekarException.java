package com.example.authsample.common.exception;

public class PendekarException extends Exception {
    private static final long serialVersionUID = 6270116931011412328L;

    private final ErrorCode errorCode;

    public PendekarException(ErrorCode code){
        super();
        this.errorCode = code;
    }

    public PendekarException(String message, Throwable cause, ErrorCode code){
        super(message, cause);
        this.errorCode = code;
    }

    public PendekarException(String message, ErrorCode code){
        super(message);
        this.errorCode = code;
    }

    public PendekarException(Throwable cause, ErrorCode code){
        super(cause);
        this.errorCode = code;
    }

    public ErrorCode getCode(){
        return this.errorCode;
    }
}
