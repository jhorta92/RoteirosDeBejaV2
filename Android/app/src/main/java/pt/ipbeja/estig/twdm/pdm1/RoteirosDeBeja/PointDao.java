package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PointDao {
    @Query("SELECT * FROM Point")
    List<Point> getAll();

    @Query("SELECT * FROM Point WHERE id ")
    Point getById(long point);

    @Query("SELECT * FROM Point ORDER BY Name ASC")
    List<Point> getAllFromNewerToOlder();

    @Update
    void update(Point point);

    @Insert
    void add(Point point);

    @Insert
    void addAll(List<Point> point);

    @Delete
    void remove(Point point);

}
