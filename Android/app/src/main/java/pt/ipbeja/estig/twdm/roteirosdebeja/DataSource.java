package pt.ipbeja.estig.twdm.roteirosdebeja;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class DataSource serve como repositório de dados (Base de Dados) em memória
 */
public class DataSource {

    // Utilizamos a Lista de rotas "routes" como "tabela" de rotas
    private static List<Route> routes;

    // método que permite obter todos os itens da lista
    public static List<Route> getAll() {
        // Caso a lista não esteja inicializada, devemos inicializar e preencher
        if (routes == null) {
            routes = new ArrayList<>();
        }
        return routes;
    }

    public static void update(int position, Route route) {
        getAll().set(position, route);
    }

    public static Route getByPosition(int position) {
        return getAll().get(position);
    }


    public static void add(Route route) {
        if (DataSource.routes == null) {
            DataSource.routes = new ArrayList<>();
        }
        long newId = 1;
        if (DataSource.routes.size() > 0) {
            Route lastOne = DataSource.routes.get(DataSource.routes.size() - 1);
            newId = lastOne.getId() + 1;
        }
        route.setId(newId);
        DataSource.routes.add(route);
    }

    public static void remove(int position) {
        if (routes != null && routes.size() > position) {
            routes.remove(position);
        }
    }

    public static void remove(Route route) {
        if (DataSource.routes != null) {
            DataSource.routes.remove(route);
        }
    }
}

