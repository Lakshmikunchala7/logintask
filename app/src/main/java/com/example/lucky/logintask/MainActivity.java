package com.example.lucky.logintask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailid,pswid;
    private TextView logwithoth,regid,forgetid,loginpageid;
    private Button loginid;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        emailid=(EditText)findViewById(R.id.emailid);
        pswid=(EditText)findViewById(R.id.pswid);
        forgetid=(TextView)findViewById(R.id.forgetid);
        regid=(TextView)findViewById(R.id.regid);
        loginid=(Button)findViewById(R.id.loginid);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        //databaseReference=firebaseDatabase.getReferenceFromUrl("https://logintask-7a602.firebaseio.com/");


    }
    public void Login (View view){
        DatabaseReference id = databaseReference.push();
        id.child("emailaddress").setValue(emailid.getText().toString());
        id.child("password").setValue(pswid.getText().toString());


    }
    private void registerUser() {

        String emailAddress = emailid.getText().toString().trim();
        String password = pswid.getText().toString().trim();


        if (TextUtils.isEmpty(emailAddress)) {
            //emailaddress is empty
            Toast.makeText(this, "enter your emailaddress", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //mobilenumber is empty
            Toast.makeText(this, "enter your password", Toast.LENGTH_SHORT).show();
            return;
        }


        //progressDialog.setMessage("registering user........");
        //progressDialog.show();

    }
    @Override
    public void onClick(View v) {
        if (v == loginid) {
            registerUser();

        }
    }
}
