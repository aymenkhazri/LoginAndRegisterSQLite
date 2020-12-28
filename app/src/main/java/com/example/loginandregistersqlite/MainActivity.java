package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Email ,Password,Cpasword ;
    Button BtmRegister ,Btmlogin ;
    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new DatabaseHelper(this) ;
        Email=findViewById(R.id.editTextTextEmail) ;
        Password=findViewById(R.id.editTextTextPassword2) ;
        Cpasword=findViewById(R.id.editTextTextPassword3) ;
        Btmlogin=findViewById(R.id.login);
        Btmlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class) ;
                startActivity(intent);
            }
        });

        BtmRegister=findViewById(R.id.button) ;
         BtmRegister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              String email =Email.getText().toString() ;
              String password =Password.getText().toString() ;
              String cpasswod =Cpasword.getText().toString() ;
              String btmRegister =BtmRegister.getText().toString() ;
              if(email.equals("")||password.equals("")||cpasswod.equals("")){
                  Toast.makeText(getApplicationContext(),"fielde are empty",Toast.LENGTH_SHORT).show();

              }else {
                 if(password.equals(cpasswod)){
                     boolean chekmail=db.chekmail(email) ;
                     if(chekmail==true){
                         boolean insert =db.insert(email,password);
                         if(insert==true){

                            Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();

                         }


                     }else {
                         Toast.makeText(getApplicationContext(),"Email Already existe",Toast.LENGTH_SHORT).show();
                     }

                 }else {
                     Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();

                 }


              }


             }
         });


    }
}