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
public class JOB2_UDP_server {
     public static void main(String[] args) throws Exception{
         DatagramSocket serverSocket = new DatagramSocket(8806);
          System.out.println("UDP Server sedang membaca port 8806");
          
    byte[] kirimData = new byte[1024];
    byte[] terimaData = new byte[1024];
    
    while(true)
    {
         DatagramPacket terimaPaket = new DatagramPacket (terimaData, terimaData.length);
         
         serverSocket.receive(terimaPaket);
         
         
         System.out.println("Anda yang mengirim packet.");
         
         String kalimat = new String (terimaPaket.getData());
         
         InetAddress ip = terimaPaket.getAddress();
         
         int port = terimaPaket.getPort();
         
         String kalimatbesar = kalimat.toUpperCase();
         
         kirimData = kalimatbesar.getBytes();
         
         DatagramPacket kirimPacket =  new DatagramPacket (kirimData,kirimData.length, ip, port );
         
         serverSocket.send(kirimPacket);
         
   
    }
    
    
}
}
