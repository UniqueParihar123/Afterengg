package com.example.anupamparihar.afterengg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {


    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }





    Button btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     final EditText   edittext1=(EditText)findViewById(R.id.let1);
      final EditText  edittext2=(EditText)findViewById(R.id.let2);
        mAuth = FirebaseAuth.getInstance();
        btn=(Button)findViewById(R.id.button3);
       Button button=(Button)findViewById(R.id.button2);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s1=edittext1.getText().toString();
                 String s2=edittext2.getText().toString();
                 if (TextUtils.isEmpty(s1)){
                     edittext1.setError("Enter Your Username");
                     edittext2.requestFocus();
                     return;
                 }
                 Boolean onError = false;
                 if (!isValidEmail(s1)) {
                     onError = true;
                     edittext1.setError("Invalid Email");
                     return;
                 }
                 if (TextUtils.isEmpty(s2)){
                     edittext2.setError("Enter Password ");
                     edittext2.requestFocus();
                     return;
                 }
                 mAuth.signInWithEmailAndPassword(s1,s2)
                         .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 //Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                 // If sign in fails, display a message to the user. If sign in succeeds
                                 // the auth state listener will be notified and logic to handle the
                                 // signed in user can be handled in the listener.


                                 ProgressDialog.show(login.this,"Logging In","Please Wait ..");
                                 Toast.makeText(login.this, "Welcome To After Engg", Toast.LENGTH_SHORT).show();
                                 Save.save(getApplicationContext(),"session","true");
                                 Intent i=new Intent(login.this,MainActivity.class);
                                 startActivity(i);
                                 finish();

                                 // ...
                             }
                         });
             }
         });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k= new Intent (login.this,Register.class);
                startActivity(k);

            }
        });
    }



    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
