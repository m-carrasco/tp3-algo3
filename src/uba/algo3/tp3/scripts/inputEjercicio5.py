import copy

def mycielski(i):
	r = dict()
	return myciel(i, r)

def myciel(i, anteriores):
	if i == 1:
		return {0: []}
	if i == 2:
		return {0 : [1] , 1 : [0]}

	#if i in anteriores:
	#	return anteriores[i]

	ant = anteriores
    # myciel(i-1, anteriores)

	n = len(ant.keys())
	antCopia = copy.deepcopy(ant)

    #recorro los nuevos
	for i in range(n, 2*n):
        # los nuevos se conectan a los vecinos de sus viejos y a w (2n)
		ant[i] = antCopia[i%n] + [2*n]
		for k in antCopia[i%n]:
			ant[k].append(i)

	ant[2*n] = [x for x in range(n,2*n)]
	
	return ant

def toAristas(dicc):
	aristas = set()

	for k,v in dicc.iteritems():
		for nodo in v:
			if str(nodo) + " " + str(k) not in aristas:
				aristas.add(str(k) + " " + str(nodo))

	return aristas

def entradaEj5Mycielski(n, file, resultados):
    f = open(file, 'w')
    my = toAristas(resultados)
    m = len(my)
    c = n

    f.write(str(len(resultados.keys())) + " " + str(m) + " " + str(c) + "\n")
    j = 0

    for i in range(0, len(resultados.keys())):
        listaColores = [x for x in range(0,n)]
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
         
    for arista in my:  
        f.write(arista + "\n")

    f.close()



#for i in range(1,13):
#    print str(i) + "\n"
#    myciel(i, resultados)

#print "Termine recursiones"

m = myciel(1, dict())

for i in range(2,15):
    entradaEj5Mycielski(i-1, "entradaEj5MycielskiN"+str(i-1)+".in", m)
    print "Ya imprimi el " + str(i-1) + "\n"
    m = myciel(i,m)



