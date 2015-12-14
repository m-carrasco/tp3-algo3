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

    m = n-1

    tamanoListas = []

    for cant in cantNodosPorColor:
        elem = random.randint(colores+1, cant-1)
        print(elem)
        tamanoListas.append(elem)
    c = colores + max(tamanoListas) - 1

    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    #Creamos la lista de colores del nodo central
    f.write(str(colores) + " ")
    for i in range(0, colores):
        f.write(str(i) + " ")
    f.write("\n")

    #Creamos la lista de colores del nodo de un solo color
    f.write("1 0 \n")

    colorSerie = 1 #empieza en 1 y llega hasta colores - 1

    #Creamos la lista de colores para cada serie de nodos de cantNodosPorColor

    for i in range(0, len(cantNodosPorColor)): #obtengo la cantidad de nodos de la serie
        listaColores = [colorSerie]
        colorSerie+=1
        colorExtra = colores

        for j in range(0, tamanoListas[i]-1): #para llenar la lista necesito agregar tamanoListas[i]-1 colores
            listaColores.append(colorExtra)
            colorExtra+=1

        for j in range(0, cantNodosPorColor[i]):
            f.write(str(tamanoListas[i]) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    

    for i in range(1, n):
        f.write("0 " + str(i) + " \n")

    f.close()



generarInputValoresEstrella(4, [6,7,8], "casoMalo1.in")