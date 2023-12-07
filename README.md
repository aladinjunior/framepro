<h1 align="center">FramePro</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img src="https://img.shields.io/badge/API-24%2B-blue.svg?style=flat" border="0" alt="API"></a>
  <br>
  <a href="https://wa.me/+5581984349138"><img alt="WhatsApp" src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"/></a>
  <a href="https://www.linkedin.com/in/aladinjunior/"><img alt="Linkedin" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/></a>
  <a href="mailto:contactaladinjr@gmail.com"><img alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"/></a>
</p>

<p align="center">  

⭐ This project aims to demonstrate my technical knowledge in native development for android with kotlin. More information below.



FramePro is an app that stores window and door measurements, streamlining the process of recording and organizing dimensions for professionals in the field.

</p>

</br>

<p float="left" align="center">
<img alt ="screenshot" width="100%" src="FramePro/apk/screenshots.png"/>
</p>

## Download
Download <a href="FramePro/apk/app-debug.apk?raw=true">APK</a> directly. You can see <a href="https://www.google.com/search?q=como+instalar+um+apk+no+android">here</a> how to install an APK in your android device.

## Technologies used and open source libraries

- Minimum SDK level: 24
- [Kotlin Language](https://kotlinlang.org/) 

- Jetpack 
  - Lifecycle: Observe the android lifecycle and manipulate UI states after lifecycle changes.
  - ViewModel: Manages user interface-related data retention and lifecycle. Allows data to survive configuration changes, such as screen rotations.
  - ViewBinding: It links the XML components in Kotlin through a class that guarantees type safety and other advantages.
  - Material Design Components: Modular and customizable components of the Material Design UI for Android.
  

- Architecture
  - MVVM (View - ViewModel - Model)
  - Communication between ViewModel and View via LiveData.
  - Repositories for abstracting communication with the data layer.
  
- Libraries 
  - [Glide](https://bumptech.github.io/glide/): For image loading and caching.
  - [iText7](https://itextpdf.com/products/itext-core): To generate PDF.
  - [Hilt](https://dagger.dev/hilt/): For dependency injection.

## Architecture

**FramePro** uses the MVVM architecture and the Repositories standard, which follows the [official Google recommendations](https://developer.android.com/topic/architecture).
</br></br>

## Features

<img src="FramePro/apk/feat1.gif" width="25%"/>

Creating data of inserted windows and doors.

<img src="FramePro/apk/feat2.gif" width="25%"/>

Generating pdf of saved data.




# License

Copyright [2023] [Aladin Bento Ferreira Júnior]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
