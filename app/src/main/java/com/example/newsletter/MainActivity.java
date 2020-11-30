package com.example.newsletter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button confirm;
    private AutoCompleteTextView email ;
    private TextView Sub ;
    private ListView subscription ;
    private String[] emails= new String[]{"Sbentaher16@gmail.com","souha@gmail.com","sou123@gmail.com"};
    private String[] subscriptions= new String[]{"Daily","Weekly","Monthly"};
    String selectedFromList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (AutoCompleteTextView) this.findViewById(R.id.emailList );
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, emails);
        email.setAdapter(adapter);

        subscription = (ListView) this.findViewById(R.id.subList);
        subscription.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,subscriptions));
        subscription.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                selectedFromList = (String)subscription.getItemAtPosition(i);
            }
        });


        confirm= (Button)findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Thank you "+email.getText().toString()+"\n You choose a " +selectedFromList+ "Subscription",
        Toast.LENGTH_SHORT).show();
    }

        });
        }
}