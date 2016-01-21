package alex.rigeditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewRig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rig);

        Button createButton = (Button)findViewById(R.id.createButton);
        final EditText rigName = (EditText)findViewById(R.id.rigName);

        createButton.setText(R.string.createButtonValue);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewRig.this, EditRig.class);
                String rignameText = "Éléments de " + rigName.getText().toString();
                i.putExtra("rigname", rignameText);
                startActivity(i);
            }
        });
    }
}
