package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Point {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long id_route;
    private String name;
    private String description;
    private List<String> images;
    private String coordinate;
    private boolean Vist;


    public Point(long id, long id_route, String name, String description, List<String> images, String coordinate, boolean vist) {
        this.id = id;
        this.id = id_route;
        this.name = name;
        this.description = description;
        this.images = images;
        this.coordinate = coordinate;
        this.Vist = vist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_route() {
        return id;
    }

    public void setId_route(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() { return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCoordinate() { return coordinate; }

    public void setCoordinate(String coordinate) { this.coordinate = coordinate; }

    public boolean isVist() { return Vist; }

    public void setVist(boolean vist) { this.Vist = vist; }
}
