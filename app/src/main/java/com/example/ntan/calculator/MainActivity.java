
/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.ntan.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;
import java.text.NumberFormat;

import static android.R.id.edit;
import static android.os.Build.VERSION_CODES.N;
import static com.example.ntan.calculator.R.id.checkBox1;
import static com.example.ntan.calculator.R.id.checkBox2;
import static com.example.ntan.calculator.R.id.price;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int counter = 0;
    int soIceCream =0 ;
    int soChocolate =0;
    public void increase (View view){
        counter++;
        display(counter);
    }
    public void decrease (View view){
        counter--;
        display(counter);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.gia_quantity);
        quantityTextView.setText(" "+ number);
    }

    public void composeEmail(View view){
        String x ="";
        int number=counter*5;
        TextView priceTextView = (TextView) findViewById(R.id.gia_price);
        EditText edText = (EditText) findViewById(R.id.edit_text) ;
        CheckBox ckBox1 = (CheckBox) findViewById(checkBox1) ;
        CheckBox ckBox2 = (CheckBox) findViewById(checkBox2) ;
        String edText_noidung = edText.getText().toString();
        if (ckBox1.isChecked()==true){
            soIceCream = 1;
            number = number + 1;
        }
        if (ckBox2.isChecked()==true){
            soChocolate = 1;
            number = number + 2;
        }
        x = "Hello Mr. "+edText_noidung+ "\n"+
                "Your order contains "+ soChocolate + " chocolate and "+soIceCream+" Ice-cream!\n"
                +"Your price is "+ number + "$" ;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        String[] diaChiEmail = new String[1];
        diaChiEmail[0] = "Customer";
        intent.putExtra(Intent.EXTRA_EMAIL, diaChiEmail);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Here is your order");
        intent.putExtra(Intent.EXTRA_TEXT, x);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}