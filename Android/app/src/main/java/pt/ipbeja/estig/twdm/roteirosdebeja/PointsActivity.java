package pt.ipbeja.estig.twdm.roteirosdebeja;

import android.content.Context;
import android.content.Intent;
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

public class PointsActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    private Point points;
    private long id;
    private PointsAdapter adapterPoints;
    private RoutesService routesService;
    private PointService pointsService;

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, PointsActivity.class);
        intent.putExtra(KEY_ID, id);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        ListView listView = findViewById(R.id.listview5);
        this.adapterPoints = new PointsAdapter(this);
        listView.setAdapter(this.adapterPoints);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PointsDetails.startActivity(PointsActivity.this, id);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        PointService service = RoutesDataSource.getPointService();
        Call<BaseResponse<List<Point>>> call = service.getPoints();
        call.enqueue(new Callback<BaseResponse<List<Point>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Point>>> call, Response<BaseResponse<List<Point>>> response) {
                if (response.isSuccessful()) {
                    List<Point> pointList = response.body().getData();
                    if (pointList != null) {
                        adapterPoints.updateList(pointList);
                    }
                } else {
                    try {
                        Log.e("PointsActivity", "Error ocurred: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Point>>> call, Throwable t) {

            }


        });
    }
}

