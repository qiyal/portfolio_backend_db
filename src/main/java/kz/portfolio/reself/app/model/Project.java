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
    private String text;
    private int view;
    private String type;
    private Date date;
    private String urlImage;
    private String urlImageSlider;
    private String urlGithub;

    public String getUrlGithub() {
        return urlGithub;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getView() {
        return view;
    }

    public String getUrlImageSlider() {
        return urlImageSlider;
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
                ", text='" + text + '\'' +
                ", view=" + view +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", urlImage='" + urlImage + '\'' +
                ", urlImageSlider='" + urlImageSlider + '\'' +
                ", urlGithub='" + urlGithub + '\'' +
                '}';
    }
}
