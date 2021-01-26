package pt.ipbeja.estig.twdm.roteirosdebeja;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private static final String BUTTON_ADD_TO_FAV = "Add to Favourites";
    private static final String BUTTON_REMOVE_FROM_FAV = "Remove from Favourites";



    private Route route;
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
            this.route = this.routesDao.getById(this.id);
            textViewName.setText(this.route.getName());
            textViewDescription.setText(this.route.getDescription());
            Context ctx = getApplicationContext();
            if (this.route.getImages().size() > 0) {
//                this.route.getImages()
//                imageSlider.setBackgroundResource(getImageId(ctx,this.route.getImageUrl()));
//                Glide.with(this).load(this.route.getImageUrl()).into(imageSlider);
            }
            this.updateUI(this.route.isFav());
        }


    }


    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    public void toggleFav(View view) {
        if (this.route.isFav()) {
            this.route.setFav(false);
        } else {
            this.route.setFav(true);
        }
        this.updateUI(this.route.isFav());

        this.routesDao.update(this.route);
    }

    private void updateUI(boolean isFav) {
//        if (isFav) {
//            this.buttonFav.setText(BUTTON_REMOVE_FROM_FAV);
//        } else {
//            this.buttonFav.setText(BUTTON_ADD_TO_FAV);
//        }
    }

}
