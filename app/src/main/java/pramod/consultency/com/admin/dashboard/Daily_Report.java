package pramod.consultency.com.admin.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pramod.consultency.com.admin.R;

public class Daily_Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__report);

        getSupportActionBar().setTitle("Daily Report");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


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
