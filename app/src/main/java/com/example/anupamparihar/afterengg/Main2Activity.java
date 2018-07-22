package com.example.anupamparihar.afterengg;

import android.*;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.Manifest.*;

public class Main2Activity extends AppCompatActivity {

    Button button1;//select file
    Button button2;//upload file
    Button button3;//fetch file
    TextView textView;
    ProgressDialog progressDialog;
    Uri pdfuri; //uri are URL meant for local storage
    FirebaseStorage firebaseStorage; //used to upload file to storage

    FirebaseDatabase firebaseDatabase;  //used to store url of uploaded file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseStorage=FirebaseStorage.getInstance(); //returns an object of firebase
        firebaseDatabase=FirebaseDatabase.getInstance();
        button1=(Button)findViewById(R.id.bt1);
        button2=(Button)findViewById(R.id.bt2);
        button3=(Button)findViewById(R.id.bt3);

        textView=(TextView)findViewById(R.id.tv);

          button3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   Intent k= new Intent(Main2Activity.this,myrecylcerviewactivity.class);
                  startActivity(k);
              }
          });









        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Main2Activity.this, permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)
                {
                    selectPdf();

                }




                else
                    ActivityCompat.requestPermissions(Main2Activity.this,new String[]{permission.READ_EXTERNAL_STORAGE},9);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfuri!=null)  //checks if user has sellected file
                {
                    uploadFile(pdfuri);
                }
                else
                {
                    Toast.makeText(Main2Activity.this, "Select the file", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void uploadFile(Uri pdfuri) {




        progressDialog=new ProgressDialog(Main2Activity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Upload File");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName=System.currentTimeMillis()+".pdf";
       final String fileName1=System.currentTimeMillis()+"";
        StorageReference storageReference=firebaseStorage.getReference();//returns root path

        storageReference.child("Uploads").child(fileName).putFile(pdfuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        @SuppressWarnings("VisibleForTests")   String url=taskSnapshot.getDownloadUrl().toString();
                        //store url in real time database
                        DatabaseReference databaseRefrence=firebaseDatabase.getReference();//returns path to root
                        databaseRefrence.child(fileName1).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Main2Activity.this, "File Successfully Uploaded", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(Main2Activity.this, "File Not Uploaded", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {



                Toast.makeText(Main2Activity.this, "File Couldnt upload", Toast.LENGTH_SHORT).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                //track the progress

                @SuppressWarnings("VisibleForTests")     int currentprogress= (int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            Toast.makeText(Main2Activity.this, "Please Provide Permission!!", Toast.LENGTH_SHORT).show();
    }
    private void selectPdf() {
        //to offer user choice to select file using file manager
        //we will use intent to do this job
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT); //TO FETCH FILES
        startActivityForResult(intent,86);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //check wether user has selected a file or not
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
            pdfuri=data.getData();
            textView.setText("File selected is:"+ data.getData().getLastPathSegment().toString());
        }
        else
            Toast.makeText(Main2Activity.this, "Please Select a File", Toast.LENGTH_SHORT).show();
    }

}
