package pramod.consultency.com.admin;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pramod.consultency.com.admin.activities.Login;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //changeStatusBarColor(ContextCompat.getColor(this, R.color.cardview_dark_background));


        Thread t=new Thread() {
            public void run() {

                try {

                    sleep(1000);


                    Intent intent=new Intent(HomeActivity.this,Login.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }


}
