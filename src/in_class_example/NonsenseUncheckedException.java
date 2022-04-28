package in_class_example;

public class NonsenseUncheckedException extends RuntimeException {

    @Override
    public String toString() {
        return "don't check this!";
    }

}