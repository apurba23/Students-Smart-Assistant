package com.example.undefined.studentsassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    FirebaseFirestore db;
    private EditText loginText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linar1);
        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView1.setText("Developed by Undefined");
        textView1.setBackgroundColor(0xff66ff66);
        textView1.setPadding(20, 20, 20, 20);
        linearLayout.addView(textView1);
        db=FirebaseFirestore.getInstance();
        loginText=findViewById(R.id.editText);
    }

    public void loginMethod(View view) {
        db.collection("tbl_student").whereEqualTo("id",loginText.getText().toString()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                if(documentSnapshots.isEmpty())
                {
                    Toast.makeText(getBaseContext(),"Login Failed!!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(),"Login Success!!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("id",loginText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}