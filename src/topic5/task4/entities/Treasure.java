package topic5.task4.entities;

import topic5.task4.enums.TypesOfTreasures;

import java.util.Objects;

public class Treasure {
    private TypesOfTreasures name;
    private double cost;
    private int quantity;

    public Treasure(TypesOfTreasures name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Treasure(TypesOfTreasures name, double cost) {
        this.name = name;
        this.cost = cost;
        this.quantity = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return Double.compare(treasure.cost, cost) == 0 &&
                name.equals(treasure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return "name='" + name.toString() + '\'' +
                ", cost=" + cost +
                (quantity > 1 ? ", quantity=" + quantity : "") +
                '\n';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypesOfTreasures getName() {
        return name;
    }

    public void setName(TypesOfTreasures name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
