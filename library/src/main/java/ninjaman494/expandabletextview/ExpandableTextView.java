package ninjaman494.expandabletextview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/** A custom View which replicates the Google Play Store dropdown description. Uses two TextViews
 * to achieve this effect, one for the "blurb" and another for the full description("desp"). Each
 * half of the View can be independently stylized.
 *
 * Usage:
 *  Use as a regular view. To activate dropdown, call toggle()
 *  setBlurbText: set the text for blurb portion
 *  setDespText: set the text for the description portion
 *
 * Optional Attributes(currently not in XML):
 *  startExpanded: starts the View expanded instead of collapsed
 *  setCollapsedLineCount: set the number of lines for the blurb. Default is 3.
 *
 * Created by ninjaman494 on 5/23/2017.
 */
public class ExpandableTextView extends LinearLayout {
    private TextView blurbView;
    private TextView despView;
    private boolean isExpanded = false;
    private int collapsedLineCount = 2;

    private void init(Context context){
        View root = inflate(context,R.layout.expandable_textview,this);
        blurbView = (TextView)root.findViewById(R.id.blurbView);
        despView = (TextView)root.findViewById(R.id.despView);

        this.setOrientation(VERTICAL);
        int blurbHeight = blurbView.getLineHeight() * blurbView.getMaxLines();
        blurbView.setHeight(blurbHeight);
    }

    public ExpandableTextView(Context context) {
        super(context);
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public boolean isExpanded(){
        return isExpanded;
    }

    public void startExpanded(boolean expanded){
        isExpanded = expanded;
        if(isExpanded){
            despView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    public void setCollapsedLineCount(int lineCount){
        collapsedLineCount = lineCount;
        blurbView.setMaxLines(collapsedLineCount);

        int blurbHeight = blurbView.getLineHeight() * blurbView.getMaxLines();
        blurbView.setHeight(blurbHeight);
    }

    public void setBlurbText(String text){
        blurbView.setText(text);
    }

    public void setDespText(String text){
        despView.setText(text);
    }

    public TextView getBlurbView(){
        return blurbView;
    }

    public TextView getDespView(){
        return despView;
    }

    public void toggle() {
        if (!isExpanded) {
            System.out.println("Expanding");
            isExpanded = true;
            despView.setMaxLines(Integer.MAX_VALUE);

            int expandedHeight = despView.getLineCount() * despView.getLineHeight();
            ObjectAnimator animation = ObjectAnimator.ofInt(despView, "Height",expandedHeight);
            animation.setDuration(375);
            animation.start();
        } else {
            System.out.println("Collapsing");
            isExpanded = false;
            despView.setMaxLines(0);

            ObjectAnimator animation = ObjectAnimator.ofInt(despView, "Height",0);
            animation.setDuration(375);
            animation.start();
        }
    }
}
