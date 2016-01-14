package alex.rigeditor;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import alex.rigeditor.R;

public class EditRig extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rig);

        this.setTitle("Édition");
    }
}
