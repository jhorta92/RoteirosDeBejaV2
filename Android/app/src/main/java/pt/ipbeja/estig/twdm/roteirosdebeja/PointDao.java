package pt.ipbeja.estig.twdm.roteirosdebeja;

//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointDao {

//    @Query("SELECT * FROM Point WHERE id =:id")
//    Point getById(long id);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void add(Point point);

    @GET("routes")
    Call<List<Point>> getPoint();

    @GET("routes/{id}")
    Call<Point> getPointDetails(@Path("id") long id);
}
