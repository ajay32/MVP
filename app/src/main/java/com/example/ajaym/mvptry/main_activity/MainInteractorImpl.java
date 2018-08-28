package com.example.ajaym.mvptry.main_activity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainInteractorImpl implements MainContract.Iteractor{


        private List<String> arrayList = Arrays.asList(

                "TextView 1",
                "TextView 2",
                "TextView 3",
                "TextView 4",
                "TextView 5"
        );


    @Override
    public void textChange(changeListener changeListener) {
        changeListener.onChange(getRandomText());   // sending data
    }


    private String getRandomText() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }


}
