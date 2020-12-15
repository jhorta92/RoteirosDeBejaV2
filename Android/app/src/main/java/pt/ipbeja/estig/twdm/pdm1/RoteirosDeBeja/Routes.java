package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Routes {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private String videoUrl;
    private String coordinate;
    private boolean fav;


    public Routes(long id, String name, String description, String imageUrl, String videoUrl, String coordinate, boolean fav) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
