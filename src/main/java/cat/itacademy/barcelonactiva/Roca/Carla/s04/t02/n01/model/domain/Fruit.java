package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="Fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name="name", nullable = false, length = 50)
    private String name;

    @Column (name ="quantity", nullable = false, length = 4)
    private int kgs;

    public Fruit(int id, String name, int kgs) {
        this.id = id;
        this.name = name;
        this.kgs = kgs;
    }

    public Fruit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKgs() {
        return kgs;
    }

    public void setKgs(int kgs) {
        this.kgs = kgs;
    }

    @Override
    public String toString() {
        return "Fruit-> Id: " + this.id + ", Name: " + this.name + ", " + this.kgs + " Kgs";
    }
}
