# Xephira Dialer (`packages/apps/Dialer`)

Official native OnePlus OxygenOS / ColorOS Phone app extracted, decompiled, and adapted for **XephiraOS 1.0-Aether**.

---

## Features
- **OnePlus Signature Dialpad**: Signature tactile sounds, speed dial, and clean typography.
- **OxygenOS InCallUI**: Full integrated in-call screen with call recording controls and hold/mute.
- **Pantanal / Live Alert Hook**: Session state broadcast support for Dynamic Island live alert capsules.
- **Speed Dial & Call History**: T9 smart dialer searching contacts by name or number.
- **AOSP / LineageOS Integration**: Replaces standard AOSP `packages/apps/Dialer` and `InCallUI`.

---

## Architecture
- `src/`: Decompiled Java/Kotlin source code.
- `res/`: Complete decoded UI layouts, vector drawables, audio tones (`res/raw`), and localized strings.
- `assets/`: Lottie animation configurations and dialer schemas.
- `AndroidManifest.xml`: System-privileged telephony, call log, and in-call permissions.

---

## License
- **SPDX-License-Identifier**: Apache-2.0
