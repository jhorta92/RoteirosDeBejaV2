package pt.ipbeja.estig.twdm.roteirosdebeja;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A Class DataSource serve como repositório de dados (Base de Dados) em memória
 */
public class RoutesDataSource {

    private static final String baseEndpointb = "https://my-json-server.typicode.com/carlossancho-pt/planets/";
    private static final String baseEndpoint  = "http://127.0.0.1:8000/api/routes";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseEndpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static RoutesService routesService;

    public static RoutesService getRoutesService() {
        if (routesService == null) {
            routesService = retrofit.create(RoutesService.class);
        }
        return routesService;
    }

    /* public static void update(int position, Route route) {
        getAll().set(position, route);
    }

    public static Route getByPosition(int position) {
        return getAll().get(position);
    }


    public static void add(Route route) {
        if (RoutesDataSource.routes == null) {
            RoutesDataSource.routes = new ArrayList<>();
        }
        long newId = 1;
        if (RoutesDataSource.routes.size() > 0) {
            Route lastOne = RoutesDataSource.routes.get(RoutesDataSource.routes.size() - 1);
            newId = lastOne.getId() + 1;
        }
        route.setId(newId);
        RoutesDataSource.routes.add(route);
    }

    public static void remove(int position) {
        if (routes != null && routes.size() > position) {
            routes.remove(position);
        }
    }

    public static void remove(Route route) {
        if (RoutesDataSource.routes != null) {
            RoutesDataSource.routes.remove(route);
        }*/
}

   /* public static void update(int position, Route route) {
        getAll().set(position, route);
    }

    public static Route getByPosition(int position) {
        return getAll().get(position);
    }


    public static void add(Route route) {
        if (RoutesDataSource.routes == null) {
            RoutesDataSource.routes = new ArrayList<>();
        }
        long newId = 1;
        if (RoutesDataSource.routes.size() > 0) {
            Route lastOne = RoutesDataSource.routes.get(RoutesDataSource.routes.size() - 1);
            newId = lastOne.getId() + 1;
        }
        route.setId(newId);
        RoutesDataSource.routes.add(route);
    }

    public static void remove(int position) {
        if (routes != null && routes.size() > position) {
            routes.remove(position);
        }
    }

    public static void remove(Route route) {
        if (RoutesDataSource.routes != null) {
            RoutesDataSource.routes.remove(route);
        }*/
   // }
//}

