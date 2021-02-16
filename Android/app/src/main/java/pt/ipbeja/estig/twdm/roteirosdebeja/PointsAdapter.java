package pt.ipbeja.estig.twdm.roteirosdebeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PointsAdapter extends BaseAdapter {

    private Context context;
    private List<Point> pointList;

    public PointsAdapter(Context context) {
        this.context = context;
        this.pointList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.pointList.size();
    }

    @Override
    public Point getItem(int position) {
        return this.pointList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_row_poits, parent, false);
        }

        Point point = this.getItem(position);
        ImageView imageViewLogo = convertView.findViewById(R.id.imageView);
        TextView textViewName = convertView.findViewById(R.id.textView2);

        textViewName.setText(point.getName());

        if (point.getImages().size() > 0) {
            Glide.with(context).load(point.getImages().get(0)).into(imageViewLogo);
        }



//        if (point.isFav()) {
//            imageViewFav.setVisibility(View.VISIBLE);
//        } else {
//            imageViewFav.setVisibility(View.INVISIBLE);
//        }

        return convertView; // devolver a linha preenchida com a informação que queremos apresentar
    }

    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    public void updateList(List<Point> newList) {
        this.pointList = newList;
        this.notifyDataSetChanged();
        // É o método que indica ao Adapter que os dados alteraram e possívelmente terá que atualizar a UI
    }
}
