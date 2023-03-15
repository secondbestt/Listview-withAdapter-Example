package self.is.kngg.com.example.shapelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shapee> shapeList = new ArrayList<Shapee>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shapee circle = new Shapee("0", "Circle", R.drawable.circle);
        shapeList.add(circle);

        Shapee triangle = new Shapee("1","Triangle", R.drawable.triangle);
        shapeList.add(triangle);

        Shapee square = new Shapee("2","Square", R.drawable.square);
        shapeList.add(square);

        Shapee rectangle = new Shapee("3","Rectangle", R.drawable.rectangle);
        shapeList.add(rectangle);

        Shapee octagon = new Shapee("4","Octagon", R.drawable.octagon);
        shapeList.add(octagon);

        Shapee circle2 = new Shapee("5", "Circle 2", R.drawable.circle);
        shapeList.add(circle2);

        Shapee triangle2 = new Shapee("6","Triangle 2", R.drawable.triangle);
        shapeList.add(triangle2);

        Shapee square2 = new Shapee("7","Square 2", R.drawable.square);
        shapeList.add(square2);

        Shapee rectangle2 = new Shapee("8","Rectangle 2", R.drawable.rectangle);
        shapeList.add(rectangle2);

        Shapee octagon2 = new Shapee("9","Octagon 2", R.drawable.octagon);
        shapeList.add(octagon2);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shapee selectShape = (Shapee) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

}