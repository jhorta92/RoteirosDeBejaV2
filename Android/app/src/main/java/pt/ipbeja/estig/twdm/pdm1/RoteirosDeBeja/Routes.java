package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Routes {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private List<String> images;
    private String videoUrl;
    private String coordinate;
    private boolean fav;


    public Routes(long id, String name, String description, List<String> imageUrl, String videoUrl, String coordinate, boolean fav) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.videoUrl = videoUrl;
        this.coordinate = coordinate;
        this.fav = fav;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoordinate() { return coordinate; }

    public void setCoordinate(String coordinate) { this.coordinate = coordinate; }

    public boolean isFav() { return fav; }

    public void setFav(boolean fav) { this.fav = fav; }
}
