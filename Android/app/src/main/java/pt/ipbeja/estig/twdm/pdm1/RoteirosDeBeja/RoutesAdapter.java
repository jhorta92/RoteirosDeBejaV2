package pt.ipbeja.estig.twdm.pdm1.RoteirosDeBeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RoutesAdapter extends BaseAdapter {

    private Context context;
    private List<Routes> routes;


    public RoutesAdapter(Context context, List<Routes> routesList) {
        this.context = context;
        this.routes = routesList;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
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
        TextView textViewName = convertView.findViewById(R.id.textViewName);

        textViewName.setText(routes.getName());
        imageViewLogo.setBackgroundResource(getImageId(context, routes.getImageUrl()));

        if (routes.isFav()) {
            imageViewFav.setVisibility(View.VISIBLE);
        } else {
            imageViewFav.setVisibility(View.INVISIBLE);
        }

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
