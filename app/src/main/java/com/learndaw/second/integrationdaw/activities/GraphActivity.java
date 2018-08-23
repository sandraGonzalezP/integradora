package com.learndaw.second.integrationdaw.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.learndaw.second.integrationdaw.R;
import com.learndaw.second.integrationdaw.objects.GradeClass;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("Units");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



    private BarChart barChart;
    private String[] unit = new String[]{"UnidadI", "UnidadII", "UnidadIII", "UnidadIV", "UnidadV"};
    //Datos de manera vertical

    private int[] grade = new int[5];
    private ProgressDialog progressDialog;

    //Agregamos colores
    private int[] colors = new int[]{Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.DKGRAY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        progressDialog = new ProgressDialog(GraphActivity.this);
        progressDialog.setMessage(getString(R.string.loading_data));
        barChart=(BarChart)findViewById(R.id.bar_chart);
        progressDialog.show();

        ref.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GradeClass grades = dataSnapshot.getValue(GradeClass.class);
                grade[0] = grades.getUnit_one();
                grade[1] = grades.getUnit_two();
                grade[2] = grades.getUnit_three();
                grade[3] = grades.getUnit_four();
                grade[4] = grades.getUnit_five();


                crateCharts();
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(GraphActivity.this, R.string.error_load_information, Toast.LENGTH_LONG).show();

            }
        });




    }

    //Metodo de actividades que llevan todos los tipos de graficas
    private Chart getSameChart(Chart chart, String description, int textColor, int background, int animateY) {
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        legend(chart);

        return chart;
    }

    //Personalizate Legend
    private void legend(Chart chart) {
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < unit.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = unit[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }


    //BarGraph

    private ArrayList<BarEntry> getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < grade.length; i++)
            entries.add(new BarEntry(i,grade[i]));
        return entries;
    }
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(unit));
        axis.setEnabled(false);
    }
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(10);
        axis.setAxisMinimum(0);
    }
    private void axisRigth(YAxis axis){
        axis.setEnabled(false);

    }

    public void crateCharts() {

        barChart = (BarChart) getSameChart(barChart, " ", Color.GRAY, Color.WHITE, 3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawGridBackground(true);
        barChart.setData(getBarData());
        barChart.invalidate();

        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRigth(barChart.getAxisRight());
        barChart.getLegend().setEnabled(true);
    }

    private DataSet getData(DataSet dataSet) {
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10);
        return dataSet;
    }


    private BarData getBarData() {
        BarDataSet barDataSet = (BarDataSet) getData(new BarDataSet(getBarEntries(), ""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData= new BarData(barDataSet);
        barData.setBarWidth(1.40f);

        return new BarData(barDataSet);

    }

}
