package volkanhotur.com.sample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
                .setHeaderColor(0XFF828282)
                .setPositiveButtonText("OKAY")
                .setNegativeButtonText("CANCEL")
                .setNeutralButtonText("LATER")
                .setPositiveButtonColor(0XFF828282)
                .setNegativeButtonColor(0XFF828282)
                .setNeutralButtonColor(0XFF828282)
                .setButtonRadius(100f)
                .setDialogRadius(25f)
                .setTextAppearaence(Alerty.MEDIUM_TEXT)
                .setTitleTextColor(0xFF000000)
                .setPositiveListener(new AlertyListener() {
                    @Override
                    public void onDialogClick(Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .build();
    }
}
