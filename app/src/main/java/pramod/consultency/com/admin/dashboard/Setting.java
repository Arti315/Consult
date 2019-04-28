package pramod.consultency.com.admin.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.activities.Notification;
import pramod.consultency.com.admin.adapter.MyListAdapter;

public class Setting extends AppCompatActivity {
   /* ListView list;

    String[] maintitle ={
            "Profile","Password Management",
           "Notification",
            // "Help",
            "Help",
    };

    String[] subtitle ={
           // "Sub Title 1","Sub Title 2",
            //"Sub Title 3","Sub Title 4",
           // "Sub Title 5",
    };

    Integer[] imgid={
            R.drawable.ic_person1,R.drawable.password,
            R.drawable.notify_ican,
           // R.drawable.chatround,
           R.drawable.ic_help_black_24dp,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setTitle("Setting");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {

                    Intent i6 = new Intent(Setting.this,Profile_Account.class);
                    startActivity(i6);
                }

                else if(position == 1) {

                    Intent i6 = new Intent(Setting.this,Password_change.class);
                    startActivity(i6);
                }

                else if(position == 2) {

                    Intent i6 = new Intent(Setting.this,Notification.class);
                    startActivity(i6);

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    public boolean onOptionsItemSelected(MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);


    }*/
}
