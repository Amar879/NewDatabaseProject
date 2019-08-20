package com.example.newdatabaseproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class DeleteUserFragment extends Fragment {
    private EditText TxtUserId;
    private Button DeleteButton,DeleteAllButton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        TxtUserId = view.findViewById(R.id.txt_delete_id);
        DeleteButton = view.findViewById(R.id.delete);

        DeleteAllButton = view.findViewById(R.id.bn_delete_all);



        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int id=Integer.parseInt(TxtUserId.getText().toString());
                User user= new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(),"User Removed from Database",Toast.LENGTH_SHORT).show();

                TxtUserId.setText("");

            }
        });
        DeleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.myAppDatabase.myDao().deleteAllUsers();
                Toast.makeText(getActivity(),"All Deleted ",Toast.LENGTH_SHORT).show();


            }
        });


        return view;
    }
}
