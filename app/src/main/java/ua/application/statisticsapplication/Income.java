package ua.application.statisticsapplication;

import androidx.room.*;


@Entity()
public class Income {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String dat;

    private long numLiter;

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

    public long getNumLiter() {
        return numLiter;
    }

    public void setNumLiter(long numLiter) {
        this.numLiter = numLiter;
    }

    public long getSumm() {
        return summ;
    }

    public void setSumm(long summ) {
        this.summ = summ;
    }
}
