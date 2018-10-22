package dh.com.digitalhouseapp.model;

public class Colearn {

    private String name;
    private String job;
    private String days;
    private String hours;
    private String imageUrl;

    public Colearn(String name, String job, String days, String hours, String imageUrl) {
        this.name = name;
        this.job = job;
        this.days = days;
        this.hours = hours;
        this.imageUrl = imageUrl;
    }

    public Colearn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
