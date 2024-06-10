import { app, BrowserWindow } from "electron";
import * as path from "path";

let mainWindow;

function createWindow() {
  mainWindow = new BrowserWindow({
    webPreferences: {
      // eslint-disable-next-line no-undef
      preload: path.join(__dirname, "../preload/preload.js"),
      webSecurity: false,
    },
  });

  // Vite DEV server URL
  mainWindow.loadURL("http://localhost:5173");
  mainWindow.on("closed", () => (mainWindow = null));
}

app.whenReady().then(() => {
  createWindow();
});

app.on("window-all-closed", () => {
  app.quit();
});

app.on("activate", () => {
  if (mainWindow == null) {
    createWindow();
  }
});
