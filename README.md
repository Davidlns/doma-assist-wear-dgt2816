# Doma Assist Wear - Trabalho Pratico DGT2816

Projeto Wear OS baseado no roteiro fornecido para a disciplina, com foco em deteccao de saidas de audio, suporte a acessibilidade e integracao com Bluetooth.

## Desenvolvedor

- David Lins Amaral

## Nome do app

- `Doma Assist Wear`
- `Package`: `com.example.domaassistwear`
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

- `app/src/main/java/com/example/domaassistwear/MainActivity.java`
- `app/src/main/java/com/example/domaassistwear/AudioHelper.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/AndroidManifest.xml`
- `docs/Documentacao_Trabalho_Pratico.pdf`

## Evidencias para entrega

As evidencias de execucao/captura foram organizadas na pasta `docs/evidencias/`.

- `01_android_studio_emulador.png`: Device Manager com emulador Wear OS criado.
- `02_app_rodando_wearos.png`: app executando no emulador Wear OS.

A captura pelo app complementar do Wear depende de um wearable real pareado com smartphone. Como o ambiente utilizado foi o emulador Wear OS, a validacao visual foi feita pelo Android Studio.

## Como abrir

1. Abrir a pasta do projeto no Android Studio.
2. Aguardar a sincronizacao Gradle.
3. Criar/selecionar emulador Wear OS API 30.
4. Executar o app.
