package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RoutesAdapter extends BaseAdapter {

    private Context context;
    private List<Routes> routes;


    public RoutesAdapter(Context context, List<Routes> routesList) {
        this.context = context;
        this.routes = routesList;

    }

    @Override
    public int getCount() {
        return this.routes.size();
    }

    @Override
    public Routes getItem(int position) {
        return this.routes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_row, parent, false);
        }

        Routes routes = this.getItem(position);
        ImageView imageViewLogo = convertView.findViewById(R.id.imageViewLogo);
        ImageView imageViewFav = convertView.findViewById(R.id.imageViewFav);
        ImageView imageViewVisited = convertView.findViewById(R.id.imageView2);
        TextView textViewName = convertView.findViewById(R.id.textViewName);

        textViewName.setText(routes.getName());
        if (routes.getImages().size() > 0) {
            Glide.with(context).load(routes.getImages().get(0)).into(imageViewLogo);
        }

        if (routes.isFav()) {
            imageViewFav.setVisibility(View.VISIBLE);
        } else {
            imageViewFav.setVisibility(View.INVISIBLE);
        }

        // if (routes.isFav()) {
//            imageViewFav.setVisibility(View.VISIBLE);
//        } else {
//            imageViewFav.setVisibility(View.INVISIBLE);
//        }

        return convertView; // devolver a linha preenchida com a informação que queremos apresentar
    }

    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    public void updateList(List<Routes> newList) {
        this.routes = newList;
        this.notifyDataSetChanged();
        // É o método que indica ao Adapter que os dados alteraram e possívelmente terá que atualizar a UI
    }
}
