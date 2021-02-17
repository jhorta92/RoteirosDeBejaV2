package pt.ipbeja.estig.twdm.roteirosdebeja;

//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointService {

//    @Query("SELECT * FROM Point WHERE id =:id")
//    Point getById(long id);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void add(Point point);

    @GET("points/{id}")
    Call<BaseResponse<Point>> getPointById(@Path("id") long id);
}
