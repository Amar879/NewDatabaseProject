package com.example.newdatabaseproject;

import android.location.Address;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ReadUserFragment extends Fragment {
    private TextView TxtFind;
    private EditText records;

    private Button FindButton, ViewAllButton;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
       // ScrollView scrollView=(view).findViewById(R.id.scrollView);
        //scrollView.scrollTo(0, 100);
        TxtFind = view.findViewById(R.id.txt_display_info);
        TxtFind.setMovementMethod(new ScrollingMovementMethod());

        records = view.findViewById(R.id.ed_find_id);



        FindButton = view.findViewById(R.id.bt_find_user);
        ViewAllButton = view.findViewById(R.id.bt_user_all);


        ViewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread=new Thread(){
                    public void run(){
                        List<User>users=MainActivity.myAppDatabase.myDao().findUsers();
                        String info="";
                        for(User usr:users){
                            int id=usr.getId();
                            String name=usr.getName();
                            String address=usr.getAddress();
                            info=info+"\n\n"+"Id : "+id+"\n name:"+name+"\n address:"+address;
                        }
                        TxtFind.setText(info);

                        try{
                            sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();


            }
        });

        FindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<User> users = MainActivity.myAppDatabase.myDao().findUser();
                String info = "";
                for (User usr : users) {
                    int id =Integer.parseInt(records.getText().toString());
                    usr.getId();
                    String name=usr.getName();
                    String address=usr.getAddress();

                    info=info+"\n\n"+"Id : "+id+"\n name:"+name+"\n address:"+address;
                }
                TxtFind.setText(info);

                Toast.makeText(getActivity(), "Record Founded by Id", Toast.LENGTH_SHORT).show();


            }
        });
    return view;
    }
}
