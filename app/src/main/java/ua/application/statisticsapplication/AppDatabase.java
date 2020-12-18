package ua.application.statisticsapplication;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Income.class, CostsOne.class, CostsTwo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract IncomeDao incomeDao();

    public abstract CostsOneDao costsOneDao();

    public abstract CostsTwoDao costsTwoDao();
}
