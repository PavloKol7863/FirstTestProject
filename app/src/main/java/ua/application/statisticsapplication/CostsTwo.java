package ua.application.statisticsapplication;

import androidx.room.*;

@Entity()
public class CostsTwo {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private long area;

    private long summ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getSumm() {
        return summ;
    }

    public void setSumm(long summ) {
        this.summ = summ;
    }
}
