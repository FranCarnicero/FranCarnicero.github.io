package HundirLaFlota;

import java.util.Scanner;

public class HundirLaFlota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner entrada = new Scanner(System.in);

			// PRINCIPAL

			
			//Variables 
			int intentos = 50;
			int lanchas = 5;
			int buques = 3;
			int acorazados = 1;
			int portaaviones = 1;
			int filas = 9;
			int columnas = 9;
			int casillasConBarcos = 0;
			int barcosTocados = lanchas + (buques * 3) + (acorazados * 4) + (portaaviones * 5);
			
			
			// Array del tablero
			
			int tiros = 0;
			int[][] tablero = { /* A */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, /* B */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					/* C */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, /* D */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					/* E */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, /* F */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					/* G */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, /* H */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					/* I */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, /* J */{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
			
			// Generar barcos
			
			// Lanchas
			int lanchasGeneradas = 0;
			while (lanchasGeneradas < lanchas) {
				int LanchaL = (int) (Math.random() * (9 + 1));
				int LanchaN = (int) (Math.random() * (9 + 1));
				if (tablero[LanchaL][LanchaN] == 0) {
					tablero[LanchaL][LanchaN] = -2;
					lanchasGeneradas++;

				} else if (tablero[LanchaL][LanchaN] == -2) {
				}
			}
			// Buques
			int buquesGenerados = 0;
			while (buquesGenerados < buques) {
				int BuqueL = (int) (Math.random() * (9 + 1));
				int BuqueN = (int) (Math.random() * (7 + 1));
				if (tablero[BuqueL][BuqueN] == 0 && tablero[BuqueL][(BuqueN + 1)] == 0
						&& tablero[BuqueL][(BuqueN + 2)] == 0) {
					tablero[BuqueL][BuqueN] = -2;
					tablero[BuqueL][(BuqueN + 1)] = -2;
					tablero[BuqueL][(BuqueN + 2)] = -2;
					buquesGenerados++;

				} else if (tablero[BuqueL][BuqueN] == -2 && tablero[BuqueL][(BuqueN + 1)] == -2
						&& tablero[BuqueL][(BuqueN + 2)] == -2) {
				}
			}
			// Acorazado
			int acorazadosGenerados = 0;
			while (acorazadosGenerados < acorazados) {
				int AcorazadoL = (int) (Math.random() * (9 + 1));
				int AcorazadoN = (int) (Math.random() * (6 + 1));
				if (tablero[AcorazadoL][AcorazadoN] == 0 && tablero[AcorazadoL][(AcorazadoN + 1)] == 0
						&& tablero[AcorazadoL][(AcorazadoN + 2)] == 0 && tablero[AcorazadoL][(AcorazadoN + 3)] == 0) {
					tablero[AcorazadoL][AcorazadoN] = -2;
					tablero[AcorazadoL][(AcorazadoN + 1)] = -2;
					tablero[AcorazadoL][(AcorazadoN + 2)] = -2;
					tablero[AcorazadoL][(AcorazadoN + 3)] = -2;
					acorazadosGenerados++;

				} else if (tablero[AcorazadoL][AcorazadoN] == -2 && tablero[AcorazadoL][(AcorazadoN + 1)] == -2
						&& tablero[AcorazadoL][(AcorazadoN + 2)] == -2 && tablero[AcorazadoL][(AcorazadoN + 3)] == -2) {
				}
			}
			// Portaaviones
			int portaavionesGenerados = 0;
			while (portaavionesGenerados <= (portaaviones - 1)) {
				int PortaavionesL = (int) (Math.random() * (5 + 1));
				int PortaavionesN = (int) (Math.random() * (9 + 1));
				if (tablero[PortaavionesL][PortaavionesN] == 0 && tablero[(PortaavionesL + 1)][(PortaavionesN)] == 0
						&& tablero[(PortaavionesL + 2)][PortaavionesN] == 0
						&& tablero[(PortaavionesL + 3)][PortaavionesN] == 0
						&& tablero[(PortaavionesL + 4)][PortaavionesN] == 0) {
					tablero[PortaavionesL][PortaavionesN] = -2;
					tablero[(PortaavionesL + 1)][PortaavionesN] = -2;
					tablero[(PortaavionesL + 2)][PortaavionesN] = -2;
					tablero[(PortaavionesL + 3)][PortaavionesN] = -2;
					tablero[(PortaavionesL + 4)][PortaavionesN] = -2;
					portaavionesGenerados++;
					
				} else if (tablero[PortaavionesL][PortaavionesN] == -2 && tablero[(PortaavionesL + 1)][PortaavionesN] == -2
						&& tablero[(PortaavionesL + 2)][PortaavionesN] == -2
						&& tablero[(PortaavionesL + 3)][PortaavionesN] == -2
						&& tablero[(PortaavionesL + 4)][PortaavionesN] == -2) {
				}
			}

			while (tiros <= intentos) {

				// Impresión tablero
				char letra = 'A';
				System.out.print("\n    0 1 2 3 4 5 6 7 8 9 ");
				for (int j = 0; j <= filas; j++) {
					System.out.print("\n " + letra + ".");
					letra++;
					for (int i = 0; i <= columnas; i++) {

						if (tablero[j][i] == 1) {
							System.out.print(" A");
						} else if (tablero[j][i] == 2) {
							System.out.print(" X");
							barcosTocados++;
						} else if (tablero[j][i] == -2) {
							System.out.print(" -");
						} else if (tablero[j][i] == 0) {
							System.out.print(" -");
						}
						;
					}
				}

				if (barcosTocados == casillasConBarcos) {
					System.out.println("\n¡FELICIDADES, HAS DERRIBADO TODOS LOS OBJETIVOS! ");
					tiros = (intentos + 1);
				} else {
				}
				// Disparos
				// Seleccion de fila
				try {
					System.out.println("\nIntroduce la fila (LETRA) que quieres seleccionar");
					char Fila = entrada.next().charAt(0);
					char fila = Character.toLowerCase(Fila);
					int filaa = 0;

					if (fila == 'a') {
						filaa = 0;
					} else if (fila == 'b') {
						filaa = 1;
					} else if (fila == 'c') {
						filaa = 2;
					} else if (fila == 'd') {
						filaa = 3;
					} else if (fila == 'e') {
						filaa = 4;
					} else if (fila == 'f') {
						filaa = 5;
					} else if (fila == 'g') {
						filaa = 6;
					} else if (fila == 'h') {
						filaa = 7;
					} else if (fila == 'i') {
						filaa = 8;
					} else if (fila == 'j') {
						filaa = 9;
					}
					
					// Seleccion de columna
					System.out.println("Introduce la columna (NUMERO) que quieres seleccionar ");
					int columna = entrada.nextInt();

					if (tablero[filaa][columna] == 0) {
						System.out.println("¡Fallo! Disparaste al agua.");
						tablero[filaa][columna] = 1;
						tiros++;
					} else if (tablero[filaa][columna] == -2) {
						System.out.println("¡Tocado! Has alcanzado un objetivo.");
						tablero[filaa][columna] = 2;
						tiros++;
					}
					

				} catch (Exception e) {
					System.err.println("!ERROR¡ Has introducido la entrada incorrectamente, vuelve a introducirlos correctamente."
							+ "			\n[Se pide introducir primero la letra y luego el número]");
				}
			}
		}
	}
