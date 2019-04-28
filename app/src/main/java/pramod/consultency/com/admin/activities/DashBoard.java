package pramod.consultency.com.admin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.hdodenhof.circleimageview.CircleImageView;
import pramod.consultency.com.admin.R;
import pramod.consultency.com.admin.dashboard.About;
import pramod.consultency.com.admin.dashboard.Chat;
import pramod.consultency.com.admin.dashboard.Condition;
import pramod.consultency.com.admin.dashboard.Daily_Report;
import pramod.consultency.com.admin.dashboard.Documents;
import pramod.consultency.com.admin.dashboard.InterView_Schedule;
import pramod.consultency.com.admin.dashboard.Password_change;
import pramod.consultency.com.admin.dashboard.Profile_Account;
import pramod.consultency.com.admin.dashboard.Report;
import pramod.consultency.com.admin.dashboard.Setting;
import pramod.consultency.com.admin.dashboard.Users;
import pramod.consultency.com.admin.locations.MapsActivity;
import pramod.consultency.com.admin.model.CircleTransform;
import pramod.consultency.com.admin.model.SharedPrefManager;
import pramod.consultency.com.admin.model.User;



    public  class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        private NavigationView navigationView;
        private View navHeader;
       // private ImageView imgNavHeaderBg, imgProfile;
        private TextView txtName,username;
        private TextView txtWebsite;
        private EditText txt;
        private Button pro;
        private CircleImageView profileImageView;
        private Button doc;

        private Button chat1;

        private Button location1;

        private Button repo;
        private Button daily_repo;

        private Button postion;

        private Button  interviewDetails;

        private static final String urlNavHeaderBg = "https://api.androidhive.info/images/nav-menu-header-bg.jpg";
        private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dash_board);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);
             getSupportActionBar().setTitle("HOME");
            pro = (Button) findViewById(R.id.profile);

            doc = (Button) findViewById(R.id.document);
            chat1 = (Button) findViewById(R.id.chat_b);
            location1 = (Button) findViewById(R.id.locations);

            repo = (Button) findViewById(R.id.report_button);

            daily_repo = (Button) findViewById(R.id.daily_r);
           interviewDetails = (Button) findViewById(R.id.interview);

            postion = (Button) findViewById(R.id.position1);


           postion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent u = new Intent(getApplicationContext(), Users.class);
                    startActivity(u);
                }
            });



          pro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Profile_Account.class);
                    startActivity(i);
                }
            });



            interviewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), InterView_Schedule.class);
                    startActivity(i);
                }
            });






            doc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Documents.class);
                    startActivity(i);
                }
            });

            chat1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Chat.class);
                    startActivity(i);
                }
            });





            location1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(i);
                }
            });



            repo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Report.class);
                    startActivity(i);
                }
            });



            daily_repo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Daily_Report.class);
                    startActivity(i);
                }
            });






            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.setItemTextAppearance(R.style.MenuTextStyle);
            navigationView.setItemIconTintList(null);
            navHeader = navigationView.getHeaderView(0);
            txtName = (TextView) navHeader.findViewById(R.id.name);
            txtWebsite = (TextView) navHeader.findViewById(R.id.website);
            // username = (TextView)findViewById(R.id.editTextemail1);
          //  imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
            profileImageView = (CircleImageView ) navHeader.findViewById(R.id.img_profile);
            naviheader();


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();




           // displaySelectedScreen(R.id.profile);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }






        public void naviheader() {



            User user = SharedPrefManager.getInstance(this).getUser();

           // txtName.setText(String.valueOf(user.getId()));
            txtWebsite.setText(user.getEmail());
            txtName.setText(user.getName());


          //  txtName.setText(user.getUsername());
           // txtWebsite.setText(user.getEmail());


         /*  Glide.with(this).load(urlNavHeaderBg)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgNavHeaderBg);*/

             //Loading profile image
            Glide.with(this).load(urlProfileImg)
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(profileImageView);

          //  navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.dash_board, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch(item.getItemId()) {

                case R.id.menuLogout12:
                    Intent Notification = new Intent(this,Notification.class);
                    startActivity(Notification);
                    break;



                case R.id.nav_setting:
                    Intent intent1 = new Intent(this,Setting.class);
                    startActivity(intent1);
                    break;


                case R.id.menuLogout:

                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                    finish();



                    break;

            }

            return super.onOptionsItemSelected(item);
        }

        private void displaySelectedScreen(int itemId) {


            Fragment fragment = null;


            switch (itemId) {

               case R.id.home:
                   Intent account = new Intent(this,Profile_Account.class);
                   startActivity(account);
                   // fragment = new Home();
                    break;



                case R.id.password:
                    Intent pass = new Intent(this,Password_change.class);
                    startActivity(pass);
                    // fragment = new Home();
                    break;





                case R.id.users:
                    Intent u = new Intent(this,Users.class);
                    startActivity(u);
                    break;

               case R.id.document:
                   Intent Documents = new Intent(this,Documents.class);
                    startActivity(Documents);
                    break;

                    /*case R.id.nav_setting:
                        Intent intent = new Intent(this,Setting.class);
                        startActivity(intent);
                            break;*/

               /* case R.id.nav_notification:
                    Intent i1 = new Intent(this,Notification.class);
                    startActivity(i1);
                    break;*/

                case R.id.nav_interView:
                    Intent i2 = new Intent(this,InterView_Schedule.class);
                    startActivity(i2);
                    break;

                case R.id.nav_massage:
                    Intent i3 = new Intent(this,Chat.class);
                    startActivity(i3);
                    break;

                case R.id.nav_location:
                    Intent i4 = new Intent(this, MapsActivity.class);
                    startActivity(i4);
                    break;


                case R.id.nav_share:
                    Intent i5 = new Intent(this,About.class);
                    startActivity(i5);
                    break;


                case R.id.nav_about:
                    Intent i6 = new Intent(this,Condition.class);
                    startActivity(i6);
                    break;
            }





          /*  if (fragment != null) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }*/

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }


        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            //calling the method displayselectedscreen and passing the id of selected menu
            displaySelectedScreen(item.getItemId());
            //make this method blank
            return true;
        }


    }



