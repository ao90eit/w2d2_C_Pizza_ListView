package com.aoinc.w2d2_c_sqlite_pretty.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aoinc.w2d2_c_sqlite_pretty.R;
import com.aoinc.w2d2_c_sqlite_pretty.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaItemAdapter extends BaseAdapter {
    private PizzaDelegate pizzaDelegate;
    private List<Pizza> availablePizzas;

    public interface PizzaDelegate {
        void SelectPizza(Pizza selectedPizza);
    }

    public PizzaItemAdapter(PizzaDelegate pizzaDelegate, List<Pizza> availablePizzas) {
        this.pizzaDelegate = pizzaDelegate;
        this.availablePizzas = availablePizzas;
    }

    @Override
    public int getCount() {
        return availablePizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return availablePizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    // This is where we * inflate * our view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pizza item = availablePizzas.get(position);

        View mainView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_flavor_layout_item, parent, false);

        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                pizzaDelegate.SelectPizza((item));
            }
        });

        TextView pizzaFlavor = mainView.findViewById(R.id.pizza_flavor_textView);
        pizzaFlavor.setText(item.getPizzaFlavor());

        TextView pizzaPrice = mainView.findViewById(R.id.pizza_price_textview);
        pizzaPrice.setText("$" + item.getPizzaPrice());

        return mainView;
    }
}
