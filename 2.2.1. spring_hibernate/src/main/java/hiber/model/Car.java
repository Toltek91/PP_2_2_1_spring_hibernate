package hiber.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @Column
    private String model;
    @Column
    private int series;
    @OneToOne (mappedBy = "users")
    private User user;


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && series == car.series && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (series != -1 ? series * 15 - 29 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
