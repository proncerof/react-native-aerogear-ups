
# react-native-aerogear-ups
Note that currently this module only works with android. In the coming weeks I will develop the iOS module.

## Getting started

`$ npm install react-native-aerogear-ups --save`

### Mostly automatic installation

`$ react-native link react-native-aerogear-ups`

#### Android
- Add the following line inside dependencies in `<PROJECT_ROOT>/build.gradle`
	```
	dependencies {
		...
		classpath 'com.google.gms:google-services:3.2.1'
	}
	```
- Add the `google-services.json` file to `<PROJECT_ROOT>/app/`. Download the `google-services.json` file as described in the [Google Documentation](https://support.google.com/firebase/answer/7015592?hl=en).


### Manual installation


<!-- #### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-aerogear-ups` and add `RNAerogearUps.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAerogearUps.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)< -->

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAerogearUpsPackage;` to the imports at the top of the file
  - Add `new RNAerogearUpsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-aerogear-ups'
  	project(':react-native-aerogear-ups').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-aerogear-ups/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-aerogear-ups')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAerogearUps.sln` in `node_modules/react-native-aerogear-ups/windows/RNAerogearUps.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Aerogear.Ups.RNAerogearUps;` to the usings at the top of the file
  - Add `new RNAerogearUpsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNAerogearUps from 'react-native-aerogear-ups';

// TODO: What to do with the module?
RNAerogearUps.init(
	"http://<your-ups-server>.com",
	"<senderId>",
	"<variantId>",
	"<variantSecret>"
);
```
  