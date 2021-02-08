package pt.ipbeja.estig.twdm.roteirosdebeja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoutesService {

    //@GET("planets")
    @GET("routes")
    Call<List<Route>> getRoutes();

    @GET("routes")
    Call<Route> getRouteById(@Path("id")long id);

    @GET("routesDetails/{id}")
    Call<Route> getRouteDetails(@Path("id") long id);

}
