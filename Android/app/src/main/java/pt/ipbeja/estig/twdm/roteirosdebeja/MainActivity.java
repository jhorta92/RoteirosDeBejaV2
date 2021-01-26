package pt.ipbeja.estig.twdm.roteirosdebeja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Criamos o adapter como variável de instância para permitir a sua utilização em todos os métodos da instância (nomeadamente no onCreate e onResume)
    private RoutesAdapter adapter;
    private RoutesDao routesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateFormat.format("", 12323L);

        ListView listView = findViewById(R.id.listView);
        // a Lista inicial das rotas é obtida do método static getAll da Class DataSource
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        this.routesDao = appDatabase.getRoutesDao();
        this.adapter = new RoutesAdapter(this);
        // definimos como Adapter da ListView o adapter que instanciámos acima
        listView.setAdapter(this.adapter);

        // Definir o novo OnItemClickListener da ListView (comportamento para quando clicamos num item da lista)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                final Route route = MainActivity.this.routesDao.getById(id);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Favourites");
                String message = "Do you really want to add " + route.getName() + " to favourites?";
                if (route.isFav()) {
                    message = "Do you really want to remove " + route.getName() + " from favourites?";
                }
                builder.setMessage(message);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Código que é executado quando clico no botão "OK" da Alert Dialog
//                        Route route = MainActivity.this.routesDao.getById(id);
//                        boolean isFavourite = route.isFav();
//                        route.setFav(!isFavourite);
//                        MainActivity.this.routesDao.update(route);
//                        MainActivity.this.adapter.updateList(MainActivity.this.routesDao.getAll());
//                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }


    //  implementamos o callback onResume para efetuar refresh da Lista sempre que a MainActivity fica disponível para o utilizador

    @Override
    protected void onResume() {
        super.onResume();
        // this.adapter.updateList(this.routesDao.getAllFromNewerToOlder());
    }
}
