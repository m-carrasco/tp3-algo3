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



m = 100
lc = 10
for i in range(1000,21000,1000):
    generarInput(i,m,lc, "entradaEj3N"+str(i)+"M100LC10.in")

n=250
m= 50
for i in range(100,1600,100):
    generarInput(n,m,i, "entradaEj3N250M50LC"+str(i)+".in")

n=500
lc=10
for i in range(1000,21000,100):
    generarInput(n,i,lc, "entradaEj3N500M"+str(i)+"LC10.in")
