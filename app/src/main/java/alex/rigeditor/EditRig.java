package alex.rigeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditRig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rig);

        // Récupération du nom
        this.setTitle("Édition de " + getIntent().getStringExtra("rigname"));
    }
}
