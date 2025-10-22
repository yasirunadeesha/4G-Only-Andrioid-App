# 4G-Only-Andrioid-App
4G Only is a lightweight Android app that quickly opens the hidden Phone Information screen, letting you set LTE-only (4G only) or NR-only (5G only) modes. It doesn’t change radio settings directly—just gives fast access. Features a simple Material UI, clear instructions, and handles blocked or missing pages gracefully.

### Highlights
- Launches the system Phone Information/RadioInfo screen directly
- Simple UI: About, Instructions, and Set 4G Only
- Material 3 styling with ConstraintLayout

### How it works
The app does not change radio settings itself. Instead, it opens the Android internal Phone Information (RadioInfo) activity if present on the device. From there, you can select the preferred network type (e.g., LTE only). Availability depends on OEM/ROM and Android version.

## Screens and Code Structure

- `MainActivity` (`app/src/main/java/com/techy404/FORGonly/MainActivity.java`)
  - Buttons: About, Instructions, Set 4G Only
  - On Android 11+ it targets `com.android.phone/.settings.RadioInfo`; on older versions `com.android.settings/.RadioInfo`

- `about` (`app/src/main/java/com/techy404/FORGonly/about.java`)
  - Shows developer card and social links

- `instructions` (`app/src/main/java/com/techy404/FORGonly/instructions.java`)
  - Step‑by‑step guide to select LTE Only in the RadioInfo screen

- Layouts (`app/src/main/res/layout`)
  - `activity_main.xml`: 3 primary actions with Material Buttons
  - `activity_about.xml`: profile card + social buttons
  - `activity_instructions.xml`: 5‑step instruction list

- Theming/Styles (`app/src/main/res/values`)
  - `themes.xml`, `themes-night.xml`, `styles.xml`, `colors.xml`
  - Material 3 DayNight, unified background color

- Manifest (`app/src/main/AndroidManifest.xml`)
  - Declares `READ_PHONE_STATE`, `MODIFY_PHONE_STATE`, `WRITE_SECURE_SETTINGS`
  - Theme: `Theme._4Gonly`

## Requirements

- Android Studio Hedgehog+ (or latest)
- Android SDK: compileSdk 34, targetSdk 34, minSdk 24
- Java 8 compatibility

## Build and Run

1. Open the project in Android Studio.
2. Let Gradle sync. The module is `app`.
3. Run on a physical device (recommended). Some emulators do not expose the RadioInfo screen.
4. Tap “Set 4G Only”. If supported, the system Phone Information screen will open.

### Gradle (CLI)

```bash
./gradlew assembleDebug
```
APK output: `app/build/outputs/apk/debug/`

## Usage

1. Open the app
2. Tap “Set 4G Only”
3. In the Phone Information page:
   - Tap “Set preferred network type”
   - Choose “LTE only” (or LTE variants available)
4. If dual‑SIM, select the appropriate phone index (SIM slot) first

## Compatibility and Limitations

- Availability of the RadioInfo activity varies by OEM, carrier, and Android version
- On some devices the activity is missing or blocked — the app will show a toast that it’s not accessible
- Even when accessible, OEM/carrier policies may ignore or revert LTE‑only selections
- Permissions like `MODIFY_PHONE_STATE` and `WRITE_SECURE_SETTINGS` are system‑level and not granted to normal apps; this app does NOT use them directly to change settings, but lists them to document intent and because some ROMs may allow the RadioInfo screen to function more fully

## Permissions Explained

- `READ_PHONE_STATE`: Read basic phone state; some devices use this for gating RadioInfo access
- `MODIFY_PHONE_STATE`: System/privileged permission; normal apps cannot obtain it from Play. Present here for transparency and for OEM builds where it may be granted
- `WRITE_SECURE_SETTINGS`: System/privileged; not granted to normal apps. Included for OEM/debug contexts

The app handles failures gracefully and informs the user if the screen cannot be opened.

## Tech Stack

- Language: Java
- UI: Material Components, ConstraintLayout
- Min SDK 24, Target/Compile SDK 34

## Project Structure

```
app/
  src/main/
    java/com/techy404/FORGonly/
      MainActivity.java
      about.java
      instructions.java
    res/
      layout/
        activity_main.xml
        activity_about.xml
        activity_instructions.xml
      values/ (themes, colors, styles, strings)
    AndroidManifest.xml
  build.gradle.kts
```

## Troubleshooting

- “Phone information settings are not accessible on this device.”
  - Your OEM/ROM removed or blocked the RadioInfo activity
  - Try a different device or ROM

- App opens but nothing happens when tapping Set 4G Only
  - Ensure you are not on a work profile or restricted user
  - Test on stock/near‑stock devices where possible

## Privacy

This app does not collect, store, or transmit personal data. It only attempts to open a system settings screen present on the device.

## Contributing

1. Fork the repo
2. Create a feature branch
3. Commit with clear messages
4. Open a Pull Request

## License

Recommended: Apache License 2.0. It’s Android‑ecosystem friendly, allows commercial and private use, and includes an express grant of patent rights.

If you adopt Apache‑2.0, add a `LICENSE` file with the full text and a short header in source files as needed.

## Acknowledgments

- Android Open Source Project (AOSP) for the RadioInfo screen components
- Material Components for Android


## Apk

- https://github.com/yasirunadeesha/4G-Only-Andrioid-App/blob/main/4G%20Only.apk
