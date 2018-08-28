package com.example.ajaym.mvptry.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajaym.mvptry.R;

public class MainActivity extends AppCompatActivity  implements MainContract.MainActivityX{



    TextView textView;
    Button button;

    MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this, new MainInteractorImpl());


        textView = (TextView) findViewById(R.id.tv_textview);
        button = (Button) findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.onButtonClick();   // all activity events wou be handling by Presenter

            }
        });

    }

    @Override
    public void textViewUpdate() {

        Toast.makeText(this, "updating ui ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setData(String string) {
        textView.setText(string);
    }
}


//===============================================================================


// MVP pattern gives u the presentation layer to seprate UI and Data
// there is no standard way to implement it ..here m showing u the way i implemented it
// the main focus from my side is to have a presenter layter to seperate things ..

// there are some rules to follow see below
/*

            VIEW (UI) -- PRESENTER -- MODEL (data)      //three component

  1.   Activity + XML --> View (UI)   (Fragment or any customview )
  2.   Presenter --> will update UI   &&   Presenter --> will update DATA
  3.   Presenter <-->  View  ( one to one relationship )   ex there is a Presenter for every activty  like  MainActivity woud have its one Presenter
  4.  Communication using interface  -->    View -- INTERFACE -- Presenter -- INTERFACE -- MODEL   (communication would be viseversa)
  5.  Presenter would store record of all the work that is getting done ( as abstract methods in interface)
  6.  View -/-  Model  (they wont talk )  they would talk through presenter
*/

//=========================================================================================
