import random

# el peor caso es un completo donde cada nodo tiene lc colores.
# cada una de esas listas usan colores distintos
# luego hay dos nodos que generan conflictos con 1 color cada uno (el mismo)
def generarInputValoresEstrella(colores, cantNodosPorColor, name):
    
    f = open(name, 'w')
    n = 0
    for i in range(0, len(cantNodosPorColor)):
        n += cantNodosPorColor[i]
    n += 2
    m = (n*(n-1))/2
    tamañoListas = []
    for cant in cantNodosPorColor:
        tamañoListas.append(random.randInt(colores+1, cant-1))

    c = colores + max(tamañoListas) - 1

    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    
    #Creamos la lista de colores del nodo central
    f.write(colores + " ")
    for i in range(0, colores)
        f.write(str(i) + " ")
    f.write("\n")

    #Creamos la lista de colores del nodo de un solo color
    f.write("1 0 \n")

    colorSerie = 1 #empieza en 1 y llega hasta colores - 1

    #Creamos la lista de colores para cada serie de nodos de cantNodosPorColor
    for i in range(0, len(cantNodosPorColor)): #obtengo la cantidad de nodos de la serie
        listaColores = [i]
        counter = colores;
        for color in range(colores, tamañoListas[i]):
            listaColores.append(counter)
            counter = counter + 1
        for nodo in range(0, cantNodosPorColor[i]): #me paro en el nodo actual
            #Falta completar

   
        #f.write(str(2) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        #ady = [str(i) + " " + str(i + 1)]        
        for arista in ady:  
            f.write(arista + "\n")

    f.close()


generarInputValoresEstrella(5,2,[1,2],"hola.txt")