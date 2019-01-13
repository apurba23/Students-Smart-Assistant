package com.example.undefined.studentsassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<StudentModel> stlist;
    CustomAdapter(Context context,List<StudentModel> stlist){
        this.context=context;
        this.stlist=stlist;
    }
    @Override
    public int getCount() {
        return stlist.size();
    }

    @Override
    public Object getItem(int position) {
        return stlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if(convertview==null)
        {
            convertview=inflater.inflate(R.layout.childview,null);
        }
        TextView name=convertview.findViewById(R.id.textView3);
        TextView semester=convertview.findViewById(R.id.textView4);
        TextView cgpa=convertview.findViewById(R.id.textView5);
        TextView performance_cgpa=convertview.findViewById(R.id.textView6);
        TextView performance_result=convertview.findViewById(R.id.textView7);

        name.setText("Name:"+stlist.get(position).name);
        semester.setText("Semester: "+stlist.get(position).semester);
        cgpa.setText("CGPA: "+stlist.get(position).cgpa);
        performance_cgpa.setText("Co-Curriculum CGPA: "+stlist.get(position).performance_cgpa);
        performance_result.setText("Performance Result: "+stlist.get(position).performance_result);
        return convertview;
    }
}
