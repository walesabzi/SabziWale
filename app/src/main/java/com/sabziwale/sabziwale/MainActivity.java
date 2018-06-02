package com.sabziwale.sabziwale;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    // TODO Home Fragment Manager
                    setTitle("Vegetables Available");
                    HomeFragment homeFragment = new HomeFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionHome.replace(R.id.content,homeFragment,"Home Fragment");
                    fragmentTransactionHome.commit();

                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_orders:

                    //TODO Order Fragment Manager
                    setTitle("Orders");
                    OrderFragment orderFragment = new OrderFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionOrders = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionOrders.replace(R.id.content,orderFragment,"Order Fragment");
                    fragmentTransactionOrders.commit();

                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_user:

                    //TODO User Fragment Manager
                    setTitle("User Profile");
                    UserFragment userFragment = new UserFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionUser = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionUser.replace(R.id.content,userFragment,"User Fragment");
                    fragmentTransactionUser.commit();

                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // TODO By Default Fragment Manager
        setTitle("Vegetables Available");
        HomeFragment homeFragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
        fragmentTransactionHome.replace(R.id.content,homeFragment,"Home Fragment");
        fragmentTransactionHome.commit();

    }

}
