package adapters;

public class News {
    private int image;
    private String title, category;
    private String date;
    private String khalid;

    public News(int image, String title, String category, String date) {
        this.image = image;
        this.title = title;
        this.category = category;
        this.date = date;
    }

    public News() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
