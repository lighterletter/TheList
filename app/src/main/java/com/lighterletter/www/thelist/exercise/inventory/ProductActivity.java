package com.lighterletter.www.thelist.exercise.inventory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lighterletter.www.thelist.R;
import com.lighterletter.www.thelist.exercise.structures.LinkedStack;

import java.util.List;

/**
 *
 */

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = ProductActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        LinkedStack<Product> inventory = new LinkedStack<>();

        Product noteBook1 = new Product("NoteBook: 1");
        Product noteBook2 = new Product("NoteBook: 2");
        Product noteBook3 = new Product("NoteBook: 3");
        Product noteBook4 = new Product("NoteBook: 4");
        Product noteBook5 = new Product("NoteBook: 5");

        if (inventory.isEmpty()) {
            //initially the stack will be empty which means we'll add these objects onto it.
            inventory.push(noteBook1);
            inventory.push(noteBook2);
            inventory.push(noteBook3);
            inventory.push(noteBook4);
            inventory.push(noteBook5);
            //The last element we add is book 5

            printStack(inventory);
        }

        /*
            At this point we'll get the top element from the ones we pushed but it will still remain in the stack.
            What element do you think that is?
         */
        Log.d(TAG, "onCreate: top: " + inventory.peek().getName());


        /**
         * When we pop an element we remove it from the stack
         */
        Product poppedElement = inventory.pop();
        Log.d(TAG, "onCreate: Popped an element: " + poppedElement.getName());
        printStack(inventory);
    }

    private void printStack(LinkedStack<Product> inventory) {
        int position = 0; //top is element 0
        for (Product product : inventory.getCurrentStack()) {
            Log.d(TAG, "onCreate: onStack: " + position++ + " : " + product.getName());
        }
    }
}
