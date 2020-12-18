package ua.application.statisticsapplication;

import androidx.room.*;

@Entity()
public class CostsOne {
    @PrimaryKey(autoGenerate = true)
    public long id;

    private String dat;

    private long summ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public long getSumm() {
        return summ;
    }

    public void setSumm(long summ) {
        this.summ = summ;
    }
}
