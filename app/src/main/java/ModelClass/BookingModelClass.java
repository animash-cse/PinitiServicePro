package ModelClass;


public class BookingModelClass {

    String accpt;
    String title;
    String description;
    String action;
    String rate;
    String feedback;
    int image;


    public BookingModelClass(String title) {
        this.title = title;
    }
    public BookingModelClass(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public BookingModelClass(String accpt,String title,String action, String rate, String feedback, int image) {
        this.accpt = accpt;
        this.title = title;
        this.action = action;
        this.rate = rate;
        this.feedback = feedback;
        this.image = image;
    }

    public String getAccpt() {
        return accpt;
    }

    public void setAccpt(String accpt) {
        this.accpt = accpt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
