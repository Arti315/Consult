package pramod.consultency.com.admin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.activities.Reset_password;
import pramod.consultency.com.admin.dashboard.Details;
import pramod.consultency.com.admin.model.DashModel;



public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {

    ArrayList<DashModel> dashModelArrayList;
    private Context mContext;

    LinearLayout parent;


    public DashAdapter(ArrayList<DashModel> dashModelArrayList) {
        this.dashModelArrayList = dashModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String ret_head = dashModelArrayList.get(position).getHead();
        holder.setheader(ret_head);

        String ret_sub = dashModelArrayList.get(position).getSub();
        holder.set_sub(ret_sub);

        int ret_image = dashModelArrayList.get(position).getImage();
        holder.set_image(ret_image);

     /*   holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

               // Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

               // Intent intent = new Intent(mContext, Details.class);
               // intent.putExtra("image_url", mImages.get(position));
                //intent.putExtra("image_name", mImageNames.get(position));
                //mContext.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return dashModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        private RelativeLayout parent;


        private TextView header,sub_header;
        private ImageView images;
        private View myView;
        private RelativeLayout relativeLayout;






       public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setheader(String h)
        {
            header = myView.findViewById(R.id.header);
            header.setText(h);
        }

        public void set_sub(String s)
        {
            sub_header = myView.findViewById(R.id.sub_header);
            sub_header.setText(s);
        }
        public void set_image(int i)
        {
            images = myView.findViewById(R.id.dash_image);
            images.setImageResource(i);
        }

        public void let_on(int i)
        {
            parent = myView.findViewById(R.id.relativelayout);

        }

    }
}
