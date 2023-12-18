/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul3;


import java.net.*;
import java.io.*;
/**
 *
 * @author lenovo
 */
public class JOB_1_UDP {
    public static void main(String[] args) throws Exception{
       BufferedReader inFromUser = new BufferedReader (new InputStreamReader (System.in));
       
       DatagramSocket clientSocket = new DatagramSocket();
       InetAddress ip = InetAddress.getByName("192.168.56.1");
       
       byte[] kirimData = new byte[1024];
       byte[] terimaData = new byte[1024];
       
       System.out.println("Masukkan Pesan : ");
       String kalimat = inFromUser.readLine();
       
       kirimData= kalimat.getBytes();
       DatagramPacket kirimPaket = new DatagramPacket (kirimData, kirimData.length, ip, 8806 );
       
       clientSocket.send(kirimPaket);
       
       DatagramPacket terimaPaket = new DatagramPacket (terimaData, terimaData.length);
       
       clientSocket.receive(kirimPaket);
       
       
       String kalimat2 = new String(kirimPaket.getData());
       System.out.println("Dari Server : "+kalimat2);
       
       clientSocket.close();
   }
    
}
