import java.text.DecimalFormatSymbols;
import java.util.Locale;

import java.text.DecimalFormat;

public class IMC extends javax.swing.JFrame {

	private javax.swing.JButton botaoCalc;
    private javax.swing.JTextField jAltura;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField jPeso;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextPane TPane2;
    private javax.swing.JLabel labelResult;
	private static final long serialVersionUID = 1L;
	float peso, altura, imc;
    
	  public static void main(String args[]) {
	        
	       
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new IMC().setVisible(true);
	            }
	        });
	    }
    
	public IMC() {
        construirComponentes();
    }
    
	
	
    
    private void construirComponentes() {

    	botaoCalc = new javax.swing.JButton();
    	label1 = new javax.swing.JLabel();
        TPane2 = new javax.swing.JTextPane();
        scrollPane = new javax.swing.JScrollPane();
        scrollPane.setViewportView(TPane2);
        labelResult = new javax.swing.JLabel();
        jPeso = new javax.swing.JTextField();
        jAltura = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Sistema de Calculo de IMC");

        botaoCalc.setText("Calcular IMC");
                botaoCalc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularAction(evt);
            }
        });

        label3.setText("Altura (CM)");
        label2.setText("Peso (KG)");
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(label1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(botaoCalc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(botaoCalc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }                        

    private void calcularIMC() {
    	DecimalFormatSymbols virgula = new DecimalFormatSymbols(Locale.getDefault());
    	DecimalFormat decimal = new DecimalFormat("0.00",virgula);
    	
        peso = Float.parseFloat(jPeso.getText());
        altura = Float.parseFloat(jAltura.getText());
        altura = altura/100;
               
        imc = peso / (altura * altura);
        System.out.println(imc);
        
        if(imc < 17){
        labelResult.setText(String.valueOf("Muito baixo - IMC: " + decimal.format(imc)));
        
        } if(imc >= 17 && imc <= 18.49){
        labelResult.setText(String.valueOf("Abaixo do peso. - IMC: " + decimal.format(imc)));
        
        } if(imc >= 18.50 && imc <= 24.99){
        labelResult.setText(String.valueOf("Peso normal. - IMC: " + decimal.format(imc)));
        
        } if(imc >= 25 && imc <= 29.99){
        labelResult.setText(String.valueOf("Acima do peso. - IMC: " + decimal.format(imc)));
        
        } if(imc >= 30 && imc <= 34.99){
        labelResult.setText(String.valueOf("Obesidade I. - IMC: " + decimal.format(imc)));
        
        } if(imc >= 35 && imc <= 39.99){
        labelResult.setText(String.valueOf("Obesidade II Severa - IMC: " + decimal.format(imc)));
        
        } if(imc >= 40){
        labelResult.setText(String.valueOf("Obesidade III Morbida - IMC: " + decimal.format(imc)));
        
        }
    }
    
    
    
    private void calcularAction(java.awt.event.ActionEvent evt) {      
    
        calcularIMC();
                
    }                                           

    
  

    
    
                       
}