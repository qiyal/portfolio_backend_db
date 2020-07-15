package kz.portfolio.reself.app.model;

import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String yearStart;
    private String yearFinish;
    private String title;
    private String text;

    public Education(){}

    public int getId() {
        return id;
    }

    public String getYearStart() {
        return yearStart;
    }

    public String getYearFinish() {
        return yearFinish;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", yearStart='" + yearStart + '\'' +
                ", yearFinish='" + yearFinish + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
