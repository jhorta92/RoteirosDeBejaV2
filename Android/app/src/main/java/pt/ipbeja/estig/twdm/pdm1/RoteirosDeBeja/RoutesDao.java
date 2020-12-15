package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoutesDao {

    @Query("SELECT * FROM Routes")
    List<Routes> getAll();

    @Query("SELECT * FROM Routes WHERE id = :routes")
    Routes getById(long routes);

    @Query("SELECT * FROM Routes ORDER BY Name ASC")
    List<Routes> getAllFromNewerToOlder();

    @Update
    void update(Routes routes);

    @Insert
    void add(Routes routes);

    @Insert
    void addAll(List<Routes> routes);

    @Delete
    void remove(Routes routes);
}
