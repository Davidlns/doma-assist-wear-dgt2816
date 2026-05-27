# Documentacao do Projeto - Trabalho Pratico DGT2816

## 1. Identificacao

- Disciplina: DGT2816 - Interacao com sensores de smartphones e wearables
- Projeto: ListaDeTarefas (Wear OS)
- Objetivo: app para comunicacao/acessibilidade com foco em uso de audio e deteccao de saidas de audio.

## 2. Microatividades executadas no projeto

### Microatividade 1 - Visao geral e melhores praticas

- Ambiente estruturado para Android Studio.
- Projeto preparado para execucao em emulador Wear OS.

### Microatividade 2 - Novo projeto no Android Studio

- Projeto Wear OS criado com base em `No Activity`.
- Nome: `ListaDeTarefas`.
- Pacote: `com.example.listadetarefas`.
- Min SDK: API 30.

### Microatividade 3 - Arquivos de logica e configuracoes

- `MainActivity.java` adicionada com interface e logica.
- `activity_main.xml` contendo `ListView` e `Button`.
- `AndroidManifest.xml` com:
  - `BODY_SENSORS`
  - `WAKE_LOCK`
  - `intent-filter` com `MAIN` e `LAUNCHER`.
- Dependencias e configuracoes no Gradle.

### Microatividade 4 - Criacao de emulador

- Projeto pronto para executar no emulador Wear OS.
- Evidencia visual deve ser anexada pelo aluno em `docs/evidencias/`.

### Microatividade 5 - Capturas com app complementar

- Roteiro de captura com app complementar previsto.
- Evidencias visuais devem ser anexadas pelo aluno em `docs/evidencias/`.

## 3. Implementacao do Trabalho Pratico (audio e acessibilidade)

### 3.1 Deteccao de saida de audio

Implementado em `AudioHelper.java`:

- `audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)`
- `audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)`
- Enumeracao por `AudioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)`

### 3.2 Deteccao dinamica

Implementado em `MainActivity.java`:

- Registro de callback via `registerAudioDeviceCallback`.
- Tratamento para conexao e desconexao de audio Bluetooth.

### 3.3 Facilitar conexao Bluetooth

Implementado em `AudioHelper.java`:

- Intent para `Settings.ACTION_BLUETOOTH_SETTINGS`.
- Extras de filtro para facilitar o fluxo de conexao.

### 3.4 Interface do app

Implementado em `activity_main.xml` e `MainActivity.java`:

- Botao para verificar audio.
- Lista de tarefas/funcoes relacionadas ao contexto da empresa Doma.
- Status atualizado de speaker e Bluetooth.

## 4. Evidencias para anexar antes da entrega

Inserir os arquivos abaixo na pasta `docs/evidencias/`:

1. `01_android_studio_emulador.png`
2. `02_app_rodando_wearos.png`
3. `03_captura_app_complementar_wear.png`
4. `04_notificacao_envio_captura.png`

## 5. Como executar

1. Abrir o projeto no Android Studio.
2. Sincronizar Gradle.
3. Criar emulador Wear OS API 30 no Device Manager.
4. Executar o app no emulador.
5. Gerar capturas e anexar em `docs/evidencias/`.

## 6. Entrega final (conforme roteiro)

1. Armazenar o projeto no Git.
2. Anexar esta documentacao em PDF no repositorio.
3. Compartilhar link do repositorio com o tutor.
4. Respeitar o prazo da disciplina.
