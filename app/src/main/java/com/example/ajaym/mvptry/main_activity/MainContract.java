package com.example.ajaym.mvptry.main_activity;

public class MainContract {

    // it will contain all the interface for commucation between view - presenter - model  (two way commucation would be done so three interfaces ex - view to presenter , presenter to view )

    interface MainActivityX { // describe task for that activity

        void textViewUpdate();

        void setData(String string);

    }


    interface Presenter {  // tell all the event that would happen in activity

      void onButtonClick();


    }


    interface Iteractor {   // to get data for activity

        //=======================================   to get data we need listener

        interface changeListener {
            void onChange(String string);
        }

        //===============================================

        void textChange(changeListener changeListener);


    }

}
