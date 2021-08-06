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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnalizar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Analizar texto");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        txtAnalizar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAnalizar.setEnabled(false);
        jScrollPane1.setViewportView(txtAnalizar);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingresa tu texto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if (frase.charAt(x) != ' ' && frase.charAt(x) != '\n') {
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
            if (verSiEsEntero(item) == false && verSiEsDecimal(item) == false && verSiEsSimbolo(item) == false && verSiEsIdentificador(item) == false) {
                txtAnalizar.append(Token.ERROR.getTipoDeToken() + item + "\n");
            }
        }

    }

    public boolean verSiEsEntero(String palabra) {
        for (int x = 0; x < palabra.length(); x++) {
            if (palabra.charAt(x) >= 48 && palabra.charAt(x) <= 57) {

            } else {
                return false;
            }
        }
        txtAnalizar.append(Token.ENTERO.getTipoDeToken() + palabra + "\n");
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
                if ((palabra.charAt(x) >= 48 && palabra.charAt(x) <= 57) || palabra.charAt(x) == '.') {

                } else {
                    return false;
                }
            }
        }
        txtAnalizar.append(Token.DECIMAL.getTipoDeToken() + palabra + "\n");
        return true;
    }

    public boolean verSiEsSimbolo(String palabra) {
        if ("{".equals(palabra) || "}".equals(palabra) || "[".equals(palabra) || "]".equals(palabra) || ";".equals(palabra) || ",".equals(palabra)) {
            txtAnalizar.append(Token.SIMBOLO.getTipoDeToken() + palabra + "\n");
            return true;
        } else {
            return false;
        }
    }

    public boolean verSiEsIdentificador(String palabra) {
        if ((palabra.charAt(0) < 65 || palabra.charAt(0) > 90) && (palabra.charAt(0) < 97 || palabra.charAt(0) > 122)) {
            return false;
        }
        for (int x = 0; x < palabra.length(); x++) {
            if ((palabra.charAt(x) >= 48 && palabra.charAt(x) <= 57) || ((palabra.charAt(x) >= 65 && palabra.charAt(x) <= 90) || (palabra.charAt(x) >= 97 && palabra.charAt(x) <= 122))) {

            } else {
                return false;
            }
        }
        txtAnalizar.append(Token.IDENTIFICADOR.getTipoDeToken() + palabra + "\n");
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizar;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
