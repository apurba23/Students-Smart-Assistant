package com.example.undefined.studentsassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import com.example.undefined.studentsassistant.R;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    List studentList;
    ListView listView;
    CustomAdapter adapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseFirestore.getInstance();
        listView=findViewById(R.id.listview);
        textView=findViewById(R.id.textView);
        String id=getIntent().getStringExtra("id");
        textView.setText("ID: "+id);
        getStudentInfo(id);
    }
    public void getStudentInfo(String id)
    {

        db.collection("tbl_student").whereEqualTo("id",id).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                studentList= new ArrayList();

                for(DocumentSnapshot doc:documentSnapshots)
                {
                    StudentModel model=doc.toObject(StudentModel.class);
                    Log.d("fbase",model.toString());
                    studentList.add(model);
                }
                adapter=new CustomAdapter(getBaseContext(),studentList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void LogOut(View view) {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
