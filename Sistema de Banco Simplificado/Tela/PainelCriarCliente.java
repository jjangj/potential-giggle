package banco.Tela;

import banco.FachadaBanco;

public class PainelCriarCliente extends javax.swing.JPanel {
   private FachadaBanco f;
    
    public PainelCriarCliente() {
        initComponents();
        
        this.setVisible(false);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel4)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel4)
                .addContainerGap(324, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

public void setFachada (FachadaBanco fachada){
    f=fachada;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
