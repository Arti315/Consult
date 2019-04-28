package pramod.consultency.com.admin.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.dashboard.Documents;
import pramod.consultency.com.admin.model.LoginResponse;
import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
    public static SharedPrefManager SharedPrefManager;
    private Button userforget;
    private Button  Button;
    private EditText Temail;
    private EditText tpass;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LOGIN");




        Button = (Button) findViewById(R.id.buttonLogin);
        userforget = (Button) findViewById(R.id.textViewRegister2);


        Temail = (EditText)findViewById(R.id.editTextemail);
        tpass = (EditText)findViewById(R.id.editTextPassword);

        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Please wait...");









        userforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Reset_password.class);
                startActivity(i);
            }
        });

        Button.setOnClickListener(this);
    }

    public void userlogin()
    {
        final String email = Temail.getText().toString().trim();

        final String password = tpass.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Temail.setError("Enter a valid email");
            Temail.requestFocus();
            return;
        }



        if (password.isEmpty()) {
            tpass.setError("Password is required");
            tpass.requestFocus();
            return;
        }

        Log.d("username",email);
        Log.d("password",password);
        progressDialog.show();

        Call<Result> call = RetrofitClient.getInstance().getApi().userLogin(email, password);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
                Result loginResponse = response.body();
                // progressDialog.dismiss();
                if (!loginResponse.getError()) {
                    // progressDialog.dismiss();
                    finish();

                    SharedPrefManager.getInstance(Login.this).saveUser(loginResponse.getUser());

                    Intent intent = new Intent(Login.this, DashBoard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }



    @Override
    public void onClick(View v) {

               // Intent intent = new Intent(Login.this,DashBoard.class);
               // startActivity(intent);
        userlogin();

    }
}
