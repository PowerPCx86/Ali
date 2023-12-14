package com.afaqalshark.android.play11;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.afaqalshark.android.play11.databinding.ActivityMainBinding;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainUI = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainUI.getRoot());

        mainUI.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = generateData(10);
        RecycleViewAdapter adapter = new RecycleViewAdapter(items);
        mainUI.recyclerView.setAdapter(adapter);
    }

    private List<Item> generateData(int amount)
    {
        Faker faker = new Faker();
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < amount; i++)
        {
            Item item = new Item();
            item.name = faker.name().fullName();
            item.description = faker.lorem().paragraph();
            items.add(item);
        }
        return items;
    }
}