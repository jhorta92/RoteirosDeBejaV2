package pt.ipbeja.estig.twdm.roteirosdebeja;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointsDetails extends AppCompatActivity {
    public static final String KEY_ID = "id";
    private Point points;
    private long id;
    private RoutesAdapter adapter;
    private RoutesService routesService;

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, PointsDetails.class);
        intent.putExtra(KEY_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_points);
        TextView textViewName = findViewById(R.id.textView3);
        TextView textViewDescription = findViewById(R.id.textView4);
        ImageView imageSlider = findViewById(R.id.imageSlider2);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
        }
        if (this.id > 0) {
            PointService service = RoutesDataSource.getPointService();
            Call<BaseResponse<Point>> call = service.getPointById(this.id);

            call.enqueue(new Callback<BaseResponse<Point>>() {
                             @Override
                             public void onResponse(Call<BaseResponse<Point>> call, Response<BaseResponse<Point>> response) {
                                 if (response.isSuccessful()) {
                                     Point point = (Point) response.body().getData();
                                     textViewName.setText(point.getName());
                                     Glide.with(PointsDetails.this).load(point.getImages()).into(imageSlider);
                                     textViewDescription.setText(point.getDescription());
                                     final Button btn = findViewById(R.id.maps);
                                     btn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             // Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                                             Uri gmmIntentUri = Uri.parse(point.getCoordinate());
                                             Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                             mapIntent.setPackage("com.google.android.apps.maps");
                                             if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                                 startActivity(mapIntent);
                                             }
                                         }
                                     });
                                 } else {
                                     Log.e("DetailsActivity", "Error ocurred");
                                 }
                             }

                             @Override
                             public void onFailure(Call<BaseResponse<Point>> call, Throwable t) {
                                 Log.e("DetailsActivity", "Exception", t);
                             }
                         }
            );


        } else {
            finish();
        }

    }
    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }
}
