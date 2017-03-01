package app.affito.com.affito.Adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import app.affito.com.affito.Model.LivingRoom;
import app.affito.com.affito.R;

/**
 * Created by sarveshpalav on 01/03/17.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.LivingRoomViewHolder>

{
    List<LivingRoom> livingRoomList;

    public RecycleViewAdapter(List<LivingRoom> livingRoomList) {
        this.livingRoomList = livingRoomList;
    }

    @Override
    public LivingRoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent, false);
        LivingRoomViewHolder pvh = new LivingRoomViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(LivingRoomViewHolder holder, int position) {

        holder.Name.setText(livingRoomList.get(position).getName());
        holder.Price.setText(livingRoomList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
       return livingRoomList.size();
    }

    public static class LivingRoomViewHolder extends RecyclerView.ViewHolder {
    TextView Name;
    TextView Price;
    ImageView Imgurl;

    LivingRoomViewHolder(View itemView) {
        super(itemView);

        Name = (TextView)itemView.findViewById(R.id.name);
        Price = (TextView)itemView.findViewById(R.id.price);
        Imgurl = (ImageView)itemView.findViewById(R.id.img);
    }
}

}




