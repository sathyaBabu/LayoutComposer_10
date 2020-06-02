package com.danaher.bt.layoutcomposer_10;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danaher.bt.layoutcomposer_10.components.Component;
import com.danaher.bt.layoutcomposer_10.components.CompositeImage;
import com.danaher.bt.layoutcomposer_10.components.CompositeLayer;
import com.danaher.bt.layoutcomposer_10.components.CompositeShell;
import com.danaher.bt.layoutcomposer_10.components.CompositeText;
import com.danaher.bt.layoutcomposer_10.components.ImageLeaf;
import com.danaher.bt.layoutcomposer_10.components.TextLeaf;


// c.add(...) takes all obj mindleassly into the component
// and gives it to the inflater to inflate
public class Builder {

           Component header;
           Component headline;


           Context context;

    Builder(Context context) {
        this.context = context;

        initLeaves();
    }

    private void initLeaves() {

//        header = new ImageLeaf(new ImageView(context),
//                R.drawable.header);
        header = new ImageLeaf(new ImageView(context),
                R.drawable.swheader);
        headline = new TextLeaf(new TextView(context),
                R.string.headline);
    }

    Component headerGroup() {
        Component ctext = new CompositeText(new TextView(context), R.string.story);
        Component c     = new CompositeImage(new ImageView(context), R.drawable.swheader);

        c.add(headline);
        ctext.add(c);

        return ctext;  // will inflate this in main
    }

    Component sandwichArray() {                     // just add 3 pic

        Component c = new CompositeShell();  // add set content inflate

//        c.add(setImage(R.drawable.sandwich1));
//        c.add(setImage(R.drawable.sandwich2));
//        c.add(setImage(R.drawable.sandwich3));
//        c.add(setImage(R.drawable.sandwich1));
//
        c.add(setImage(R.drawable.sandwichmeal2));
        c.add(setImage(R.drawable.sandwichmeal3));
      //  c.add(setImage(R.drawable.sandwichm));
        c.add(setImage(R.drawable.sandwich1));


        return c;
    }

    Component sandwichLayout() {
        Component c = new CompositeLayer(new LinearLayout(context),

             //   R.color.colorAccent);
       // R.drawable.sandwich2);
               R.color.colorLayoutBackground);  // create a linear layout
        c.add(sandwichArray());                  // then add 3 pic  traversing the node here.....
        return c;
    }

    Component story(){
        Component c = new CompositeText(new TextView(context)
                ,R.string.story);
        c.add(setImage(R.drawable.footer));
     //   c.add(setImage(R.drawable.swfooter));
        return c;
    }

    public TextLeaf setText(int t) {
        TextLeaf leaf = new TextLeaf(new TextView(context), t);
        return leaf;
    }

    public ImageLeaf setImage(int t) {
        ImageLeaf leaf = new ImageLeaf(new ImageView(context), t);
        return leaf;
    }



}
