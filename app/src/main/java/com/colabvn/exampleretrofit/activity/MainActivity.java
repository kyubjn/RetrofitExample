package com.colabvn.exampleretrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.colabvn.exampleretrofit.R;
import com.colabvn.exampleretrofit.activity.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recy_greenview;
    private MainActivityPresenter presenter;
    LinearLayoutManager linLayoutManager;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }

    private void addControls() {
        recy_greenview=findViewById(R.id.recy_greenhouse);
        btnLogin=findViewById(R.id.btnLogin);
        linLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        presenter=new MainActivityPresenter(this);
//        recy_greenview.setItemAnimator(new DefaultItemAnimator());
//        recy_greenview.setLayoutManager(linLayoutManager);

        final String username="vshnn@gmail.com";
       final  String password="adminadmin";
       // recy_greenview.setAdapter(presenter.getAdapter());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presenter!=null)
                {
                    // presenter.getListGreenhouse("2");
                    presenter.login(username,password);
                }
            }
        });

    }

    private void addEvents() {
    }
}
