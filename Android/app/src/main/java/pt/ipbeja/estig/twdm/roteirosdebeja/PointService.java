package pt.ipbeja.estig.twdm.roteirosdebeja;

//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointService {

//    @Query("SELECT * FROM Point WHERE id =:id")
//    Point getById(long id);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void add(Point point);

    @GET("route/{id}/Points")
    Call<BaseResponse<List<Point>>> getPoints();

    @GET("route/{id}/Points/{id}")
    Call<BaseResponse<Route>> getPointById(@Path("id") long id);
}
