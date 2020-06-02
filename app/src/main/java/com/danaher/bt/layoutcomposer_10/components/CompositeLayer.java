package com.danaher.bt.layoutcomposer_10.components;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CompositeLayer implements Component {

    List<Component> components = new ArrayList<>();

    private LinearLayout linearLayout;

    public CompositeLayer(LinearLayout linearLayout, int id) {
        this.linearLayout = linearLayout;
        setContent(id);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void setContent(int id) {
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setBackgroundResource(id);
    }

    @Override
    public void inflate(ViewGroup layout) {

        layout.addView(linearLayout);
         int count = 0 ;
        for (Component component : components) {
            component.inflate(linearLayout);
            Log.d("tag","Called in Composite layer "+count++);
        }
    }
}
