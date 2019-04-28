package pramod.consultency.com.admin.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.adapter.DashAdapter;
import pramod.consultency.com.admin.adapter.MyListAdapter;
import pramod.consultency.com.admin.model.DashModel;


public class Users  extends AppCompatActivity
{

    ArrayList<DashModel> dashModelArrayList;
    private RecyclerView recyclerView;
    DashAdapter dashAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportActionBar().setTitle("Position");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = findViewById(R.id.rv1);

        dashModelArrayList = new ArrayList<>();
        String heads[] = {"Sales", "Hr", "Marketing", "Mechanical", "Finance", "Development"};

      //  String subs[] = {"12 new jobs found", "75% complete", "2 new messages", "3 applies jobs", "Edit resume", "Set preferences"};

        int images[] = {R.drawable.sales_reprentative, R.drawable.profile_image, R.drawable.profile_image, R.drawable.profile_image,
                R.drawable.profile_image,R.drawable.profile_image};

        for(int count = 0 ; count < heads.length ; count++)
        {
            DashModel dashModel = new DashModel();
            dashModel.setHead(heads[count]);
           // dashModel.setSub(subs[count]);
            dashModel.setImage(images[count]);
            dashModelArrayList.add(dashModel);

        }
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        dashAdapter = new DashAdapter(dashModelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashAdapter);
    }




    public boolean onOptionsItemSelected(android.view.MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
