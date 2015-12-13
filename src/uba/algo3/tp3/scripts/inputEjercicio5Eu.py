
def eulerianos(nombre,ciclo,colores):
    f = open(nombre, 'w')
    n=ciclo+2 -1
    m = n+1

    f.write(str(n) + " " + str(m) + " " + str(colores) + "\n")

    repertorio = [x for x in range(1,colores+1)]

    for i in range(0, n):
        listaColores = repertorio
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    for i in range(0, (n+1)/2 - 1):
    	f.write(str(i) + " " + str(i+1)+ "\n")
    
    f.write(str((n+1)/2 -1) + " " +str(0)+ "\n")
    f.write(str((n+1)/2 -1) + " " +str((n+1)/2)+ "\n")
    f.write(str((n+1)/2 -1) + " " +str(n-1)+ "\n")

    for i in range((n+1)/2 , n-1):
        f.write(str(i) + " " + str(i+1)+ "\n")

    f.close()

eulerianos("entradaEj5EuImpar5.in",3,3)
eulerianos("entradaEj5EuImpar7.in",4,2)

#PARES
ciclo = 5
for i in range(0, 7):
    eulerianos("entradaEj5EuPar"+ str(ciclo*2 -1) +".in",ciclo,2)
    ciclo = ciclo + 5

ciclo = 6
for i in range(0, 7):
    eulerianos("entradaEj5EuImpar"+ str(ciclo*2 -1) +".in",ciclo,3)
    ciclo = ciclo + 5