package sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ninjaman494.expandabletextview.ExpandableTextView;
import ninjaman494.sample.R;


public class MainActivity extends AppCompatActivity {
    String blurbExample = "BrickHack brings designers, developers, and all sorts of makers together for 24 hours to create the impossible!";
    String despExample = "Mentors and industry representatives will lend expertise and watch as you dive into learning, developing, and producing a unique project." +
            "From noon February 11 to noon February 12, you'll join a team or work solo in RIT's Clark Gym. " +
            "If you'd like to see how to get around the RIT campus, see our parking instructions and RIT's map.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ExpandableTextView etv = (ExpandableTextView)findViewById(R.id.expandable);
        etv.setBlurbText(blurbExample);
        etv.setDespText(despExample);

        etv.setAnimSpeed(150);
        etv.setCollapsedLineCount(4);
        TextView blurb = etv.getBlurbView();
        blurb.setGravity(Gravity.CENTER);
        blurb.setTypeface(null, Typeface.BOLD);
        blurb.setTextSize(16);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etv.toggle();
            }
        });
    }
}
