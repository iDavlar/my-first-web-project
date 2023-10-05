package daniil.ardiukov.validators;

public interface Validator<T> {
    boolean validate(T object);
}
