package com.lighterletter.www.thelist.exercise.kennel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lighterletter.www.thelist.R;
import com.lighterletter.www.thelist.exercise.structures.LinkedQueue;


public class KennelActivity extends AppCompatActivity {

    private final static String TAG = KennelActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kennel);

        LinkedQueue<Dog> kennel = new LinkedQueue<>();

        Dog bella = new Dog("Bella");
        Dog lady = new Dog("lady");
        Dog gizmo = new Dog("gizmo");
        Dog mos = new Dog("MosDef");

        kennel.insert(mos);
        kennel.insert(bella);
        kennel.insert(gizmo);
        kennel.insert(lady);

        printQueue(kennel);

        Dog first = kennel.remove();
        Log.d(TAG, "onCreate: removed: " + first);

        printQueue(kennel);
    }

    private void printQueue(LinkedQueue<Dog> kennel) {
        int position = 0; //top is element 0
        for (Dog dog : kennel.getCurrentQueue()) {
            Log.d(TAG, "onCreate: onStack: " + position++ + " : " + dog.getName());
        }
    }
}
