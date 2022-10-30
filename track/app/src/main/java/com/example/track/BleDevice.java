package com.example.track;

import android.bluetooth.BluetoothDevice;

public class BleDevice {
    private BluetoothDevice mBluetoothDevice;
    private int rssi;
    private String mRealName;

    /**
     *
     * @param bluetoothDevice:蓝牙设备
     * @param rssi:信号强度
     * @param realName:真实名称
     */
    public BleDevice(BluetoothDevice bluetoothDevice, int rssi, String realName) {
        this.mBluetoothDevice = bluetoothDevice;
        this.rssi = rssi;
        this.mRealName = realName;
    }

    public BluetoothDevice getBluetoothDevice() {
        return mBluetoothDevice;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getRealName() {
        return mRealName;
    }

    public void setRealName(String realName) {
        this.mRealName = realName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BleDevice) {
            final BleDevice device = (BleDevice) obj;
            return mBluetoothDevice.getAddress().equals(device.mBluetoothDevice.getAddress());
        }
        return super.equals(obj);
    }
}
