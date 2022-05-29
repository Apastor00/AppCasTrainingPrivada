package com.castraining.app_castraining_privada.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.castraining.app_castraining_privada.R;

import java.util.ArrayList;
import java.util.Map;

public class ExpanableAdapter extends BaseExpandableListAdapter {

    //Aquí pasamos cada categoría
    private ArrayList<String> listCategoria;
    /*Aquí pasamos los child de cada categoría. El primer String son las categorías y el segundo
    las child asociadas a cada categoría, como sólo ponemos uno, no lo hacemos ArrayList*/
    private Map<String, String > mapChild;
    //Le pasamos un contexto
    private Context context;

    public ExpanableAdapter(ArrayList<String> listCategoria, Map<String, String> mapChild, Context context) {
        this.listCategoria = listCategoria;
        this.mapChild = mapChild;
        this.context = context;
    }

    /** Todo lo que tenga que ver con Group son las categorías, los child son los grupos que despliegas*/
    @Override
    public int getGroupCount() {
        return listCategoria.size(); //Devolvemos el tamaño de la categoría
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //mapChild.get(groupPosition).size()
        //mapChild.get(listCategoria.get(groupPosition));
        return 1; //Devolvemos el tamaño de los child
    }

    @Override
    public Object getGroup(int groupPosition) {
        Object elemtGroup = listCategoria.get(groupPosition);
        return elemtGroup;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listCategoria.get(childPosition));
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        String tituloCategoria = getGroup(groupPosition).toString();
        view = LayoutInflater.from(context).inflate(R.layout.element_expanable_group, null);
        TextView expanableGroup = view.findViewById(R.id.expanableGroup);
        expanableGroup.setText(tituloCategoria);
        return view;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        //String childItem = getChild(groupPosition,childPosition).toString();
        String childItem = String.valueOf(getChild(groupPosition, groupPosition));
        view = LayoutInflater.from(context).inflate(R.layout.element_expanable_child, null);
        TextView expanableChild = view.findViewById(R.id.expanableChild);
        expanableChild.setText(Html.fromHtml(childItem));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
