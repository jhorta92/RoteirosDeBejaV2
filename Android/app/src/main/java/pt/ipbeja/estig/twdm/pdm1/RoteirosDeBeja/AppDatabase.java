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
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            db.execSQL("Insert into Routes VALUES (1, \"Rota do Castelo\", \"O Castelo de Beja, nomeadamente a sua Torre de Menagem, é o monumento mais conhecido e emblemático da cidade.A rota do castelo é uma visita completa ao castelo de beja\", \"castelo\", null, null,0)");
                            db.execSQL("Insert into Routes VALUES (2, \"Rota das Adegas\", \"Sugerimos uma visita às adegas do concelho, onde pode provar, ficar a saber mais sobre os modos de produção, as castas, as adegas e até participar nas actividades\", \"adega\", null, null,0)");
                            db.execSQL("Insert into Routes VALUES (3, \"Rota das Igrejas\", \"A rota das igrejas é uma visita que pretende proporcionar, a oportunidade de ver as varias igrejas de beja \", \"santo\", null, null,0)");
                            db.execSQL("Insert into Routes VALUES (4, \"Rota dos Museus\", \"A rota dos museus oferece um desconto na entrada de todos os museus, uma vez que o objectivo é visitar é saber mais sobre a cidade de beja\", \"museu\", null, null,0)");
                            db.execSQL("Insert into Routes VALUES (5, \"Rota  romana\", \" Na rota romana os visitantes tem a oportunidade de visitar, as ruínas arquivologia de pisoes e ainda em Março poderão visitar a feira romana anual\", \"romana\", null, null,0)");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
