package pt.ipbeja.estig.twdm.roteirosdebeja;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Criamos o adapter como variável de instância para permitir a sua utilização em todos os métodos da instância (nomeadamente no onCreate e onResume)
    private RoutesAdapter adapter;
    private RoutesService routesService;
    private static String url_all_routes = "http://localhost:8000/api/routes";
    //private static String url_all_points = "http://localhost:8000/api/routes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        this.adapter = new RoutesAdapter(this);
        listView.setAdapter(this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DetailsActivity.startActivity(MainActivity.this, id);
            }
        });


//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
//                final Route route = MainActivity.this.routesService.getRouteById(id);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Favourites");
//                String message = "Do you really want to add " + route.getName() + " to favourites?";
//                if (route.isFav()) {
//                    message = "Do you really want to remove " + route.getName() + " from favourites?";
//                }
//                builder.setMessage(message);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Código que é executado quando clico no botão "OK" da Alert Dialog
////                        Route route = MainActivity.this.routesDao.getById(id);
////                        boolean isFavourite = route.isFav();
////                        route.setFav(!isFavourite);
////                        MainActivity.this.routesDao.update(route);
////                        MainActivity.this.adapter.updateList(MainActivity.this.routesDao.getAll());
////                        dialog.dismiss();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                return true;
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        RoutesService service = RoutesDataSource.getRoutesService();
        Call<List<Route>> call = service.getRoutes();
        call.enqueue(new Callback<List<Route>>() {
            @Override
            public void onResponse(Call<List<Route>> call, Response<List<Route>> response) {
                if (response.isSuccessful()) {
                    List<Route> routeList = response.body();
                    if (routeList != null) {
                        adapter.updateList(routeList);
                    }
                } else {
                    try {
                        Log.e("MainActivity", "Error ocurred: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Route>> call, Throwable t) {
                Log.e("MainActivity", "Error ocurred", t);
            }
        });
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        DateFormat.format("", 12323L);
//
//        // Creating JSON Parser object
//        JSONParser jParser = new JSONParser();
//        //ArrayList<HashMap<String, String>> productsList;
//        // url to get all products list
//
//        ListView listView = findViewById(R.id.listView);
//        // a Lista inicial das rotas é obtida do método static getAll da Class DataSource
//        AppDatabase appDatabase = (AppDatabase) AppDatabase.getRoutesService();
//        this.routesService = appDatabase.getRoutesService();
//        this.adapter = new RoutesAdapter(this);
//        // definimos como Adapter da ListView o adapter que instanciámos acima
//        listView.setAdapter(this.adapter);
//
//        // Definir o novo OnItemClickListener da ListView (comportamento para quando clicamos num item da lista)
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra(DetailsActivity.KEY_ID, id);
//                startActivity(intent);
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
//                final Route route = MainActivity.this.routesService.get(id);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Favourites");
//                String message = "Do you really want to add " + route.getName() + " to favourites?";
//                if (route.isFav()) {
//                    message = "Do you really want to remove " + route.getName() + " from favourites?";
//                }
//                builder.setMessage(message);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Código que é executado quando clico no botão "OK" da Alert Dialog
////                        Route route = MainActivity.this.routesDao.getById(id);
////                        boolean isFavourite = route.isFav();
////                        route.setFav(!isFavourite);
////                        MainActivity.this.routesDao.update(route);
////                        MainActivity.this.adapter.updateList(MainActivity.this.routesDao.getAll());
////                        dialog.dismiss();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                return true;
//            }
//        });
//    }


    //  implementamos o callback onResume para efetuar refresh da Lista sempre que a MainActivity fica disponível para o utilizador

//    @Override
//    protected void onResume() {
//        super.onResume();
//        // this.adapter.updateList(this.routesDao.getAllFromNewerToOlder());
//    }

