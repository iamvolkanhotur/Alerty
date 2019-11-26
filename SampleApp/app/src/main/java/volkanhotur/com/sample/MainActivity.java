package volkanhotur.com.sample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.volkanhotur.alerty.Alerty;
import com.volkanhotur.alerty.AlertyListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Alerty.Builder(this)
                .setTitle("Test Title")
                .setMessage("Test Message Dialog")
                .setCancellable(false)
                .setPositiveButtonText("DONE")
                .setNegativeButtonText("CANCEL")
                .setHeaderImage(R.drawable.ic_message_red)
                .setPositiveButtonColor(0XFF0EC432)
                .setNegativeButtonColor(0XFF828282)
                .setButtonRadius(16f)
                .setDialogRadius(16f)
                .setTextAppearance(Alerty.MEDIUM_TEXT)
                .setTitleTextColor(0xFF000000)
                .setPositiveListener(new AlertyListener() {
                    @Override
                    public void onDialogClick(Dialog dialog) {
                        Toast.makeText(MainActivity.this, "DONE!", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
