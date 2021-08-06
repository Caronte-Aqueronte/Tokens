package interfacesGui;

import java.util.ArrayList;

public class Ingresar extends javax.swing.JFrame {

    ArrayList<String> palabras = new ArrayList<>();

    public Ingresar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnalizar = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Analizar texto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane3.setViewportView(txtTexto);

        txtAnalizar.setColumns(20);
        txtAnalizar.setRows(5);
        jScrollPane1.setViewportView(txtAnalizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtAnalizar.setText("");
        palabras.removeAll(palabras);
        String texto = txtTexto.getText();
        separarFrase(texto);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void separarFrase(String frase) {
        String palabra = "";
        for (int x = 0; x < frase.length(); x++) {
            if (frase.charAt(x) != ' ') {
                palabra = palabra + frase.charAt(x);
            } else {
                palabras.add(palabra);
                palabra = "";
            }
        }
        if (!palabra.equals("")) {
            palabras.add(palabra);
        }
        //aqui mandamos a comparar los chars
        for (String item : palabras) {
            verSiEsEntero(item);
            verSiEsDecimal(item);
            verSiEsSimbolo(item);
        }
    }

    public boolean verSiEsEntero(String palabra) {
        for (int x = 0; x < palabra.length(); x++) {
            if (palabra.charAt(x) >= 48 && palabra.charAt(x) <= 57) {

            } else {
                return false;
            }
        }
        txtAnalizar.append("entero: " + palabra + "\n");
        return true;
    }

    public boolean verSiEsDecimal(String palabra) {
        int contadorPuntoDecimal = 0;
        //vemos si el primerchar es numero
        if (palabra.charAt(0) < 48 || palabra.charAt(0) > 57) {
            return false;        
        }
        //vemos si el ultimo char es un numero
        if (palabra.charAt(palabra.length() - 1) < 48 || palabra.charAt(palabra.length() - 1) > 57) {
            return false;
        }
        //contamos cuantos puentos decimales hay
        for (int x = 0; x < palabra.length(); x++) {
            if (palabra.charAt(x) == '.') {
                contadorPuntoDecimal++;
            }
        }
        //si esto se cumple es porque hay mas de un punto decimal o no hay
        if (contadorPuntoDecimal > 1 || contadorPuntoDecimal == 0) {
            return false;
        } else { // si no entonces solo hay un punto decimal
            for (int x = 0; x < palabra.length(); x++) {
                if ((palabra.charAt(x) >= 48 && palabra.charAt(x) <= 57)||palabra.charAt(x) == '.') {
                    
                }else{
                    return false;
                }
            }
        }
        txtAnalizar.append("decimal: "+palabra+"\n");
        return true;
    }
    public boolean verSiEsSimbolo(String palabra){
        if("{".equals(palabra) || "}".equals(palabra) || "[".equals(palabra)||"]".equals(palabra)||";".equals(palabra)|| ",".equals(palabra)){
            txtAnalizar.append("simbolo:: "+palabra+"\n");
            return true;
        }else{
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizar;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
