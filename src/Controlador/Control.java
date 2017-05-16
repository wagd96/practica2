/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Modelo.*;

/**
 *
 * @author Carolina
 */
public class Control implements ActionListener {
    
    Visual vista = new Visual();
    ListaSimpleCCPoli polinomios = new ListaSimpleCCPoli();
    
    public Control(Visual vista) {
        this.vista = vista;
        
        this.vista.btningreso1.addActionListener(this);
        this.vista.btnsalir.addActionListener(this);
        /*this.vista.btnsuma.addActionListener(this);
        this.vista.btnmul.addActionListener(this);
        this.vista.btnder.addActionListener(this);
        this.vista.btndern.addActionListener(this);
        this.vista.btninte.addActionListener(this);
        this.vista.btninted.addActionListener(this);
        this.vista.btneva.addActionListener(this);
        this.vista.btnfac.addActionListener(this);
        this.vista.btnborrar.addActionListener(this);
        //this.vista.btnañad.addActionListener(this);
        this.vista.jcombo1.addActionListener(this);
        this.vista.jcombo2.addActionListener(this);*/
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Polinomio p = new Polinomio();
        /*Polinomio q;
        String resul;
        int auxPos, auxPos2;
        double eva, a, b;
        int n;*/
        
        //String px = this.vista.jText1.getText();
//        
//        if (e.getSource() == vista.btningreso1) {
//           
//            
//            try {
//                //p.insertarPolinomio(px);
//                polinomios.insertarPol(p);
//                String poli = p.listaAString();
//                /*vista.labelp1.setVisible(true);
//                this.vista.labelp.setVisible(true);
//                vista.jcombo1.setVisible(true);
//                vista.jcombo2.setVisible(true);
//                this.vista.jcombo1.addItem(poli);
//                this.vista.jcombo2.addItem(poli);*/
//                this.vista.jText1.setText("");
//                
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "caracteres invalidos", "ERROR", JOptionPane.ERROR_MESSAGE);
//                 this.vista.jText1.setText("");
//                 /*vista.jcombo1.setVisible(false);
//                 vista.jcombo2.setVisible(false);*/
//            }
//        }

/*        //Verifica qué combobox se está utilizando
        if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
            vista.labelo.setVisible(true);
            vista.btnsuma.setVisible(true);
            vista.btnmul.setVisible(true);
            vista.btnborrar.setVisible(true);
            vista.btneva.setVisible(false);
            vista.btnfac.setVisible(false);
            vista.btnder.setVisible(false);
            vista.btndern.setVisible(false);
            vista.btninte.setVisible(false);
            vista.btninted.setVisible(false);
        }
        //Verifica qué combobox se está utilizando
        if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
            vista.labelo.setVisible(true);
            vista.btneva.setVisible(true);
            vista.btnfac.setVisible(true);
            vista.btnder.setVisible(true);
            vista.btndern.setVisible(true);
            vista.btninte.setVisible(true);
            vista.btninted.setVisible(true);
            vista.btnborrar.setVisible(true);
            vista.btnsuma.setVisible(false);
            vista.btnmul.setVisible(false);
            
        }
        //Verifica qué combobox se está utilizando
        if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
            vista.labelo.setVisible(true);
            vista.btneva.setVisible(true);
            vista.btnfac.setVisible(true);
            vista.btnder.setVisible(true);
            vista.btndern.setVisible(true);
            vista.btninte.setVisible(true);
            vista.btninted.setVisible(true);
            vista.btnborrar.setVisible(true);
            vista.btnsuma.setVisible(false);
            vista.btnmul.setVisible(false);
            
        }
        //Verifica qué combobox se está utilizando
        if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
            
            vista.btneva.setVisible(false);
            vista.btnfac.setVisible(false);
            vista.btnder.setVisible(false);
            vista.btndern.setVisible(false);
            vista.btninte.setVisible(false);
            vista.btninted.setVisible(false);
            vista.btnsuma.setVisible(false);
            vista.btnmul.setVisible(false);
            vista.btnborrar.setVisible(false);
            
        }
//Evento suma
        if (e.getSource() == vista.btnsuma) {
            vista.jtextre.setText("");
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            vista.linte.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);

            //Obtiene el elemento del combobox1 F(x) que fue elegido
            auxPos = vista.jcombo1.getSelectedIndex();
            //Obtiene el polinomio de la lista de polinomios correspondiente al elegido en el combobox1 F(x) 
            p = polinomios.getPoli(auxPos);
            //Obtiene el elemento del combobox2 Q(x) que fue elegido
            auxPos2 = vista.jcombo2.getSelectedIndex();
            //Obtiene el polinomio de la lista de polinomios correspondiente al elegido en el combobox2 Q(x)
            q = polinomios.getPoli(auxPos2);
            
            resul = p.sumar(q).listaAString();
            vista.labelre.setVisible(true);
            vista.jtextre.setVisible(true);
            vista.jtextre.setText(resul);
            
        }
//Evento Multiplicar
        if (e.getSource() == vista.btnmul) {
            vista.jtextre.setText("");
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            
            vista.linte.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
            //Obtiene el elemento del combobox1 F(x) que fue elegido
            auxPos = vista.jcombo1.getSelectedIndex();
            //Obtiene el polinomio de la lista de polinomios correspondiente al elegido en el combobox1 F(x)
            p = polinomios.getPoli(auxPos);
            //Obtiene el elemento del combobox2 Q(x) que fue elegido 
            auxPos2 = vista.jcombo2.getSelectedIndex();
            //Obtiene el polinomio de la lista de polinomios correspondiente al elegido en el combobox2 Q(x)
            q = polinomios.getPoli(auxPos2);
            
            resul = p.mult(q).listaAString();
            
            vista.labelre.setVisible(true);
            vista.jtextre.setVisible(true);
            vista.jtextre.setText(resul);
            
        }
//Evento evaluar
        if (e.getSource() == vista.btneva) {
            vista.jtextre.setText("");
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.linte.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            
            vista.leva.setVisible(true);
            vista.labeleval.setVisible(true);
            vista.jtexteval.setVisible(true);
            //Verifica qué combobox se está usando. F(x) o Q(x)
            if (vista.jcombo1.getSelectedIndex() != 0) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            if (vista.jcombo2.getSelectedIndex() != 0) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            //Controla la excepcion NumberFormatException
            try {
                eva = Double.parseDouble(vista.jtexteval.getText());
                resul = String.valueOf(p.evaluar(eva));
                
                vista.labelre.setVisible(true);
                vista.jtextre.setVisible(true);
                vista.jtextre.setText(resul);
                
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Recuerde ingresar números", "INFO", JOptionPane.INFORMATION_MESSAGE);
                vista.jtexteval.setText("");
                
            }
            
        }
        //Evento es factor
        if (e.getSource() == vista.btnfac) {
            vista.jtextre.setText("");
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.linte.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            
            vista.lfac.setVisible(true);
            vista.labelf.setVisible(true);
            vista.labelx.setVisible(true);
            vista.jtextf.setVisible(true);

            //Verifica qué combobox se está usando. F(x) o Q(x)
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }

            //Controla la excepcion NumberFormatException
            try {
                eva = Double.parseDouble(vista.jtextf.getText());
                resul = String.valueOf(p.esFactor(eva));
                vista.labelre.setVisible(true);
                vista.jtextre.setVisible(true);
                vista.jtextre.setText(resul);
                
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Recuerde ingresar solo números", "INFO", JOptionPane.INFORMATION_MESSAGE);
                vista.jtextf.setText("");
                
            }
            
        }
//Evento n-derivada
        if (e.getSource() == vista.btndern) {
            vista.jtextre.setText("");
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.linte.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            
            vista.lder.setVisible(true);
            vista.labeln.setVisible(true);
            vista.jtextn.setVisible(true);
            //Verifica qué combobox se está usando. F(x) o Q(x)
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            //Controla la excepcion NumberFormatException
            try {
                n = Integer.parseInt(vista.jtextn.getText());
                if (n <= (p.getPrimero().getLiga()).getExp()) {
                    resul = (p.derivadaN(n)).listaAString();
                    vista.labelre.setVisible(true);
                    vista.jtextre.setVisible(true);
                    vista.jtextre.setText(resul);
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "No se puede realizar", "INFO", JOptionPane.ERROR_MESSAGE);
                    vista.jtextn.setText("");
                    vista.jtextre.setText("");
                }
                
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Recuerde ingresar solo números", "INFO", JOptionPane.INFORMATION_MESSAGE);
                vista.jtextn.setText("");
                vista.jtextre.setText("");
                
            }
            
        }
//Evento Integral definida
        if (e.getSource() == vista.btninted) {
            vista.jtextre.setText("");
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            
            vista.linte.setVisible(true);
            vista.labela.setVisible(true);
            vista.labelb.setVisible(true);
            vista.jtexta.setVisible(true);
            vista.jtextb.setVisible(true);
            //Verifica qué combobox se está usando. F(x) o Q(x)
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
//Controla la excepcion NumberFormatException
            try {
                a = Double.parseDouble(this.vista.jtexta.getText());
                b = Double.parseDouble(this.vista.jtextb.getText());
                resul = String.valueOf(p.integralDef(a, b));
                
                vista.labelre.setVisible(true);
                vista.jtextre.setVisible(true);
                vista.jtextre.setText(resul);
                
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Recuerde ingresar solo números", "INFO", JOptionPane.INFORMATION_MESSAGE);
                vista.jtexta.setText("");
                vista.jtextb.setText("");
                vista.jtextre.setText("");
                
            }
        }
//Evento derivada
        if (e.getSource() == vista.btnder) {
            
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            
            vista.linte.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
            vista.jtextre.setText("");
            //Verifica qué combobox se está usando. F(x) o Q(x)
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            resul = p.derivada().listaAString();
            vista.labelre.setVisible(true);
            vista.jtextre.setVisible(true);
            vista.jtextre.setText(resul);
            
        }
//Evento integral indefinida
        if (e.getSource() == vista.btninte) {
            vista.jtextre.setText("");
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            vista.linte.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);
           
            //Verifica qué combobox se está usando. F(x) o Q(x)
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                auxPos = vista.jcombo1.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                auxPos = vista.jcombo2.getSelectedIndex();
                p = polinomios.getPoli(auxPos);
            }
            resul = p.integralInd().listaAString();
            vista.labelre.setVisible(true);
            vista.jtextre.setVisible(true);
            vista.jtextre.setText(resul);
            
        }
        
        if (e.getSource() == vista.btnborrar) {
            vista.jtextre.setText("");
            vista.labelo.setVisible(false);
            vista.labelre.setVisible(false);
            vista.jtextre.setVisible(false);
            vista.jtextn.setVisible(false);
            vista.labeln.setVisible(false);
            vista.lder.setVisible(false);
            vista.leva.setVisible(false);
            vista.labeleval.setVisible(false);
            vista.jtexteval.setVisible(false);
            vista.labelf.setVisible(false);
            vista.labelx.setVisible(false);
            vista.lfac.setVisible(false);
            vista.jtextf.setVisible(false);
            
            vista.linte.setVisible(false);
            vista.labela.setVisible(false);
            vista.labelb.setVisible(false);
            vista.jtexta.setVisible(false);
            vista.jtextb.setVisible(false);

            //Verifica qué combobox fue seleccionado
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                
                auxPos = vista.jcombo1.getSelectedIndex();
                auxPos2 = vista.jcombo2.getSelectedIndex();
                //verifica que no se esté refiriendo al mismo polinomio
                if (auxPos != auxPos2) {
                    polinomios.borrar(auxPos);
                    polinomios.borrar(auxPos2);
                    vista.jcombo1.removeItemAt(auxPos);
                    vista.jcombo2.removeItemAt(auxPos);
                    vista.jcombo1.removeItemAt(auxPos2 - 1);
                    vista.jcombo2.removeItemAt(auxPos2 - 1);
                } else {
                    polinomios.borrar(auxPos2);
                    vista.jcombo1.removeItemAt(auxPos);
                    vista.jcombo2.removeItemAt(auxPos);
                }
            }
            //Verifica qué combobox fue seleccionado
            if ((vista.jcombo1.getSelectedIndex() != 0) && (vista.jcombo2.getSelectedIndex() == 0)) {
                
                auxPos = vista.jcombo1.getSelectedIndex();
                
                polinomios.borrar(auxPos);
                vista.jcombo1.removeItemAt(auxPos);
                vista.jcombo2.removeItemAt(auxPos);
            }
            //Verifica qué combobox fue seleccionado
            if ((vista.jcombo1.getSelectedIndex() == 0) && (vista.jcombo2.getSelectedIndex() != 0)) {
                
                auxPos = vista.jcombo2.getSelectedIndex();
                
                polinomios.borrar(auxPos);
                vista.jcombo1.removeItemAt(auxPos);
                vista.jcombo2.removeItemAt(auxPos);
            }
        }*/

//Evento salir
        if (e.getSource() == vista.btnsalir) {
            System.exit(0);
            
        }
        
    }
}
