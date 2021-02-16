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
    private long routes_id;
    @Ignore
    private String name;
    @Ignore
    private String description;
    @Ignore
    private List<String> images;
    @Ignore
    private String coordinate;
    private String videoUrl;

    public Point() {}

    @Ignore
    public Point(long id, long routes_id, String name, String description, List<String> images, String coordinate, String videoUrl) {
        this.id = id;
        this.routes_id = routes_id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.coordinate = coordinate;
        this.videoUrl = videoUrl;
    }

    public long getId() {
        return id;
    }

    public long getRoutes_id() {
        return routes_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
