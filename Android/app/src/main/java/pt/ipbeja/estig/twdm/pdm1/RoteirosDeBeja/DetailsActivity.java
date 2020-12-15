package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private static final String BUTTON_ADD_TO_FAV = "Add to Favourites";
    private static final String BUTTON_REMOVE_FROM_FAV = "Remove from Favourites";



    private Routes routes;
    private long id;
    private RoutesDao routesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewDescription = findViewById(R.id.textView);
        ImageView imageSlider = findViewById(R.id.imageSlider);
        this.routesDao = AppDatabase.getInstance(this).getRoutesDao();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
            if (this.id == -1) {
                finish(); // Termina esta Activity
            }
            this.routes = this.routesDao.getById(this.id);
            textViewName.setText(this.routes.getName());
            textViewDescription.setText(this.routes.getDescription());
            Context ctx = getApplicationContext();
            imageSlider.setBackgroundResource(getImageId(ctx,this.routes.getImageUrl()));
            Glide.with(this).load(this.routes.getImageUrl()).into(imageSlider);
            this.updateUI(this.routes.isFav());
        }


    }


    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    public void toggleFav(View view) {
        if (this.routes.isFav()) {
            this.routes.setFav(false);
        } else {
            this.routes.setFav(true);
        }
        this.updateUI(this.routes.isFav());

        this.routesDao.update(this.routes);
    }

    private void updateUI(boolean isFav) {
//        if (isFav) {
//            this.buttonFav.setText(BUTTON_REMOVE_FROM_FAV);
//        } else {
//            this.buttonFav.setText(BUTTON_ADD_TO_FAV);
//        }
    }

}
