def convertir(file, n, m, chromatic):
    f = open(file, 'r')
    
    aristas = []
    for l in f:
        valores = l.split(" ")
        aristas.append(str(int(valores[1])-1) + " " + str(int(valores[2])-1))
   
    f.close()
    
    f = open(file, 'w')
    f.write(str(n) + " " + str(m) + " " + str(chromatic) + "\n")
    
    for i in range(0, n):
        listaColores = [x for x in range(0, chromatic)]
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    for i in aristas:
        f.write(i + "\n")

    f.close()

#convertir("myciel4.in", 11, 20, 4)
convertir("myciel5.in", 23, 71, 5)
convertir("myciel6.in", 47, 236, 6)
convertir("myciel7.in", 95, 755, 7)
convertir("myciel8.in", 191, 2360, 8)

