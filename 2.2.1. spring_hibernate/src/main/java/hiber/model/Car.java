package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private int series;

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setId(long id) { this.id = id; }

    public void setModel(String model) { this.model = model; }

    public void setSeries(int series) { this.series = series; }

    public long getId() { return id; }

    public String getModel() { return model; }

    public int getSeries() { return series; }
}
