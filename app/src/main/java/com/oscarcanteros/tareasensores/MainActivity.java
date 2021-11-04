package com.oscarcanteros.tareasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView txtSensor1, txtSensor2;

    Sensor sensor1, sensor2;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSensor1 = (TextView) findViewById(R.id.sensor1);
        txtSensor2 = (TextView) findViewById(R.id.sensor2);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor1 = (Sensor) sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor2 = (Sensor) sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, sensor1, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                txtSensor1.setText(String.valueOf(sensorEvent.values[0]));
                break;
            case Sensor.TYPE_LIGHT:
                txtSensor2.setText(String.valueOf(sensorEvent.values[0]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}