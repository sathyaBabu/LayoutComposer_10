package com.danaher.bt.layoutcomposer_10.components;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CompositeImage implements Component {

    List<Component> components = new ArrayList<>();

    private ImageView imageView;

    public CompositeImage(ImageView imageView, int id) {

        this.imageView = imageView;
        setContent(id);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void setContent(int id) {
        imageView.setPadding(20,20,20,20);
        imageView.setImageResource(id);
        // Inject Picasso
    }

    @Override
    public void inflate(ViewGroup layout) {
        layout.addView(imageView);
        int count =0;

        for (Component component : components) {
            component.inflate(layout);
            Log.d("tag","Called in Composite Image "+count++);
        }
    }
}
