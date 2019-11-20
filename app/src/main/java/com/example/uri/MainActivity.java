package com.example.uri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText3);
    }

    public void search (View v) {

        String str = editText.getText().toString();


        String type = "tel:";
        for(int i = 0; i < str.length(); i++) {
            int n = (int) str.charAt(i);

            if(n >= 97 && n <= 122){
                type = "";
                break;
            }
            else
                if (str.charAt(i) == '.'){
                    type = "geo:";
                    break;
                }
        }

        Uri uri = Uri.parse(String.format("%s%s", type, str));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
