package com.example.track;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter mBluetoothAdapter;
    private Button mStartScanButton;
    private Button mStopScanButton;
    private EditText mTestNumText;
    private EditText mTestPersonText;
    private RecyclerView mDeviceListView;
    private List<BleDevice> mDeviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDeviceList = new ArrayList();
        initView();
    }

    public void initView() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mStartScanButton = findViewById(R.id.start_scan_button);
        mStopScanButton = findViewById(R.id.stop_scan_button);
        mTestNumText = findViewById(R.id.test_num);
        mTestPersonText = findViewById(R.id.test_person);
        mDeviceListView = findViewById(R.id.list_device);
    }

    /**
     * 打开蓝牙
     */
    private void enableBluetooth() {
        if (!mBluetoothAdapter.isEnabled())     mBluetoothAdapter.enable();
    }

    /**
     * 扫描周围的蓝牙设备
     */
    private ScanCallback callback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            BluetoothDevice bluetoothDevice = result.getDevice();
            if (!mDeviceList.contains(bluetoothDevice) && bluetoothDevice.getName() != null) {
                mDeviceList.add(bluetoothDevice);
            }
        }
    };

    /**
     * 添加扫描到的蓝牙设备到蓝牙列表中
     * @param bleDevice:扫描到的蓝牙设备
     * @return:添加后的蓝牙列表
     */
    private List<BleDevice> addDeviceToList(BleDevice bleDevice) {
        if (!mDeviceList.contains(bleDevice)) {
            bleDevice.setRealName(bleDevice == null ? "UNKNOWN" : bleDevice.getRealName());
            mDeviceList.add(bleDevice);
        } else {
            for (BleDevice device : mDeviceList) {
                device.setRssi(bleDevice.getRssi());
            }
        }
        mBluetoothAdapter.notifyDataChanged();
    }
}