package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PointDao {

    @Query("SELECT * FROM Point WHERE id =:id")
    Point getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Point point);
}
