package pramod.consultency.com.admin.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reset_password extends AppCompatActivity {
    private EditText reset_pass;
    private Button  restbutton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
       getSupportActionBar().setTitle("Rest Password");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        reset_pass = (EditText)findViewById(R.id.forgetuser);
        restbutton =(Button)findViewById(R.id.rest_Button);
        progressDialog = new ProgressDialog(this);
        //progressDialog.s(ColorStateList.valueOf(Color.RED));
        progressDialog.setMessage("Please wait...");


        restbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restpassword();
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


    }


    public void restpassword()
    {
        final String  restpassword= reset_pass.getText().toString().trim();




        if (!Patterns.EMAIL_ADDRESS.matcher(restpassword).matches()) {
            reset_pass.setError("Enter a valid email");
            reset_pass.requestFocus();
            return;
        }



        Log.d("rest",restpassword);

        progressDialog.show();

        Call<Result> call = RetrofitClient.getInstance().getApi().resetpassword(restpassword);


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
        });


    }

}
