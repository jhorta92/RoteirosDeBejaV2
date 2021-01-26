package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RoutesDao {
    @Query("SELECT * FROM Route WHERE id = :id")
    Route getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Route route);
}
