package com.howtoevery.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int duration = Toast.LENGTH_SHORT;
    CharSequence toastText;
    /**
     * This method is called when the order button is clicked.
     */

    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void addOne(View view) {
        num++;
        display(num);
        displayPrice(num*5);
    }

    public void removeOne(View view) {
        if (num > 0) {
            num--;
            display(num);
            displayPrice(num * 5);
        }

        else {
            Context context = getApplicationContext();

            toastText = getString(R.string.negativeCups);
            Toast toast = Toast.makeText(context, toastText, duration);
            toast.show();
        }
    }

    public void reset(View view) {
        if (num > 0) {
            num = 0;
            display(num);
            displayPrice(num);
        }
        else {
            Context context = getApplicationContext();
            toastText = getString(R.string.resetted);

            Toast toast = Toast.makeText(context, toastText, duration);
            toast.show();
        }

    }

    public void submitOrder(View view) {
        displayToast(num);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayToast(int number) {
        Context context = getApplicationContext();

        if (number > 0) {
            toastText = getString(R.string.ordering) + num + getString(R.string.ordering_cups_price) + NumberFormat.getCurrencyInstance().format(num*5);
        }

        else
            toastText = getString(R.string.empty_order);


            Toast toast = Toast.makeText(context, toastText, duration);
            toast.show();
        }
    }