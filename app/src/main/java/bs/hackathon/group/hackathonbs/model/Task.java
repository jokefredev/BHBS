package bs.hackathon.group.hackathonbs.model;

/**
 * Created by anveena on 09.11.17.
 */

public class Task {

    public String title = "";
    public String content = "";
    public String date = "";
    public String time = "";
    public String location = "";

    public Task(String title, String content, String date, String time, String location) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.location = location;
    }
}
