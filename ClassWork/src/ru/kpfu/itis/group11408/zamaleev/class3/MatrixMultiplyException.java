package ru.kpfu.itis.group11408.zamaleev.class3;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by ������ on 26.04.2015.
 */
public class MatrixMultiplyException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }

    public MatrixMultiplyException() {
        super();
    }

    public MatrixMultiplyException(String message) {
        super(message);
    }

    public MatrixMultiplyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixMultiplyException(Throwable cause) {
        super(cause);
    }

    protected MatrixMultiplyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
