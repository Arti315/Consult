package pramod.consultency.com.admin.dashboard;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.activities.Reset_password;
import pramod.consultency.com.admin.app.RetrofitClient;
import pramod.consultency.com.admin.locations.MapsActivity;
import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.SharedPrefManager;
import pramod.consultency.com.admin.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Documents extends AppCompatActivity implements View.OnClickListener {

    private static final int STORAGE_PERMISSION_CODE = 1;
    private ProgressDialog progress;
    private ImageView imageView;
    private ImageButton imgbutton;
    private EditText com_name;
    private EditText email_id;
    private TextView notification1;

    private EditText comment_send;
    private Button upload_Button;
    private ProgressDialog progressDialog;
    private Uri pdfUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        getSupportActionBar().setTitle("Documents");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        com_name = findViewById(R.id.company_serch);
        email_id = findViewById(R.id.document_sendername);
        comment_send = findViewById(R.id.comment_admin);
        upload_Button = findViewById(R.id.document_send);
        upload_Button.setOnClickListener(this);

        imgbutton = findViewById(R.id.image_upload);
        notification1 = findViewById(R.id.notification);
        imgbutton.setOnClickListener(this);

        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Documents.this, Manifest.permission.READ_EXTERNAL_STORAGE) == getPackageManager().PERMISSION_GRANTED) {
                    selectPdf();
                } else
                    ActivityCompat.requestPermissions(Documents.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
            }
        });



        }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
            selectPdf();
        }
        else{
        Toast.makeText(Documents.this,"Please Provide permission..",Toast.LENGTH_LONG).show();
        }











    }
        private void selectPdf() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }


    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
            pdfUri=data.getData();
            notification1.setText("A file Selected:" +data.getData().getLastPathSegment());
           // imageView.setImageBitmap(data.getData().getLastPathSegment());

        }
        else{
            Toast.makeText(Documents.this,"Please Selcted a file",Toast.LENGTH_LONG).show();
        }

    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }


    private void uploadFile( Uri pdfUri) {

       // File file = new File(getRealPathFromURI(fileUri));

       // RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
       // RequestBody descBody = RequestBody.create(MediaType.parse("text/plain"), desc);


        final String company_name = com_name.getText().toString().trim();
        final String email = email_id.getText().toString().trim();
        final String comment = comment_send.getText().toString().trim();


        if (company_name.isEmpty()) {
            com_name.setError("Company Name Is required");
            com_name.requestFocus();
            return;
        }


       if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_id.setError("Enter a valid email");
            email_id.requestFocus();
            return;
        }


        if (comment.isEmpty()) {
            comment_send.setError("Comment is mandatory");
            comment_send.requestFocus();
            return;
        }
        dialog();
          //File file = FileUtils.getFile(this,SelectedFileUri)
        Call<Result> call = RetrofitClient.getInstance().getApi().document(company_name, email, comment);


        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

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


    private void dialog() {

        progress = new ProgressDialog(this);
        progress.setMax(100);
        progress.setTitle("Uploding file...");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progress.getProgress() <= progress.getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progress.getProgress() == progress.getMax()) {
                            progress.dismiss();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress.incrementProgressBy(1);
        }
    };

    @Override
    public void onClick(View v) {

        if(pdfUri!=null)
             uploadFile(pdfUri);
        else
            Toast.makeText(Documents.this,"Please select PDF Document..",Toast.LENGTH_LONG).show();
        }



    }