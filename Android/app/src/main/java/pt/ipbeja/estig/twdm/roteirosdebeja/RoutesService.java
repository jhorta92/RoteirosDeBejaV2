package pt.ipbeja.estig.twdm.roteirosdebeja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoutesService {


    @GET("route")
    Call<BaseResponse<List<Route>>> getRoutes();

    @GET("route/{id}")
    Call<BaseResponse<Route>> getRouteById(@Path("id")long id);

    @GET("route/{id}/points")
    Call<BaseResponse<List<Point>>> getPointsByRoute(@Path("id")long routeId);
}
