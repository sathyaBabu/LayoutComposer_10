package com.danaher.bt.layoutcomposer_10;

import android.os.Bundle;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

/*

FlyweightPool can hold Inflated Layout builder to give seemless screen experience...
done by paging!
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Replace default layout

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundResource(R.color.colorLayoutBackground);

       // layout.setBackgroundResource(R.drawable.wallpaperr);
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        setContentView(layout);




        // Inflate components
        Builder builder = new Builder(this);  // UI

        // eg 1 & 2
        // builder.header.inflate(layout);  // this is not wraped around the object which formats by padding etc
                   //builder.headline.inflate(layout);

        // eg 3
        builder.headerGroup().inflate(layout); // It has a wrapper : also we r passing the layout as linear Layout to inflate data

        // eg 4
      // builder.sandwichArray().inflate(layout); // this inflates 3 pic in linear way

        // eg 5



                     builder.sandwichLayout().inflate(layout); //this inflates 3 pic in horizontally

                       builder.story().inflate(layout); // tells a story

        //////



    }
}
