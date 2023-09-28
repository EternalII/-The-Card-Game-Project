package com.company;

import com.company.StructureC.*;


import java.awt.*;
import java.io.IOException;


public class Main {
    public static Server GameServer;
    public static void main(String[] args) throws InterruptedException, IOException {
	    GameServer=new Server();
        // Just calling and waiting for needed thread...

        DisplayUI ClientG = new DisplayUI();
        ClientG.start();
        ClientG.GenerateDisplay("LoginScreen");
        ClientG.join(0);
    }
}
