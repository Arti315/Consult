package pramod.consultency.com.admin.dashboard;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;




import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.SharedPrefManager;
import pramod.consultency.com.admin.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class InterView_Schedule extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private EditText interViewdate;

    private String TAG;
    private EditText condidate_names;
    private EditText email_id1;
    private EditText company_webSeaching;
    private EditText  job_apply;
    private EditText interView;
    private EditText address_location;
    private EditText contract_mob;
    private EditText contract_person_name;
    String[] language ={"Gts Technolgy","india Ltd","noida limited","india pvt ltd","iPhone.ltd","india pvtTechnolgy","birla technolgy","technolgy.pvtd"};


    String[] job ={"Android","php","java","ios","laravel","pythan","silm"};
    private EditText enter_comment;
    private ProgressDialog  progressDialog;
    private Button  send;
      /**************************Calender***************************************************************/
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_view__schedule);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("InterView Details");


        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);


        /*********************Autu Search box *********************************************************/



        AutoCompleteTextView  editText = findViewById(R.id.company);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,language);

             editText.setAdapter(adapter);


       // AutoCompleteTextView  editText = findViewById(R.id.company);


        /************************************************************************************************web Search************************/

       /* AutoCompleteTextView  editText1 = findViewById(R.id.job_search);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,job);

        editText.setAdapter(adapter1);*/


       // AutoCompleteTextView  editText1 = findViewById(R.id.job_search);
/*****************************************************************************************************************/
        condidate_names = (EditText) findViewById(R.id.condidate_name);

        email_id1 = (EditText) findViewById(R.id.email_id);

        company_webSeaching = (EditText) findViewById(R.id.company_web);

        job_apply = (EditText) findViewById(R.id.enterView_job);

        interView = (EditText) findViewById(R.id.interview_date);


        interView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });







        address_location = (EditText) findViewById(R.id.enter_address);

        contract_person_name = (EditText) findViewById(R.id.contract_person);


        contract_mob = (EditText) findViewById(R.id.contract_person_mobile);

        enter_comment = (EditText) findViewById(R.id.interview_comment);


        progressDialog = new ProgressDialog(this);
        //progressDialog.s(ColorStateList.valueOf(Color.RED));
        progressDialog.setMessage("Please wait...");

        send = (Button) findViewById(R.id.interview_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interview_detail();
            }
        });


    }
















    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }





   public void interview_detail()
    {
         String condidate = condidate_names.getText().toString().trim();


        String email = email_id1.getText().toString().trim();

        String com_web = company_webSeaching.getText().toString().trim();

        String job = job_apply.getText().toString().trim();

        String interviewDate = interView.getText().toString().trim();

        String address = address_location.getText().toString().trim();

        String contract_name = contract_person_name.getText().toString().trim();

        String contract_mobile = contract_mob.getText().toString().trim();

        String comment = enter_comment.getText().toString().trim();




       // User user = SharedPrefManager.getInstance(this).getUser();






       // Log.d("condidateName",condiidate_name);
        Log.d("condidate",condidate);
        Log.d("email",email);
        Log.d("com_web",com_web);
        Log.d("job",job);
        Log.d("interviewDate",interviewDate);
        Log.d("address",address);
        Log.d("contract_name",contract_name);
        Log.d("contract_mobile",contract_mobile);

       Log.d("comment", comment);









      if (condidate.length() <3) {
            condidate_names.setError("Condidate Name  is required ");
            condidate_names.requestFocus();
            return;
        }




        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_id1.setError("Enter a valid email");
            email_id1.requestFocus();
            return;
        }



       /* if (com_web.isEmpty()) {
            company_webSeaching.setError("InterView Time  is required ");
            company_webSeaching.requestFocus();
            return;
        }


      if (job.isEmpty()) {
            job_apply.setError("job  is required ");
            job_apply.requestFocus();
            return;
        }*/


         if (interviewDate.isEmpty()) {
            interView.setError("InterView date  is required ");
            interView.requestFocus();
            return;
        }



        if (contract_name.isEmpty()) {
            contract_person_name.setError("Contract name is Required ");
            contract_person_name.requestFocus();
            return;
        }

        if (contract_mobile.length() < 10)  {
            contract_mob.setError("Enter valid Mobile");
            contract_mob.requestFocus();
            return;
        }

        if (contract_mobile.length() < 10)  {
            contract_mob.setError("Enter valid Mobile");
            contract_mob.requestFocus();
            return;
        }



        if (comment.isEmpty()) {
            enter_comment.setError("Contract name is Required ");
            enter_comment.requestFocus();
            return;
        }

        progressDialog.setMessage("wait...");
        progressDialog.show();
        User user = SharedPrefManager.getInstance(this).getUser();


        Call<Result> call = RetrofitClient.getInstance().getApi().interviewSchedule(user.getId(),condidate, email, com_web,job,interviewDate,address,contract_name,contract_mobile,comment);


        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response)
            {

                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }






    private void colocar_fecha() {
        interView.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }
/************************************Search View Query*************************************************************************/

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}