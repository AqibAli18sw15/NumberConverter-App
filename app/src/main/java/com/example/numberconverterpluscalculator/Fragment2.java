package com.example.numberconverterpluscalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private Spinner spi1;
    private Spinner spi2;
    private Spinner spi3;
    private EditText field1;
    private EditText field2;
    private TextView result;
    private String num1,num2;
    private String f1,f2;
    Long sum;
    Long reminder;
    private String temp1,temp2,res;
    boolean isThereAReminder;
    private Button bSum;
    private Button bSub;
    private Button bMul;
    private Button bDiv;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_2, container, false);

        spi1 = view.findViewById(R.id.spi1);
        spi2 = view.findViewById(R.id.spi2);
        spi3 = view.findViewById(R.id.spi3);
        field1 = view.findViewById(R.id.field1);
        field2 = view.findViewById(R.id.field2);
        result = view.findViewById(R.id.result2);
        res=result.getText().toString();
        ArrayList<String> spi1_items=new ArrayList<>();
        spi1_items.add("Decimal");
        spi1_items.add("Binary");
        spi1_items.add("Quinary");
        spi1_items.add("Octal");

        ArrayAdapter<String> for_spi1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,spi1_items);

        spi1.setAdapter(for_spi1);
        spi2.setAdapter(for_spi1);
        spi3.setAdapter(for_spi1);

        spi3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(result.getText().toString().matches("")){result.setText("");}
                else if(isThereAReminder){
                    String rem=reminder.toString(),divided=sum.toString();
                    switch (position){
                        case 0:result.setText(res); break;
                        case 1:result.setText(Converter.decToBin(divided)+" Reminder= "+Converter.decToBin(rem));break;
                        case 2:result.setText(Converter.decToQuin(divided)+" Reminder= " +Converter.decToQuin(rem));break;
                        case 3:result.setText(Converter.decToOctal(divided)+ " Reminder= "+Converter.decToOctal(rem) );break;
                    }

                }
                else{
                    switch (position){
                        case 0:result.setText(res); break;
                        case 1:result.setText(Converter.decToBin(res));break;
                        case 2:result.setText(Converter.decToQuin(res));break;
                        case 3:result.setText(Converter.decToOctal(res));break;

                    }}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bSum = view.findViewById(R.id.add);
        bSub = view.findViewById(R.id.sub);
        bMul = view.findViewById(R.id.mul);
        bDiv = view.findViewById(R.id.div);

        bSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAction(v);
            }
        });
        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subAction(v);
            }
        });
        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulAction(v);
            }
        });
        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divAction(v);
            }
        });


        return view;
    } //end of onCreateView method
    public void addAction(View v){
        field1 = view.findViewById(R.id.field1);
        field2 = view.findViewById(R.id.field2);
        result = view.findViewById(R.id.result2);
        f1=field1.getText().toString();
        f2=field2.getText().toString();
        temp1=f1;
        temp2=f2;
        isThereAReminder=false;
        if(isEmpty(f1,f2))result.setText("insert please!");
        else if(isError(spi1.getSelectedItem().toString(),temp1)||isError(spi2.getSelectedItem().toString(),temp2))result.setText("Error");
        else {
            if(spi1.getSelectedItem().toString().matches("Binary"))f1=Converter2.binToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Quinary"))f1=Converter2.quinToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Octal"))f1=Converter2.octToDec(f1);

            if(spi2.getSelectedItem().toString().matches("Binary"))f2=Converter2.binToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Quinary"))f2=Converter2.quinToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Octal"))f2=Converter2.octToDec(f2);

            long l1=Long.parseLong(f1);
            long l2=Long.parseLong(f2);

            sum=l1+l2;
            res=sum.toString();
            if(spi3.getSelectedItem().toString().matches("Decimal"))result.setText(res);
            else if(spi3.getSelectedItem().toString().matches("Binary"))result.setText(Converter.decToBin(res));
            else if(spi3.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.decToQuin(res));
            else if(spi3.getSelectedItem().toString().matches("Octal"))result.setText(Converter.decToOctal(res));

        }

    }//end of add Action
    public void subAction(View v){
        field1 = view.findViewById(R.id.field1);
        field2 = view.findViewById(R.id.field2);
        result = view.findViewById(R.id.result2);
        f1=field1.getText().toString();
        f2=field2.getText().toString();
        temp1=f1;
        temp2=f2;
        String temp3=temp1;
        String temp4=temp2;

        isThereAReminder=false;
        if(isEmpty(f1,f2))result.setText("insert please!");
        else if(isError(spi1.getSelectedItem().toString(),temp1)||isError(spi2.getSelectedItem().toString(),temp2))result.setText("Error");
        else if(Long.parseLong(convertToDecimal(spi1.getSelectedItem().toString(),temp3))<Long.parseLong(convertToDecimal(spi2.getSelectedItem().toString(),temp4))){result.setText("Please insert lesser value in num 2");}
        else {
            if(spi1.getSelectedItem().toString().matches("Binary"))f1=Converter2.binToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Quinary"))f1=Converter2.quinToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Octal"))f1=Converter2.octToDec(f1);

            if(spi2.getSelectedItem().toString().matches("Binary"))f2=Converter2.binToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Quinary"))f2=Converter2.quinToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Octal"))f2=Converter2.octToDec(f2);

            long l1=Long.parseLong(f1);
            long l2=Long.parseLong(f2);

            sum=l1-l2;
            res=sum.toString();
            if(spi3.getSelectedItem().toString().matches("Decimal"))result.setText(res);
            else if(spi3.getSelectedItem().toString().matches("Binary"))result.setText(Converter.decToBin(res));
            else if(spi3.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.decToQuin(res));
            else if(spi3.getSelectedItem().toString().matches("Octal"))result.setText(Converter.decToOctal(res));
        }

    }//end of subtract Action
    public void mulAction(View v){
        field1 = view.findViewById(R.id.field1);
        field2 = view.findViewById(R.id.field2);
        result = view.findViewById(R.id.result2);
        f1=field1.getText().toString();
        f2=field2.getText().toString();
        temp1=f1;
        temp2=f2;
        isThereAReminder=false;
        if(isEmpty(f1,f2))result.setText("insert please!");
        else if(isError(spi1.getSelectedItem().toString(),temp1)||isError(spi2.getSelectedItem().toString(),temp2))result.setText("Error");
        else {
            if(spi1.getSelectedItem().toString().matches("Binary"))f1=Converter2.binToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Quinary"))f1=Converter2.quinToDec(f1);
            else if(spi1.getSelectedItem().toString().matches("Octal"))f1=Converter2.octToDec(f1);

            if(spi2.getSelectedItem().toString().matches("Binary"))f2=Converter2.binToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Quinary"))f2=Converter2.quinToDec(f2);
            else if(spi2.getSelectedItem().toString().matches("Octal"))f2=Converter2.octToDec(f2);

            long l1=Long.parseLong(f1);
            long l2=Long.parseLong(f2);

            sum=l1*l2;
            res=sum.toString();
            if(spi3.getSelectedItem().toString().matches("Decimal"))result.setText(res);
            else if(spi3.getSelectedItem().toString().matches("Binary"))result.setText(Converter.decToBin(res));
            else if(spi3.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.decToQuin(res));
            else if(spi3.getSelectedItem().toString().matches("Octal"))result.setText(Converter.decToOctal(res));
        }

    }//end of Multiply
    public void divAction(View v){
        field1 = view.findViewById(R.id.field1);
        field2 = view.findViewById(R.id.field2);
        result = view.findViewById(R.id.result2);
        f1=field1.getText().toString();
        f2=field2.getText().toString();
        temp1=f1;
        temp2=f2;
        isThereAReminder=true;
        if(isEmpty(f1,f2))result.setText("insert please!");
        else if(isError(spi1.getSelectedItem().toString(),temp1)||isError(spi2.getSelectedItem().toString(),temp2))result.setText("Error");

        else {
            if (spi1.getSelectedItem().toString().matches("Binary")) f1 = Converter2.binToDec(f1);
            else if (spi1.getSelectedItem().toString().matches("Quinary"))
                f1 = Converter2.quinToDec(f1);
            else if (spi1.getSelectedItem().toString().matches("Octal"))
                f1 = Converter2.octToDec(f1);

            if (spi2.getSelectedItem().toString().matches("Binary")) f2 = Converter2.binToDec(f2);
            else if (spi2.getSelectedItem().toString().matches("Quinary"))
                f2 = Converter2.quinToDec(f2);
            else if (spi2.getSelectedItem().toString().matches("Octal"))
                f2 = Converter2.octToDec(f2);

            long l1 = Long.parseLong(f1);
            long l2 = Long.parseLong(f2);
            reminder = l1 % l2;
            sum = (l1 - reminder) / l2;
            res = sum + " Reminder= " + reminder;

            String rem = reminder.toString(), divided = sum.toString();
            if (spi3.getSelectedItem().toString().matches("Decimal")) result.setText(res);
            else if (spi3.getSelectedItem().toString().matches("Binary"))
                result.setText(Converter.decToBin(divided) + " Reminder= " + Converter.decToBin(rem));
            else if (spi3.getSelectedItem().toString().matches("Quinary"))
                result.setText(Converter.decToQuin(divided) + " Reminder= " + Converter.decToQuin(rem));
            else if (spi3.getSelectedItem().toString().matches("Octal"))
                result.setText(Converter.decToOctal(divided) + " Reminder= " + Converter.decToOctal(rem));

        }
    }//end of Divide action

    private boolean isError(String selected,String temp){
        String num=temp;
        if(selected.matches("Binary")){
            if(!Checker.isBinary(num))return true;
            else return false;
        }//end of binary
        else if(selected.matches("Quinary")){
            if(!Checker.isQuinary(num))return true;
            else return false;
        }//end of quinary checker
        else if(selected.matches("Octal")){
            if(!Checker.isOctal(num))return true;
            else return false;
        }//end of quinary checker
        else return false;

    }//end of convertToDecimal
    private String convertToDecimal(String s,String num){

        if(s.matches("Binary"))return Converter2.binToDec(num);
        else if(s.matches("Quinary"))return Converter2.quinToDec(num);
        else if(s.matches("Octal"))return Converter2.octToDec(num);
        else return num;
    }//end of convert
    public boolean isEmpty(String s, String s2){return (s.matches("")||s2.matches(""));}
}