package pramod.consultency.com.admin.dashboard;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.SharedPrefManager;
import pramod.consultency.com.admin.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Report extends AppCompatActivity implements View.OnClickListener {
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;

    private Button report_button;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setTitle("Report");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        checkBox1 = findViewById(R.id.check1);

        checkBox1.setOnClickListener(this);
        checkBox2 = findViewById(R.id.check2);
        checkBox2.setOnClickListener(this);
        checkBox3 = findViewById(R.id.check3);

        checkBox4 = findViewById(R.id.check4);

        checkBox5 = findViewById(R.id.check5);

        report_button = findViewById(R.id.textViewRegister2);

        report_button.setOnClickListener(this);


    }


    public void onCheckboxClicked(View view) {
        if(view == checkBox1)
        {
            Toast.makeText(getApplicationContext(), "pramod" ,Toast.LENGTH_LONG).show();
        }
        else if(checkBox2 == view)
        {
            Toast.makeText(getApplicationContext(), "pradeep" ,Toast.LENGTH_LONG).show();
        }

    }

    public void Report_card() {
        final String position = checkBox1.getText().toString().trim();
        final String company = checkBox2.getText().toString().trim();
        final String open = checkBox2.getText().toString().trim();

        final String closed = checkBox2.getText().toString().trim();

        final String onhold = checkBox2.getText().toString().trim();


       // progressDialog.setMessage("update password...");
       // progressDialog.show();






       /*Call<Result> call = RetrofitClient.getInstance().getApi().report();


       call.enqueue(new Callback<Result>() {
           @Override
           public void onResponse(Call<Result> call, Response<Result> response)
           {

               progressDialog.dismiss();
               // Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();


           }

           @Override
           public void onFailure(Call<Result> call, Throwable t) {
               progressDialog.dismiss();
               Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
           }
       });*/


    }





    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View v) {
        Report_card();
    }
}