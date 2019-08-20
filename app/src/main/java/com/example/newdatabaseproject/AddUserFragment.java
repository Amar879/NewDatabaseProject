package com.example.newdatabaseproject;

import android.location.Address;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddUserFragment extends Fragment {


    private EditText UserId, UserName, UserAddress;
    private Button BnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        UserId = view.findViewById(R.id.txt_user_id);
        UserName = view.findViewById(R.id.txt_user_name);

        UserAddress = view.findViewById(R.id.txt_user_address);

        BnSave = view.findViewById(R.id.bn_save_user);


        BnSave.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View view) {


                final int userId = Integer.parseInt(UserId.getText().toString());


                final String userName = UserName.getText().toString();


                final String userAddress = UserAddress.getText().toString();


                for (int i = 0; i < 500000; i++) {

                    final User user = new User();
                    user.setId(userId + i);
                    user.setName(userName);
                    user.setAddress(userAddress);


                    Thread thread = new Thread() {

                        public void run() {
                            try {

                                MainActivity.myAppDatabase.myDao().addUser(user);

                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    };


                    thread.start();

                }


                Toast.makeText(getActivity(), "User Added Successfully", Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserName.setText("");
                UserAddress.setText("");


            }



        });

        return view;

    }
}

