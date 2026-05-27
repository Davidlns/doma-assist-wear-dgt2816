# Trabalho Pratico DGT2816 - Interacao com sensores de smartphones e wearables

Projeto Wear OS baseado no roteiro fornecido para a disciplina, com foco em deteccao de saidas de audio, suporte a acessibilidade e integracao com Bluetooth.

## Nome do app

- `ListaDeTarefas`
- `Package`: `com.example.listadetarefas`
- `Minimum SDK`: API 30 (Android 11)

## Funcionalidades implementadas

- Tela principal com `ListView` e `Button`.
- Permissoes declaradas:
  - `android.permission.BODY_SENSORS`
  - `android.permission.WAKE_LOCK`
- `intent-filter` para abrir a `MainActivity` como launcher.
- Enumeracao de saidas de audio com `AudioManager.getDevices(GET_DEVICES_OUTPUTS)`.
- Verificacao de speaker interno (`TYPE_BUILTIN_SPEAKER`).
- Verificacao de Bluetooth A2DP (`TYPE_BLUETOOTH_A2DP`).
- Callback dinamico de conexao/desconexao com `registerAudioDeviceCallback`.
- Atalho para configuracoes Bluetooth com `Settings.ACTION_BLUETOOTH_SETTINGS`.

## Estrutura principal

- `app/src/main/java/com/example/listadetarefas/MainActivity.java`
- `app/src/main/java/com/example/listadetarefas/AudioHelper.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/AndroidManifest.xml`
- `docs/Documentacao_Trabalho_Pratico.pdf`

## Evidencias para entrega

As evidencias de execucao/captura devem ser geradas por voce no Android Studio e no app complementar do Wear:

- Captura do app no emulador Wear OS.
- Captura feita pelo app complementar no smartphone.

Use a pasta `docs/evidencias/` para anexar as imagens antes da submissao final.

## Como abrir

1. Abrir a pasta do projeto no Android Studio.
2. Aguardar a sincronizacao Gradle.
3. Criar/selecionar emulador Wear OS API 30.
4. Executar o app.
