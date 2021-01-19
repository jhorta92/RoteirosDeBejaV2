package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Routes.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RoutesDao getRoutesDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "RoteirosDeBejaDB")
                    .allowMainThreadQueries() // do not use in PRODUCTION!!
                    .build();
        }
        return INSTANCE;
    }
}
