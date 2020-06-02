package com.danaher.bt.layoutcomposer_10.components;

import android.view.ViewGroup;

public interface Component {

    void add(Component component);
    void setContent(int id);
    void inflate(ViewGroup layout);
}

