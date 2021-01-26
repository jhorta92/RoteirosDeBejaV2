package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Route {
    @PrimaryKey()
    private long id;
    @Ignore
    private String name;
    @Ignore
    private String description;
    @Ignore
    private List<String> images;
    @Ignore
    private String videoUrl;
    private boolean fav;

    public Route() {

    }

    @Ignore
    public Route(long id, String name, String description, List<String> imageUrl, String videoUrl, boolean fav) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.videoUrl = videoUrl;
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

    public boolean isFav() { return fav; }

    public void setFav(boolean fav) { this.fav = fav; }
}