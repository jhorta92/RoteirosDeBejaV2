package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.room.Entity;

@Entity
public class Event {

    private long id;
    private String name;
    private String images;
    private String description;
    private String videoUrl;
    //private boolean fav;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

 /*   public List<String> getImages() {
      return image;
   }

    public void setImages(List<String> images) {
       this.image = images;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {

        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }