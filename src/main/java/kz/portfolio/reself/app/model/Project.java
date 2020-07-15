package kz.portfolio.reself.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String type;
    private Date date;
    private String urlImage;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
