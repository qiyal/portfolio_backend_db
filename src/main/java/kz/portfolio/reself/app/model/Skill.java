package kz.portfolio.reself.app.model;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int percentage;

    public Skill(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
