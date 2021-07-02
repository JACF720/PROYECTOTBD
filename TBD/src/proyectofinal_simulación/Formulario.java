/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_simulación;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
/* 3511 
Equipo 3 
Simulación
/**
 * @author Aguilar Castellanos Alexis
 * @author Alatorre Perez Irving Alan
 * @author Antonio Torres Juan
 * @author Casillas Flores Jaime Alberto
 * @author Sanchez Hernandez Brenda Alejandra
 */
public class Formulario extends javax.swing.JFrame {

    double alt;
    double resultado;
    int ed, delH, norH, soH, oH, delM, norM, soM, oM;
    double pes;
    double imc;
    static int c;
    String sexo;
    File archivo;
    FileWriter escribir;
    PrintWriter linea;

    /**
     * Creates new form Formulario
     */
    public Formulario() {
        initComponents();
        setLocationRelativeTo(null);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(Rhombre);
        grupo1.add(Rmujer);
        Rhombre.setSelected(true);
    }

    public void datos() {
        if (Rhombre.isSelected() == true) {
            Rmujer.setSelected(false);
            System.out.println("Hombre seleccionado.");
        }
        if (Rmujer.isSelected() == true) {
            Rhombre.setSelected(false);
            System.out.println("Mujer seleccionado.");
        }
        resultado = (pes / (alt * alt));
        imc = resultado;
    }

    public void indicedemasa() {
        delH = 0;
        norH = 0;
        soH = 0;
        oH = 0;
        delM = 0;
        norM = 0;
        soM = 0;
        oM = 0;
        if (Rhombre.isSelected() == true) {
            sexo = "Hombre";
        }
        if (Rmujer.isSelected() == true) {
            sexo = "Mujer";
        }
        if (ed == 5) {
            if (Rhombre.isSelected() == true) {

                if (imc <= 13.8) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 14.1 && imc <= 16.7) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 16.8 && imc < 17.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 17.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 13.8) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 13.9 && imc <= 16.8) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 16.9 && imc < 18.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 18.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//    6 AÑOS
        if (ed == 6) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 13.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;

                } else if (imc >= 14.0 && imc <= 16.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 17.0 && imc < 18.4) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 18.4) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 13.8) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;

                } else if (imc >= 13.9 && imc <= 16.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;

                } else if (imc >= 17.0 && imc >= 19.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;

                } else if (imc >= 19.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//7 AÑOS
        if (ed == 7) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 13.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 14.0 && imc <= 17.3) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 17.4 && imc < 19.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 19.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 13.8) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 13.9 && imc <= 17.2) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 17.3 && imc < 19.7) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 19.7) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//8 AÑOS
        if (ed == 8) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 13.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 14.1 && imc <= 17.8) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 17.9 && imc < 20.0) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 20.0) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 14.0) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 14.1 && imc <= 17.6) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 17.7 && imc < 20.5) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 20.5) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//9 AÑOS
        if (ed == 9) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 13.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 14.3 && imc <= 18.5) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 18.6 && imc < 21.0) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 21.0) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 14.3) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 14.4 && imc <= 18.2) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 18.3 && imc < 21.4) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 21.4) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//       10 AÑOS
        if (ed == 10) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 14.2) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 14.6 && imc <= 19.2) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 19.3 && imc < 22.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 22.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 14.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 14.8 && imc <= 18.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 19.0 && imc < 22.5) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 22.5) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//       11 AÑOS 
        if (ed == 11) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 14.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 15.0 && imc <= 20.0) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 20.1 && imc < 23.2) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 23.2) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 15.2) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 15.3 && imc <= 19.8) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 19.9 && imc < 23.6) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 23.6) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//       12 AÑOS
        if (ed == 12) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 14.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 15.4 && imc <= 20.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 21.0 && imc < 24.2) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 24.2) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 15.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 16.0 && imc <= 20.7) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 20.8 && imc < 24.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 24.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
//13 AÑOS
        if (ed == 13) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 15.4) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 15.9 && imc <= 21.7) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 21.8 && imc < 25.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 25.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 16.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 16.6 && imc <= 21.7) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 21.8 && imc < 26.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 26.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }

//14 AÑOS
        if (ed == 14) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 15.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 16.5 && imc <= 22.5) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 22.6 && imc < 26.0) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 26.0) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 17.1) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 17.2 && imc <= 22.6) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 22.7 && imc < 27.2) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 27.2) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
        //15 AÑOS
        if (ed == 15) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 16.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 17.1 && imc <= 23.3) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 23.4 && imc < 26.8) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 26.8) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 17.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 17.8 && imc <= 23.4) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 23.5 && imc < 28.1) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 28.1) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }

        }
        //16 AÑOS
        if (ed == 16) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 17.1) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 17.7 && imc <= 24.1) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 24.2 && imc < 27.5) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 27.5) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 18.1) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 18.2 && imc <= 24.0) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 24.1 && imc < 28.8) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 28.8) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
        //17 AÑOS
        if (ed == 17) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 17.7) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 18.3 && imc <= 24.8) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 24.9 && imc < 28.2) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 28.2) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 18.3) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 18.4 && imc <= 24.4) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 24.5 && imc < 29.2) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 29.2) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
        //18 AÑOS
        if (ed == 18) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 18.2) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 18.8 && imc <= 25.5) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 25.6 && imc < 28.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 28.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 18.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 18.6 && imc <= 24.7) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 24.8 && imc < 29.4) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 29.4) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
        //19 a 24 AÑOS
        if (ed >= 19 && ed <= 24) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 18.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 18.6 && imc <= 24.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 25.0 && imc < 29.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 29.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 18.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 22.1 && imc <= 24.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 25.0 && imc < 29.6) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 29.6) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
            }
        }
        //25 a 29 AÑOS
        if (ed >= 25 && ed <= 29) {
            if (Rhombre.isSelected() == true) {
                if (imc <= 18.5) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delH = 1;
                } else if (imc >= 18.6 && imc <= 24.9) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norH = 1;
                } else if (imc >= 25.0 && imc < 29.9) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soH = 1;
                } else if (imc >= 29.9) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oH = 1;
                }
            }
            if (Rmujer.isSelected() == true) {
                if (imc <= 18.9) {
                    JOptionPane.showMessageDialog(null, "Delgadez. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    delM = 1;
                } else if (imc >= 22.0 && imc <= 25.3) {
                    JOptionPane.showMessageDialog(null, "Normal. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    norM = 1;
                } else if (imc >= 25.4 && imc < 29.8) {
                    JOptionPane.showMessageDialog(null, "Sobrepeso. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    soM = 1;
                } else if (imc >= 29.8) {
                    JOptionPane.showMessageDialog(null, "Obesidad. Su IMC es: " + imc, "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                    oM = 1;
                }
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

        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JAltura = new javax.swing.JTextField();
        JEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Rhombre = new javax.swing.JRadioButton();
        Rmujer = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("¿Cual es tu sexo? ");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel1.setText("Calcular tu IMC");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("¿Cual es tu peso?");

        JPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPesoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("¿Cual es tu altura?");

        JAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAlturaActionPerformed(evt);
            }
        });
        JAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JAlturaKeyPressed(evt);
            }
        });

        JEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JEdadKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("¿Cual es tu edad?");

        Rhombre.setText("Hombre");

        Rmujer.setText("Mujer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(Rhombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rmujer))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JEdad)
                                        .addComponent(JAltura)))))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rhombre)
                    .addComponent(Rmujer))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        conexionbd d = new conexionbd();
        String altur = JAltura.getText();
        alt = Double.parseDouble(altur);
        if (alt < 1.30 || alt > 2.30) {
            JOptionPane.showMessageDialog(null, "La altura que ingreso no es adecuada,Debe ser entre 1.30 y 2.30", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String pe = this.JPeso.getText();
        pes = Double.parseDouble(pe);
        if (pes < 40 || pes > 200) {
            JOptionPane.showMessageDialog(null, "El peso que ingreso no es adecuado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String e = this.JEdad.getText();
        ed = Integer.parseInt(e);
        if (ed > 29 || ed < 5) {
            JOptionPane.showMessageDialog(null, "La edad que ingreso no es adecuada, debe ser entre 5 y 29 años.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if ((!JAltura.getText().equals("") || !JEdad.getText().equals("") || !JPeso.getText().equals("")) || (alt > 1.30 && alt <= 2.30 && pes > 40 && pes < 200 && ed < 30 && ed > 4)) {
            if (c < d.cantUs) {
                datos();
                indicedemasa();
//                ALTURA,RESULTADO,EDAD,PESO,DELGADOH,NORMALH,SOBREPESOH,OBESIDADH,DELGADOM,NORMALM,SOBREPESOM,OBESIDADM,IMC,CONTADOR,SEXO
                String altura = alt + "|", resu = resultado + "|", edad = ed + "|", peso = pes + "|", delgadoH = delH + "|", normalH = norH + "|", sobrepesoH = soH + "|", obesidadH = oH + "|", delgadoM = delM + "|", normalM = norM + "|", sobrepesoM = soM + "|", obesidadM = oM + "|", IMC = imc + "|", contador = c + "|", Sexo = sexo;
                archivo = new File("formulario.txt");
                if (!archivo.exists()) {
                    try {
                        archivo.createNewFile();
                        escribir = new FileWriter(archivo, true);
                        linea = new PrintWriter(escribir);
                        linea.println(altura + resu + edad + peso + delgadoH + normalH + sobrepesoH + obesidadH + delgadoM + normalM + sobrepesoM + obesidadM + IMC + contador + Sexo);
                        linea.close();
                        escribir.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error con la creacion del archivo.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        escribir = new FileWriter(archivo, true);
                        linea = new PrintWriter(escribir);
                        linea.println(altura + resu + edad + peso + delgadoH + normalH + sobrepesoH + obesidadH + delgadoM + normalM + sobrepesoM + obesidadM + IMC + contador + Sexo);
                        linea.close();
                        escribir.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error con la escritura y lectura del archivo.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                c++;
                Inicio a1 = new Inicio();
                a1.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ya se alcanzo el limite de encuestados. Vuelve en la siguiente!!.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejar campos vacios.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Se ha completado el registro, vuelva para la próxima encuesta.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JAlturaActionPerformed

    private void JPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPesoKeyPressed
        // TODO add your handling code here:
        if (JPeso.getText().equals("")) {
            // cadena no está vacía
            JPeso.requestFocus();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                JAltura.requestFocus();
            }
        }
    }//GEN-LAST:event_JPesoKeyPressed

    private void JAlturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JAlturaKeyPressed
        // TODO add your handling code here:
        if (JAltura.getText().equals("")) {
            // cadena no está vacía
            JAltura.requestFocus();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                JEdad.requestFocus();
            }
        }
    }//GEN-LAST:event_JAlturaKeyPressed

    private void JEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JEdadKeyPressed
        // TODO add your handling code here:
        if (JEdad.getText().equals("")) {
            // cadena no está vacía
            JEdad.requestFocus();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                JPeso.requestFocus();
            }
        }
    }//GEN-LAST:event_JEdadKeyPressed
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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JAltura;
    private javax.swing.JTextField JEdad;
    private javax.swing.JTextField JPeso;
    private javax.swing.JRadioButton Rhombre;
    private javax.swing.JRadioButton Rmujer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
