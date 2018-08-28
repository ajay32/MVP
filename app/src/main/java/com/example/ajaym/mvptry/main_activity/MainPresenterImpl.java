package com.example.ajaym.mvptry.main_activity;


// it will implement all the interfaces in MainContract class


public class MainPresenterImpl implements MainContract.Presenter , MainContract.Iteractor.changeListener{

    MainContract.Iteractor iteractor;
    MainContract.MainActivityX mainActivityX;


    //getting interfaces
    public MainPresenterImpl(MainContract.MainActivityX mainActivityX, MainContract.Iteractor iteractor) {
        this.mainActivityX = mainActivityX;
        this.iteractor = iteractor;
    }



    @Override
    public void onButtonClick() {  // two type of method ...one with data (set listenr ) and other with no data
        if (mainActivityX != null) {
            mainActivityX.textViewUpdate();   //without data
        }

        iteractor.textChange(this);   // to get data //do this
    }


    @Override
    public void onChange(String string) {

        if (mainActivityX != null) {
            mainActivityX.setData(string);
        }


    }
}
