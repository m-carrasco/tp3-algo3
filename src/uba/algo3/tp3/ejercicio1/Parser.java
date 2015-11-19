package uba.algo3.tp3.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Parser {
	public GrafoMaterias parse(InputStream in) throws IOException{
		
		BufferedReader archivo = new BufferedReader( new InputStreamReader( in ) );
		
		String line = archivo.readLine();
		
		String[] contenido = line.split(" ");
		int n = java.lang.Integer.parseInt(contenido[0]);
		int m = java.lang.Integer.parseInt(contenido[1]);
		int c = java.lang.Integer.parseInt(contenido[2]);
		GrafoMaterias grafo = new GrafoMaterias(n);
		for(int i=0;i<n;i++){
			Nodo nodo = new Nodo();
			String line2 = archivo.readLine();
			String[] contenido2 = line2.split(" ");
			int t = java.lang.Integer.parseInt(contenido2[0]);
			ArrayList<Integer> colores = new ArrayList<Integer>(t);
			for(int j=0;j<t;j++){
				colores.add(j,java.lang.Integer.parseInt(contenido2[j+1]));
			}
			nodo.setColores(colores);
			grafo.setNodo(i, nodo);
		}
		for(int i=0;i<m;i++){
			String line2 = archivo.readLine();
			String[] contenido2 = line2.split(" ");
			int u = java.lang.Integer.parseInt(contenido2[0]);
			int v = java.lang.Integer.parseInt(contenido2[1]);
			
			grafo.getNodo(u).addVecinos(v);
			grafo.getNodo(v).addVecinos(u); 
		}
		
		return grafo;
	}
}
