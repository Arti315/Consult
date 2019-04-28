package pramod.consultency.com.admin.dashboard;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.SharedPrefManager;
import pramod.consultency.com.admin.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Password_change extends AppCompatActivity implements View.OnClickListener {

    private EditText current_password;
    private EditText new_password;
    private EditText  confirm_password;
    private Button  submit_button;
    private ProgressDialog  progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Password Change");


        progressDialog = new  ProgressDialog(this);

        progressDialog.setMessage("Please wait...");


        current_password = findViewById(R.id.current_pass);

        new_password = findViewById(R.id.new_pass);

        confirm_password = findViewById(R.id.confirm_pa);

        submit_button = findViewById(R.id.password_button);


        submit_button.setOnClickListener(this);




    }



    public void password_change()
    {
        final String  currentpassword =current_password.getText().toString().trim();

        final String  newpassword =new_password.getText().toString().trim();

        final String  confirm_pass =confirm_password.getText().toString().trim();

        Log.d("current_pass",currentpassword);

        Log.d("new_pass",newpassword);
        Log.d("confirm_pass",confirm_pass);

        if (currentpassword.isEmpty()) {
            current_password.setError("Current Password required");
            current_password.requestFocus();
            return;
        }

        if (newpassword.length() < 8) {
            new_password.setError("New Password required");
            new_password.requestFocus();
            return;
        }

        if (!confirm_pass.equals(newpassword)) {
            confirm_password.setError("Confirm is Not match");
            confirm_password.requestFocus();
            return;
        }
            progressDialog.setMessage("update password...");
            progressDialog.show();

        User user = SharedPrefManager.getInstance(this).getUser();


        Call<Result> call = RetrofitClient.getInstance().getApi().updatePassword(user.getId(),currentpassword,newpassword);


        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response)
            {

                progressDialog.dismiss();
                //Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


























    public boolean onOptionsItemSelected(android.view.MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View v) {

        password_change();

    }
}
