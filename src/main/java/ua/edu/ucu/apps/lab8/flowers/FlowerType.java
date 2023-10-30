package ua.edu.ucu.apps.lab8.flowers;

public enum FlowerType {
    CHAMOMILE("CHAMOMILE"),
    ROSE(""),
    TULIP("TULIP"),
    DAHLIA("DAHLIA"),
    IRIS("IRIS"),
    DAISY("DAISY"),
    LILAC("LILAC");
    private final String stringRepresentation;

    FlowerType(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
