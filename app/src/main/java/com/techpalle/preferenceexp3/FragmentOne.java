package com.techpalle.preferenceexp3;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    EditText editTextName, editTextSubject, editTextEmail;
    Button buttonSubmit, buttonEdit;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    TextView textView, textView1;
    int j;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        editTextName = (EditText) v.findViewById(R.id.edit_text_name);
        editTextSubject = (EditText) v.findViewById(R.id.edit_text_subject);
        editTextEmail = (EditText) v.findViewById(R.id.edit_text_email);
        textView = (TextView) v.findViewById(R.id.text_view);
        buttonSubmit = (Button) v.findViewById(R.id.button_Submit);
        buttonEdit = (Button) v.findViewById(R.id.button_edit);
        spinner = (Spinner) v.findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        adapter.add("Select");
        adapter.add("Name");
        adapter.add("Subject");
        adapter.add("Email");
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        SharedPreferences sharedPreferences  = getActivity().getSharedPreferences("contain", 0);
        int count = sharedPreferences.getInt("count", 0);
        if(count==1){
            String name = sharedPreferences.getString("name", null);
            String subject = sharedPreferences.getString("subject", null);
            String email = sharedPreferences.getString("email", null);
            textView.setText(" Name : "+ name+"\n Subject : "+subject+"\n Email : "+email);
        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences  = getActivity().getSharedPreferences("contain", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("count", 1);
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String email = sharedPreferences.getString("email", null);
             //   boolean b = email.matches(emailPattern);
                if(editTextName.getText().toString().trim().isEmpty()|| editTextSubject.getText().toString().trim().isEmpty()
                        || editTextEmail.getText().toString().trim().isEmpty() )
                {
                    android.support.v4.app.DialogFragment dialogFragment = new DialogFragment();
                    dialogFragment.show(getFragmentManager(),null);
                }
                else{
                    editor.putString("name", editTextName.getText().toString().trim());
                    editor.putString("subject", editTextSubject.getText().toString().trim());
                    editor.putString("email", editTextEmail.getText().toString().trim());
                    editor.commit();
                    editTextName.setText("");
                    editTextSubject.setText("");
                    editTextEmail.setText("");
                    editTextName.requestFocus();
                }
                String name = sharedPreferences.getString("name", null);
                String subject = sharedPreferences.getString("subject", null);
                textView.setText(" Name : "+ name+"\n Subject : "+subject+"\n Email : "+email);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                j =i;
                SharedPreferences sharedPreferences  = getActivity().getSharedPreferences("contain", 0);
                switch (i){
                    case 0 :
                        editTextName.setEnabled(true);
                        editTextSubject.setEnabled(true);
                        editTextEmail.setEnabled(true);
                        buttonSubmit.setEnabled(true);
                        buttonEdit.setEnabled(false);
                        editTextName.setText("");
                        editTextSubject.setText("");
                        editTextEmail.setText("");
                        editTextName.requestFocus();
                        break;
                    case 1 :
                        editTextName.setEnabled(true);
                        editTextSubject.setEnabled(false);
                        editTextEmail.setEnabled(false);
                        editTextName.requestFocus();
                        buttonSubmit.setEnabled(false);
                        buttonEdit.setEnabled(true);
                        editTextName.setText(sharedPreferences.getString("name", null));
                        editTextSubject.setText(sharedPreferences.getString("subject", null));
                        editTextEmail.setText(sharedPreferences.getString("email", null));
                        break;
                    case 2 :
                        editTextName.setEnabled(false);
                        editTextSubject.setEnabled(true);
                        editTextEmail.setEnabled(false);
                        editTextSubject.requestFocus();
                        buttonSubmit.setEnabled(false);
                        buttonEdit.setEnabled(true);
                        editTextName.setText(sharedPreferences.getString("name", null));
                        editTextSubject.setText(sharedPreferences.getString("subject", null));
                        editTextEmail.setText(sharedPreferences.getString("email", null));
                        break;
                    case 3 :
                        editTextName.setEnabled(false);
                        editTextSubject.setEnabled(false);
                        editTextEmail.setEnabled(true);
                        editTextEmail.requestFocus();
                        buttonSubmit.setEnabled(false);
                        buttonEdit.setEnabled(true);
                        editTextName.setText(sharedPreferences.getString("name", null));
                        editTextSubject.setText(sharedPreferences.getString("subject", null));
                        editTextEmail.setText(sharedPreferences.getString("email", null));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences  = getActivity().getSharedPreferences("contain", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                android.support.v4.app.DialogFragment dialogFragment = new DialogFragment();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String email = sharedPreferences.getString("email", null);
                boolean b = email.matches(emailPattern);

                switch (j){
                    case 1 :if(editTextName.getText().toString().trim().isEmpty())
                    {
                        dialogFragment.show(getFragmentManager(),null);
                    }
                    else {
                        editor.putString("name", editTextName.getText().toString().trim());
                        editor.commit();
                    }
                        break;
                    case 2 :if(editTextSubject.getText().toString().trim().isEmpty())
                    {
                        dialogFragment.show(getFragmentManager(),null);
                    }
                    else {
                        editor.putString("subject", editTextSubject.getText().toString().trim());
                        editor.commit();
                    }
                        break;
                    case 3 :if(editTextEmail.getText().toString().trim().isEmpty() || b == true)
                    {
                        dialogFragment.show(getFragmentManager(),null);
                    }
                    else {
                        editor.putString("email", editTextEmail.getText().toString().trim());
                        editor.commit();
                    }
                        break;
                }
                String name = sharedPreferences.getString("name", null);
                String subject = sharedPreferences.getString("subject", null);
                textView.setText(" Name : "+ name+"\n Subject : "+subject+"\n Email : "+email);
            }
        });
        return v;

    }



}
