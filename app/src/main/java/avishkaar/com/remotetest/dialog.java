package avishkaar.com.remotetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.zip.Inflater;

public class dialog extends DialogFragment {
    Spinner motor_select;
    Spinner direction_select;
    String motor;
    String direction;
    Button button;
    public interface send_to_activity {
        public void stringforactivity(String motor, String configuration);

    }

    public send_to_activity implementInterface;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout, container, false);
        motor_select = view.findViewById(R.id.motor_select);
        direction_select = view.findViewById(R.id.direction);
        button = view.findViewById(R.id.button_dialog);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.motors, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motor_select.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.direction, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        direction_select.setAdapter(adapter2);

        motor_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                motor = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        direction_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                direction = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), motor + "    " + direction, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementInterface.stringforactivity(motor,direction);
                getDialog().dismiss();
            }

        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            implementInterface = (send_to_activity)getActivity();
        }catch (ClassCastException e){

        }
    }
}




