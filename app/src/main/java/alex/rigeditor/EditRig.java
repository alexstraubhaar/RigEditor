package alex.rigeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import alex.rigeditor.data.ElementType;

public class EditRig extends AppCompatActivity {

    private String[] typeArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rig);

        // Récupération du nom
        this.setTitle(getIntent().getStringExtra("rigname"));

        // Récupération des widgets
        final ListView elementList = (ListView)findViewById(R.id.elementsList);
        Spinner typeList = (Spinner)findViewById(R.id.typeListe);
        Button addButton = (Button)findViewById(R.id.addElementButton);
        final EditText marqueEdit = (EditText)findViewById(R.id.brandText);
        final EditText modelEdit = (EditText)findViewById(R.id.modelText);

        // Validation
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (marqueEdit.getText().toString().matches("") && modelEdit.getText().toString().matches(""))
                {
                    Toast.makeText(EditRig.this, "Entrez une marque et un model !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    
                }
            }
        });

    }
}
