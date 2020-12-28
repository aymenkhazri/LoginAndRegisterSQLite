package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email , password ;
    private Button login ,register ;
   DatabaseHelper db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email=findViewById(R.id.editTextTextPersonEmail);
        password=findViewById(R.id.editTextTextPassword) ;
        login=findViewById(R.id.btnlogin) ;
         db=new DatabaseHelper(this);

         register=findViewById(R.id.btnRegister);
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
             }
         });


         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String Email = email.getText().toString();
                 String Password = password.getText().toString();

                 boolean checkEmailAndPassword=db.checkEmailAndPassword(Email,Password) ;
                 if (Email.equals("") || Password.equals("")) {
                     Toast.makeText(getApplicationContext(), "field are empty", Toast.LENGTH_SHORT).show();

                 } else {
                     if (checkEmailAndPassword) {

                         Toast.makeText(getApplicationContext(), " Wrong  Email or password ", Toast.LENGTH_SHORT).show();
                     } else {

                         Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                     }

                 }
             }
         }) ;

    }
}