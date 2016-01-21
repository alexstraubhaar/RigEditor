package alex.rigeditor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import alex.rigeditor.data.Element;
import alex.rigeditor.data.Rig;

public class EditRig extends AppCompatActivity {

    public ListView elementList;
    public ArrayList<String> stringArrayList;
    public ArrayAdapter<String> adapter;
    public String marque;
    public String model;
    public String type;

    public String title;

    public Rig newRig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rig);

        // Récupération du nom
        title = getIntent().getStringExtra("rigname");
        this.setTitle("Éléments de " + title);

        // Récupération des widgets
        elementList = (ListView)findViewById(R.id.elementsList);
        final Spinner typeList = (Spinner)findViewById(R.id.typeListe);
        Button addButton = (Button)findViewById(R.id.addElementButton);
        final EditText marqueEdit = (EditText)findViewById(R.id.brandText);
        final EditText modelEdit = (EditText)findViewById(R.id.modelText);

        stringArrayList = new ArrayList<String>();
        marque = marqueEdit.getText().toString();
        model = modelEdit.getText().toString();
        type = typeList.getSelectedItem().toString();

        adapter = new ArrayAdapter<String>(EditRig.this, R.layout.mon_layout_adapter);
        elementList.setAdapter(adapter);

        // Rig
        newRig = new Rig(title);

        // Validation
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (marque == "" && model == "")
                {
                    Toast.makeText(EditRig.this, "Entrez une marque et un model !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    marque = marqueEdit.getText().toString();
                    model = modelEdit.getText().toString();
                    type = typeList.getSelectedItem().toString();

                    stringArrayList.add(marque + " " + model + " " + type);
                    adapter.add(stringArrayList.get(stringArrayList.size()-1));

                    newRig.addElement(marque + " " + model, new Element(marque, model, null, type));
                }
            }
        });

        // Sauvegarde
        Button buttonSave = (Button)findViewById(R.id.saveButton);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application app = getApplication();
                Intent i = new Intent(EditRig.this, MainActivity.class);
                SharedPreferences mPrefs=app.getSharedPreferences(app.getApplicationInfo().name, Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=mPrefs.edit();
                Gson gson = new Gson();
                ed.putString(title, gson.toJson(newRig));
                ed.commit();
                startActivity(i);
            }
        });

    }
}
