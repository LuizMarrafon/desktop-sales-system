const { app, BrowserWindow } = require('electron');

function createWindow() {
    const janela = new BrowserWindow({
        width: 1920,
        height: 1080
    });

    janela.loadFile('front/index.html');
}

app.whenReady().then(createWindow);