package pt.ipbeja.estig.twdm.roteirosdebeja;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Route.class,Point.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RoutesDao getRoutesDao();
    public abstract PointDao getPointDao();

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
