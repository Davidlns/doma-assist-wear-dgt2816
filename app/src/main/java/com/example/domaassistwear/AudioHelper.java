package com.example.domaassistwear;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.provider.Settings;

public class AudioHelper {
    private final Context context;
    private final AudioManager audioManager;

    public AudioHelper(Context context) {
        this.context = context;
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean audioOutputAvailable(int type) {
        if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            return false;
        }

        AudioDeviceInfo[] outputs = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS);
        for (AudioDeviceInfo device : outputs) {
            if (device.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public Intent bluetoothSettingsIntent() {
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("EXTRA_CONNECTION_ONLY", true);
        intent.putExtra("EXTRA_CLOSE_ON_CONNECT", true);
        intent.putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1);
        return intent;
    }

    public AudioManager getAudioManager() {
        return audioManager;
    }
}
