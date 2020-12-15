package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class DataSource serve como repositório de dados (Base de Dados) em memória
 */
public class DataSource {

    // Utilizamos a Lista de CarManufacturer "carManufacturers" como "tabela" de CarManufacturer
    private static List<Routes> routes;

    // método que permite obter todos os itens da lista
    public static List<Routes> getAll() {
        // Caso a lista não esteja inicializada, devemos inicializar e preencher
        if (routes == null) {
            routes = new ArrayList<>();
        }
        return routes;
    }

    public static void update(int position, Routes routes) {
        getAll().set(position, routes);
    }

    public static Routes getByPosition(int position) {
        return getAll().get(position);
    }


    public static void add(Routes routes) {
        if (DataSource.routes == null) {
            DataSource.routes = new ArrayList<>();
        }
        long newId = 1;
        if (DataSource.routes.size() > 0) {
            Routes lastOne = DataSource.routes.get(DataSource.routes.size() - 1);
            newId = lastOne.getId() + 1;
        }
        routes.setId(newId);
        DataSource.routes.add(routes);
    }

    public static void remove(int position) {
        if (routes != null && routes.size() > position) {
            routes.remove(position);
        }
    }

    public static void remove(Routes routes) {
        if (DataSource.routes != null) {
            DataSource.routes.remove(routes);
        }
    }
}
