
package lab1_alberto.martinez;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab1_AlbertoMartinez {
static String[][] Tablero = Lectura();
static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int opc;
        
        do{//volver a jugar
            Tablero=Lectura();
            int cont=2;
            String Jugador1, Jugador2;
            Jugador1 = JOptionPane.showInputDialog("Nombre del lider de los Atacantes (Piezas negras)");
            Jugador2 = JOptionPane.showInputDialog("Nombre del lider de los Defensores (Piezas blancas)");
            
            //variable de control para ganar
            int win=0;
            do{
                int resp, fuera ,x, x1,y,y1;
            if (cont%2==0) {
                do{
                    
                    resp=2;
                    do{
                    fuera=1;
                    Imprimir(Tablero);
                    System.out.println("");
                    System.out.println("Es el turno de " + Jugador1+"!");
                    System.out.println("Si escoje una posicion fuera del tablero se le volvera a preguntar");
                    System.out.println("Escoja la Fila:");
                    x = sc.nextInt();
                    System.out.println("Columna:");
                    y = sc.nextInt();
                    System.out.println("Escoja la nueva posicion de fila:");
                    x1 = sc.nextInt();
                    System.out.println("columna:");
                    y1 = sc.nextInt();
                    
                    if(x<12&&y<12&&x1<12&&y1<12&&x>0&&y>0&&x1>0&&y1>0){
                        fuera=2;
                    }
                    
                    }while(fuera==1);
                    if (" • ".equals(Tablero[x][y])  ) {
                            resp=1;
                            if (x==x1||y==y1) {
                            if (x==x1) {
                                if(y<y1){
                                    for (int i = y+1; i <= y1; i++) {
                                        if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                            System.out.println("");
                                            resp=3;
                                            
                                        }

                                    }
                                }if(y1<y){
                                    for (int i = y-1; i >= y1; i--) {
                                        if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                            System.out.println("");
                                            resp=3;

                                        }

                                    }
                                }

                            }
                            
                        
                            if (y==y1) {

                                if(x<x1){
                                    for (int i = x+1; i <= x1; i++) {
                                        if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                            System.out.println("");
                                            resp=3;
                                        }
                                    }
                                }else{
                                    for (int i = x-1; i >= x1; i--) {
                                        if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                            System.out.println("");
                                            resp=3;
                                        }

                                    }
                                 }

                            }
                            }else{
                            resp=4;
                            }    

                           
                    
                   
                        if (resp<2) {
                            //mover
                            Tablero[x1][y1] = Tablero[x][y];
                            Tablero[x][y] = "   ";

                            //comer1
                            if (Tablero[x1][y1+1].equals(" o ")||Tablero[x1][y1+1].equals("{o}")) {
                                if (Tablero[x1][y1+2].equals(" • ")) {
                                    Tablero[x1][y1+1]="   ";
                                }
                            }
                            if (Tablero[x1][y1-1].equals(" o ")||Tablero[x1][y1-1].equals("{o}")) {
                                if (Tablero[x1][y1-2].equals(" • ")) {
                                    Tablero[x1][y1-1]="   ";
                                }
                            }
                            if (Tablero[x1+1][y1].equals(" o ")||Tablero[x1+1][y1].equals("{o}")) {
                                if (Tablero[x1+2][y1].equals(" • ")) {
                                    Tablero[x1+1][y1]="   ";
                                }
                            }
                            if (Tablero[x1-1][y1].equals(" o ")||Tablero[x1-1][y1].equals("{o}")) {
                                if (Tablero[x1-2][y1].equals(" • ")) {
                                    Tablero[x1-1][y1]="   ";
                                }
                            }
                            
                            //comer2
                            if(y1+2<12){
                            if ((Tablero[x1][y1+1].equals(" o ")&&((Tablero[x1][y1+2].equals(" o "))||(Tablero[x1][y1+1].equals("{o}")))) || (Tablero[x1][y1+1].equals("{o}")&&(Tablero[x1][y1+2].equals(" o ")))) {
                                if (Tablero[x1][y1+3].equals(" • ")) {
                                    Tablero[x1][y1+1]="   ";
                                    Tablero[x1][y1+2]="   ";
                                }
                            }
                            }
                            if(y1-2>0){
                            if ((Tablero[x1][y1-1].equals(" o ")&&((Tablero[x1][y1-2].equals(" o "))||(Tablero[x1][y1-1].equals("{o}")))) || (Tablero[x1][y1-1].equals("{o}")&&(Tablero[x1][y1-2].equals(" o ")))) {
                                if (Tablero[x1][y1-3].equals(" • ")) {
                                    Tablero[x1][y1-1]="   ";
                                    Tablero[x1][y1-2]="   ";
                                }
                            }
                            }
                            if(x1+2<12){
                            if ((Tablero[x1+1][y1].equals(" o ")&&((Tablero[x1+2][y1].equals(" o "))||(Tablero[x1+1][y1].equals("{o}")))) || (Tablero[x1+1][y1].equals("{o}")&&(Tablero[x1+2][y1].equals(" o ")))) {
                                if (Tablero[x1+3][y1].equals(" • ")) {
                                    Tablero[x1+1][y1]="   ";
                                    Tablero[x1+2][y1]="   ";
                                }
                            }
                            }
                            if(x1-2>0){
                            if ((Tablero[x1-1][y1].equals(" o ")&&((Tablero[x1-2][y1].equals(" o "))||(Tablero[x1-1][y1].equals("{o}")))) || (Tablero[x1-1][y1].equals("{o}")&&(Tablero[x1-2][y1].equals(" o ")))) {
                                if(x1-3>0){
                                if (Tablero[x1-3][y1].equals(" • ")) {
                                    Tablero[x1-1][y1]="   ";
                                    Tablero[x1-2][y1]="   ";
                                }
                                }
                            }
                            }
                            //comer3
                            if(y1+2<12&& y1+3<12){
                            if ((Tablero[x1][y1+1].equals(" o ")||Tablero[x1][y1+1].equals("{o}"))&&(Tablero[x1][y1+2].equals(" o ")||Tablero[x1][y1+2].equals("{o}"))&&(Tablero[x1][y1+3].equals(" o ")||Tablero[x1][y1+3].equals("{o}"))) {
                                System.out.println("hola");
                                if (Tablero[x1][y1+4].equals(" • ")) {
                                    System.out.println("hola2");
                                    Tablero[x1][y1+1]="   ";
                                    Tablero[x1][y1+2]="   ";
                                    Tablero[x1][y1+3]="   ";
                                }
                            }
                            }
                            if(y1-2>0&& y1-3>0){
                            if ((Tablero[x1][y1-1].equals(" o ")||Tablero[x1][y1-1].equals("{o}"))&&(Tablero[x1][y1-2].equals(" o ")||Tablero[x1][y1-2].equals("{o}"))&&(Tablero[x1][y1-3].equals(" o ")||Tablero[x1][y1-3].equals("{o}"))) {
                                System.out.println("hola3");
                                if (Tablero[x1][y1-4].equals(" • ")) {
                                    System.out.println("hola4");
                                    Tablero[x1][y1-1]="   ";
                                    Tablero[x1][y1-2]="   ";
                                    Tablero[x1][y1-3]="   ";
                                }
                            }
                            }
                            if(x1+2<12&& x1+3<12){
                            if ((Tablero[x1+1][y1].equals(" o ")||Tablero[x1+1][y1].equals("{o}"))&&(Tablero[x1+2][y1].equals(" o ")||Tablero[x1+2][y1].equals("{o}"))&&(Tablero[x1+3][y1].equals(" o ")||Tablero[x1+3][y1].equals("{o}"))) {
                                if (Tablero[x1+4][y1].equals(" • ")) {
                                    Tablero[x1+1][y1]="   ";
                                    Tablero[x1+2][y1]="   ";
                                    Tablero[x1+3][y1]="   ";
                                }
                            }
                            }
                            if(x1-2>0&& x1-3>0){
                            if ((Tablero[x1-1][y1].equals(" o ")||Tablero[x1-1][y1].equals("{o}"))&&(Tablero[x1-2][y1].equals(" o ")||Tablero[x1-2][y1].equals("{o}"))&&(Tablero[x1-3][y1].equals(" o ")||Tablero[x1-3][y1].equals("{o}"))) {
                                if (Tablero[x1-4][y1].equals(" • ")) {
                                    Tablero[x1-1][y1]="   ";
                                    Tablero[x1-2][y1]="   ";
                                    Tablero[x1-3][y1]="   ";
                                }
                            }
                            }
                            resp=1;
                        }
                        }
                    Validar(resp);
                    win=1;
                    for (int i = 0; i < Tablero.length; i++) {
                        for (int j = 0; j < Tablero[i].length; j++) {
                            if (Tablero[i][j].equals("{o}")) {
                                win=0;
                            }
 

                        }

                    }

                }while(resp==2||resp==3||resp==4);



                cont++;
                    
                    
            }else{
                do{
                    resp=2;
                    do{
                    fuera=1;
                    Imprimir(Tablero);
                    System.out.println("");
                    System.out.println("Es el turno de " + Jugador2+"!");
                    System.out.println("Escoja la Fila:");
                    x = sc.nextInt();
                    System.out.println("Columna:");
                    y = sc.nextInt();
                    System.out.println("Escoja la nueva posicion de fila:");
                    x1 = sc.nextInt();
                    System.out.println("columna:");
                    y1 = sc.nextInt();
                    
                    if(x<12&&y<12&&x1<12&&y1<12&&x>0&&y>0&&x1>0&&y1>0){
                        fuera=2;
                    }
                    }while(fuera==1);
                    
                    
                        if (" o ".equals(Tablero[x][y])||" 0 ".equals(Tablero[x][y])   ) {
                            resp=1;
                            if(x==x1||y==y1){
                                if (x==x1) {
                                    if(y<y1){
                                        for (int i = y+1; i <= y1; i++) {
                                            if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }

                                        }
                                    }else{
                                        for (int i = y-1; i >= y1; i--) {
                                            if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }

                                        }
                                    }

                                }
                                if (y==y1) {
                                    if(x<x1){
                                        for (int i = x+1; i <= x1; i++) {
                                            if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }
                                        }
                                    }else{
                                        for (int i = x-1; i >= x1; i--) {
                                            if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }

                                        }
                                    }                                                    
                                }
                            }else{
                              resp=4;
                            }   
                        
                        
                    
                        if ( resp<2 ) {
                                //mover
                                Tablero[x1][y1] = Tablero[x][y];
                                Tablero[x][y] = "   ";
                                
                                //comer
                                if (Tablero[x1][y1+1].equals(" • ")) {
                                    if (Tablero[x1][y1+2].equals(" o ")||Tablero[x1][y1+2].equals("{o}")) {
                                        Tablero[x1][y1+1]="   ";
                                    }
                                }
                                if (Tablero[x1][y1-1].equals(" • ")) {
                                    if (Tablero[x1][y1-2].equals(" o ")||Tablero[x1][y1-2].equals("{o}")) {
                                        Tablero[x1][y1-1]="   ";
                                    }
                                }
                                if (Tablero[x1+1][y1].equals(" • ")) {
                                    if (Tablero[x1+2][y1].equals(" o ")||Tablero[x1+2][y1].equals("{o}")) {
                                        Tablero[x1+1][y1]="   ";
                                    }
                                }
                                if (Tablero[x1-1][y1].equals(" • ")) {
                                    if (Tablero[x1-2][y1].equals(" o ")||Tablero[x1-2][y1].equals("{o}")) {
                                        Tablero[x1-1][y1]="   ";
                                    }
                                }
                                //comer2
                                if(y1+2<12){
                                if (Tablero[x1][y1+1].equals(" • ")&&(Tablero[x1][y1+2].equals(" • "))) {
                                    if (Tablero[x1][y1+3].equals(" o ")||Tablero[x1][y1+3].equals("{o}")) {
                                        Tablero[x1][y1+1]="   ";
                                        Tablero[x1][y1+2]="   ";
                                    }
                                }
                                }
                                if(y1-2>0){
                                if (Tablero[x1][y1-1].equals(" • ")&&Tablero[x1][y1-2].equals(" • ")) {
                                    if (Tablero[x1][y1-3].equals(" o ")||Tablero[x1][y1-3].equals("{o}")) {
                                        Tablero[x1][y1-1]="   ";
                                        Tablero[x1][y1-2]="   ";
                                    }
                                }
                                }
                                if(x1+2<12){
                                if (Tablero[x1+1][y1].equals(" • ")||Tablero[x1+2][y1].equals(" • ")) {
                                    if (Tablero[x1+3][y1].equals(" o ")||Tablero[x1+3][y1].equals("{o}")) {
                                        Tablero[x1+1][y1]="   ";
                                        Tablero[x1+2][y1]="   ";
                                    }
                                }
                                }
                                if(x1-2>0){
                                if (Tablero[x1-1][y1].equals(" • ")||Tablero[x1-2][y1].equals(" • ")) {
                                    if(x1-3>0){
                                    if (Tablero[x1-3][y1].equals(" o ")||Tablero[x1-3][y1].equals("{o}")) {
                                        Tablero[x1-1][y1]="   ";
                                        Tablero[x1-2][y1]="   ";
                                    }
                                    }
                                }
                                }
                                //comer3
                                if(y1+2<12&& y1+3<12){
                                if (Tablero[x1][y1+1].equals(" • ")||Tablero[x1][y1+2].equals(" • ")||Tablero[x1][y1+3].equals(" • ")) {
                                    if (Tablero[x1][y1+4].equals(" o ")||Tablero[x1][y1+4].equals("{o}")) {
                                        Tablero[x1][y1+1]="   ";
                                        Tablero[x1][y1+2]="   ";
                                        Tablero[x1][y1+3]="   ";
                                    }
                                }
                                }
                                if(y1-2>0&& y1-3>0){
                                if (Tablero[x1][y1-1].equals(" • ")||Tablero[x1][y1-2].equals(" • ")||Tablero[x1][y1-3].equals(" • ")) {
                                    if (Tablero[x1][y1-4].equals(" o ")||Tablero[x1][y1-4].equals("{o}")) {
                                        Tablero[x1][y1-1]="   ";
                                        Tablero[x1][y1-2]="   ";
                                        Tablero[x1][y1-3]="   ";
                                    }
                                }
                                }
                                if(x1+2<12&& x1+3<12){
                                if (Tablero[x1+1][y1].equals(" • ")||Tablero[x1+2][y1].equals(" • ")||Tablero[x1+3][y1].equals(" • ")) {
                                    if (Tablero[x1+4][y1].equals(" o ")||Tablero[x1+4][y1].equals("{o}")) {
                                        Tablero[x1+1][y1]="   ";
                                        Tablero[x1+2][y1]="   ";
                                        Tablero[x1+3][y1]="   ";
                                    }
                                }
                                }
                                if(x1-2>0&& x1-3>0){
                                if (Tablero[x1-1][y1].equals(" • ")||Tablero[x1-2][y1].equals(" • ")||Tablero[x1-3][y1].equals(" • ")) {
                                    if (Tablero[x1-4][y1].equals(" o ")||Tablero[x1-4][y1].equals("{o}")) {
                                        Tablero[x1-1][y1]="   ";
                                        Tablero[x1-2][y1]="   ";
                                        Tablero[x1-3][y1]="   ";
                                    }
                                }
                                }
                            }
                        
                        }
                        
                        if (" o ".equals(Tablero[x][y])) {
                        Validar(resp);
                        }
                        
                    
                        
                        if ("{o}".equals(Tablero[x][y])  ) {
                            resp=1;
                            if(x==x1||y==y1){
                                if (x==x1) {
                                    if(y<y1){
                                        for (int i = y+1; i <= y1; i++) {
                                            if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                                System.out.println("hola1");
                                            }

                                        }
                                    }else{
                                        for (int i = y-1; i >= y1; i--) {
                                            if (Tablero[x][i] == " o "||Tablero[x][i] == "{o}"||Tablero[x][i] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                                System.out.println("hola2");
                                            }

                                        }
                                    }

                                }
                                if (y==y1) {
                                   if(x<x1){
                                        for (int i = x+1; i <= x1; i++) {
                                            if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }
                                        }
                                    }else{
                                        for (int i = x-1; i >= x1; i--) {
                                            if (Tablero[i][y] == " o "||Tablero[i][y] == "{o}"||Tablero[i][y] == " • ") {
                                                System.out.println("");
                                                resp=3;
                                            }

                                        }
                                    }                  
                                }
                            }else{
                            resp=4;
                            }
                        
                        
                    
                        if ( resp<2 ) {
                            //mover
                                Tablero[x1][y1] = Tablero[x][y];
                                Tablero[x][y] = "   ";

                                //comer
                                
                                if (Tablero[x1][y1+1].equals(" • ")) {
                                    if (Tablero[x1][y1+2].equals(" o ")) {
                                        Tablero[x1][y1+1]="   ";
                                    }
                                }
                                if (Tablero[x1][y1-1].equals(" • ")) {
                                    if (Tablero[x1][y1-2].equals(" o ")) {
                                        Tablero[x1][y1-1]="   ";
                                    }
                                }
                                if (Tablero[x1+1][y1].equals(" • ")) {
                                    if (Tablero[x1+2][y1].equals(" o ")) {
                                        Tablero[x1+1][y1]="   ";
                                    }
                                }
                                if (Tablero[x1-1][y1].equals(" • ")) {
                                    if (Tablero[x1-2][y1].equals(" o ")) {
                                        Tablero[x1-1][y1]="   ";
                                    }
                                }
                                //comer2
                                if(y1+2<12){
                                if (Tablero[x1][y1+1].equals(" • ")&&(Tablero[x1][y1+2].equals(" • "))) {
                                    if (Tablero[x1][y1+3].equals(" o ")) {
                                        Tablero[x1][y1+1]="   ";
                                        Tablero[x1][y1+2]="   ";
                                    }
                                }
                                }
                                if(y1-2>0){
                                if (Tablero[x1][y1-1].equals(" • ")&&Tablero[x1][y1-2].equals(" • ")) {
                                    if (Tablero[x1][y1-3].equals(" o ")) {
                                        Tablero[x1][y1-1]="   ";
                                        Tablero[x1][y1-2]="   ";
                                    }
                                }
                                }
                                if(x1+2<12){
                                if (Tablero[x1+1][y1].equals(" • ")||Tablero[x1+2][y1].equals(" • ")) {
                                    if (Tablero[x1+3][y1].equals(" o ")) {
                                        Tablero[x1+1][y1]="   ";
                                        Tablero[x1+2][y1]="   ";
                                    }
                                }
                                }
                                if(x1-2>0){
                                if (Tablero[x1-1][y1].equals(" • ")||Tablero[x1-2][y1].equals(" • ")) {
                                    if(x1-3>0){
                                    if (Tablero[x1-3][y1].equals(" o ")) {
                                        Tablero[x1-1][y1]="   ";
                                        Tablero[x1-2][y1]="   ";
                                    }
                                    }
                                }
                                }
                                //comer3
                                if(y1+2<12&& y1+3<12){
                                if (Tablero[x1][y1+1].equals(" • ")||Tablero[x1][y1+2].equals(" • ")||Tablero[x1][y1+3].equals(" • ")) {
                                    if (Tablero[x1][y1+4].equals(" o ")) {
                                        Tablero[x1][y1+1]="   ";
                                        Tablero[x1][y1+2]="   ";
                                        Tablero[x1][y1+3]="   ";
                                    }
                                }
                                }
                                if(y1-2>0&& y1-3>0){
                                if (Tablero[x1][y1-1].equals(" • ")||Tablero[x1][y1-2].equals(" • ")||Tablero[x1][y1-3].equals(" • ")) {
                                    if (Tablero[x1][y1-4].equals(" o ")) {
                                        Tablero[x1][y1-1]="   ";
                                        Tablero[x1][y1-2]="   ";
                                        Tablero[x1][y1-3]="   ";
                                    }
                                }
                                }
                                if(x1+2<12&& x1+3<12){
                                if (Tablero[x1+1][y1].equals(" • ")||Tablero[x1+2][y1].equals(" • ")||Tablero[x1+3][y1].equals(" • ")) {
                                    if (Tablero[x1+4][y1].equals(" o ")) {
                                        Tablero[x1+1][y1]="   ";
                                        Tablero[x1+2][y1]="   ";
                                        Tablero[x1+3][y1]="   ";
                                    }
                                }
                                }
                                if(x1-2>0&& x1-3>0){
                                if (Tablero[x1-1][y1].equals(" • ")||Tablero[x1-2][y1].equals(" • ")||Tablero[x1-3][y1].equals(" • ")) {
                                    if (Tablero[x1-4][y1].equals(" o ")) {
                                        Tablero[x1-1][y1]="   ";
                                        Tablero[x1-2][y1]="   ";
                                        Tablero[x1-3][y1]="   ";
                                    }
                                }
                                }
                            }
                            //ver si el rey esta en un borde
                            for (int i = 0; i < 11; i++) {
                                for (int j = 0; j < 11; j++) {
                                   if (Tablero[1][j].equals("{o}")||Tablero[11][j].equals("{o}")) {
                                    win=2;
                                }
                                }
                                if (Tablero[i][1].equals("{o}")||Tablero[i][11].equals("{o}")) {
                                    win=2;
                                
                            }
                            
                            }
                                
                        }
                                
                        
                        if (resp==2||"{o}".equals(Tablero[x][y])) {
                        Validar(resp);
                    }
                     
                }while(resp==2||resp==3||resp==4);
                cont++;
                
            }
                
            }while(win==0);
        Imprimir(Tablero);
        if (win==1) {
            JOptionPane.showMessageDialog(null, "Felicidades " + Jugador1+" GANASTE!"); 
        }
        if (win==2) {
            JOptionPane.showMessageDialog(null, "Felicidades " + Jugador2+" GANASTE!");
        }           
        
            opc=Integer.parseInt(JOptionPane.showInputDialog("Desea volver a jugar? 0=si, 1=no"));
        }while(opc==0);
    }
        
       
    public static String[][] Lectura() {
        String[][] Temporal = new String[13][13];
        //Defensores
        Temporal[3][6] = " o ";
        Temporal[4][6] = " o ";
        Temporal[5][6] = " o ";
        Temporal[7][6] = " o ";
        Temporal[8][6] = " o ";
        Temporal[9][6] = " o ";
        Temporal[6][3] = " o ";
        Temporal[6][4] = " o ";
        Temporal[6][5] = " o ";
        Temporal[6][7] = " o ";
        Temporal[6][8] = " o ";
        Temporal[6][9] = " o ";
        
        //rey
        Temporal[6][6] = "{o}";
        
        //Atacantes
        Temporal[1][4] = " • ";
        Temporal[1][5] = " • ";
        Temporal[1][6] = " • ";
        Temporal[1][7] = " • ";
        Temporal[1][8] = " • ";
        Temporal[2][6] = " • ";
        
        Temporal[4][1] = " • ";
        Temporal[5][1] = " • ";
        Temporal[6][1] = " • ";
        Temporal[7][1] = " • ";
        Temporal[8][1] = " • ";
        Temporal[6][2] = " • ";
        
        Temporal[11][4] = " • ";
        Temporal[11][5] = " • ";
        Temporal[11][6] = " • ";
        Temporal[11][7] = " • ";
        Temporal[11][8] = " • ";
        Temporal[10][6] = " • ";
        
        Temporal[4][11] = " • ";
        Temporal[5][11] = " • ";
        Temporal[6][11] = " • ";
        Temporal[7][11] = " • ";
        Temporal[8][11] = " • ";
        Temporal[6][10] = " • ";
        
        //numeros
        int cont=0, cont2=1;
        for (int i = 0; i < Temporal.length; i++) {
            for (int j = 0; j < Temporal[i].length; j++) {
                if(i==0){
                    if(cont>9){
                        Temporal[i][j] = " "+(cont);
                    }else{
                        Temporal[i][j] = " "+(cont)+" ";
                    }
                    cont++;
                }
                if (j==0&&i>0) {
                    if(cont2>9){
                        Temporal[i][j] = " "+(cont2); 
                    }else{
                        Temporal[i][j] = " "+(cont2)+" ";
                    }
                    cont2++;
                }
                
            }
            
        }
        //LLenar los null con recursivo
        Temporal=LlenarE(Temporal, 0, 0);
        
        return Temporal;
    }
    
    //RECURSIVO
    static String[][] LlenarE(String matriz[][], int filas, int cols){
        if (filas==matriz.length-1&&cols==matriz[0].length-1){
            if (matriz[filas][cols] == null) {
                    matriz[filas][cols] = "   ";
                }
            return matriz;
        }else{
            if (cols==matriz[0].length-1) {
                if (matriz[filas][cols] == null) {
                    matriz[filas][cols] = "   ";
                }
                LlenarE(matriz,filas+1,0);
            } else {
                if (matriz[filas][cols] == null) {
                    matriz[filas][cols] = "   ";
                }
                
                LlenarE(matriz,filas,cols+1);
            }
        }
        return matriz;
    }
    
    public static void Imprimir(String[][] matriz) {
        for (int i = 0; i < matriz.length-1; i++) {
            System.out.print(" |");
            for (int j = 0; j < matriz[i].length-1; j++) {
                System.out.print(matriz[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }
    
    public static void Validar(int resp){
            switch(resp){
                case 2:
                    JOptionPane.showMessageDialog(null, "Selecciono una coordenada incorrecta");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "No se puede saltar otras piezas!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Solo se puede mover en cruz, vuelva a intentar");
                    break;
                default:
                    break;
            }
        }
}
