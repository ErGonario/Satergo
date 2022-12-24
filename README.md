# Satergo
Desktop wallet for the cryptocurrency Ergo with embedded node functionality. Downloads can be found at [the website](https://satergo.com).

Why use Satergo?
- **Secure**: Everything is encrypted and stored on your disk
- **Independent**: Host your own node if you want to
- **Invaluable**: Contribute to the Ergo network
- **Portable**: Does not depend on any other software being installed
- **Cross-platform**: Supports all major desktop platforms
- **Fully featured**: Has many features but is still easy to use
- **Reliable**: You can be sure about what runs on your computer
- **Light**: Usable in slow or portable operating system environments

## Supported platforms
More can easily be added.
- Windows (x64)
- Linux (x64 and aarch64)
- Mac (x64 and aarch64)
- Universal (Java 19+)

## Translating
To translate the program, open the directory src/main/resources/lang and duplicate Lang.properties.
Change the file name to Lang_ and the 3-letter code of your language (ISO-639-3) (for example Lang_ita.properties) and translate everything in the file.

Then, in the same folder, open the index.json file, add a comma to the last entry and make a new line inside the list like:
```json
	"???": { "name": "Name of the language in the language", "credit": "Your contact details (socials, etc.), or your name" }
```

## Build setup
If you don't want to download the prebuilt runtimes, you can build the wallet for yourself.

Java is not needed for running the prebuilt runtimes, because it is included in the runtime. But for building or running from sources, Java 19+ is required. The easiest way to download and install it is from [adoptium.net](https://adoptium.net).

To run the wallet from the sources, run the command `./gradlew run`.

To build a runtime, run `./gradlew satergoRuntime -Pplatform=<platform>`, where platform can be any of `win linux linux-aarch64 linux-arm32 mac mac-aarch64`.

To build runtimes for all platforms, run `./build-all-runtimes.sh`.

## License
- Project: see [LICENSE](LICENSE)
- Icons: see [icons.properties](src/main/resources/icons.properties)