package ua.application.statisticsapplication;
import androidx.room.*;

import java.util.List;

@Dao
public interface IncomeDao {

    @Query("SELECT * FROM income")
    List<Income> getAll();

    @Insert
    void insert(Income income);
}
