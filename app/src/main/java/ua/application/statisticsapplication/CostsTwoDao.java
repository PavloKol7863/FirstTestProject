package ua.application.statisticsapplication;
import androidx.room.*;

import java.util.List;
@Dao
public interface CostsTwoDao {
    @Query("SELECT * FROM coststwo")
    List<CostsTwo> getAll();

    @Insert
    void insert(CostsTwo costsTwo);
}
