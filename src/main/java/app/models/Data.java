package app.models;


public class Data {
    private final String name;
    private final Double value;

    public Data(final String name, final Double value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
