package ua.application.statisticsapplication;
import androidx.room.*;

import java.util.List;
@Dao
public interface CostsOneDao {
    @Query("SELECT * FROM costsone")
    List<CostsOne> getAll();

    @Insert
    void insert(CostsOne costsOne);
}
