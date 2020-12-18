package ua.application.statisticsapplication;

import androidx.room.*;


@Entity()
public class Income {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String dat;

    private String numLiter;

    private String summ;

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

    public String getNumLiter() {
        return numLiter;
    }

    public void setNumLiter(String numLiter) {
        this.numLiter = numLiter;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }
}
