package demo7;

public class Cup {
    private String cupName;
    private int cupSize;

    public Cup() {
    }

    public Cup(String cupName, int cupSize) {
        this.cupName = cupName;
        this.cupSize = cupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cup cup = (Cup) o;

        if (cupSize != cup.cupSize) return false;
        return cupName != null ? cupName.equals(cup.cupName) : cup.cupName == null;
    }

    @Override
    public int hashCode() {
        int result = cupName != null ? cupName.hashCode() : 0;
        result = 31 * result + cupSize;
        return result;
    }
}
