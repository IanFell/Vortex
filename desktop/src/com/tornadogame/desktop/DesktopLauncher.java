package com.tornadogame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tornadogame.TornadoGame;

public class DesktopLauncher {

	/**
	 * Mouse is hidden in InputHandler.
	 * 
	 * Currently, the game closes after end slam screen, and actually closes itself in SlamScreen.java.
	 * This is due to a massive memory leak if the game restarts itself over two or three times,
	 * that appears to be caused by the static effect rectangles.
	 * Things do not seem to be correctly getting disposed of.
	 */
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("artwork/icon/VortexIcon.png", FileType.Internal);
		config.title         = "VORTEX";
		config.foregroundFPS = 30;
		config.vSyncEnabled  = true;
		config.width         = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height        = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen    = true;
		new LwjglApplication(new TornadoGame(), config);
	}
}

// 1.5.0_111 min
// 1.9.0 max

//Use this one.
//%JAVA_HOME%;%PATH%
//%JAVA_HOME%;%PATH%


//C:\Users\User\Downloads\openjdk-19.0.1_windows-x64_bin\jdk-19.0.1\bin

// "C:\Users\User\Desktop\Java\jre1.8.0_241\bin"

//Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFileName: "{app}C:\Users\User\Desktop\New Vortex Stuff\icon\VortexIcon.ico" 
//Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon; IconFileName: "{app}C:\Users\User\Desktop\New Vortex Stuff\icon\VortexIcon.ico"
