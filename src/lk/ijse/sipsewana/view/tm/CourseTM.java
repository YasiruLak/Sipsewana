package lk.ijse.sipsewana.view.tm;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/27/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class CourseTM {
    private String id;
    private String name;
    private String duration;
    private double fee;

    public CourseTM() {
    }

    public CourseTM(String id, String name, String duration, double fee) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
