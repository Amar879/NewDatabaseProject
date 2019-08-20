package com.example.newdatabaseproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {
    private EditText UserId,UserName,UserAddress;
    private Button BnUpdate;


    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_user, container, false);
        UserId=view.findViewById(R.id.ed_update_userId);
        UserName=view.findViewById(R.id.ed_update_name);
        UserAddress=view.findViewById(R.id.ed_update_address);
        BnUpdate=view.findViewById(R.id.bn_update_user);

        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId = Integer.parseInt(UserId.getText().toString());
                String userName = UserName.getText().toString();
                String userAddress = UserAddress.getText().toString();


                User user = new User();
                user.setId(userId );
                user.setName(userName);
                user.setAddress(userAddress);

                MainActivity.myAppDatabase.myDao().userUpdate(user);

                Toast.makeText(getActivity(), "User Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
