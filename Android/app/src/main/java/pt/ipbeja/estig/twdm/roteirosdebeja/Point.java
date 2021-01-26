package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Point {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @Ignore
    private long id_route;
    @Ignore
    private String name;
    @Ignore
    private String description;
    @Ignore
    private List<String> images;
    @Ignore
    private String coordinate;
    private boolean isSeen;

    public Point() {}

    @Ignore
    public Point(long id, long id_route, String name, String description, List<String> images, String coordinate, boolean isSeen) {
        this.id = id;
        this.id = id_route;
        this.name = name;
        this.description = description;
        this.images = images;
        this.coordinate = coordinate;
        this.isSeen = isSeen;
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

    public boolean isSeen() { return this.isSeen; }

    public void setSeen(boolean isSeen) { this.isSeen = isSeen; }
}
