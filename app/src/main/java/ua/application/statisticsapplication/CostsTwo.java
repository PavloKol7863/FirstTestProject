package ua.application.statisticsapplication;

import androidx.room.*;

@Entity()
public class CostsTwo {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String area;

    private String summ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }
}
