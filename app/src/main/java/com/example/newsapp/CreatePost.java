package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePost extends AppCompatActivity {

    EditText post;
    Button submit;
    Button home;
    String content,username="abhi",email="abhi@gmail.com";

    DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        post = findViewById(R.id.editTextPost);
        submit = findViewById(R.id.submit);

        data = FirebaseDatabase.getInstance().getReference().child("user");
        home = findViewById(R.id.home_btn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String postContent = post.getText().toString();
                Pojo pojo = new Pojo(postContent,username,email);
                String key = data.push().getKey();
                data.child(key).setValue(pojo);
                Toast.makeText(CreatePost.this, "News is posted", Toast.LENGTH_SHORT).show();
                post.setText("");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

    }
    public void openHome(){
        Intent intent2 = new Intent(this, MainActivity2.class);
        startActivity(intent2);
    }


}