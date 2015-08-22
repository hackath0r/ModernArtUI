package course.lab.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class ModernArtUIActivity extends AppCompatActivity {

    private DialogFragment mDialog;

    // text views for which background color needs to be changed
    private TextView mtextview;
    private TextView mtextview3;
    private TextView mtextview4;
    private TextView mtextview5;

    // seeker bar
    private SeekBar mseekbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_art_ui);

        // Get the text views by their Ids
        mtextview = (TextView) findViewById(R.id.textView);
        mtextview3 = (TextView) findViewById(R.id.textView3);
        mtextview4 = (TextView) findViewById(R.id.textView4);
        mtextview5 = (TextView) findViewById(R.id.textView5);

        // Get the seeker bar by its Ids
        mseekbar = (SeekBar) findViewById(R.id.seekBar);

        mseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // If action is initiated by the uesr
                if(fromUser){
                    int R,G,B,R3,G3,B3,R4,G4,B4,R5,G5,B5;

                    R = 12 + progress;
                    G = 34 + progress;
                    B = 56 + progress;
                    R3 = 25 + progress;
                    G3 = 43 + progress;
                    B3 = 21 + progress;
                    R4 = 78 + progress;
                    G4 = 12 + progress;
                    B4 = 34 + progress;
                    R5 = 89 + progress;
                    G5 = 33 + progress;
                    B5 = 20 + progress;

                    // Set new color values
                    mtextview.setBackgroundColor(Color.rgb(R, G, B));
                    mtextview3.setBackgroundColor(Color.rgb(R3, G3, B3));
                    mtextview4.setBackgroundColor(Color.rgb(R4, G4, B4));
                    mtextview5.setBackgroundColor(Color.rgb(R5, G5, B5));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modern_art_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Create a new MoreInformationDialog
            mDialog = MoreInformationDialog.newInstance();

            // Show MoreInformationDialog
            mDialog.show(getFragmentManager(), "MoreInformation");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Class that creates the MoreInformationDialog
    public static class MoreInformationDialog extends DialogFragment {

        public static MoreInformationDialog newInstance() {
            return new MoreInformationDialog();
        }

        // Build MoreInformationDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.more_information_message)

                    // Set Visit MOMA button
                    .setPositiveButton("Visit MOMA",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Uri for MOMA webpage
                                    Uri webpage = Uri.parse("http://www.moma.org");
                                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                                    startActivity(intent);
                                }
                            })

                    // Set up Not Now Button
                    .setNegativeButton("Not Now",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })

                    .create();

        }
    }
}
