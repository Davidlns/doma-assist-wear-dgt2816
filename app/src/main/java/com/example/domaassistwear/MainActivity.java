package com.example.domaassistwear;

import android.app.Activity;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private final List<String> tarefas = new ArrayList<>();
    private AudioHelper audioHelper;
    private ArrayAdapter<String> adapter;
    private AudioDeviceCallback audioDeviceCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioHelper = new AudioHelper(this);

        Button btnVerificarAudio = findViewById(R.id.btnVerificarAudio);
        ListView listViewTarefas = findViewById(R.id.listViewTarefas);

        tarefas.add("Ler mensagens em voz alta");
        tarefas.add("Alerta de seguranca por audio");
        tarefas.add("Instrucao de treinamento por voz");
        tarefas.add("Lembrete de notificacoes importantes");

        adapter = new ArrayAdapter<>(this, R.layout.item_tarefa, tarefas);
        listViewTarefas.setAdapter(adapter);

        btnVerificarAudio.setOnClickListener(v -> verificarAudioEConexaoBluetooth());

        registrarCallbackDeAudio();
        atualizarStatusNaLista();
    }

    private void verificarAudioEConexaoBluetooth() {
        boolean speaker =
                audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER);
        boolean bluetooth =
                audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP);

        if (bluetooth) {
            Toast.makeText(this, "Fone Bluetooth conectado.", Toast.LENGTH_SHORT).show();
        } else if (speaker) {
            Toast.makeText(this, "Sem Bluetooth. Usando alto-falante do wearable.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nenhuma saida de audio detectada.", Toast.LENGTH_SHORT).show();
        }

        if (!bluetooth) {
            startActivity(audioHelper.bluetoothSettingsIntent());
        }

        atualizarStatusNaLista();
    }

    private void registrarCallbackDeAudio() {
        audioDeviceCallback = new AudioDeviceCallback() {
            @Override
            public void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
                atualizarStatusNaLista();
                if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)) {
                    Toast.makeText(MainActivity.this, "Bluetooth conectado.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
                atualizarStatusNaLista();
                if (!audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)) {
                    Toast.makeText(MainActivity.this, "Bluetooth desconectado.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        AudioManager audioManager = audioHelper.getAudioManager();
        audioManager.registerAudioDeviceCallback(audioDeviceCallback, null);
    }

    private void atualizarStatusNaLista() {
        boolean speaker =
                audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER);
        boolean bluetooth =
                audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP);

        String statusSpeaker = "Speaker interno: " + (speaker ? "disponivel" : "indisponivel");
        String statusBluetooth = "Bluetooth A2DP: " + (bluetooth ? "conectado" : "desconectado");

        if (tarefas.size() >= 6) {
            tarefas.set(4, statusSpeaker);
            tarefas.set(5, statusBluetooth);
        } else {
            tarefas.add(statusSpeaker);
            tarefas.add(statusBluetooth);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (audioDeviceCallback != null) {
            audioHelper.getAudioManager().unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }
}
