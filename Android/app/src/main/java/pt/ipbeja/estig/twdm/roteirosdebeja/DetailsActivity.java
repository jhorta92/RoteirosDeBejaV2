package pt.ipbeja.estig.twdm.roteirosdebeja;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private static final String BUTTON_ADD_TO_FAV = "Add to Favourites";
    private static final String BUTTON_REMOVE_FROM_FAV = "Remove from Favourites";



    private Route route;
    private long id;
    private RoutesService routesService;

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_ID, id);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewDescription = findViewById(R.id.textView);
        ImageView imageSlider = findViewById(R.id.imageSlider);
        //this.routesDao = AppDatabase.getRoutesService().getRoutesService();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
        }
        if (this.id > 0) {
            RoutesService service = RoutesDataSource.getRoutesService();
            Call<Route> call = service.getRouteDetails(this.id);
            call.enqueue(new Callback<Route>() {
                @Override
                public void onResponse(Call<Route> call, Response<Route> response) {
                    if (response.isSuccessful()) {
                        Route route = response.body();
                        textViewName.setText(route.getName());
                        textViewDescription.setText(route.getDescription());
                        Glide.with(DetailsActivity.this).load(route.getImage()).into(imageSlider);
                    } else {
                        Log.e("PlanetDetailsActivity", "Error ocurred");
                    }
                }

                @Override
                public void onFailure(Call<Route> call, Throwable t) {
                    Log.e("PlanetDetailsActivity", "Exception", t);
                }
            });
        } else {
            finish();
        }

    }


    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

//    public void toggleFav(View view) {
//        if (this.route.isFav()) {
//            this.route.setFav(false);
//        } else {
//            this.route.setFav(true);
//        }
//        this.updateUI(this.route.isFav());
//
//        //this.routesService.update(this.route);
//    }

    private void updateUI(boolean isFav) {
//        if (isFav) {
//            this.buttonFav.setText(BUTTON_REMOVE_FROM_FAV);
//        } else {
//            this.buttonFav.setText(BUTTON_ADD_TO_FAV);
//        }
    }

}
