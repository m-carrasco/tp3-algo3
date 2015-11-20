import random

# el peor caso es un completo donde cada nodo tiene lc colores.
# cada una de esas listas usan colores distintos
# luego hay dos nodos que generan conflictos con 1 color cada uno (el mismo)
def generarInputPeorCaso(n, lc, name):
    f = open(name, 'w')
    m = ((n-2)*(n-3))/2 + 2
    c = lc * (n-2) + 1
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    for i in range(0, n-2):
        listaColores = [x for x in range(i*lc, i*lc+lc)]
        f.write(str(lc) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    c = lc*(n-3)+lc   
    f.write("1 " + str(c) + "\n")
    f.write("1 " + str(c) + "\n")
  
    for i in range(0, n-2):
        ady = [str(i) + " " + str(x) for x in range(i+1, n-2)]
        for arista in ady:  
            f.write(arista + "\n")

    f.write(str(n-3) + " " + str(n-2) + "\n")
    f.write(str(n-2) + " " + str(n-1) + "\n")

    f.close()

#Mejor caso solo cambia el orden en el que se arman.
def generarInputMejorCaso(n, lc, name):
    f = open(name, 'w')
    m = ((n-2)*(n-3))/2 + 2
    c = lc * (n-2) + 1
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")


    f.write("1 " + str(lc*(n-3)+lc) + "\n")
    f.write("1 " + str(lc*(n-3)+lc) + "\n")
  

    for i in range(0, n-2):
        listaColores = [x for x in range(i*lc, i*lc+lc)]
        f.write(str(lc) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    

    f.write("0 1" + "\n")
    f.write("1 2" + "\n")

    for i in range(2, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        for arista in ady:  
            f.write(arista + "\n")



    f.close()

def generarInputSinIntencionalidad(n, lc, name):
    f = open(name, 'w')
    m = ((n-2)*(n-3))/2 + 2
    c = lc * (n-2) + 1
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    colores = [x for x in range(0, c)]

    for i in range(0, n-2):
        listaColores = random.sample(colores, lc)
        f.write(str(lc) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
     
    f.write("1 " + str(random.choice(colores)) + "\n")
    f.write("1 " + str(random.choice(colores)) + "\n")
  
    for i in range(0, n-2):
        ady = [str(i) + " " + str(x) for x in range(i+1, n-2)]
        for arista in ady:  
            f.write(arista + "\n")

    f.write(str(random.randint(0, n-3)) + " " + str(n-2) + "\n")
    f.write(str(n-2) + " " + str(n-1) + "\n")

    f.close()


for i in range(1,101):
    generarInputPeorCaso(10, i, "entradaPeorEj2N10LC"+ str(i)+".in")

#generarInputMejorCaso(5, 3, 'entradaMejor.in')
#generarInputSinIntencionalidad(5, 3, 'entradaSinIntencionalidad.in')
