/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bagian_Server;

/**
 *
 * @author Rahmisefrialdayanti21076020
 */
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SisiServer extends javax.swing.JFrame {

    /**
     * Creates new form SisiServer
     */
    ServerSocket ss;
    HashMap clientColl=new HashMap();
    HashMap serverColl=new HashMap();
    DataInputStream din;
    DataOutputStream dout;
    DefaultListModel dlm;
    
    public SisiServer() {
        try{
            initComponents();
            ss=new ServerSocket(2089);
            server.setText("Server Active");
            dlm=new DefaultListModel();
            UL.setModel(dlm);
            
            new ClientAccept().start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } 
    
    class ClientAccept extends Thread {
        public void run() {
            while (true) {
                try {
                    Socket s = ss.accept();
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    if (clientColl.containsKey(i)) {
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        dout.writeUTF("You Are Already Registered!...");
                    } else { 
                        clientColl.put(i, s);
                        pesanbox.append(i + " Joined! \n");
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        dout.writeUTF("");
                        new Readpesan(s, i).start();
                        new PrepareClientList().start();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    class Readpesan extends Thread {

        Socket s;
        String ID;
        
        Readpesan(Socket s, String ID) {
            this.s=s;
            this.ID=ID;
        }

        public void run() {
            while (!clientColl.isEmpty()) {
                try {
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    if (i.equals("Left this chat")) {
                        clientColl.remove(ID);
                        pesanbox.append(ID + ": removed! \n");
                        new PrepareClientList().start();
                        
                        Set <String> k = clientColl.keySet();
                        Iterator itr= k.iterator();
                        while (itr.hasNext()) {
                            String key = (String)itr.next();
                            if (!key.equalsIgnoreCase(ID)) {
                                try {
                                    new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF("< "+ID+" to All > "+i);
                                } catch (Exception ex) {
                                    clientColl.remove(key);
                                    pesanbox.append(key + ": removed! \n");
                                    new PrepareClientList().start();
                                }
                            }
                        }
                    }else if(i.contains("#4344554@@@@@67667@@")){
                        i=i.substring(20);
                        StringTokenizer st=new StringTokenizer(i,":");
                        String id=st.nextToken();
                        i=st.nextToken();
                        try{
                            new DataOutputStream(((Socket)clientColl.get(id)).getOutputStream()).writeUTF("< "+ID+" to you > "+i);
                        }catch (Exception ex){
                            clientColl.remove(id);
                            pesanbox.append(id+": removed!");
                            new PrepareClientList().start();
                        }
                    } 
                    else {
                        Set k=clientColl.keySet();
                        Iterator itr=k.iterator();
                        while(itr.hasNext()){
                            String key=(String)itr.next();
                            if(!key.equalsIgnoreCase(ID)){
                                try{
                                    new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF("< "+ID+" to All > "+i);
                                }catch(Exception ex){
                                    clientColl.remove(key);
                                    pesanbox.append(key+": removed!");
                                    new PrepareClientList().start();
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        }
    }
    
    class PrepareClientList extends Thread{
        public void run(){
            try{
                String ids="";
                Set k=clientColl.keySet();
                Iterator itr=k.iterator();
                while(itr.hasNext()){
                    String key=(String)itr.next();
                    ids+=key+",";
                }if (ids.length() !=0)
                    ids=ids.substring(0, ids.length()-1);
                itr=k.iterator();
                while(itr.hasNext()){
                    String key=(String)itr.next();
                    try{
                        new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF(":;.,/="+ids);
                    }catch(Exception ex){
                        clientColl.remove(key);
                        pesanbox.append(key+": removed! \n");
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pesanbox = new java.awt.TextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        UL = new javax.swing.JList<>();
        btnsend = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        pesan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnreconnect = new javax.swing.JButton();
        server = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisiServer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        pesanbox.setMinimumSize(new java.awt.Dimension(52, 317));
        jPanel1.add(pesanbox);
        pesanbox.setBounds(20, 60, 310, 320);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(350, 60, 20, 320);

        UL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UL.setMaximumSize(new java.awt.Dimension(15, 18));
        UL.setMinimumSize(new java.awt.Dimension(15, 18));
        UL.setPreferredSize(new java.awt.Dimension(15, 18));
        UL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ULValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(UL);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(390, 60, 190, 320);

        btnsend.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnsend.setText("SEND");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });
        jPanel1.add(btnsend);
        btnsend.setBounds(220, 450, 130, 30);

        btnexit.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit);
        btnexit.setBounds(390, 450, 190, 30);

        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });
        jPanel1.add(pesan);
        pesan.setBounds(71, 400, 280, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Pesan:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 400, 90, 30);

        btnreconnect.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnreconnect.setText("RECONNECT");
        jPanel1.add(btnreconnect);
        btnreconnect.setBounds(390, 400, 190, 30);

        server.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        server.setText("...............");
        jPanel1.add(server);
        server.setBounds(80, 20, 230, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Server: ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 60, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try{
            ss.close();
        }catch(IOException ex){
            Logger.getLogger(SisiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsendActionPerformed

    private void ULValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ULValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ULValueChanged

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesanActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SisiServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SisiServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SisiServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SisiServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SisiServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> UL;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnreconnect;
    private javax.swing.JButton btnsend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pesan;
    private java.awt.TextArea pesanbox;
    private javax.swing.JLabel server;
    // End of variables declaration//GEN-END:variables
}
