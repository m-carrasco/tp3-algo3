def generarInput(n, m, lc, name):
    f = open(name, 'w')
    c = lc * n
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = [x for x in range(0, lc)]
        f.write(str(lc) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    aristas = 0
    for i in range(0,n):
        for j in range(i+1, n):
            if aristas < m:
                f.write(str(i) + " " + str(j) + "\n")
                aristas = aristas + 1
    f.close()


generarInput(5, 5, 3, 'entradaEj3.in')
